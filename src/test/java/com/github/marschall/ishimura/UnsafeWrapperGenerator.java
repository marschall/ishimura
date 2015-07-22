package com.github.marschall.ishimura;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UnsafeWrapperGenerator {

  public static void main(String[] args) {
    UnsafeWrapperGenerator generator = new UnsafeWrapperGenerator();

    System.out.println(generator.getClassContent());
  }

  String getInterfaceContent() {
    StringBuilder buffer = new StringBuilder();
    for (Method method : this.getPublicUnsafeMethods()) {
      buffer.append("  ");
      this.generateMethodSignature(method, buffer);
      buffer.append(";\n");
    }
    return buffer.toString();
  }

  String getClassContent() {
    StringBuilder buffer = new StringBuilder();
    for (Method method : this.getPublicUnsafeMethods()) {
      this.generateMethodSignature(method, buffer);
      buffer.append("{ ");
      Class<?> returnType = method.getReturnType();
      if (returnType != Void.TYPE) {
        buffer.append("return ");
      }
      buffer.append("unsafe.");
      buffer.append(method.getName());
      buffer.append('(');

      int parameterCount = method.getParameterCount();
      for (int i = 0; i < parameterCount; i++) {
        if (i > 0) {
          buffer.append(", ");
        }
        buffer.append("arg").append(i);
      }

      buffer.append(");");
      buffer.append("}\n");
    }
    return buffer.toString();
  }

  String generateMethodSignature(Method method) {
    StringBuilder buffer = new StringBuilder();
    return generateMethodSignature(method, buffer);
  }

  String generateMethodSignature(Method method, StringBuilder buffer) {
    int modifiers = method.getModifiers();
    if (!Modifier.isPublic(modifiers)) {
      throw new IllegalArgumentException("method " + method + " not public");
    }
    buffer.append("public ");

    if (Modifier.isStatic(modifiers)) {
      throw new IllegalArgumentException("method " + method + " is static");
    }

    Class<?> returnType = method.getReturnType();
    appendShortClassName(returnType, buffer);
    buffer.append(' ');

    buffer.append(method.getName());
    buffer.append('(');

    Class<?>[] parameterTypes = method.getParameterTypes();
    for (int i = 0; i < parameterTypes.length; i++) {
      Class<?> parameterType = parameterTypes[i];
      if (i > 0) {
        buffer.append(", ");
      }
      appendShortClassName(parameterType, buffer);
      buffer.append(' ').append("arg").append(i);
    }

    buffer.append(')');

    Class<?>[] exceptionTypes = method.getExceptionTypes();
    if (exceptionTypes.length != 0) {
      buffer.append(" throws ");
      for (int i = 0; i < exceptionTypes.length; i++) {
        Class<?> exceptionType = exceptionTypes[i];
        if (i > 0) {
          buffer.append(", ");
        }
        appendShortClassName(exceptionType, buffer);
      }
    }

    return buffer.toString();
  }

  private static void appendShortClassName(Class<?> clazz, StringBuilder buffer) {
    if (clazz.isArray()) {
      appendShortClassName(clazz.getComponentType(), buffer);
      buffer.append("[]");
      return;
    }

    String className = clazz.getName();
    if (className.startsWith("java.lang.") && Character.isUpperCase(className.charAt(10))) {
      buffer.append(className, 10, className.length());
    } else {
      buffer.append(className);
    }
  }

  List<Method> getPublicUnsafeMethods() {
    return Stream.of(sun.misc.Unsafe.class.getDeclaredMethods())
            .filter((m) -> Modifier.isPublic(m.getModifiers()))
            .collect(Collectors.toList());
  }

}
