Ishimura
========

Provides access to `sun.misc.Unsafe` even if it is isolated away by a different class loader.

Usage
-----
The interface `com.github.marschall.ishimura.UnsafeWrapper` exposes all the public methods of `sun.misc.Unsafe`.

```java
UnsafeWrapperFactory.getUnsafeWrapper()
```
Optionally you can pass in the unsafe instance if you already have it.

How does it work?
-----------------

Why would I need this?
----------------------

This code likely breaks when there is a security manager present.

> While you can take away classes from people you can't take away class loaders from people.


