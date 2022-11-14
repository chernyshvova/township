package com.google.gson.internal;

import com.google.gson.ExclusionStrategy;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Excluder implements TypeAdapterFactory, Cloneable {
    public static final Excluder DEFAULT = new Excluder();
    public List<ExclusionStrategy> deserializationStrategies = Collections.emptyList();
    public int modifiers = 136;
    public boolean requireExpose;
    public List<ExclusionStrategy> serializationStrategies = Collections.emptyList();
    public boolean serializeInnerClasses = true;
    public double version = -1.0d;

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        boolean excludeClassChecks = excludeClassChecks(rawType);
        final boolean z = excludeClassChecks || excludeClassInStrategy(rawType, true);
        final boolean z2 = excludeClassChecks || excludeClassInStrategy(rawType, false);
        if (!z && !z2) {
            return null;
        }
        final Gson gson2 = gson;
        final TypeToken<T> typeToken2 = typeToken;
        return new TypeAdapter<T>() {
            public TypeAdapter<T> delegate;

            public T read(JsonReader jsonReader) throws IOException {
                if (z2) {
                    jsonReader.skipValue();
                    return null;
                }
                TypeAdapter<T> typeAdapter = this.delegate;
                if (typeAdapter == null) {
                    typeAdapter = gson2.getDelegateAdapter(Excluder.this, typeToken2);
                    this.delegate = typeAdapter;
                }
                return typeAdapter.read(jsonReader);
            }

            public void write(JsonWriter jsonWriter, T t) throws IOException {
                if (z) {
                    jsonWriter.nullValue();
                    return;
                }
                TypeAdapter<T> typeAdapter = this.delegate;
                if (typeAdapter == null) {
                    typeAdapter = gson2.getDelegateAdapter(Excluder.this, typeToken2);
                    this.delegate = typeAdapter;
                }
                typeAdapter.write(jsonWriter, t);
            }
        };
    }

    public final boolean excludeClassChecks(Class<?> cls) {
        if (this.version != -1.0d && !isValidVersion((Since) cls.getAnnotation(Since.class), (Until) cls.getAnnotation(Until.class))) {
            return true;
        }
        if ((this.serializeInnerClasses || !isInnerClass(cls)) && !isAnonymousOrLocal(cls)) {
            return false;
        }
        return true;
    }

    public final boolean excludeClassInStrategy(Class<?> cls, boolean z) {
        for (ExclusionStrategy shouldSkipClass : z ? this.serializationStrategies : this.deserializationStrategies) {
            if (shouldSkipClass.shouldSkipClass(cls)) {
                return true;
            }
        }
        return false;
    }

    public final boolean isAnonymousOrLocal(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    public final boolean isInnerClass(Class<?> cls) {
        if (cls.isMemberClass()) {
            if (!((cls.getModifiers() & 8) != 0)) {
                return true;
            }
        }
        return false;
    }

    public final boolean isValidVersion(Since since, Until until) {
        if (!(since == null || since.value() <= this.version)) {
            return false;
        }
        if (until == null || until.value() > this.version) {
            return true;
        }
        return false;
    }

    public Excluder withExclusionStrategy(ExclusionStrategy exclusionStrategy, boolean z, boolean z2) {
        Excluder clone = clone();
        if (z) {
            ArrayList arrayList = new ArrayList(this.serializationStrategies);
            clone.serializationStrategies = arrayList;
            arrayList.add(exclusionStrategy);
        }
        if (z2) {
            ArrayList arrayList2 = new ArrayList(this.deserializationStrategies);
            clone.deserializationStrategies = arrayList2;
            arrayList2.add(exclusionStrategy);
        }
        return clone;
    }

    public Excluder clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
