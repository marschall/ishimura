package com.github.marschall.ishimura;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PrintWrapperImplByteCode {

  public static void main(String[] args) throws IOException {
    byte[] byteCode = getByteCode();
    System.out.println(byteCode.length);
    for (int p = 0; p <= byteCode.length; p += 10_000) {
      System.out.print("  static final byte[] CODE");
      System.out.print(p / 10_000 + 1);
      System.out.print(" = new byte[]{");
      for (int i = 0; i + p < byteCode.length && i < 10_000; i++) {
        if (i > 0) {
          System.out.print(", ");
        }
        System.out.print(byteCode[i + p]);

      }
      System.out.print("};\n");
    }
  }

  static byte[] getByteCode() throws IOException {
    Path classFile = Paths.get("target/classes/com/github/marschall/ishimura/UnsafeWrapperImpl.class");
    return Files.readAllBytes(classFile);
  }

}
