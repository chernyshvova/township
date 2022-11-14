package com.google.gson.internal.reflect;

import com.google.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

public final class UnsafeReflectionAccessor extends ReflectionAccessor {
    public static Class unsafeClass;
    public final Field overrideField;
    public final Object theUnsafe;

    public UnsafeReflectionAccessor() {
        Object obj;
        Field field = null;
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            unsafeClass = cls;
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            obj = declaredField.get((Object) null);
        } catch (Exception unused) {
            obj = null;
        }
        this.theUnsafe = obj;
        try {
            field = AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException unused2) {
        }
        this.overrideField = field;
    }

    public void makeAccessible(AccessibleObject accessibleObject) {
        boolean z = false;
        if (!(this.theUnsafe == null || this.overrideField == null)) {
            try {
                long longValue = ((Long) unsafeClass.getMethod("objectFieldOffset", new Class[]{Field.class}).invoke(this.theUnsafe, new Object[]{this.overrideField})).longValue();
                unsafeClass.getMethod("putBoolean", new Class[]{Object.class, Long.TYPE, Boolean.TYPE}).invoke(this.theUnsafe, new Object[]{accessibleObject, Long.valueOf(longValue), Boolean.TRUE});
                z = true;
            } catch (Exception unused) {
            }
        }
        if (!z) {
            try {
                accessibleObject.setAccessible(true);
            } catch (SecurityException e) {
                throw new JsonIOException("Gson couldn't modify fields for " + accessibleObject + "\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.", e);
            }
        }
    }
}
