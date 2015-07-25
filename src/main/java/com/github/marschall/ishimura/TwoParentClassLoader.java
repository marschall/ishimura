package com.github.marschall.ishimura;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.security.SecureClassLoader;
import java.util.Enumeration;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Class loader used to define the implementation class of {@link UnsafeWrapper}.
 *
 * <p>Effectively this class loader will only load three classes:</p>
 * <dl>
 * <dt>{@link sun.misc.Unsafe}</dt>
 * <dd>delegated to {@link #jdkClassLoader}, the class loader of a class that has access to {@link sun.misc.Unsafe}</dd>
 * <dt>{@link UnsafeWrapper}</dt>
 * <dd>delegated to {@link #moduleClassLoader}, the class loader of this class</dd>
 * <dt>{@link UnsafeWrapperImpl}</dt>
 * <dd>defined by this class loader</dd>
 * </dl>
 *
 * <p>The parent class loader passed to the superclass will be {@code null} so
 * we can access the bootstrap class loader when need be (on Java 8).</p>
 */
final class TwoParentClassLoader extends SecureClassLoader {

  /**
   * Name of the {@link UnsafeWrapper} implementation class.
   */
  static final String WRAPPER_IMPL_CLASS_NAME = "com.github.marschall.ishimura.UnsafeWrapperImpl";

  /**
   * Name of the {@link UnsafeWrapper} implementation class resource.
   */
  static final String WRAPPER_IMPL_RESOURCE_NAME = "com/github/marschall/ishimura/UnsafeWrapperImpl.java";

  /**
   * Byte code of the {@link UnsafeWrapper} implementation class.
   */
  static final byte[] WRAPPER_IMPL_CODE;

  static {
    ClassLoader classLoader = TwoParentClassLoader.class.getClassLoader();
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    byte[] buffer = new byte[4096];
    try (InputStream stream = classLoader.getResourceAsStream("com/github/marschall/ishimura/UnsafeWrapperImpl.class")) {
      for (int read = stream.read(buffer); read != -1; read = stream.read(buffer)) {
        bos.write(buffer, 0, read);
      }
    } catch (IOException e) {
      throw new RuntimeException("could not read class file", e);
    }
    WRAPPER_IMPL_CODE = bos.toByteArray();
  }

  static {
    registerAsParallelCapable();
  }

  // can be null if bootstrap class loader
  private final ClassLoader jdkClassLoader;
  private final ClassLoader moduleClassLoader;

  TwoParentClassLoader() {
    this(getClassloaderWithUnsafeAccess(),
            // the class loader of this class, can load UnsafeWrapper
            TwoParentClassLoader.class.getClassLoader());
  }

  static ClassLoader getClassloaderWithUnsafeAccess() {
    // LockSupport can park threads and has access to the unsafe
    // returns null if loaded with bootstrap class loader
    return java.util.concurrent.locks.LockSupport.class.getClassLoader();
  }

  private TwoParentClassLoader(ClassLoader jdkClassLoader, ClassLoader moduleClassLoader) {
    super(null); // causes superclass methods to use bootstrap class loader
    Objects.requireNonNull(moduleClassLoader);
    this.jdkClassLoader = jdkClassLoader;
    this.moduleClassLoader = moduleClassLoader;
  }

  @Override
  protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
    synchronized (getClassLoadingLock(name)) {
      // First, check if the class has already been loaded
      Class<?> clazz = findLoadedClass(name);
      if (clazz == null) {
        try {
          // check the JDK class loader first
          if (jdkClassLoader != null) {
            clazz = jdkClassLoader.loadClass(name);
          } else {
            clazz = loadFromBootstrapClassLoader(name, resolve);
          }
        } catch (ClassNotFoundException e1) {
          try {
            // then check the module loader
            clazz = moduleClassLoader.loadClass(name);
          } catch (ClassNotFoundException e2) {
            // finally check we ask for the impl class
            if (name.equals(WRAPPER_IMPL_CLASS_NAME)) {
              clazz = defineClass(name, WRAPPER_IMPL_CODE, 0, WRAPPER_IMPL_CODE.length);
            }
          }
        }

      }
      if (resolve) {
        resolveClass(clazz);
      }
      return clazz;
    }
  }

  private Class<?> loadFromBootstrapClassLoader(String name, boolean resolve) throws ClassNotFoundException {
    return super.loadClass(name, resolve);
  }

  private URL getBootstrapResource(String name) {
    return super.getResource(name);
  }

  private Enumeration<URL> getBootstrapResources(String name) throws IOException {
    return super.getResources(name);
  }

  @Override
  public URL getResource(String name) {
    URL resource;
    if (jdkClassLoader != null) {
      resource = this.jdkClassLoader.getResource(name);
    } else {
      resource = this.getBootstrapResource(name);
    }
    if (resource == null) {
      resource = this.moduleClassLoader.getResource(name);
    }
    if (resource == null && name.equals(WRAPPER_IMPL_RESOURCE_NAME)) {
      resource = newByteCodeUrl();
    }
    return resource;
  }

  private static URL newByteCodeUrl() {
    try {
      return new URL(null, "ishimura://" + WRAPPER_IMPL_RESOURCE_NAME, ImplClassUrlStreamHandler.INSTANCE);
    } catch (MalformedURLException e) {
      throw new RuntimeException("could not create resource", e);
    }
  }

  @Override
  public Enumeration<URL> getResources(String name) throws IOException {
    Enumeration<URL> first;
    if (this.jdkClassLoader != null) {
      first = this.jdkClassLoader.getResources(name);
    } else {
      first = this.getBootstrapResources(name);
    }
    Enumeration<URL> second = this.moduleClassLoader.getResources(name);
    boolean includeByteCode = name.equals(WRAPPER_IMPL_CODE);
    return new CompositeEnumeration(first, second, includeByteCode);
  }

  static final class CompositeEnumeration implements Enumeration<URL> {

    private final Enumeration<URL> first;
    private final Enumeration<URL> second;
    private Enumeration<URL> current;

    private final boolean includeByteCode;
    private boolean byteCodeReturned;


    CompositeEnumeration(Enumeration<URL> first, Enumeration<URL> second, boolean includeByteCode) {
      this.first = first;
      this.second = second;
      this.current = first;
      this.includeByteCode = includeByteCode;
      this.byteCodeReturned = false;
    }

    @Override
    public boolean hasMoreElements() {
      if (this.current == first) {
        return this.first.hasMoreElements() || this.second.hasMoreElements() || this.includeByteCode;
      } else {
        return this.second.hasMoreElements() || this.includeByteCode;
      }
    }

    @Override
    public URL nextElement() {
      if (this.current.hasMoreElements()) {
        URL element = current.nextElement();
        if (this.current == this.first && !this.current.hasMoreElements()) {
          this.current = this.second;
        }
        return element;
      }
      if (this.includeByteCode && !this.byteCodeReturned) {
        this.byteCodeReturned = true;
        return newByteCodeUrl();
      }
      throw new NoSuchElementException();
    }

  }

  /**
   * An {@link URLStreamHandler} for {@link TwoParentClassLoader#WRAPPER_IMPL_CODE}.
   */
  static final class ImplClassUrlStreamHandler extends URLStreamHandler {

    static final URLStreamHandler INSTANCE = new ImplClassUrlStreamHandler();

    @Override
    protected URLConnection openConnection(URL url) throws IOException {
      return new ImplClassUrlConnection(url);
    }

  }

  /**
   * An {@link URLConnection} for {@link TwoParentClassLoader#WRAPPER_IMPL_CODE}.
   */
  static final class ImplClassUrlConnection extends URLConnection {

    ImplClassUrlConnection(URL url) {
      super(url);
    }

    @Override
    public void connect() throws IOException {
      // ignore
    }

    @Override
    public InputStream getInputStream() throws IOException {
      return new ByteArrayInputStream(WRAPPER_IMPL_CODE);
    }

    @Override
    public int getContentLength() {
      return WRAPPER_IMPL_CODE.length;
    }

    @Override
    public long getContentLengthLong() {
      return WRAPPER_IMPL_CODE.length;
    }

  }

}
