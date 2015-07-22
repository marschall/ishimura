package com.github.marschall.ishimura;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;

/**
 * Test for {@link TwoParentClassLoader}.
 */
public class TwoParentClassLoaderTest {

  @Test
  public void byteCodeUpToDate() throws IOException {
    assertArrayEquals(PrintWrapperImplByteCode.getByteCode(), TwoParentClassLoader.WRAPPER_IMPL_CODE);
  }

  @Test
  public void getUnsafeWrapper() throws IOException {
    assertNotNull("Classloader with Unsafe access", TwoParentClassLoader.getClassloaderWithUnsafeAccess());
  }

}
