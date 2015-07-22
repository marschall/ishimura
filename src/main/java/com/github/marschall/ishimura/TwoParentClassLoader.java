package com.github.marschall.ishimura;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.security.SecureClassLoader;
import java.util.Enumeration;

final class TwoParentClassLoader extends SecureClassLoader {

  private static final String WRAPPER_IMPL_CLASS_NAME = "com.github.marschall.ishimura.UnsafeWrapperImpl";

  private static final String WRAPPER_IMPL_RESOURCE_NAME = "com/github/marschall/ishimura/UnsafeWrapperImpl.java";

  private static final byte[] WRAPPER_IMPL_CODE = new byte[]{-54, -2, -70, -66, 0, 0, 0, 52, 0, 23, 7, 0, 2, 1, 0, 47, 99, 111, 109, 47, 103, 105, 116, 104, 117, 98, 47, 109, 97, 114, 115, 99, 104, 97, 108, 108, 47, 105, 115, 104, 105, 109, 117, 114, 97, 47, 85, 110, 115, 97, 102, 101, 87, 114, 97, 112, 112, 101, 114, 73, 109, 112, 108, 7, 0, 4, 1, 0, 16, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 79, 98, 106, 101, 99, 116, 7, 0, 6, 1, 0, 43, 99, 111, 109, 47, 103, 105, 116, 104, 117, 98, 47, 109, 97, 114, 115, 99, 104, 97, 108, 108, 47, 105, 115, 104, 105, 109, 117, 114, 97, 47, 85, 110, 115, 97, 102, 101, 87, 114, 97, 112, 112, 101, 114, 1, 0, 6, 117, 110, 115, 97, 102, 101, 1, 0, 17, 76, 115, 117, 110, 47, 109, 105, 115, 99, 47, 85, 110, 115, 97, 102, 101, 59, 1, 0, 6, 60, 105, 110, 105, 116, 62, 1, 0, 20, 40, 76, 115, 117, 110, 47, 109, 105, 115, 99, 47, 85, 110, 115, 97, 102, 101, 59, 41, 86, 1, 0, 4, 67, 111, 100, 101, 10, 0, 3, 0, 13, 12, 0, 9, 0, 14, 1, 0, 3, 40, 41, 86, 9, 0, 1, 0, 16, 12, 0, 7, 0, 8, 1, 0, 15, 76, 105, 110, 101, 78, 117, 109, 98, 101, 114, 84, 97, 98, 108, 101, 1, 0, 18, 76, 111, 99, 97, 108, 86, 97, 114, 105, 97, 98, 108, 101, 84, 97, 98, 108, 101, 1, 0, 4, 116, 104, 105, 115, 1, 0, 49, 76, 99, 111, 109, 47, 103, 105, 116, 104, 117, 98, 47, 109, 97, 114, 115, 99, 104, 97, 108, 108, 47, 105, 115, 104, 105, 109, 117, 114, 97, 47, 85, 110, 115, 97, 102, 101, 87, 114, 97, 112, 112, 101, 114, 73, 109, 112, 108, 59, 1, 0, 10, 83, 111, 117, 114, 99, 101, 70, 105, 108, 101, 1, 0, 22, 85, 110, 115, 97, 102, 101, 87, 114, 97, 112, 112, 101, 114, 73, 109, 112, 108, 46, 106, 97, 118, 97, 0, 48, 0, 1, 0, 3, 0, 1, 0, 5, 0, 1, 0, 18, 0, 7, 0, 8, 0, 0, 0, 1, 0, 0, 0, 9, 0, 10, 0, 1, 0, 11, 0, 0, 0, 70, 0, 2, 0, 2, 0, 0, 0, 10, 42, -73, 0, 12, 42, 43, -75, 0, 15, -79, 0, 0, 0, 2, 0, 17, 0, 0, 0, 14, 0, 3, 0, 0, 0, 16, 0, 4, 0, 17, 0, 9, 0, 18, 0, 18, 0, 0, 0, 22, 0, 2, 0, 0, 0, 10, 0, 19, 0, 20, 0, 0, 0, 0, 0, 10, 0, 7, 0, 8, 0, 1, 0, 1, 0, 21, 0, 0, 0, 2, 0, 22};

  static {
    registerAsParallelCapable();
  }

  private final ClassLoader jdkClassLoader;
  private final ClassLoader moduleClassLoader;

  TwoParentClassLoader() {
    this(java.util.concurrent.locks.LockSupport.class.getClassLoader(), TwoParentClassLoader.class.getClassLoader());
  }

  private TwoParentClassLoader(ClassLoader jdkClassLoader, ClassLoader moduleClassLoader) {
    this.jdkClassLoader = jdkClassLoader;
    this.moduleClassLoader = moduleClassLoader;
  }

  @Override
  protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
    synchronized (getClassLoadingLock(name)) {
      // First, check if the class has already been loaded
      Class<?> c = findLoadedClass(name);
      if (c == null) {
        try {
          // check the JDK class loader first
          c = jdkClassLoader.loadClass(name);
        } catch (ClassNotFoundException e1) {
          try {
            // then check the module loader
            c = moduleClassLoader.loadClass(name);
          } catch (ClassNotFoundException e2) {
            // finally check we ask for the impl class
            if (name.equals(WRAPPER_IMPL_CLASS_NAME)) {
              c = defineClass(name, WRAPPER_IMPL_CODE, 0, WRAPPER_IMPL_CODE.length);
            }
          }
        }

      }
      if (resolve) {
        resolveClass(c);
      }
      return c;
    }
  }

  @Override
  public URL getResource(String name) {
    URL resource = this.jdkClassLoader.getResource(name);
    if (resource == null) {
      resource = this.moduleClassLoader.getResource(name);
    }
    if (resource == null && name.equals(WRAPPER_IMPL_RESOURCE_NAME)) {
      try {
        resource = new URL(null, name, ImplClassUrlStreamHandler.INSTANCE);
      } catch (MalformedURLException e) {
        throw new RuntimeException("could not create resource", e);
      }
    }
    return resource;
  }

  @Override
  protected Enumeration<URL> findResources(String name) throws IOException {
    // TODO Auto-generated method stub
    return super.findResources(name);
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
