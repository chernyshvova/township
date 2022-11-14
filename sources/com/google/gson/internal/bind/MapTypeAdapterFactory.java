package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

public final class MapTypeAdapterFactory implements TypeAdapterFactory {
    public final boolean complexMapKeySerialization;
    public final ConstructorConstructor constructorConstructor;

    public final class Adapter<K, V> extends TypeAdapter<Map<K, V>> {
        public final ObjectConstructor<? extends Map<K, V>> constructor;
        public final TypeAdapter<K> keyTypeAdapter;
        public final TypeAdapter<V> valueTypeAdapter;

        public Adapter(Gson gson, Type type, TypeAdapter<K> typeAdapter, Type type2, TypeAdapter<V> typeAdapter2, ObjectConstructor<? extends Map<K, V>> objectConstructor) {
            this.keyTypeAdapter = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.valueTypeAdapter = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter2, type2);
            this.constructor = objectConstructor;
        }

        public Object read(JsonReader jsonReader) throws IOException {
            JsonToken peek = jsonReader.peek();
            if (peek == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            Map map = (Map) this.constructor.construct();
            if (peek == JsonToken.BEGIN_ARRAY) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    jsonReader.beginArray();
                    K read = this.keyTypeAdapter.read(jsonReader);
                    if (map.put(read, this.valueTypeAdapter.read(jsonReader)) == null) {
                        jsonReader.endArray();
                    } else {
                        throw new JsonSyntaxException("duplicate key: " + read);
                    }
                }
                jsonReader.endArray();
            } else {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    JsonReaderInternalAccess.INSTANCE.promoteNameToValue(jsonReader);
                    K read2 = this.keyTypeAdapter.read(jsonReader);
                    if (map.put(read2, this.valueTypeAdapter.read(jsonReader)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + read2);
                    }
                }
                jsonReader.endObject();
            }
            return map;
        }

        public void write(JsonWriter jsonWriter, Object obj) throws IOException {
            String str;
            Map map = (Map) obj;
            if (map == null) {
                jsonWriter.nullValue();
            } else if (!MapTypeAdapterFactory.this.complexMapKeySerialization) {
                jsonWriter.beginObject();
                for (Map.Entry entry : map.entrySet()) {
                    jsonWriter.name(String.valueOf(entry.getKey()));
                    this.valueTypeAdapter.write(jsonWriter, entry.getValue());
                }
                jsonWriter.endObject();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                int i = 0;
                boolean z = false;
                for (Map.Entry entry2 : map.entrySet()) {
                    TypeAdapter<K> typeAdapter = this.keyTypeAdapter;
                    Object key = entry2.getKey();
                    if (typeAdapter != null) {
                        try {
                            JsonTreeWriter jsonTreeWriter = new JsonTreeWriter();
                            typeAdapter.write(jsonTreeWriter, key);
                            JsonElement jsonElement = jsonTreeWriter.get();
                            arrayList.add(jsonElement);
                            arrayList2.add(entry2.getValue());
                            if (jsonElement != null) {
                                z |= (jsonElement instanceof JsonArray) || (jsonElement instanceof JsonObject);
                            } else {
                                throw null;
                            }
                        } catch (IOException e) {
                            throw new JsonIOException((Throwable) e);
                        }
                    } else {
                        throw null;
                    }
                }
                if (z) {
                    jsonWriter.beginArray();
                    int size = arrayList.size();
                    while (i < size) {
                        jsonWriter.beginArray();
                        TypeAdapters.JSON_ELEMENT.write(jsonWriter, (JsonElement) arrayList.get(i));
                        this.valueTypeAdapter.write(jsonWriter, arrayList2.get(i));
                        jsonWriter.endArray();
                        i++;
                    }
                    jsonWriter.endArray();
                    return;
                }
                jsonWriter.beginObject();
                int size2 = arrayList.size();
                while (i < size2) {
                    JsonElement jsonElement2 = (JsonElement) arrayList.get(i);
                    if (jsonElement2 != null) {
                        if (jsonElement2 instanceof JsonPrimitive) {
                            JsonPrimitive asJsonPrimitive = jsonElement2.getAsJsonPrimitive();
                            Object obj2 = asJsonPrimitive.value;
                            if (obj2 instanceof Number) {
                                str = String.valueOf(asJsonPrimitive.getAsNumber());
                            } else if (obj2 instanceof Boolean) {
                                str = Boolean.toString(asJsonPrimitive.getAsBoolean());
                            } else if (obj2 instanceof String) {
                                str = asJsonPrimitive.getAsString();
                            } else {
                                throw new AssertionError();
                            }
                        } else if (jsonElement2 instanceof JsonNull) {
                            str = "null";
                        } else {
                            throw new AssertionError();
                        }
                        jsonWriter.name(str);
                        this.valueTypeAdapter.write(jsonWriter, arrayList2.get(i));
                        i++;
                    } else {
                        throw null;
                    }
                }
                jsonWriter.endObject();
            }
        }
    }

    public MapTypeAdapterFactory(ConstructorConstructor constructorConstructor2, boolean z) {
        this.constructorConstructor = constructorConstructor2;
        this.complexMapKeySerialization = z;
    }

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Type[] typeArr;
        TypeAdapter<Boolean> typeAdapter;
        Type type = typeToken.getType();
        if (!Map.class.isAssignableFrom(typeToken.getRawType())) {
            return null;
        }
        Class<?> rawType = C$Gson$Types.getRawType(type);
        Class<Object> cls = Object.class;
        Class<String> cls2 = String.class;
        if (type == Properties.class) {
            typeArr = new Type[]{cls2, cls2};
        } else {
            Type supertype = C$Gson$Types.getSupertype(type, rawType, Map.class);
            typeArr = supertype instanceof ParameterizedType ? ((ParameterizedType) supertype).getActualTypeArguments() : new Type[]{cls, cls};
        }
        Type type2 = typeArr[0];
        if (type2 == Boolean.TYPE || type2 == Boolean.class) {
            typeAdapter = TypeAdapters.BOOLEAN_AS_STRING;
        } else {
            typeAdapter = gson.getAdapter(TypeToken.get(type2));
        }
        return new Adapter(gson, typeArr[0], typeAdapter, typeArr[1], gson.getAdapter(TypeToken.get(typeArr[1])), this.constructorConstructor.get(typeToken));
    }
}
