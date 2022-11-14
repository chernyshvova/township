package com.google.gson.internal.reflect;

import com.google.gson.internal.JavaVersion;
import java.lang.reflect.AccessibleObject;

public abstract class ReflectionAccessor {
    public static final ReflectionAccessor instance = (JavaVersion.majorJavaVersion < 9 ? new PreJava9ReflectionAccessor() : new UnsafeReflectionAccessor());

    public abstract void makeAccessible(AccessibleObject accessibleObject);
}
