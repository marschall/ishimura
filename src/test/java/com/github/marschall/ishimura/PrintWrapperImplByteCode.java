package com.github.marschall.ishimura;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PrintWrapperImplByteCode {

  public static void main(String[] args) throws IOException {
    Path classFile = Paths.get("target/classes/com/github/marschall/ishimura/UnsafeWrapperImpl.class");

    try (InputStream stream = new BufferedInputStream(Files.newInputStream(classFile))) {
      System.out.print("new byte[]{");
      int byteValue = stream.read();
      boolean first = true;
      while (byteValue != -1) {
        if (!first) {
          System.out.print(", ");
        }
        System.out.print((byte) byteValue);

        first = false;
        byteValue = stream.read();
      }
      System.out.print("}");
    }
  }

}
