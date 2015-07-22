package com.github.marschall.ishimura;

import java.lang.reflect.Field;
import java.util.Objects;

/**
 * Creates an instance {@link UnsafeWrapper}. Avoids all static references to
 * {@link sun.miscUnsafe}.
 */
public final class UnsafeWrapperFactory {

  private static UnsafeWrapper wrapper;

  /**
   * Creates the implementation of {@link UnsafeWrapper}. Does a dynamic lookup
   * of {@link sun.miscUnsafe}.
   *
   * @return the implementation of {@link UnsafeWrapper}
   */
  public synchronized static UnsafeWrapper getUnsafeWrapper() {
    // should not be called only once so synchronized should not be too expensive
    if (wrapper != null) {
      return wrapper;
    }
    return getUnsafeWrapper(getUnsafe());
  }

  /**
   * Creates the implementation of {@link UnsafeWrapper} for a given
   * {@link sun.miscUnsafe} instance. Use this methods when the dynamic lookup
   * of {@link sun.miscUnsafe} in this class does not work for you.
   *
   * @param theUnsafe the unsafe instance to use
   * @return the implementation of {@link UnsafeWrapper}
   */
  public synchronized static UnsafeWrapper getUnsafeWrapper(Object theUnsafe) {
    // should not be called only once so synchronized should not be too expensive
    Objects.requireNonNull(theUnsafe);
    if (wrapper != null) {
      return wrapper;
    }
    ClassLoader classLoader = new TwoParentClassLoader();
    try {
      Class<?> wrapperClass = classLoader.loadClass(TwoParentClassLoader.WRAPPER_IMPL_CLASS_NAME);
      wrapper = (UnsafeWrapper) wrapperClass.getConstructor(Object.class).newInstance(theUnsafe);
    } catch (ReflectiveOperationException e) {
      throw new RuntimeException("could not create unsafe wrapper class", e);
    }
    return wrapper;
  }

  private static Object getUnsafe() {
    ClassLoader classLoader = TwoParentClassLoader.getClassloaderWithUnsafeAccess();
    if (classLoader == null) {
      classLoader = UnsafeWrapperFactory.class.getClassLoader();
    }
    try {
      Class<?> unsafeClass = classLoader.loadClass("sun.misc.Unsafe");
      Field field = unsafeClass.getDeclaredField("theUnsafe");
      field.setAccessible(true);
      return field.get(null);
    } catch (ReflectiveOperationException e) {
      throw new RuntimeException("Could not obtain access to sun.misc.Unsafe", e);
    }
  }

}
