package com.github.marschall.ishimura;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

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
  public void getResourceOpenStream() throws IOException {
    TwoParentClassLoader classLoader = new TwoParentClassLoader();
    URL resource = classLoader.getResource(TwoParentClassLoader.WRAPPER_IMPL_RESOURCE_NAME);
    byte[] contents = getContents(resource.openStream());
    assertArrayEquals(PrintWrapperImplByteCode.getByteCode(), contents);
  }

  @Test
  public void getResourceAsStream() throws IOException {
    TwoParentClassLoader classLoader = new TwoParentClassLoader();
    byte[] contents = getContents(classLoader.getResourceAsStream(TwoParentClassLoader.WRAPPER_IMPL_RESOURCE_NAME));
    assertArrayEquals(PrintWrapperImplByteCode.getByteCode(), contents);
  }

  private byte[] getContents(InputStream stream) throws IOException {
    assertNotNull("stream", stream);
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    try {
      byte[] buffer = new byte[1024];
      for (int read = stream.read(buffer); read != -1 ; read = stream.read(buffer)) {
        bos.write(buffer, 0, read);
      }
      return bos.toByteArray();
    } finally {
      stream.close();
    }
  }

}
