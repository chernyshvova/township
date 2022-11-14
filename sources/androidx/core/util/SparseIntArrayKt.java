package androidx.core.util;

import android.util.SparseIntArray;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SparseIntArray.kt */
public final class SparseIntArrayKt {
    public static final boolean contains(SparseIntArray sparseIntArray, int i) {
        Intrinsics.checkParameterIsNotNull(sparseIntArray, "$this$contains");
        return sparseIntArray.indexOfKey(i) >= 0;
    }

    public static final boolean containsKey(SparseIntArray sparseIntArray, int i) {
        Intrinsics.checkParameterIsNotNull(sparseIntArray, "$this$containsKey");
        return sparseIntArray.indexOfKey(i) >= 0;
    }

    public static final boolean containsValue(SparseIntArray sparseIntArray, int i) {
        Intrinsics.checkParameterIsNotNull(sparseIntArray, "$this$containsValue");
        return sparseIntArray.indexOfValue(i) >= 0;
    }

    public static final void forEach(SparseIntArray sparseIntArray, Function2<? super Integer, ? super Integer, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(sparseIntArray, "$this$forEach");
        Intrinsics.checkParameterIsNotNull(function2, "action");
        int size = sparseIntArray.size();
        for (int i = 0; i < size; i++) {
            function2.invoke(Integer.valueOf(sparseIntArray.keyAt(i)), Integer.valueOf(sparseIntArray.valueAt(i)));
        }
    }

    public static final int getOrDefault(SparseIntArray sparseIntArray, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(sparseIntArray, "$this$getOrDefault");
        return sparseIntArray.get(i, i2);
    }

    public static final int getOrElse(SparseIntArray sparseIntArray, int i, Function0<Integer> function0) {
        Intrinsics.checkParameterIsNotNull(sparseIntArray, "$this$getOrElse");
        Intrinsics.checkParameterIsNotNull(function0, "defaultValue");
        int indexOfKey = sparseIntArray.indexOfKey(i);
        return indexOfKey >= 0 ? sparseIntArray.valueAt(indexOfKey) : function0.invoke().intValue();
    }

    public static final int getSize(SparseIntArray sparseIntArray) {
        Intrinsics.checkParameterIsNotNull(sparseIntArray, "$this$size");
        return sparseIntArray.size();
    }

    public static final boolean isEmpty(SparseIntArray sparseIntArray) {
        Intrinsics.checkParameterIsNotNull(sparseIntArray, "$this$isEmpty");
        return sparseIntArray.size() == 0;
    }

    public static final boolean isNotEmpty(SparseIntArray sparseIntArray) {
        Intrinsics.checkParameterIsNotNull(sparseIntArray, "$this$isNotEmpty");
        return sparseIntArray.size() != 0;
    }

    public static final IntIterator keyIterator(SparseIntArray sparseIntArray) {
        Intrinsics.checkParameterIsNotNull(sparseIntArray, "$this$keyIterator");
        return new SparseIntArrayKt$keyIterator$1(sparseIntArray);
    }

    public static final SparseIntArray plus(SparseIntArray sparseIntArray, SparseIntArray sparseIntArray2) {
        Intrinsics.checkParameterIsNotNull(sparseIntArray, "$this$plus");
        Intrinsics.checkParameterIsNotNull(sparseIntArray2, "other");
        SparseIntArray sparseIntArray3 = new SparseIntArray(sparseIntArray2.size() + sparseIntArray.size());
        putAll(sparseIntArray3, sparseIntArray);
        putAll(sparseIntArray3, sparseIntArray2);
        return sparseIntArray3;
    }

    public static final void putAll(SparseIntArray sparseIntArray, SparseIntArray sparseIntArray2) {
        Intrinsics.checkParameterIsNotNull(sparseIntArray, "$this$putAll");
        Intrinsics.checkParameterIsNotNull(sparseIntArray2, "other");
        int size = sparseIntArray2.size();
        for (int i = 0; i < size; i++) {
            sparseIntArray.put(sparseIntArray2.keyAt(i), sparseIntArray2.valueAt(i));
        }
    }

    public static final boolean remove(SparseIntArray sparseIntArray, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(sparseIntArray, "$this$remove");
        int indexOfKey = sparseIntArray.indexOfKey(i);
        if (indexOfKey < 0 || i2 != sparseIntArray.valueAt(indexOfKey)) {
            return false;
        }
        sparseIntArray.removeAt(indexOfKey);
        return true;
    }

    public static final void set(SparseIntArray sparseIntArray, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(sparseIntArray, "$this$set");
        sparseIntArray.put(i, i2);
    }

    public static final IntIterator valueIterator(SparseIntArray sparseIntArray) {
        Intrinsics.checkParameterIsNotNull(sparseIntArray, "$this$valueIterator");
        return new SparseIntArrayKt$valueIterator$1(sparseIntArray);
    }
}
