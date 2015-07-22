package com.github.marschall.ishimura;

import sun.misc.Unsafe;

/**
 * Implementation of {@link UnsafeWrapper} that delegates to
 * {@link sun.misc.Unsafe}.
 *
 * <p>This class will have to be loaded from a class loader that has access
 * to {@link sun.misc.Unsafe}.</p>
 */
final class UnsafeWrapperImpl implements UnsafeWrapper {

  private final sun.misc.Unsafe unsafe;

  UnsafeWrapperImpl(Unsafe unsafe) {
    this.unsafe = unsafe;
  }



}
