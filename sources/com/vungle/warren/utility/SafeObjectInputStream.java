package com.vungle.warren.utility;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.util.List;

public class SafeObjectInputStream extends ObjectInputStream {
    public final List<Class<?>> allowed;

    public SafeObjectInputStream(InputStream inputStream, List<Class<?>> list) throws IOException {
        super(inputStream);
        this.allowed = list;
    }

    public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws ClassNotFoundException, IOException {
        Class<?> resolveClass = super.resolveClass(objectStreamClass);
        if (this.allowed == null || Number.class.isAssignableFrom(resolveClass) || String.class.equals(resolveClass) || Boolean.class.equals(resolveClass) || resolveClass.isArray() || this.allowed.contains(resolveClass)) {
            return resolveClass;
        }
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Deserialization is not allowed for ");
        outline24.append(objectStreamClass.getName());
        throw new IOException(outline24.toString());
    }
}
