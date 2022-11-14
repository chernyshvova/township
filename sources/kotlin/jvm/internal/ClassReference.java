package kotlin.jvm.internal;

import com.android.billingclient.api.zzam;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.LegacyTokenHelper;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.reflect.KClass;
import kotlin.text.CharsKt__CharKt;

/* compiled from: ClassReference.kt */
public final class ClassReference implements KClass<Object>, ClassBasedDeclarationContainer {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final Map<Class<? extends Object<?>>, Integer> FUNCTION_CLASSES;
    public static final HashMap<String, String> classFqNames;
    public static final HashMap<String, String> primitiveFqNames;
    public static final HashMap<String, String> primitiveWrapperFqNames;
    public static final Map<String, String> simpleNames;
    public final Class<?> jClass;

    /* compiled from: ClassReference.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        Map<Class<? extends Object<?>>, Integer> map;
        List listOf = CollectionsKt__CollectionsKt.listOf(Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class);
        ArrayList arrayList = new ArrayList(zzam.collectionSizeOrDefault(listOf, 10));
        int i = 0;
        for (Object next : listOf) {
            int i2 = i + 1;
            if (i >= 0) {
                arrayList.add(new Pair((Class) next, Integer.valueOf(i)));
                i = i2;
            } else {
                throw new ArithmeticException("Index overflow has happened.");
            }
        }
        Intrinsics.checkNotNullParameter(arrayList, "$this$toMap");
        int size = arrayList.size();
        if (size == 0) {
            map = EmptyMap.INSTANCE;
        } else if (size != 1) {
            map = new LinkedHashMap<>(zzam.mapCapacity(arrayList.size()));
            zzam.toMap(arrayList, map);
        } else {
            Pair pair = (Pair) arrayList.get(0);
            Intrinsics.checkNotNullParameter(pair, "pair");
            map = Collections.singletonMap(pair.first, pair.second);
            Intrinsics.checkNotNullExpressionValue(map, "java.util.Collections.si…(pair.first, pair.second)");
        }
        FUNCTION_CLASSES = map;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("boolean", "kotlin.Boolean");
        hashMap.put(LegacyTokenHelper.TYPE_CHAR, "kotlin.Char");
        hashMap.put(LegacyTokenHelper.TYPE_BYTE, "kotlin.Byte");
        hashMap.put(LegacyTokenHelper.TYPE_SHORT, "kotlin.Short");
        hashMap.put(LegacyTokenHelper.TYPE_INTEGER, "kotlin.Int");
        hashMap.put(LegacyTokenHelper.TYPE_FLOAT, "kotlin.Float");
        hashMap.put(LegacyTokenHelper.TYPE_LONG, "kotlin.Long");
        hashMap.put(LegacyTokenHelper.TYPE_DOUBLE, "kotlin.Double");
        primitiveFqNames = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        primitiveWrapperFqNames = hashMap2;
        HashMap<String, String> hashMap3 = new HashMap<>();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(primitiveFqNames);
        hashMap3.putAll(primitiveWrapperFqNames);
        Collection<String> values = primitiveFqNames.values();
        Intrinsics.checkNotNullExpressionValue(values, "primitiveFqNames.values");
        for (String str : values) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            Intrinsics.checkNotNullExpressionValue(str, "kotlinName");
            sb.append(CharsKt__CharKt.substringAfterLast$default(str, '.', (String) null, 2));
            sb.append("CompanionObject");
            Pair pair2 = new Pair(sb.toString(), GeneratedOutlineSupport.outline16(str, ".Companion"));
            hashMap3.put(pair2.first, pair2.second);
        }
        for (Map.Entry next2 : FUNCTION_CLASSES.entrySet()) {
            int intValue = ((Number) next2.getValue()).intValue();
            String name = ((Class) next2.getKey()).getName();
            hashMap3.put(name, "kotlin.Function" + intValue);
        }
        classFqNames = hashMap3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(zzam.mapCapacity(hashMap3.size()));
        for (Map.Entry entry : hashMap3.entrySet()) {
            linkedHashMap.put(entry.getKey(), CharsKt__CharKt.substringAfterLast$default((String) entry.getValue(), '.', (String) null, 2));
        }
        simpleNames = linkedHashMap;
    }

    public ClassReference(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "jClass");
        this.jClass = cls;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ClassReference) && Intrinsics.areEqual(zzam.getJavaObjectType(this), zzam.getJavaObjectType((KClass) obj));
    }

    public Class<?> getJClass() {
        return this.jClass;
    }

    public String getSimpleName() {
        String str;
        String str2;
        Class<?> cls = this.jClass;
        Intrinsics.checkNotNullParameter(cls, "jClass");
        String str3 = null;
        if (!cls.isAnonymousClass()) {
            if (cls.isLocalClass()) {
                String simpleName = cls.getSimpleName();
                Method enclosingMethod = cls.getEnclosingMethod();
                if (enclosingMethod != null) {
                    Intrinsics.checkNotNullExpressionValue(simpleName, "name");
                    str2 = CharsKt__CharKt.substringAfter$default(simpleName, enclosingMethod.getName() + "$", (String) null, 2);
                } else {
                    Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
                    if (enclosingConstructor != null) {
                        Intrinsics.checkNotNullExpressionValue(simpleName, "name");
                        str2 = CharsKt__CharKt.substringAfter$default(simpleName, enclosingConstructor.getName() + "$", (String) null, 2);
                    } else {
                        str2 = null;
                    }
                }
                if (str2 != null) {
                    return str2;
                }
                Intrinsics.checkNotNullExpressionValue(simpleName, "name");
                Intrinsics.checkNotNullParameter(simpleName, "$this$substringAfter");
                Intrinsics.checkNotNullParameter(simpleName, "missingDelimiterValue");
                int indexOf$default = CharsKt__CharKt.indexOf$default((CharSequence) simpleName, '$', 0, false, 6);
                if (indexOf$default == -1) {
                    return simpleName;
                }
                String substring = simpleName.substring(indexOf$default + 1, simpleName.length());
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return substring;
            } else if (cls.isArray()) {
                Class<?> componentType = cls.getComponentType();
                Intrinsics.checkNotNullExpressionValue(componentType, "componentType");
                if (componentType.isPrimitive() && (str = simpleNames.get(componentType.getName())) != null) {
                    str3 = GeneratedOutlineSupport.outline16(str, "Array");
                }
                if (str3 == null) {
                    return "Array";
                }
            } else {
                String str4 = simpleNames.get(cls.getName());
                return str4 != null ? str4 : cls.getSimpleName();
            }
        }
        return str3;
    }

    public int hashCode() {
        return zzam.getJavaObjectType(this).hashCode();
    }

    public String toString() {
        return this.jClass.toString() + " (Kotlin reflection is not available)";
    }
}
