package com.google.gson.internal;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.lang.reflect.Modifier;

public abstract class UnsafeAllocator {
    public static void assertInstantiable(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("Interface can't be instantiated! Interface name: ");
            outline24.append(cls.getName());
            throw new UnsupportedOperationException(outline24.toString());
        } else if (Modifier.isAbstract(modifiers)) {
            StringBuilder outline242 = GeneratedOutlineSupport.outline24("Abstract class can't be instantiated! Class name: ");
            outline242.append(cls.getName());
            throw new UnsupportedOperationException(outline242.toString());
        }
    }

    public abstract <T> T newInstance(Class<T> cls) throws Exception;
}
