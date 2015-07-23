package com.github.marschall.ishimura;

/**
 * A wrapper interface exposing all public methods of {@link sun.misc.Unsafe}.
 *
 * <p>Code can safely compile and link against this code even if it has no
 * access to {@link sun.misc.Unsafe}.</p>
 */
// http://grepcode.com/file/repository.grepcode.com/java/root/jdk/openjdk/8u40-b25/sun/misc/Unsafe.java
public interface UnsafeWrapper {
  @javax.annotation.Generated("ishimura")
  public Object allocateInstance(Class arg0) throws InstantiationException;
  @javax.annotation.Generated("ishimura")
  public void copyMemory(long arg0, long arg1, long arg2);
  @javax.annotation.Generated("ishimura")
  public void copyMemory(Object arg0, long arg1, Object arg2, long arg3, long arg4);
  @javax.annotation.Generated("ishimura")
  public void park(boolean arg0, long arg1);
  @javax.annotation.Generated("ishimura")
  public void unpark(Object arg0);
  @javax.annotation.Generated("ishimura")
  public void loadFence();
  @javax.annotation.Generated("ishimura")
  public void storeFence();
  @javax.annotation.Generated("ishimura")
  public void fullFence();
  @javax.annotation.Generated("ishimura")
  public Object getObject(Object arg0, long arg1);
  @javax.annotation.Generated("ishimura")
  public Object getObject(Object arg0, int arg1);
  @javax.annotation.Generated("ishimura")
  public void putObject(Object arg0, long arg1, Object arg2);
  @javax.annotation.Generated("ishimura")
  public void putObject(Object arg0, int arg1, Object arg2);
  @javax.annotation.Generated("ishimura")
  public boolean getBoolean(Object arg0, int arg1);
  @javax.annotation.Generated("ishimura")
  public boolean getBoolean(Object arg0, long arg1);
  @javax.annotation.Generated("ishimura")
  public void putBoolean(Object arg0, int arg1, boolean arg2);
  @javax.annotation.Generated("ishimura")
  public void putBoolean(Object arg0, long arg1, boolean arg2);
  @javax.annotation.Generated("ishimura")
  public byte getByte(long arg0);
  @javax.annotation.Generated("ishimura")
  public byte getByte(Object arg0, long arg1);
  @javax.annotation.Generated("ishimura")
  public byte getByte(Object arg0, int arg1);
  @javax.annotation.Generated("ishimura")
  public void putByte(long arg0, byte arg1);
  @javax.annotation.Generated("ishimura")
  public void putByte(Object arg0, int arg1, byte arg2);
  @javax.annotation.Generated("ishimura")
  public void putByte(Object arg0, long arg1, byte arg2);
  @javax.annotation.Generated("ishimura")
  public short getShort(Object arg0, int arg1);
  @javax.annotation.Generated("ishimura")
  public short getShort(long arg0);
  @javax.annotation.Generated("ishimura")
  public short getShort(Object arg0, long arg1);
  @javax.annotation.Generated("ishimura")
  public void putShort(Object arg0, int arg1, short arg2);
  @javax.annotation.Generated("ishimura")
  public void putShort(long arg0, short arg1);
  @javax.annotation.Generated("ishimura")
  public void putShort(Object arg0, long arg1, short arg2);
  @javax.annotation.Generated("ishimura")
  public char getChar(long arg0);
  @javax.annotation.Generated("ishimura")
  public char getChar(Object arg0, long arg1);
  @javax.annotation.Generated("ishimura")
  public char getChar(Object arg0, int arg1);
  @javax.annotation.Generated("ishimura")
  public void putChar(long arg0, char arg1);
  @javax.annotation.Generated("ishimura")
  public void putChar(Object arg0, long arg1, char arg2);
  @javax.annotation.Generated("ishimura")
  public void putChar(Object arg0, int arg1, char arg2);
  @javax.annotation.Generated("ishimura")
  public int getInt(Object arg0, long arg1);
  @javax.annotation.Generated("ishimura")
  public int getInt(Object arg0, int arg1);
  @javax.annotation.Generated("ishimura")
  public int getInt(long arg0);
  @javax.annotation.Generated("ishimura")
  public void putInt(long arg0, int arg1);
  @javax.annotation.Generated("ishimura")
  public void putInt(Object arg0, int arg1, int arg2);
  @javax.annotation.Generated("ishimura")
  public void putInt(Object arg0, long arg1, int arg2);
  @javax.annotation.Generated("ishimura")
  public long getLong(Object arg0, int arg1);
  @javax.annotation.Generated("ishimura")
  public long getLong(long arg0);
  @javax.annotation.Generated("ishimura")
  public long getLong(Object arg0, long arg1);
  @javax.annotation.Generated("ishimura")
  public void putLong(long arg0, long arg1);
  @javax.annotation.Generated("ishimura")
  public void putLong(Object arg0, long arg1, long arg2);
  @javax.annotation.Generated("ishimura")
  public void putLong(Object arg0, int arg1, long arg2);
  @javax.annotation.Generated("ishimura")
  public float getFloat(Object arg0, long arg1);
  @javax.annotation.Generated("ishimura")
  public float getFloat(long arg0);
  @javax.annotation.Generated("ishimura")
  public float getFloat(Object arg0, int arg1);
  @javax.annotation.Generated("ishimura")
  public void putFloat(Object arg0, long arg1, float arg2);
  @javax.annotation.Generated("ishimura")
  public void putFloat(long arg0, float arg1);
  @javax.annotation.Generated("ishimura")
  public void putFloat(Object arg0, int arg1, float arg2);
  @javax.annotation.Generated("ishimura")
  public double getDouble(Object arg0, long arg1);
  @javax.annotation.Generated("ishimura")
  public double getDouble(Object arg0, int arg1);
  @javax.annotation.Generated("ishimura")
  public double getDouble(long arg0);
  @javax.annotation.Generated("ishimura")
  public void putDouble(Object arg0, int arg1, double arg2);
  @javax.annotation.Generated("ishimura")
  public void putDouble(long arg0, double arg1);
  @javax.annotation.Generated("ishimura")
  public void putDouble(Object arg0, long arg1, double arg2);
  @javax.annotation.Generated("ishimura")
  public Object getObjectVolatile(Object arg0, long arg1);
  @javax.annotation.Generated("ishimura")
  public void putObjectVolatile(Object arg0, long arg1, Object arg2);
  @javax.annotation.Generated("ishimura")
  public boolean getBooleanVolatile(Object arg0, long arg1);
  @javax.annotation.Generated("ishimura")
  public void putBooleanVolatile(Object arg0, long arg1, boolean arg2);
  @javax.annotation.Generated("ishimura")
  public byte getByteVolatile(Object arg0, long arg1);
  @javax.annotation.Generated("ishimura")
  public void putByteVolatile(Object arg0, long arg1, byte arg2);
  @javax.annotation.Generated("ishimura")
  public short getShortVolatile(Object arg0, long arg1);
  @javax.annotation.Generated("ishimura")
  public void putShortVolatile(Object arg0, long arg1, short arg2);
  @javax.annotation.Generated("ishimura")
  public char getCharVolatile(Object arg0, long arg1);
  @javax.annotation.Generated("ishimura")
  public void putCharVolatile(Object arg0, long arg1, char arg2);
  @javax.annotation.Generated("ishimura")
  public int getIntVolatile(Object arg0, long arg1);
  @javax.annotation.Generated("ishimura")
  public void putIntVolatile(Object arg0, long arg1, int arg2);
  @javax.annotation.Generated("ishimura")
  public long getLongVolatile(Object arg0, long arg1);
  @javax.annotation.Generated("ishimura")
  public void putLongVolatile(Object arg0, long arg1, long arg2);
  @javax.annotation.Generated("ishimura")
  public float getFloatVolatile(Object arg0, long arg1);
  @javax.annotation.Generated("ishimura")
  public void putFloatVolatile(Object arg0, long arg1, float arg2);
  @javax.annotation.Generated("ishimura")
  public double getDoubleVolatile(Object arg0, long arg1);
  @javax.annotation.Generated("ishimura")
  public void putDoubleVolatile(Object arg0, long arg1, double arg2);
  @javax.annotation.Generated("ishimura")
  public long getAddress(long arg0);
  @javax.annotation.Generated("ishimura")
  public void putAddress(long arg0, long arg1);
  @javax.annotation.Generated("ishimura")
  public boolean compareAndSwapObject(Object arg0, long arg1, Object arg2, Object arg3);
  @javax.annotation.Generated("ishimura")
  public boolean compareAndSwapLong(Object arg0, long arg1, long arg2, long arg3);
  @javax.annotation.Generated("ishimura")
  public boolean compareAndSwapInt(Object arg0, long arg1, int arg2, int arg3);
  @javax.annotation.Generated("ishimura")
  public void putOrderedObject(Object arg0, long arg1, Object arg2);
  @javax.annotation.Generated("ishimura")
  public void putOrderedLong(Object arg0, long arg1, long arg2);
  @javax.annotation.Generated("ishimura")
  public void putOrderedInt(Object arg0, long arg1, int arg2);
  @javax.annotation.Generated("ishimura")
  public int getAndAddInt(Object arg0, long arg1, int arg2);
  @javax.annotation.Generated("ishimura")
  public long getAndAddLong(Object arg0, long arg1, long arg2);
  @javax.annotation.Generated("ishimura")
  public int getAndSetInt(Object arg0, long arg1, int arg2);
  @javax.annotation.Generated("ishimura")
  public long getAndSetLong(Object arg0, long arg1, long arg2);
  @javax.annotation.Generated("ishimura")
  public Object getAndSetObject(Object arg0, long arg1, Object arg2);
  @javax.annotation.Generated("ishimura")
  public void throwException(Throwable arg0);
  @javax.annotation.Generated("ishimura")
  public Class defineClass(String arg0, byte[] arg1, int arg2, int arg3, ClassLoader arg4, java.security.ProtectionDomain arg5);
  @javax.annotation.Generated("ishimura")
  public Object staticFieldBase(java.lang.reflect.Field arg0);
  @javax.annotation.Generated("ishimura")
  public Object staticFieldBase(Class arg0);
  @javax.annotation.Generated("ishimura")
  public int fieldOffset(java.lang.reflect.Field arg0);
  @javax.annotation.Generated("ishimura")
  public long staticFieldOffset(java.lang.reflect.Field arg0);
  @javax.annotation.Generated("ishimura")
  public long objectFieldOffset(java.lang.reflect.Field arg0);
  @javax.annotation.Generated("ishimura")
  public boolean shouldBeInitialized(Class arg0);
  @javax.annotation.Generated("ishimura")
  public void ensureClassInitialized(Class arg0);
  @javax.annotation.Generated("ishimura")
  public long allocateMemory(long arg0);
  @javax.annotation.Generated("ishimura")
  public long reallocateMemory(long arg0, long arg1);
  @javax.annotation.Generated("ishimura")
  public void setMemory(long arg0, long arg1, byte arg2);
  @javax.annotation.Generated("ishimura")
  public void setMemory(Object arg0, long arg1, long arg2, byte arg3);
  @javax.annotation.Generated("ishimura")
  public void freeMemory(long arg0);
  @javax.annotation.Generated("ishimura")
  public int arrayBaseOffset(Class arg0);
  @javax.annotation.Generated("ishimura")
  public int arrayIndexScale(Class arg0);
  @javax.annotation.Generated("ishimura")
  public int addressSize();
  @javax.annotation.Generated("ishimura")
  public int pageSize();
  @javax.annotation.Generated("ishimura")
  public Class defineAnonymousClass(Class arg0, byte[] arg1, Object[] arg2);
  @javax.annotation.Generated("ishimura")
  public void monitorEnter(Object arg0);
  @javax.annotation.Generated("ishimura")
  public void monitorExit(Object arg0);
  @javax.annotation.Generated("ishimura")
  public boolean tryMonitorEnter(Object arg0);
  @javax.annotation.Generated("ishimura")
  public int getLoadAverage(double[] arg0, int arg1);
}
