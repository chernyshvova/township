package androidx.core.util;

import android.util.SparseArray;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SparseArray.kt */
public final class SparseArrayKt {
    public static final <T> boolean contains(SparseArray<T> sparseArray, int i) {
        Intrinsics.checkParameterIsNotNull(sparseArray, "$this$contains");
        return sparseArray.indexOfKey(i) >= 0;
    }

    public static final <T> boolean containsKey(SparseArray<T> sparseArray, int i) {
        Intrinsics.checkParameterIsNotNull(sparseArray, "$this$containsKey");
        return sparseArray.indexOfKey(i) >= 0;
    }

    public static final <T> boolean containsValue(SparseArray<T> sparseArray, T t) {
        Intrinsics.checkParameterIsNotNull(sparseArray, "$this$containsValue");
        return sparseArray.indexOfValue(t) >= 0;
    }

    public static final <T> void forEach(SparseArray<T> sparseArray, Function2<? super Integer, ? super T, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(sparseArray, "$this$forEach");
        Intrinsics.checkParameterIsNotNull(function2, "action");
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            function2.invoke(Integer.valueOf(sparseArray.keyAt(i)), sparseArray.valueAt(i));
        }
    }

    public static final <T> T getOrDefault(SparseArray<T> sparseArray, int i, T t) {
        Intrinsics.checkParameterIsNotNull(sparseArray, "$this$getOrDefault");
        T t2 = sparseArray.get(i);
        return t2 != null ? t2 : t;
    }

    public static final <T> T getOrElse(SparseArray<T> sparseArray, int i, Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(sparseArray, "$this$getOrElse");
        Intrinsics.checkParameterIsNotNull(function0, "defaultValue");
        T t = sparseArray.get(i);
        return t != null ? t : function0.invoke();
    }

    public static final <T> int getSize(SparseArray<T> sparseArray) {
        Intrinsics.checkParameterIsNotNull(sparseArray, "$this$size");
        return sparseArray.size();
    }

    public static final <T> boolean isEmpty(SparseArray<T> sparseArray) {
        Intrinsics.checkParameterIsNotNull(sparseArray, "$this$isEmpty");
        return sparseArray.size() == 0;
    }

    public static final <T> boolean isNotEmpty(SparseArray<T> sparseArray) {
        Intrinsics.checkParameterIsNotNull(sparseArray, "$this$isNotEmpty");
        return sparseArray.size() != 0;
    }

    public static final <T> IntIterator keyIterator(SparseArray<T> sparseArray) {
        Intrinsics.checkParameterIsNotNull(sparseArray, "$this$keyIterator");
        return new SparseArrayKt$keyIterator$1(sparseArray);
    }

    public static final <T> SparseArray<T> plus(SparseArray<T> sparseArray, SparseArray<T> sparseArray2) {
        Intrinsics.checkParameterIsNotNull(sparseArray, "$this$plus");
        Intrinsics.checkParameterIsNotNull(sparseArray2, "other");
        SparseArray<T> sparseArray3 = new SparseArray<>(sparseArray2.size() + sparseArray.size());
        putAll(sparseArray3, sparseArray);
        putAll(sparseArray3, sparseArray2);
        return sparseArray3;
    }

    public static final <T> void putAll(SparseArray<T> sparseArray, SparseArray<T> sparseArray2) {
        Intrinsics.checkParameterIsNotNull(sparseArray, "$this$putAll");
        Intrinsics.checkParameterIsNotNull(sparseArray2, "other");
        int size = sparseArray2.size();
        for (int i = 0; i < size; i++) {
            sparseArray.put(sparseArray2.keyAt(i), sparseArray2.valueAt(i));
        }
    }

    public static final <T> boolean remove(SparseArray<T> sparseArray, int i, T t) {
        Intrinsics.checkParameterIsNotNull(sparseArray, "$this$remove");
        int indexOfKey = sparseArray.indexOfKey(i);
        if (indexOfKey < 0 || !Intrinsics.areEqual(t, sparseArray.valueAt(indexOfKey))) {
            return false;
        }
        sparseArray.removeAt(indexOfKey);
        return true;
    }

    public static final <T> void set(SparseArray<T> sparseArray, int i, T t) {
        Intrinsics.checkParameterIsNotNull(sparseArray, "$this$set");
        sparseArray.put(i, t);
    }

    public static final <T> Iterator<T> valueIterator(SparseArray<T> sparseArray) {
        Intrinsics.checkParameterIsNotNull(sparseArray, "$this$valueIterator");
        return new SparseArrayKt$valueIterator$1(sparseArray);
    }
}
