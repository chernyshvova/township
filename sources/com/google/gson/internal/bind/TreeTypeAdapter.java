package com.google.gson.internal.bind;

import com.android.billingclient.api.zzam;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

public final class TreeTypeAdapter<T> extends TypeAdapter<T> {
    public final TreeTypeAdapter<T>.GsonContextImpl context = new GsonContextImpl((C24091) null);
    public TypeAdapter<T> delegate;
    public final JsonDeserializer<T> deserializer;
    public final Gson gson;
    public final JsonSerializer<T> serializer;
    public final TypeAdapterFactory skipPast;
    public final TypeToken<T> typeToken;

    public final class GsonContextImpl implements JsonSerializationContext, JsonDeserializationContext {
        public GsonContextImpl(C24091 r2) {
        }
    }

    public static final class SingleTypeFactory implements TypeAdapterFactory {
        public final JsonDeserializer<?> deserializer;
        public final TypeToken<?> exactType;
        public final Class<?> hierarchyType;
        public final boolean matchRawType;
        public final JsonSerializer<?> serializer;

        public SingleTypeFactory(Object obj, TypeToken<?> typeToken, boolean z, Class<?> cls) {
            JsonDeserializer<?> jsonDeserializer = null;
            this.serializer = obj instanceof JsonSerializer ? (JsonSerializer) obj : null;
            jsonDeserializer = obj instanceof JsonDeserializer ? (JsonDeserializer) obj : jsonDeserializer;
            this.deserializer = jsonDeserializer;
            zzam.checkArgument((this.serializer == null && jsonDeserializer == null) ? false : true);
            this.exactType = typeToken;
            this.matchRawType = z;
            this.hierarchyType = cls;
        }

        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            boolean z;
            TypeToken<?> typeToken2 = this.exactType;
            if (typeToken2 != null) {
                z = typeToken2.equals(typeToken) || (this.matchRawType && this.exactType.getType() == typeToken.getRawType());
            } else {
                z = this.hierarchyType.isAssignableFrom(typeToken.getRawType());
            }
            if (z) {
                return new TreeTypeAdapter(this.serializer, this.deserializer, gson, typeToken, this);
            }
            return null;
        }
    }

    public TreeTypeAdapter(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson2, TypeToken<T> typeToken2, TypeAdapterFactory typeAdapterFactory) {
        this.serializer = jsonSerializer;
        this.deserializer = jsonDeserializer;
        this.gson = gson2;
        this.typeToken = typeToken2;
        this.skipPast = typeAdapterFactory;
    }

    public T read(JsonReader jsonReader) throws IOException {
        if (this.deserializer == null) {
            TypeAdapter<T> typeAdapter = this.delegate;
            if (typeAdapter == null) {
                typeAdapter = this.gson.getDelegateAdapter(this.skipPast, this.typeToken);
                this.delegate = typeAdapter;
            }
            return typeAdapter.read(jsonReader);
        }
        JsonElement parse = zzam.parse(jsonReader);
        if (parse == null) {
            throw null;
        } else if (parse instanceof JsonNull) {
            return null;
        } else {
            return this.deserializer.deserialize(parse, this.typeToken.getType(), this.context);
        }
    }

    public void write(JsonWriter jsonWriter, T t) throws IOException {
        JsonSerializer<T> jsonSerializer = this.serializer;
        if (jsonSerializer == null) {
            TypeAdapter<T> typeAdapter = this.delegate;
            if (typeAdapter == null) {
                typeAdapter = this.gson.getDelegateAdapter(this.skipPast, this.typeToken);
                this.delegate = typeAdapter;
            }
            typeAdapter.write(jsonWriter, t);
        } else if (t == null) {
            jsonWriter.nullValue();
        } else {
            TypeAdapters.JSON_ELEMENT.write(jsonWriter, jsonSerializer.serialize(t, this.typeToken.getType(), this.context));
        }
    }
}
