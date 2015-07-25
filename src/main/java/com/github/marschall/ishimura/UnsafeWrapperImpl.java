package com.github.marschall.ishimura;

import java.util.Objects;

import sun.misc.Unsafe;

/**
 * Implementation of {@link UnsafeWrapper} that delegates to
 * {@link sun.misc.Unsafe}.
 *
 * <p>This class will have to be loaded from a class loader that has access
 * to {@link sun.misc.Unsafe}.</p>
 */
final class UnsafeWrapperImpl implements UnsafeWrapper {

  private final sun.misc.Unsafe unsafe;

  public UnsafeWrapperImpl(Object unsafe) {
    // public so we don't need to set it to accessible
    // Use Object instead of Unsafe because the caller class loader may not have access to the Unsafe class
    Objects.requireNonNull(unsafe);
    this.unsafe = (Unsafe) unsafe;
  }

  @javax.annotation.Generated("ishimura")
  public Object allocateInstance(Class arg0) throws InstantiationException{ return unsafe.allocateInstance(arg0);}
  @javax.annotation.Generated("ishimura")
  public void copyMemory(long arg0, long arg1, long arg2){ unsafe.copyMemory(arg0, arg1, arg2);}
  @javax.annotation.Generated("ishimura")
  public void copyMemory(Object arg0, long arg1, Object arg2, long arg3, long arg4){ unsafe.copyMemory(arg0, arg1, arg2, arg3, arg4);}
  @javax.annotation.Generated("ishimura")
  public void park(boolean arg0, long arg1){ unsafe.park(arg0, arg1);}
  @javax.annotation.Generated("ishimura")
  public void unpark(Object arg0){ unsafe.unpark(arg0);}
  @javax.annotation.Generated("ishimura")
  public void loadFence(){ unsafe.loadFence();}
  @javax.annotation.Generated("ishimura")
  public void storeFence(){ unsafe.storeFence();}
  @javax.annotation.Generated("ishimura")
  public void fullFence(){ unsafe.fullFence();}
  @javax.annotation.Generated("ishimura")
  public Object getObject(Object arg0, long arg1){ return unsafe.getObject(arg0, arg1);}
  @javax.annotation.Generated("ishimura")
  public Object getObject(Object arg0, int arg1){ return unsafe.getObject(arg0, arg1);}
  @javax.annotation.Generated("ishimura")
  public void putObject(Object arg0, long arg1, Object arg2){ unsafe.putObject(arg0, arg1, arg2);}
  @javax.annotation.Generated("ishimura")
  public void putObject(Object arg0, int arg1, Object arg2){ unsafe.putObject(arg0, arg1, arg2);}
  @javax.annotation.Generated("ishimura")
  public boolean getBoolean(Object arg0, int arg1){ return unsafe.getBoolean(arg0, arg1);}
  @javax.annotation.Generated("ishimura")
  public boolean getBoolean(Object arg0, long arg1){ return unsafe.getBoolean(arg0, arg1);}
  @javax.annotation.Generated("ishimura")
  public void putBoolean(Object arg0, int arg1, boolean arg2){ unsafe.putBoolean(arg0, arg1, arg2);}
  @javax.annotation.Generated("ishimura")
  public void putBoolean(Object arg0, long arg1, boolean arg2){ unsafe.putBoolean(arg0, arg1, arg2);}
  @javax.annotation.Generated("ishimura")
  public byte getByte(long arg0){ return unsafe.getByte(arg0);}
  @javax.annotation.Generated("ishimura")
  public byte getByte(Object arg0, long arg1){ return unsafe.getByte(arg0, arg1);}
  @javax.annotation.Generated("ishimura")
  public byte getByte(Object arg0, int arg1){ return unsafe.getByte(arg0, arg1);}
  @javax.annotation.Generated("ishimura")
  public void putByte(long arg0, byte arg1){ unsafe.putByte(arg0, arg1);}
  @javax.annotation.Generated("ishimura")
  public void putByte(Object arg0, int arg1, byte arg2){ unsafe.putByte(arg0, arg1, arg2);}
  @javax.annotation.Generated("ishimura")
  public void putByte(Object arg0, long arg1, byte arg2){ unsafe.putByte(arg0, arg1, arg2);}
  @javax.annotation.Generated("ishimura")
  public short getShort(Object arg0, int arg1){ return unsafe.getShort(arg0, arg1);}
  @javax.annotation.Generated("ishimura")
  public short getShort(long arg0){ return unsafe.getShort(arg0);}
  @javax.annotation.Generated("ishimura")
  public short getShort(Object arg0, long arg1){ return unsafe.getShort(arg0, arg1);}
  @javax.annotation.Generated("ishimura")
  public void putShort(Object arg0, int arg1, short arg2){ unsafe.putShort(arg0, arg1, arg2);}
  @javax.annotation.Generated("ishimura")
  public void putShort(long arg0, short arg1){ unsafe.putShort(arg0, arg1);}
  @javax.annotation.Generated("ishimura")
  public void putShort(Object arg0, long arg1, short arg2){ unsafe.putShort(arg0, arg1, arg2);}
  @javax.annotation.Generated("ishimura")
  public char getChar(long arg0){ return unsafe.getChar(arg0);}
  @javax.annotation.Generated("ishimura")
  public char getChar(Object arg0, long arg1){ return unsafe.getChar(arg0, arg1);}
  @javax.annotation.Generated("ishimura")
  public char getChar(Object arg0, int arg1){ return unsafe.getChar(arg0, arg1);}
  @javax.annotation.Generated("ishimura")
  public void putChar(long arg0, char arg1){ unsafe.putChar(arg0, arg1);}
  @javax.annotation.Generated("ishimura")
  public void putChar(Object arg0, long arg1, char arg2){ unsafe.putChar(arg0, arg1, arg2);}
  @javax.annotation.Generated("ishimura")
  public void putChar(Object arg0, int arg1, char arg2){ unsafe.putChar(arg0, arg1, arg2);}
  @javax.annotation.Generated("ishimura")
  public int getInt(Object arg0, long arg1){ return unsafe.getInt(arg0, arg1);}
  @javax.annotation.Generated("ishimura")
  public int getInt(Object arg0, int arg1){ return unsafe.getInt(arg0, arg1);}
  @javax.annotation.Generated("ishimura")
  public int getInt(long arg0){ return unsafe.getInt(arg0);}
  @javax.annotation.Generated("ishimura")
  public void putInt(long arg0, int arg1){ unsafe.putInt(arg0, arg1);}
  @javax.annotation.Generated("ishimura")
  public void putInt(Object arg0, int arg1, int arg2){ unsafe.putInt(arg0, arg1, arg2);}
  @javax.annotation.Generated("ishimura")
  public void putInt(Object arg0, long arg1, int arg2){ unsafe.putInt(arg0, arg1, arg2);}
  @javax.annotation.Generated("ishimura")
  public long getLong(Object arg0, int arg1){ return unsafe.getLong(arg0, arg1);}
  @javax.annotation.Generated("ishimura")
  public long getLong(long arg0){ return unsafe.getLong(arg0);}
  @javax.annotation.Generated("ishimura")
  public long getLong(Object arg0, long arg1){ return unsafe.getLong(arg0, arg1);}
  @javax.annotation.Generated("ishimura")
  public void putLong(long arg0, long arg1){ unsafe.putLong(arg0, arg1);}
  @javax.annotation.Generated("ishimura")
  public void putLong(Object arg0, long arg1, long arg2){ unsafe.putLong(arg0, arg1, arg2);}
  @javax.annotation.Generated("ishimura")
  public void putLong(Object arg0, int arg1, long arg2){ unsafe.putLong(arg0, arg1, arg2);}
  @javax.annotation.Generated("ishimura")
  public float getFloat(Object arg0, long arg1){ return unsafe.getFloat(arg0, arg1);}
  @javax.annotation.Generated("ishimura")
  public float getFloat(long arg0){ return unsafe.getFloat(arg0);}
  @javax.annotation.Generated("ishimura")
  public float getFloat(Object arg0, int arg1){ return unsafe.getFloat(arg0, arg1);}
  @javax.annotation.Generated("ishimura")
  public void putFloat(Object arg0, long arg1, float arg2){ unsafe.putFloat(arg0, arg1, arg2);}
  @javax.annotation.Generated("ishimura")
  public void putFloat(long arg0, float arg1){ unsafe.putFloat(arg0, arg1);}
  @javax.annotation.Generated("ishimura")
  public void putFloat(Object arg0, int arg1, float arg2){ unsafe.putFloat(arg0, arg1, arg2);}
  @javax.annotation.Generated("ishimura")
  public double getDouble(Object arg0, long arg1){ return unsafe.getDouble(arg0, arg1);}
  @javax.annotation.Generated("ishimura")
  public double getDouble(Object arg0, int arg1){ return unsafe.getDouble(arg0, arg1);}
  @javax.annotation.Generated("ishimura")
  public double getDouble(long arg0){ return unsafe.getDouble(arg0);}
  @javax.annotation.Generated("ishimura")
  public void putDouble(Object arg0, int arg1, double arg2){ unsafe.putDouble(arg0, arg1, arg2);}
  @javax.annotation.Generated("ishimura")
  public void putDouble(long arg0, double arg1){ unsafe.putDouble(arg0, arg1);}
  @javax.annotation.Generated("ishimura")
  public void putDouble(Object arg0, long arg1, double arg2){ unsafe.putDouble(arg0, arg1, arg2);}
  @javax.annotation.Generated("ishimura")
  public Object getObjectVolatile(Object arg0, long arg1){ return unsafe.getObjectVolatile(arg0, arg1);}
  @javax.annotation.Generated("ishimura")
  public void putObjectVolatile(Object arg0, long arg1, Object arg2){ unsafe.putObjectVolatile(arg0, arg1, arg2);}
  @javax.annotation.Generated("ishimura")
  public boolean getBooleanVolatile(Object arg0, long arg1){ return unsafe.getBooleanVolatile(arg0, arg1);}
  @javax.annotation.Generated("ishimura")
  public void putBooleanVolatile(Object arg0, long arg1, boolean arg2){ unsafe.putBooleanVolatile(arg0, arg1, arg2);}
  @javax.annotation.Generated("ishimura")
  public byte getByteVolatile(Object arg0, long arg1){ return unsafe.getByteVolatile(arg0, arg1);}
  @javax.annotation.Generated("ishimura")
  public void putByteVolatile(Object arg0, long arg1, byte arg2){ unsafe.putByteVolatile(arg0, arg1, arg2);}
  @javax.annotation.Generated("ishimura")
  public short getShortVolatile(Object arg0, long arg1){ return unsafe.getShortVolatile(arg0, arg1);}
  @javax.annotation.Generated("ishimura")
  public void putShortVolatile(Object arg0, long arg1, short arg2){ unsafe.putShortVolatile(arg0, arg1, arg2);}
  @javax.annotation.Generated("ishimura")
  public char getCharVolatile(Object arg0, long arg1){ return unsafe.getCharVolatile(arg0, arg1);}
  @javax.annotation.Generated("ishimura")
  public void putCharVolatile(Object arg0, long arg1, char arg2){ unsafe.putCharVolatile(arg0, arg1, arg2);}
  @javax.annotation.Generated("ishimura")
  public int getIntVolatile(Object arg0, long arg1){ return unsafe.getIntVolatile(arg0, arg1);}
  @javax.annotation.Generated("ishimura")
  public void putIntVolatile(Object arg0, long arg1, int arg2){ unsafe.putIntVolatile(arg0, arg1, arg2);}
  @javax.annotation.Generated("ishimura")
  public long getLongVolatile(Object arg0, long arg1){ return unsafe.getLongVolatile(arg0, arg1);}
  @javax.annotation.Generated("ishimura")
  public void putLongVolatile(Object arg0, long arg1, long arg2){ unsafe.putLongVolatile(arg0, arg1, arg2);}
  @javax.annotation.Generated("ishimura")
  public float getFloatVolatile(Object arg0, long arg1){ return unsafe.getFloatVolatile(arg0, arg1);}
  @javax.annotation.Generated("ishimura")
  public void putFloatVolatile(Object arg0, long arg1, float arg2){ unsafe.putFloatVolatile(arg0, arg1, arg2);}
  @javax.annotation.Generated("ishimura")
  public double getDoubleVolatile(Object arg0, long arg1){ return unsafe.getDoubleVolatile(arg0, arg1);}
  @javax.annotation.Generated("ishimura")
  public void putDoubleVolatile(Object arg0, long arg1, double arg2){ unsafe.putDoubleVolatile(arg0, arg1, arg2);}
  @javax.annotation.Generated("ishimura")
  public long getAddress(long arg0){ return unsafe.getAddress(arg0);}
  @javax.annotation.Generated("ishimura")
  public void putAddress(long arg0, long arg1){ unsafe.putAddress(arg0, arg1);}
  @javax.annotation.Generated("ishimura")
  public boolean compareAndSwapObject(Object arg0, long arg1, Object arg2, Object arg3){ return unsafe.compareAndSwapObject(arg0, arg1, arg2, arg3);}
  @javax.annotation.Generated("ishimura")
  public boolean compareAndSwapLong(Object arg0, long arg1, long arg2, long arg3){ return unsafe.compareAndSwapLong(arg0, arg1, arg2, arg3);}
  @javax.annotation.Generated("ishimura")
  public boolean compareAndSwapInt(Object arg0, long arg1, int arg2, int arg3){ return unsafe.compareAndSwapInt(arg0, arg1, arg2, arg3);}
  @javax.annotation.Generated("ishimura")
  public void putOrderedObject(Object arg0, long arg1, Object arg2){ unsafe.putOrderedObject(arg0, arg1, arg2);}
  @javax.annotation.Generated("ishimura")
  public void putOrderedLong(Object arg0, long arg1, long arg2){ unsafe.putOrderedLong(arg0, arg1, arg2);}
  @javax.annotation.Generated("ishimura")
  public void putOrderedInt(Object arg0, long arg1, int arg2){ unsafe.putOrderedInt(arg0, arg1, arg2);}
  @javax.annotation.Generated("ishimura")
  public int getAndAddInt(Object arg0, long arg1, int arg2){ return unsafe.getAndAddInt(arg0, arg1, arg2);}
  @javax.annotation.Generated("ishimura")
  public long getAndAddLong(Object arg0, long arg1, long arg2){ return unsafe.getAndAddLong(arg0, arg1, arg2);}
  @javax.annotation.Generated("ishimura")
  public int getAndSetInt(Object arg0, long arg1, int arg2){ return unsafe.getAndSetInt(arg0, arg1, arg2);}
  @javax.annotation.Generated("ishimura")
  public long getAndSetLong(Object arg0, long arg1, long arg2){ return unsafe.getAndSetLong(arg0, arg1, arg2);}
  @javax.annotation.Generated("ishimura")
  public Object getAndSetObject(Object arg0, long arg1, Object arg2){ return unsafe.getAndSetObject(arg0, arg1, arg2);}
  @javax.annotation.Generated("ishimura")
  public void throwException(Throwable arg0){ unsafe.throwException(arg0);}
  @javax.annotation.Generated("ishimura")
  public Class defineClass(String arg0, byte[] arg1, int arg2, int arg3, ClassLoader arg4, java.security.ProtectionDomain arg5){ return unsafe.defineClass(arg0, arg1, arg2, arg3, arg4, arg5);}
  @javax.annotation.Generated("ishimura")
  public Object staticFieldBase(java.lang.reflect.Field arg0){ return unsafe.staticFieldBase(arg0);}
  @javax.annotation.Generated("ishimura")
  public Object staticFieldBase(Class arg0){ return unsafe.staticFieldBase(arg0);}
  @javax.annotation.Generated("ishimura")
  public int fieldOffset(java.lang.reflect.Field arg0){ return unsafe.fieldOffset(arg0);}
  @javax.annotation.Generated("ishimura")
  public long staticFieldOffset(java.lang.reflect.Field arg0){ return unsafe.staticFieldOffset(arg0);}
  @javax.annotation.Generated("ishimura")
  public long objectFieldOffset(java.lang.reflect.Field arg0){ return unsafe.objectFieldOffset(arg0);}
  @javax.annotation.Generated("ishimura")
  public boolean shouldBeInitialized(Class arg0){ return unsafe.shouldBeInitialized(arg0);}
  @javax.annotation.Generated("ishimura")
  public void ensureClassInitialized(Class arg0){ unsafe.ensureClassInitialized(arg0);}
  @javax.annotation.Generated("ishimura")
  public long allocateMemory(long arg0){ return unsafe.allocateMemory(arg0);}
  @javax.annotation.Generated("ishimura")
  public long reallocateMemory(long arg0, long arg1){ return unsafe.reallocateMemory(arg0, arg1);}
  @javax.annotation.Generated("ishimura")
  public void setMemory(long arg0, long arg1, byte arg2){ unsafe.setMemory(arg0, arg1, arg2);}
  @javax.annotation.Generated("ishimura")
  public void setMemory(Object arg0, long arg1, long arg2, byte arg3){ unsafe.setMemory(arg0, arg1, arg2, arg3);}
  @javax.annotation.Generated("ishimura")
  public void freeMemory(long arg0){ unsafe.freeMemory(arg0);}
  @javax.annotation.Generated("ishimura")
  public int arrayBaseOffset(Class arg0){ return unsafe.arrayBaseOffset(arg0);}
  @javax.annotation.Generated("ishimura")
  public int arrayIndexScale(Class arg0){ return unsafe.arrayIndexScale(arg0);}
  @javax.annotation.Generated("ishimura")
  public int addressSize(){ return unsafe.addressSize();}
  @javax.annotation.Generated("ishimura")
  public int pageSize(){ return unsafe.pageSize();}
  @javax.annotation.Generated("ishimura")
  public Class defineAnonymousClass(Class arg0, byte[] arg1, Object[] arg2){ return unsafe.defineAnonymousClass(arg0, arg1, arg2);}
  @javax.annotation.Generated("ishimura")
  public void monitorEnter(Object arg0){ unsafe.monitorEnter(arg0);}
  @javax.annotation.Generated("ishimura")
  public void monitorExit(Object arg0){ unsafe.monitorExit(arg0);}
  @javax.annotation.Generated("ishimura")
  public boolean tryMonitorEnter(Object arg0){ return unsafe.tryMonitorEnter(arg0);}
  @javax.annotation.Generated("ishimura")
  public int getLoadAverage(double[] arg0, int arg1){ return unsafe.getLoadAverage(arg0, arg1);}



}
