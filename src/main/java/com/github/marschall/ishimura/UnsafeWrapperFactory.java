package com.github.marschall.ishimura;

import java.lang.reflect.InvocationTargetException;

public final class UnsafeWrapperFactory {

  private static UnsafeWrapper wrapper;

  public synchronized static UnsafeWrapper getUnsafeWrapper() {
    // should not be called only once so synchronized should not be too expensive
    if (wrapper != null) {
      return wrapper;
    }
    return getUnsafeWrapper(getUnsafe());
  }

  public synchronized static UnsafeWrapper getUnsafeWrapper(Object theUnsafe) {
    // should not be called only once so synchronized should not be too expensive
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
    // FIXME
    return sun.misc.Unsafe.getUnsafe();
  }

}
