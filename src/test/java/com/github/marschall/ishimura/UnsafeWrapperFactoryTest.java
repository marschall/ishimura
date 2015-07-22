package com.github.marschall.ishimura;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test for {@link UnsafeWrapperFactory}.
 */
public class UnsafeWrapperFactoryTest {

  @Test
  public void getUnsafeWrapper() {
    UnsafeWrapper wrapper = UnsafeWrapperFactory.getUnsafeWrapper();
    assertNotNull(wrapper);

    int addressSize = wrapper.addressSize();
    assertTrue("address size", addressSize == 32 || addressSize == 64);
  }

}
