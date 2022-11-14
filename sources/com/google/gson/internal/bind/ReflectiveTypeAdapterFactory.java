package com.google.gson.internal.bind;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.reflect.ReflectionAccessor;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {
    public final ReflectionAccessor accessor = ReflectionAccessor.instance;
    public final ConstructorConstructor constructorConstructor;
    public final Excluder excluder;
    public final FieldNamingStrategy fieldNamingPolicy;
    public final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;

    public static final class Adapter<T> extends TypeAdapter<T> {
        public final Map<String, BoundField> boundFields;
        public final ObjectConstructor<T> constructor;

        public Adapter(ObjectConstructor<T> objectConstructor, Map<String, BoundField> map) {
            this.constructor = objectConstructor;
            this.boundFields = map;
        }

        public T read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            T construct = this.constructor.construct();
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    BoundField boundField = this.boundFields.get(jsonReader.nextName());
                    if (boundField != null) {
                        if (boundField.deserialized) {
                            C24061 r1 = (C24061) boundField;
                            Object read = r7.read(jsonReader);
                            if (read != null || !r10) {
                                r5.set(construct, read);
                            }
                        }
                    }
                    jsonReader.skipValue();
                }
                jsonReader.endObject();
                return construct;
            } catch (IllegalStateException e) {
                throw new JsonSyntaxException((Throwable) e);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }

        public void write(JsonWriter jsonWriter, T t) throws IOException {
            TypeAdapter typeAdapter;
            if (t == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            try {
                for (BoundField next : this.boundFields.values()) {
                    C24061 r2 = (C24061) next;
                    boolean z = false;
                    if (r2.serialized) {
                        if (r5.get(t) != t) {
                            z = true;
                        }
                    }
                    if (z) {
                        jsonWriter.name(next.name);
                        C24061 r1 = (C24061) next;
                        Object obj = r5.get(t);
                        if (r6) {
                            typeAdapter = r7;
                        } else {
                            typeAdapter = new TypeAdapterRuntimeTypeWrapper(r8, r7, r9.getType());
                        }
                        typeAdapter.write(jsonWriter, obj);
                    }
                }
                jsonWriter.endObject();
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
    }

    public static abstract class BoundField {
        public final boolean deserialized;
        public final String name;
        public final boolean serialized;

        public BoundField(String str, boolean z, boolean z2) {
            this.name = str;
            this.serialized = z;
            this.deserialized = z2;
        }
    }

    public ReflectiveTypeAdapterFactory(ConstructorConstructor constructorConstructor2, FieldNamingStrategy fieldNamingStrategy, Excluder excluder2, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory) {
        this.constructorConstructor = constructorConstructor2;
        this.fieldNamingPolicy = fieldNamingStrategy;
        this.excluder = excluder2;
        this.jsonAdapterFactory = jsonAdapterAnnotationTypeAdapterFactory;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x01a1 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0189 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> com.google.gson.TypeAdapter<T> create(com.google.gson.Gson r36, com.google.gson.reflect.TypeToken<T> r37) {
        /*
            r35 = this;
            r11 = r35
            r12 = r36
            java.lang.Class<java.lang.Object> r13 = java.lang.Object.class
            java.lang.Class r0 = r37.getRawType()
            boolean r1 = r13.isAssignableFrom(r0)
            r14 = 0
            if (r1 != 0) goto L_0x0012
            return r14
        L_0x0012:
            com.google.gson.internal.ConstructorConstructor r1 = r11.constructorConstructor
            r2 = r37
            com.google.gson.internal.ObjectConstructor r15 = r1.get(r2)
            com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$Adapter r10 = new com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$Adapter
            java.util.LinkedHashMap r9 = new java.util.LinkedHashMap
            r9.<init>()
            boolean r1 = r0.isInterface()
            if (r1 == 0) goto L_0x002e
        L_0x0027:
            r14 = r9
            r34 = r10
            r22 = r15
            goto L_0x01e4
        L_0x002e:
            java.lang.reflect.Type r8 = r37.getType()
            r7 = r0
            r16 = r2
        L_0x0035:
            if (r7 == r13) goto L_0x0027
            java.lang.reflect.Field[] r6 = r7.getDeclaredFields()
            int r5 = r6.length
            r4 = 0
            r3 = 0
        L_0x003e:
            if (r3 >= r5) goto L_0x01bd
            r2 = r6[r3]
            r1 = 1
            boolean r0 = r11.excludeField(r2, r1)
            boolean r17 = r11.excludeField(r2, r4)
            if (r0 != 0) goto L_0x0063
            if (r17 != 0) goto L_0x0063
            r20 = r3
            r32 = r5
            r33 = r6
            r37 = r7
            r12 = r8
            r14 = r9
            r34 = r10
            r19 = r13
            r22 = r15
            r31 = 0
            goto L_0x0189
        L_0x0063:
            com.google.gson.internal.reflect.ReflectionAccessor r4 = r11.accessor
            r4.makeAccessible(r2)
            java.lang.reflect.Type r4 = r16.getType()
            java.lang.reflect.Type r14 = r2.getGenericType()
            java.lang.reflect.Type r14 = com.google.gson.internal.C$Gson$Types.resolve(r4, r7, r14)
            java.lang.Class<com.google.gson.annotations.SerializedName> r4 = com.google.gson.annotations.SerializedName.class
            java.lang.annotation.Annotation r4 = r2.getAnnotation(r4)
            com.google.gson.annotations.SerializedName r4 = (com.google.gson.annotations.SerializedName) r4
            if (r4 != 0) goto L_0x008b
            com.google.gson.FieldNamingStrategy r4 = r11.fieldNamingPolicy
            java.lang.String r4 = r4.translateName(r2)
            java.util.List r4 = java.util.Collections.singletonList(r4)
            r19 = r0
            goto L_0x009c
        L_0x008b:
            java.lang.String r1 = r4.value()
            java.lang.String[] r4 = r4.alternate()
            r19 = r0
            int r0 = r4.length
            if (r0 != 0) goto L_0x00a1
            java.util.List r4 = java.util.Collections.singletonList(r1)
        L_0x009c:
            r20 = r3
            r18 = 1
            goto L_0x00c1
        L_0x00a1:
            java.util.ArrayList r0 = new java.util.ArrayList
            r20 = r3
            int r3 = r4.length
            r18 = 1
            int r3 = r3 + 1
            r0.<init>(r3)
            r0.add(r1)
            int r1 = r4.length
            r3 = 0
        L_0x00b2:
            if (r3 >= r1) goto L_0x00c0
            r21 = r1
            r1 = r4[r3]
            r0.add(r1)
            int r3 = r3 + 1
            r1 = r21
            goto L_0x00b2
        L_0x00c0:
            r4 = r0
        L_0x00c1:
            int r3 = r4.size()
            r0 = r19
            r1 = 0
            r19 = r13
            r13 = 0
        L_0x00cb:
            if (r1 >= r3) goto L_0x0179
            java.lang.Object r21 = r4.get(r1)
            r22 = r15
            r15 = r21
            java.lang.String r15 = (java.lang.String) r15
            if (r1 == 0) goto L_0x00dc
            r21 = 0
            goto L_0x00de
        L_0x00dc:
            r21 = r0
        L_0x00de:
            com.google.gson.reflect.TypeToken r0 = com.google.gson.reflect.TypeToken.get((java.lang.reflect.Type) r14)
            r23 = r1
            java.lang.Class r1 = r0.getRawType()
            r24 = r3
            boolean r3 = r1 instanceof java.lang.Class
            if (r3 == 0) goto L_0x00f7
            boolean r1 = r1.isPrimitive()
            if (r1 == 0) goto L_0x00f7
            r25 = 1
            goto L_0x00f9
        L_0x00f7:
            r25 = 0
        L_0x00f9:
            java.lang.Class<com.google.gson.annotations.JsonAdapter> r1 = com.google.gson.annotations.JsonAdapter.class
            java.lang.annotation.Annotation r1 = r2.getAnnotation(r1)
            com.google.gson.annotations.JsonAdapter r1 = (com.google.gson.annotations.JsonAdapter) r1
            if (r1 == 0) goto L_0x010e
            com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory r3 = r11.jsonAdapterFactory
            r26 = r2
            com.google.gson.internal.ConstructorConstructor r2 = r11.constructorConstructor
            com.google.gson.TypeAdapter r1 = r3.getTypeAdapter(r2, r12, r0, r1)
            goto L_0x0111
        L_0x010e:
            r26 = r2
            r1 = 0
        L_0x0111:
            if (r1 == 0) goto L_0x0116
            r27 = 1
            goto L_0x0118
        L_0x0116:
            r27 = 0
        L_0x0118:
            if (r1 != 0) goto L_0x011e
            com.google.gson.TypeAdapter r1 = r12.getAdapter(r0)
        L_0x011e:
            r28 = r1
            com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$1 r3 = new com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$1
            r29 = r0
            r0 = r3
            r18 = r23
            r23 = 1
            r1 = r35
            r2 = r15
            r11 = r3
            r3 = r21
            r30 = r4
            r31 = 0
            r4 = r17
            r32 = r5
            r5 = r26
            r33 = r6
            r6 = r27
            r37 = r7
            r7 = r28
            r12 = r8
            r8 = r36
            r27 = r14
            r14 = r9
            r9 = r29
            r34 = r10
            r10 = r25
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            java.lang.Object r0 = r14.put(r15, r11)
            com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$BoundField r0 = (com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField) r0
            if (r13 != 0) goto L_0x0159
            r13 = r0
        L_0x0159:
            int r1 = r18 + 1
            r11 = r35
            r7 = r37
            r8 = r12
            r9 = r14
            r0 = r21
            r15 = r22
            r3 = r24
            r2 = r26
            r14 = r27
            r4 = r30
            r5 = r32
            r6 = r33
            r10 = r34
            r18 = 1
            r12 = r36
            goto L_0x00cb
        L_0x0179:
            r32 = r5
            r33 = r6
            r37 = r7
            r12 = r8
            r14 = r9
            r34 = r10
            r22 = r15
            r31 = 0
            if (r13 != 0) goto L_0x01a1
        L_0x0189:
            int r3 = r20 + 1
            r11 = r35
            r7 = r37
            r8 = r12
            r9 = r14
            r13 = r19
            r15 = r22
            r5 = r32
            r6 = r33
            r10 = r34
            r4 = 0
            r14 = 0
            r12 = r36
            goto L_0x003e
        L_0x01a1:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r12)
            java.lang.String r2 = " declares multiple JSON fields named "
            r1.append(r2)
            java.lang.String r2 = r13.name
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x01bd:
            r37 = r7
            r12 = r8
            r14 = r9
            r34 = r10
            r19 = r13
            r22 = r15
            java.lang.reflect.Type r0 = r16.getType()
            java.lang.reflect.Type r1 = r37.getGenericSuperclass()
            r2 = r37
            java.lang.reflect.Type r0 = com.google.gson.internal.C$Gson$Types.resolve(r0, r2, r1)
            com.google.gson.reflect.TypeToken r16 = com.google.gson.reflect.TypeToken.get((java.lang.reflect.Type) r0)
            java.lang.Class r7 = r16.getRawType()
            r11 = r35
            r14 = 0
            r12 = r36
            goto L_0x0035
        L_0x01e4:
            r0 = r22
            r1 = r34
            r1.<init>(r0, r14)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.create(com.google.gson.Gson, com.google.gson.reflect.TypeToken):com.google.gson.TypeAdapter");
    }

    public boolean excludeField(Field field, boolean z) {
        boolean z2;
        Expose expose;
        Excluder excluder2 = this.excluder;
        Class<?> type = field.getType();
        if (!(excluder2.excludeClassChecks(type) || excluder2.excludeClassInStrategy(type, z))) {
            if ((excluder2.modifiers & field.getModifiers()) == 0 && ((excluder2.version == -1.0d || excluder2.isValidVersion((Since) field.getAnnotation(Since.class), (Until) field.getAnnotation(Until.class))) && !field.isSynthetic() && ((!excluder2.requireExpose || ((expose = (Expose) field.getAnnotation(Expose.class)) != null && (!z ? expose.deserialize() : expose.serialize()))) && ((excluder2.serializeInnerClasses || !excluder2.isInnerClass(field.getType())) && !excluder2.isAnonymousOrLocal(field.getType()))))) {
                List<ExclusionStrategy> list = z ? excluder2.serializationStrategies : excluder2.deserializationStrategies;
                if (!list.isEmpty()) {
                    FieldAttributes fieldAttributes = new FieldAttributes(field);
                    Iterator<ExclusionStrategy> it = list.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().shouldSkipField(fieldAttributes)) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                z2 = false;
            } else {
                z2 = true;
            }
            if (!z2) {
                return true;
            }
        }
        return false;
    }
}
