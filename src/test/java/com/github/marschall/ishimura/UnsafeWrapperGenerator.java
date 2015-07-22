package com.github.marschall.ishimura;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class UnsafeWrapperGenerator {

  public static void main(String[] args) {
    UnsafeWrapperGenerator generator = new UnsafeWrapperGenerator();

    for (Method method : generator.getPublicUnsafeMethods()) {
      System.out.println(generator.generateMethodSignature(method));
    }
  }

  String generateMethodSignature(Method method) {
    int modifiers = method.getModifiers();
    if (!Modifier.isPublic(modifiers)) {
      throw new IllegalArgumentException("method " + method + " not public");
    }
    StringBuilder buffer = new StringBuilder();
    buffer.append("public ");

    if (Modifier.isStatic(modifiers)) {
      buffer.append("static ");
    }

    Class<?> returnType = method.getReturnType();
    appendShortClassName(returnType.getName(), buffer);
    buffer.append(' ');

    buffer.append(method.getName());
    buffer.append('(');
    buffer.append(')');

    Class<?>[] exceptionTypes = method.getExceptionTypes();
    if (exceptionTypes.length != 0) {
      buffer.append(" throws ");
      for (int i = 0; i < exceptionTypes.length; i++) {
        Class<?> exceptionType = exceptionTypes[i];
        if (i > 0) {
          buffer.append(", ");
        }
        appendShortClassName(exceptionType.getName(), buffer);
      }
    }

    return buffer.toString();
  }

  private static void appendShortClassName(String className, StringBuilder buffer) {
    if (className.startsWith("java.lang.")) {
      buffer.append(className, 10, className.length());
    } else {
      buffer.append(className);
    }
  }

  Method[] getPublicUnsafeMethods() {
    return sun.misc.Unsafe.class.getMethods();
  }

}
