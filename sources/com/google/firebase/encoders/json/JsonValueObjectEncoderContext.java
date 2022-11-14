package com.google.firebase.encoders.json;

import android.util.Base64;
import android.util.JsonWriter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-encoders-json@@16.0.0 */
public final class JsonValueObjectEncoderContext implements ObjectEncoderContext, ValueEncoderContext {
    public boolean active = true;
    public JsonValueObjectEncoderContext childContext = null;
    public final JsonWriter jsonWriter;
    public final Map<Class<?>, ObjectEncoder<?>> objectEncoders;
    public final Map<Class<?>, ValueEncoder<?>> valueEncoders;

    public JsonValueObjectEncoderContext(@NonNull Writer writer, @NonNull Map<Class<?>, ObjectEncoder<?>> map, @NonNull Map<Class<?>, ValueEncoder<?>> map2) {
        this.jsonWriter = new JsonWriter(writer);
        this.objectEncoders = map;
        this.valueEncoders = map2;
    }

    @NonNull
    public ObjectEncoderContext add(@NonNull String str, @Nullable Object obj) throws IOException, EncodingException {
        maybeUnNest();
        this.jsonWriter.name(str);
        if (obj != null) {
            return add(obj);
        }
        this.jsonWriter.nullValue();
        return this;
    }

    public final void maybeUnNest() throws IOException {
        if (this.active) {
            JsonValueObjectEncoderContext jsonValueObjectEncoderContext = this.childContext;
            if (jsonValueObjectEncoderContext != null) {
                jsonValueObjectEncoderContext.maybeUnNest();
                this.childContext.active = false;
                this.childContext = null;
                this.jsonWriter.endObject();
                return;
            }
            return;
        }
        throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
    }

    @NonNull
    public ObjectEncoderContext add(@NonNull String str, int i) throws IOException, EncodingException {
        maybeUnNest();
        this.jsonWriter.name(str);
        maybeUnNest();
        this.jsonWriter.value((long) i);
        return this;
    }

    @NonNull
    public ObjectEncoderContext add(@NonNull String str, long j) throws IOException, EncodingException {
        maybeUnNest();
        this.jsonWriter.name(str);
        maybeUnNest();
        this.jsonWriter.value(j);
        return this;
    }

    @NonNull
    public ValueEncoderContext add(@Nullable String str) throws IOException, EncodingException {
        maybeUnNest();
        this.jsonWriter.value(str);
        return this;
    }

    @NonNull
    public ValueEncoderContext add(boolean z) throws IOException, EncodingException {
        maybeUnNest();
        this.jsonWriter.value(z);
        return this;
    }

    @NonNull
    public JsonValueObjectEncoderContext add(@Nullable Object obj) throws IOException, EncodingException {
        if (obj == null) {
            this.jsonWriter.nullValue();
            return this;
        } else if (obj instanceof Number) {
            this.jsonWriter.value((Number) obj);
            return this;
        } else {
            int i = 0;
            if (obj.getClass().isArray()) {
                if (obj instanceof byte[]) {
                    maybeUnNest();
                    this.jsonWriter.value(Base64.encodeToString((byte[]) obj, 2));
                    return this;
                }
                this.jsonWriter.beginArray();
                if (obj instanceof int[]) {
                    int[] iArr = (int[]) obj;
                    int length = iArr.length;
                    while (i < length) {
                        this.jsonWriter.value((long) iArr[i]);
                        i++;
                    }
                } else if (obj instanceof long[]) {
                    long[] jArr = (long[]) obj;
                    int length2 = jArr.length;
                    while (i < length2) {
                        long j = jArr[i];
                        maybeUnNest();
                        this.jsonWriter.value(j);
                        i++;
                    }
                } else if (obj instanceof double[]) {
                    double[] dArr = (double[]) obj;
                    int length3 = dArr.length;
                    while (i < length3) {
                        this.jsonWriter.value(dArr[i]);
                        i++;
                    }
                } else if (obj instanceof boolean[]) {
                    boolean[] zArr = (boolean[]) obj;
                    int length4 = zArr.length;
                    while (i < length4) {
                        this.jsonWriter.value(zArr[i]);
                        i++;
                    }
                } else if (obj instanceof Number[]) {
                    Number[] numberArr = (Number[]) obj;
                    int length5 = numberArr.length;
                    while (i < length5) {
                        add((Object) numberArr[i]);
                        i++;
                    }
                } else {
                    Object[] objArr = (Object[]) obj;
                    int length6 = objArr.length;
                    while (i < length6) {
                        add(objArr[i]);
                        i++;
                    }
                }
                this.jsonWriter.endArray();
                return this;
            } else if (obj instanceof Collection) {
                this.jsonWriter.beginArray();
                for (Object add : (Collection) obj) {
                    add(add);
                }
                this.jsonWriter.endArray();
                return this;
            } else if (obj instanceof Map) {
                this.jsonWriter.beginObject();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    Object key = entry.getKey();
                    try {
                        Object value = entry.getValue();
                        maybeUnNest();
                        this.jsonWriter.name((String) key);
                        if (value == null) {
                            this.jsonWriter.nullValue();
                        } else {
                            add(value);
                        }
                    } catch (ClassCastException e) {
                        throw new EncodingException(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", new Object[]{key, key.getClass()}), e);
                    }
                }
                this.jsonWriter.endObject();
                return this;
            } else {
                ObjectEncoder objectEncoder = this.objectEncoders.get(obj.getClass());
                if (objectEncoder != null) {
                    this.jsonWriter.beginObject();
                    objectEncoder.encode(obj, this);
                    this.jsonWriter.endObject();
                    return this;
                }
                ValueEncoder valueEncoder = this.valueEncoders.get(obj.getClass());
                if (valueEncoder != null) {
                    valueEncoder.encode(obj, this);
                    return this;
                } else if (obj instanceof Enum) {
                    String name = ((Enum) obj).name();
                    maybeUnNest();
                    this.jsonWriter.value(name);
                    return this;
                } else {
                    StringBuilder outline24 = GeneratedOutlineSupport.outline24("Couldn't find encoder for type ");
                    outline24.append(obj.getClass().getCanonicalName());
                    throw new EncodingException(outline24.toString());
                }
            }
        }
    }
}
