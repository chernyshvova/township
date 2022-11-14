package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public final class TypeAdapterRuntimeTypeWrapper<T> extends TypeAdapter<T> {
    public final Gson context;
    public final TypeAdapter<T> delegate;
    public final Type type;

    public TypeAdapterRuntimeTypeWrapper(Gson gson, TypeAdapter<T> typeAdapter, Type type2) {
        this.context = gson;
        this.delegate = typeAdapter;
        this.type = type2;
    }

    public T read(JsonReader jsonReader) throws IOException {
        return this.delegate.read(jsonReader);
    }

    public void write(JsonWriter jsonWriter, T t) throws IOException {
        TypeAdapter<T> typeAdapter = this.delegate;
        Type type2 = this.type;
        if (t != null && (type2 == Object.class || (type2 instanceof TypeVariable) || (type2 instanceof Class))) {
            type2 = t.getClass();
        }
        if (type2 != this.type) {
            typeAdapter = this.context.getAdapter(TypeToken.get(type2));
            if (typeAdapter instanceof ReflectiveTypeAdapterFactory.Adapter) {
                TypeAdapter<T> typeAdapter2 = this.delegate;
                if (!(typeAdapter2 instanceof ReflectiveTypeAdapterFactory.Adapter)) {
                    typeAdapter = typeAdapter2;
                }
            }
        }
        typeAdapter.write(jsonWriter, t);
    }
}
