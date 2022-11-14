package com.google.gson;

import com.android.billingclient.api.zzam;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.TreeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class GsonBuilder {
    public boolean complexMapKeySerialization = false;
    public String datePattern;
    public int dateStyle = 2;
    public boolean escapeHtmlChars = true;
    public Excluder excluder = Excluder.DEFAULT;
    public final List<TypeAdapterFactory> factories = new ArrayList();
    public FieldNamingStrategy fieldNamingPolicy = FieldNamingPolicy.IDENTITY;
    public boolean generateNonExecutableJson = false;
    public final List<TypeAdapterFactory> hierarchyFactories = new ArrayList();
    public final Map<Type, InstanceCreator<?>> instanceCreators = new HashMap();
    public boolean lenient = false;
    public LongSerializationPolicy longSerializationPolicy = LongSerializationPolicy.DEFAULT;
    public boolean prettyPrinting = false;
    public boolean serializeNulls = false;
    public boolean serializeSpecialFloatingPointValues = false;
    public int timeStyle = 2;

    public GsonBuilder() {
    }

    private void addTypeAdaptersForDate(String str, int i, int i2, List<TypeAdapterFactory> list) {
        DefaultDateTypeAdapter defaultDateTypeAdapter;
        DefaultDateTypeAdapter defaultDateTypeAdapter2;
        DefaultDateTypeAdapter defaultDateTypeAdapter3;
        if (str != null && !"".equals(str.trim())) {
            defaultDateTypeAdapter2 = new DefaultDateTypeAdapter(Date.class, str);
            defaultDateTypeAdapter = new DefaultDateTypeAdapter(Timestamp.class, str);
            defaultDateTypeAdapter3 = new DefaultDateTypeAdapter(java.sql.Date.class, str);
        } else if (i != 2 && i2 != 2) {
            DefaultDateTypeAdapter defaultDateTypeAdapter4 = new DefaultDateTypeAdapter(Date.class, i, i2);
            DefaultDateTypeAdapter defaultDateTypeAdapter5 = new DefaultDateTypeAdapter(Timestamp.class, i, i2);
            DefaultDateTypeAdapter defaultDateTypeAdapter6 = new DefaultDateTypeAdapter(java.sql.Date.class, i, i2);
            defaultDateTypeAdapter2 = defaultDateTypeAdapter4;
            defaultDateTypeAdapter = defaultDateTypeAdapter5;
            defaultDateTypeAdapter3 = defaultDateTypeAdapter6;
        } else {
            return;
        }
        list.add(TypeAdapters.newFactory(Date.class, defaultDateTypeAdapter2));
        list.add(new TypeAdapterFactory(Timestamp.class, defaultDateTypeAdapter) {
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                if (typeToken.getRawType() == r1) {
                    return r2;
                }
                return null;
            }

            public String toString() {
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Factory[type=");
                outline24.append(r1.getName());
                outline24.append(",adapter=");
                outline24.append(r2);
                outline24.append("]");
                return outline24.toString();
            }
        });
        list.add(new TypeAdapterFactory(java.sql.Date.class, defaultDateTypeAdapter3) {
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
                if (typeToken.getRawType() == r1) {
                    return r2;
                }
                return null;
            }

            public String toString() {
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Factory[type=");
                outline24.append(r1.getName());
                outline24.append(",adapter=");
                outline24.append(r2);
                outline24.append("]");
                return outline24.toString();
            }
        });
    }

    public GsonBuilder addDeserializationExclusionStrategy(ExclusionStrategy exclusionStrategy) {
        this.excluder = this.excluder.withExclusionStrategy(exclusionStrategy, false, true);
        return this;
    }

    public GsonBuilder addSerializationExclusionStrategy(ExclusionStrategy exclusionStrategy) {
        this.excluder = this.excluder.withExclusionStrategy(exclusionStrategy, true, false);
        return this;
    }

    public Gson create() {
        ArrayList arrayList = r1;
        ArrayList arrayList2 = new ArrayList(this.hierarchyFactories.size() + this.factories.size() + 3);
        arrayList2.addAll(this.factories);
        Collections.reverse(arrayList2);
        ArrayList arrayList3 = new ArrayList(this.hierarchyFactories);
        Collections.reverse(arrayList3);
        arrayList2.addAll(arrayList3);
        addTypeAdaptersForDate(this.datePattern, this.dateStyle, this.timeStyle, arrayList2);
        return new Gson(this.excluder, this.fieldNamingPolicy, this.instanceCreators, this.serializeNulls, this.complexMapKeySerialization, this.generateNonExecutableJson, this.escapeHtmlChars, this.prettyPrinting, this.lenient, this.serializeSpecialFloatingPointValues, this.longSerializationPolicy, this.datePattern, this.dateStyle, this.timeStyle, this.factories, this.hierarchyFactories, arrayList);
    }

    public GsonBuilder disableHtmlEscaping() {
        this.escapeHtmlChars = false;
        return this;
    }

    public GsonBuilder disableInnerClassSerialization() {
        Excluder clone = this.excluder.clone();
        clone.serializeInnerClasses = false;
        this.excluder = clone;
        return this;
    }

    public GsonBuilder enableComplexMapKeySerialization() {
        this.complexMapKeySerialization = true;
        return this;
    }

    public GsonBuilder excludeFieldsWithModifiers(int... iArr) {
        Excluder clone = this.excluder.clone();
        clone.modifiers = 0;
        for (int i : iArr) {
            clone.modifiers = i | clone.modifiers;
        }
        this.excluder = clone;
        return this;
    }

    public GsonBuilder excludeFieldsWithoutExposeAnnotation() {
        Excluder clone = this.excluder.clone();
        clone.requireExpose = true;
        this.excluder = clone;
        return this;
    }

    public GsonBuilder generateNonExecutableJson() {
        this.generateNonExecutableJson = true;
        return this;
    }

    public GsonBuilder registerTypeAdapter(Type type, Object obj) {
        boolean z = obj instanceof JsonSerializer;
        boolean z2 = false;
        zzam.checkArgument(z || (obj instanceof JsonDeserializer) || (obj instanceof InstanceCreator) || (obj instanceof TypeAdapter));
        if (obj instanceof InstanceCreator) {
            this.instanceCreators.put(type, (InstanceCreator) obj);
        }
        if (z || (obj instanceof JsonDeserializer)) {
            TypeToken<?> typeToken = TypeToken.get(type);
            List<TypeAdapterFactory> list = this.factories;
            if (typeToken.getType() == typeToken.getRawType()) {
                z2 = true;
            }
            list.add(new TreeTypeAdapter.SingleTypeFactory(obj, typeToken, z2, (Class<?>) null));
        }
        if (obj instanceof TypeAdapter) {
            this.factories.add(TypeAdapters.newFactory(TypeToken.get(type), (TypeAdapter) obj));
        }
        return this;
    }

    public GsonBuilder registerTypeAdapterFactory(TypeAdapterFactory typeAdapterFactory) {
        this.factories.add(typeAdapterFactory);
        return this;
    }

    public GsonBuilder registerTypeHierarchyAdapter(Class<?> cls, Object obj) {
        boolean z = obj instanceof JsonSerializer;
        zzam.checkArgument(z || (obj instanceof JsonDeserializer) || (obj instanceof TypeAdapter));
        if ((obj instanceof JsonDeserializer) || z) {
            this.hierarchyFactories.add(new TreeTypeAdapter.SingleTypeFactory(obj, (TypeToken<?>) null, false, cls));
        }
        if (obj instanceof TypeAdapter) {
            this.factories.add(TypeAdapters.newTypeHierarchyFactory(cls, (TypeAdapter) obj));
        }
        return this;
    }

    public GsonBuilder serializeNulls() {
        this.serializeNulls = true;
        return this;
    }

    public GsonBuilder serializeSpecialFloatingPointValues() {
        this.serializeSpecialFloatingPointValues = true;
        return this;
    }

    public GsonBuilder setDateFormat(String str) {
        this.datePattern = str;
        return this;
    }

    public GsonBuilder setExclusionStrategies(ExclusionStrategy... exclusionStrategyArr) {
        for (ExclusionStrategy withExclusionStrategy : exclusionStrategyArr) {
            this.excluder = this.excluder.withExclusionStrategy(withExclusionStrategy, true, true);
        }
        return this;
    }

    public GsonBuilder setFieldNamingPolicy(FieldNamingPolicy fieldNamingPolicy2) {
        this.fieldNamingPolicy = fieldNamingPolicy2;
        return this;
    }

    public GsonBuilder setFieldNamingStrategy(FieldNamingStrategy fieldNamingStrategy) {
        this.fieldNamingPolicy = fieldNamingStrategy;
        return this;
    }

    public GsonBuilder setLenient() {
        this.lenient = true;
        return this;
    }

    public GsonBuilder setLongSerializationPolicy(LongSerializationPolicy longSerializationPolicy2) {
        this.longSerializationPolicy = longSerializationPolicy2;
        return this;
    }

    public GsonBuilder setPrettyPrinting() {
        this.prettyPrinting = true;
        return this;
    }

    public GsonBuilder setVersion(double d) {
        Excluder clone = this.excluder.clone();
        clone.version = d;
        this.excluder = clone;
        return this;
    }

    public GsonBuilder setDateFormat(int i) {
        this.dateStyle = i;
        this.datePattern = null;
        return this;
    }

    public GsonBuilder setDateFormat(int i, int i2) {
        this.dateStyle = i;
        this.timeStyle = i2;
        this.datePattern = null;
        return this;
    }

    public GsonBuilder(Gson gson) {
        this.excluder = gson.excluder;
        this.fieldNamingPolicy = gson.fieldNamingStrategy;
        this.instanceCreators.putAll(gson.instanceCreators);
        this.serializeNulls = gson.serializeNulls;
        this.complexMapKeySerialization = gson.complexMapKeySerialization;
        this.generateNonExecutableJson = gson.generateNonExecutableJson;
        this.escapeHtmlChars = gson.htmlSafe;
        this.prettyPrinting = gson.prettyPrinting;
        this.lenient = gson.lenient;
        this.serializeSpecialFloatingPointValues = gson.serializeSpecialFloatingPointValues;
        this.longSerializationPolicy = gson.longSerializationPolicy;
        this.datePattern = gson.datePattern;
        this.dateStyle = gson.dateStyle;
        this.timeStyle = gson.timeStyle;
        this.factories.addAll(gson.builderFactories);
        this.hierarchyFactories.addAll(gson.builderHierarchyFactories);
    }
}
