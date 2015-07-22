package com.github.marschall.ishimura;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PrintWrapperImplByteCode {

  public static void main(String[] args) throws IOException {
    System.out.print("new byte[]{");
    byte[] byteCode = getByteCode();
    for (int i = 0; i < byteCode.length; i++) {
      if (i > 0) {
        System.out.print(", ");
      }
      System.out.print(byteCode[i]);

    }
    System.out.print("}");
  }

  static byte[] getByteCode() throws IOException {
    Path classFile = Paths.get("target/classes/com/github/marschall/ishimura/UnsafeWrapperImpl.class");
    return Files.readAllBytes(classFile);
  }

}
