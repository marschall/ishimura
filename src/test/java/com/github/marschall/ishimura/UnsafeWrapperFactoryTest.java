package com.github.marschall.ishimura;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
    assertTrue("address size", addressSize == 4 || addressSize == 8);
  }

}
