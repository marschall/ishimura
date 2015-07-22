Ishimura
========

Provides access to `sun.misc.Unsafe` even if it is isolated away by a different class loader in [Jigsaw](http://openjdk.java.net/projects/jigsaw/).

Usage
-----
The interface `com.github.marschall.ishimura.UnsafeWrapper` exposes all the public methods of `sun.misc.Unsafe`. You can access it through:

```java
UnsafeWrapperFactory.getUnsafeWrapper()
```
Optionally you can pass in the unsafe instance if you already have it.

How does it work?
-----------------
The wrapper interface exposes all of the functionality of `sun.misc.Unsafe` without having to compile and link against it.
At runtime an implementation class is generated in a custom class loader that has access to `sun.misc.Unsafe`.


Why would I need this?
----------------------
You have an existing library that needs access to `sun.misc.Unsafe` but Java 9 hides it. You want to have that code working in Java 8 and 9 without a JDK switch or having to resort to reflection.

Does this actually work?
------------------------
We don't yet have a Jigsaw JDK so we don't know yet. It will all depend on whether we'll be able to get hold of a class loader that has access to `sun.misc.Unsafe`. Currently `sun.misc.Unsafe` is loaded using the bootstrap class loader which can't be accessed easily (`"".getClass().getClassLoader()` returns `null`). The current assumption is that `sun.misc.Unsafe` will be moved to a custom class loader. We assume that JDK classes using `sun.misc.Unsafe` like `java.util.concurrent.locks.LockSupport` will be moved from the bootstrap class loader to a custom class loader that is either the same or has access to `sun.misc.Unsafe` as well. If that is the case and we can access their class loader using `#getClassLoader()` then our approach should work.

This code likely breaks when there is a security manager present.

> While you can take away classes from people you can't take away class loaders from people.


