package com.github.marschall.ishimura;

import sun.misc.Unsafe;

/**
 * Implementation of {@link UnsafeWrapper} that delegates to
 * {@link sun.misc.Unsafe}.
 *
 * <p>This class will have to be loaded from a class loader that has access
 * to {@link sun.misc.Unsafe}.</p>
 *
 * <p>This class will not be present in the resulting JAR. Instead the byte
 * code will be stored in {@link TwoParentClassLoader}.</p>
 */
final class UnsafeWrapperImpl implements UnsafeWrapper {

  private final sun.misc.Unsafe unsafe;

  UnsafeWrapperImpl(Object unsafe) {
    this.unsafe = (Unsafe) unsafe;
  }

  public Object allocateInstance(Class arg0) throws InstantiationException{ return unsafe.allocateInstance(arg0);}
  public void copyMemory(long arg0, long arg1, long arg2){ unsafe.copyMemory(arg0, arg1, arg2);}
  public void copyMemory(Object arg0, long arg1, Object arg2, long arg3, long arg4){ unsafe.copyMemory(arg0, arg1, arg2, arg3, arg4);}
  public void park(boolean arg0, long arg1){ unsafe.park(arg0, arg1);}
  public void unpark(Object arg0){ unsafe.unpark(arg0);}
  public void loadFence(){ unsafe.loadFence();}
  public void storeFence(){ unsafe.storeFence();}
  public void fullFence(){ unsafe.fullFence();}
  public Object getObject(Object arg0, long arg1){ return unsafe.getObject(arg0, arg1);}
  public Object getObject(Object arg0, int arg1){ return unsafe.getObject(arg0, arg1);}
  public void putObject(Object arg0, long arg1, Object arg2){ unsafe.putObject(arg0, arg1, arg2);}
  public void putObject(Object arg0, int arg1, Object arg2){ unsafe.putObject(arg0, arg1, arg2);}
  public boolean getBoolean(Object arg0, int arg1){ return unsafe.getBoolean(arg0, arg1);}
  public boolean getBoolean(Object arg0, long arg1){ return unsafe.getBoolean(arg0, arg1);}
  public void putBoolean(Object arg0, int arg1, boolean arg2){ unsafe.putBoolean(arg0, arg1, arg2);}
  public void putBoolean(Object arg0, long arg1, boolean arg2){ unsafe.putBoolean(arg0, arg1, arg2);}
  public byte getByte(long arg0){ return unsafe.getByte(arg0);}
  public byte getByte(Object arg0, long arg1){ return unsafe.getByte(arg0, arg1);}
  public byte getByte(Object arg0, int arg1){ return unsafe.getByte(arg0, arg1);}
  public void putByte(long arg0, byte arg1){ unsafe.putByte(arg0, arg1);}
  public void putByte(Object arg0, int arg1, byte arg2){ unsafe.putByte(arg0, arg1, arg2);}
  public void putByte(Object arg0, long arg1, byte arg2){ unsafe.putByte(arg0, arg1, arg2);}
  public short getShort(Object arg0, int arg1){ return unsafe.getShort(arg0, arg1);}
  public short getShort(long arg0){ return unsafe.getShort(arg0);}
  public short getShort(Object arg0, long arg1){ return unsafe.getShort(arg0, arg1);}
  public void putShort(Object arg0, int arg1, short arg2){ unsafe.putShort(arg0, arg1, arg2);}
  public void putShort(long arg0, short arg1){ unsafe.putShort(arg0, arg1);}
  public void putShort(Object arg0, long arg1, short arg2){ unsafe.putShort(arg0, arg1, arg2);}
  public char getChar(long arg0){ return unsafe.getChar(arg0);}
  public char getChar(Object arg0, long arg1){ return unsafe.getChar(arg0, arg1);}
  public char getChar(Object arg0, int arg1){ return unsafe.getChar(arg0, arg1);}
  public void putChar(long arg0, char arg1){ unsafe.putChar(arg0, arg1);}
  public void putChar(Object arg0, long arg1, char arg2){ unsafe.putChar(arg0, arg1, arg2);}
  public void putChar(Object arg0, int arg1, char arg2){ unsafe.putChar(arg0, arg1, arg2);}
  public int getInt(Object arg0, long arg1){ return unsafe.getInt(arg0, arg1);}
  public int getInt(Object arg0, int arg1){ return unsafe.getInt(arg0, arg1);}
  public int getInt(long arg0){ return unsafe.getInt(arg0);}
  public void putInt(long arg0, int arg1){ unsafe.putInt(arg0, arg1);}
  public void putInt(Object arg0, int arg1, int arg2){ unsafe.putInt(arg0, arg1, arg2);}
  public void putInt(Object arg0, long arg1, int arg2){ unsafe.putInt(arg0, arg1, arg2);}
  public long getLong(Object arg0, int arg1){ return unsafe.getLong(arg0, arg1);}
  public long getLong(long arg0){ return unsafe.getLong(arg0);}
  public long getLong(Object arg0, long arg1){ return unsafe.getLong(arg0, arg1);}
  public void putLong(long arg0, long arg1){ unsafe.putLong(arg0, arg1);}
  public void putLong(Object arg0, long arg1, long arg2){ unsafe.putLong(arg0, arg1, arg2);}
  public void putLong(Object arg0, int arg1, long arg2){ unsafe.putLong(arg0, arg1, arg2);}
  public float getFloat(Object arg0, long arg1){ return unsafe.getFloat(arg0, arg1);}
  public float getFloat(long arg0){ return unsafe.getFloat(arg0);}
  public float getFloat(Object arg0, int arg1){ return unsafe.getFloat(arg0, arg1);}
  public void putFloat(Object arg0, long arg1, float arg2){ unsafe.putFloat(arg0, arg1, arg2);}
  public void putFloat(long arg0, float arg1){ unsafe.putFloat(arg0, arg1);}
  public void putFloat(Object arg0, int arg1, float arg2){ unsafe.putFloat(arg0, arg1, arg2);}
  public double getDouble(Object arg0, long arg1){ return unsafe.getDouble(arg0, arg1);}
  public double getDouble(Object arg0, int arg1){ return unsafe.getDouble(arg0, arg1);}
  public double getDouble(long arg0){ return unsafe.getDouble(arg0);}
  public void putDouble(Object arg0, int arg1, double arg2){ unsafe.putDouble(arg0, arg1, arg2);}
  public void putDouble(long arg0, double arg1){ unsafe.putDouble(arg0, arg1);}
  public void putDouble(Object arg0, long arg1, double arg2){ unsafe.putDouble(arg0, arg1, arg2);}
  public Object getObjectVolatile(Object arg0, long arg1){ return unsafe.getObjectVolatile(arg0, arg1);}
  public void putObjectVolatile(Object arg0, long arg1, Object arg2){ unsafe.putObjectVolatile(arg0, arg1, arg2);}
  public boolean getBooleanVolatile(Object arg0, long arg1){ return unsafe.getBooleanVolatile(arg0, arg1);}
  public void putBooleanVolatile(Object arg0, long arg1, boolean arg2){ unsafe.putBooleanVolatile(arg0, arg1, arg2);}
  public byte getByteVolatile(Object arg0, long arg1){ return unsafe.getByteVolatile(arg0, arg1);}
  public void putByteVolatile(Object arg0, long arg1, byte arg2){ unsafe.putByteVolatile(arg0, arg1, arg2);}
  public short getShortVolatile(Object arg0, long arg1){ return unsafe.getShortVolatile(arg0, arg1);}
  public void putShortVolatile(Object arg0, long arg1, short arg2){ unsafe.putShortVolatile(arg0, arg1, arg2);}
  public char getCharVolatile(Object arg0, long arg1){ return unsafe.getCharVolatile(arg0, arg1);}
  public void putCharVolatile(Object arg0, long arg1, char arg2){ unsafe.putCharVolatile(arg0, arg1, arg2);}
  public int getIntVolatile(Object arg0, long arg1){ return unsafe.getIntVolatile(arg0, arg1);}
  public void putIntVolatile(Object arg0, long arg1, int arg2){ unsafe.putIntVolatile(arg0, arg1, arg2);}
  public long getLongVolatile(Object arg0, long arg1){ return unsafe.getLongVolatile(arg0, arg1);}
  public void putLongVolatile(Object arg0, long arg1, long arg2){ unsafe.putLongVolatile(arg0, arg1, arg2);}
  public float getFloatVolatile(Object arg0, long arg1){ return unsafe.getFloatVolatile(arg0, arg1);}
  public void putFloatVolatile(Object arg0, long arg1, float arg2){ unsafe.putFloatVolatile(arg0, arg1, arg2);}
  public double getDoubleVolatile(Object arg0, long arg1){ return unsafe.getDoubleVolatile(arg0, arg1);}
  public void putDoubleVolatile(Object arg0, long arg1, double arg2){ unsafe.putDoubleVolatile(arg0, arg1, arg2);}
  public long getAddress(long arg0){ return unsafe.getAddress(arg0);}
  public void putAddress(long arg0, long arg1){ unsafe.putAddress(arg0, arg1);}
  public boolean compareAndSwapObject(Object arg0, long arg1, Object arg2, Object arg3){ return unsafe.compareAndSwapObject(arg0, arg1, arg2, arg3);}
  public boolean compareAndSwapLong(Object arg0, long arg1, long arg2, long arg3){ return unsafe.compareAndSwapLong(arg0, arg1, arg2, arg3);}
  public boolean compareAndSwapInt(Object arg0, long arg1, int arg2, int arg3){ return unsafe.compareAndSwapInt(arg0, arg1, arg2, arg3);}
  public void putOrderedObject(Object arg0, long arg1, Object arg2){ unsafe.putOrderedObject(arg0, arg1, arg2);}
  public void putOrderedLong(Object arg0, long arg1, long arg2){ unsafe.putOrderedLong(arg0, arg1, arg2);}
  public void putOrderedInt(Object arg0, long arg1, int arg2){ unsafe.putOrderedInt(arg0, arg1, arg2);}
  public int getAndAddInt(Object arg0, long arg1, int arg2){ return unsafe.getAndAddInt(arg0, arg1, arg2);}
  public long getAndAddLong(Object arg0, long arg1, long arg2){ return unsafe.getAndAddLong(arg0, arg1, arg2);}
  public int getAndSetInt(Object arg0, long arg1, int arg2){ return unsafe.getAndSetInt(arg0, arg1, arg2);}
  public long getAndSetLong(Object arg0, long arg1, long arg2){ return unsafe.getAndSetLong(arg0, arg1, arg2);}
  public Object getAndSetObject(Object arg0, long arg1, Object arg2){ return unsafe.getAndSetObject(arg0, arg1, arg2);}
  public void throwException(Throwable arg0){ unsafe.throwException(arg0);}
  public Class defineClass(String arg0, byte[] arg1, int arg2, int arg3, ClassLoader arg4, java.security.ProtectionDomain arg5){ return unsafe.defineClass(arg0, arg1, arg2, arg3, arg4, arg5);}
  public Object staticFieldBase(java.lang.reflect.Field arg0){ return unsafe.staticFieldBase(arg0);}
  public Object staticFieldBase(Class arg0){ return unsafe.staticFieldBase(arg0);}
  public int fieldOffset(java.lang.reflect.Field arg0){ return unsafe.fieldOffset(arg0);}
  public long staticFieldOffset(java.lang.reflect.Field arg0){ return unsafe.staticFieldOffset(arg0);}
  public long objectFieldOffset(java.lang.reflect.Field arg0){ return unsafe.objectFieldOffset(arg0);}
  public boolean shouldBeInitialized(Class arg0){ return unsafe.shouldBeInitialized(arg0);}
  public void ensureClassInitialized(Class arg0){ unsafe.ensureClassInitialized(arg0);}
  public long allocateMemory(long arg0){ return unsafe.allocateMemory(arg0);}
  public long reallocateMemory(long arg0, long arg1){ return unsafe.reallocateMemory(arg0, arg1);}
  public void setMemory(long arg0, long arg1, byte arg2){ unsafe.setMemory(arg0, arg1, arg2);}
  public void setMemory(Object arg0, long arg1, long arg2, byte arg3){ unsafe.setMemory(arg0, arg1, arg2, arg3);}
  public void freeMemory(long arg0){ unsafe.freeMemory(arg0);}
  public int arrayBaseOffset(Class arg0){ return unsafe.arrayBaseOffset(arg0);}
  public int arrayIndexScale(Class arg0){ return unsafe.arrayIndexScale(arg0);}
  public int addressSize(){ return unsafe.addressSize();}
  public int pageSize(){ return unsafe.pageSize();}
  public Class defineAnonymousClass(Class arg0, byte[] arg1, Object[] arg2){ return unsafe.defineAnonymousClass(arg0, arg1, arg2);}
  public void monitorEnter(Object arg0){ unsafe.monitorEnter(arg0);}
  public void monitorExit(Object arg0){ unsafe.monitorExit(arg0);}
  public boolean tryMonitorEnter(Object arg0){ return unsafe.tryMonitorEnter(arg0);}
  public int getLoadAverage(double[] arg0, int arg1){ return unsafe.getLoadAverage(arg0, arg1);}

}
