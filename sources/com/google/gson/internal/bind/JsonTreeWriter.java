package com.google.gson.internal.bind;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class JsonTreeWriter extends JsonWriter {
    public static final JsonPrimitive SENTINEL_CLOSED = new JsonPrimitive("closed");
    public static final Writer UNWRITABLE_WRITER = new Writer() {
        public void close() throws IOException {
            throw new AssertionError();
        }

        public void flush() throws IOException {
            throw new AssertionError();
        }

        public void write(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }
    };
    public String pendingName;
    public JsonElement product = JsonNull.INSTANCE;
    public final List<JsonElement> stack = new ArrayList();

    public JsonTreeWriter() {
        super(UNWRITABLE_WRITER);
    }

    public JsonWriter beginArray() throws IOException {
        JsonArray jsonArray = new JsonArray();
        put(jsonArray);
        this.stack.add(jsonArray);
        return this;
    }

    public JsonWriter beginObject() throws IOException {
        JsonObject jsonObject = new JsonObject();
        put(jsonObject);
        this.stack.add(jsonObject);
        return this;
    }

    public void close() throws IOException {
        if (this.stack.isEmpty()) {
            this.stack.add(SENTINEL_CLOSED);
            return;
        }
        throw new IOException("Incomplete document");
    }

    public JsonWriter endArray() throws IOException {
        if (this.stack.isEmpty() || this.pendingName != null) {
            throw new IllegalStateException();
        } else if (peek() instanceof JsonArray) {
            List<JsonElement> list = this.stack;
            list.remove(list.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public JsonWriter endObject() throws IOException {
        if (this.stack.isEmpty() || this.pendingName != null) {
            throw new IllegalStateException();
        } else if (peek() instanceof JsonObject) {
            List<JsonElement> list = this.stack;
            list.remove(list.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public void flush() throws IOException {
    }

    public JsonElement get() {
        if (this.stack.isEmpty()) {
            return this.product;
        }
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Expected one JSON element but was ");
        outline24.append(this.stack);
        throw new IllegalStateException(outline24.toString());
    }

    public JsonWriter name(String str) throws IOException {
        if (this.stack.isEmpty() || this.pendingName != null) {
            throw new IllegalStateException();
        } else if (peek() instanceof JsonObject) {
            this.pendingName = str;
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public JsonWriter nullValue() throws IOException {
        put(JsonNull.INSTANCE);
        return this;
    }

    public final JsonElement peek() {
        List<JsonElement> list = this.stack;
        return list.get(list.size() - 1);
    }

    public final void put(JsonElement jsonElement) {
        if (this.pendingName != null) {
            if (!(jsonElement instanceof JsonNull) || getSerializeNulls()) {
                ((JsonObject) peek()).add(this.pendingName, jsonElement);
            }
            this.pendingName = null;
        } else if (this.stack.isEmpty()) {
            this.product = jsonElement;
        } else {
            JsonElement peek = peek();
            if (peek instanceof JsonArray) {
                ((JsonArray) peek).elements.add(jsonElement);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public JsonWriter value(Boolean bool) throws IOException {
        if (bool == null) {
            put(JsonNull.INSTANCE);
            return this;
        }
        put(new JsonPrimitive(bool));
        return this;
    }

    public JsonWriter value(Number number) throws IOException {
        if (number == null) {
            put(JsonNull.INSTANCE);
            return this;
        }
        if (!isLenient()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        put(new JsonPrimitive(number));
        return this;
    }

    public JsonWriter value(String str) throws IOException {
        if (str == null) {
            put(JsonNull.INSTANCE);
            return this;
        }
        put(new JsonPrimitive(str));
        return this;
    }

    public JsonWriter value(boolean z) throws IOException {
        put(new JsonPrimitive(Boolean.valueOf(z)));
        return this;
    }

    public JsonWriter value(double d) throws IOException {
        if (isLenient() || (!Double.isNaN(d) && !Double.isInfinite(d))) {
            put(new JsonPrimitive((Number) Double.valueOf(d)));
            return this;
        }
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d);
    }

    public JsonWriter value(long j) throws IOException {
        put(new JsonPrimitive((Number) Long.valueOf(j)));
        return this;
    }
}
