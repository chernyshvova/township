package androidx.core.util;

import android.util.SparseBooleanArray;
import kotlin.Unit;
import kotlin.collections.BooleanIterator;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SparseBooleanArray.kt */
public final class SparseBooleanArrayKt {
    public static final boolean contains(SparseBooleanArray sparseBooleanArray, int i) {
        Intrinsics.checkParameterIsNotNull(sparseBooleanArray, "$this$contains");
        return sparseBooleanArray.indexOfKey(i) >= 0;
    }

    public static final boolean containsKey(SparseBooleanArray sparseBooleanArray, int i) {
        Intrinsics.checkParameterIsNotNull(sparseBooleanArray, "$this$containsKey");
        return sparseBooleanArray.indexOfKey(i) >= 0;
    }

    public static final boolean containsValue(SparseBooleanArray sparseBooleanArray, boolean z) {
        Intrinsics.checkParameterIsNotNull(sparseBooleanArray, "$this$containsValue");
        return sparseBooleanArray.indexOfValue(z) >= 0;
    }

    public static final void forEach(SparseBooleanArray sparseBooleanArray, Function2<? super Integer, ? super Boolean, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(sparseBooleanArray, "$this$forEach");
        Intrinsics.checkParameterIsNotNull(function2, "action");
        int size = sparseBooleanArray.size();
        for (int i = 0; i < size; i++) {
            function2.invoke(Integer.valueOf(sparseBooleanArray.keyAt(i)), Boolean.valueOf(sparseBooleanArray.valueAt(i)));
        }
    }

    public static final boolean getOrDefault(SparseBooleanArray sparseBooleanArray, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(sparseBooleanArray, "$this$getOrDefault");
        return sparseBooleanArray.get(i, z);
    }

    public static final boolean getOrElse(SparseBooleanArray sparseBooleanArray, int i, Function0<Boolean> function0) {
        Intrinsics.checkParameterIsNotNull(sparseBooleanArray, "$this$getOrElse");
        Intrinsics.checkParameterIsNotNull(function0, "defaultValue");
        int indexOfKey = sparseBooleanArray.indexOfKey(i);
        return indexOfKey >= 0 ? sparseBooleanArray.valueAt(indexOfKey) : function0.invoke().booleanValue();
    }

    public static final int getSize(SparseBooleanArray sparseBooleanArray) {
        Intrinsics.checkParameterIsNotNull(sparseBooleanArray, "$this$size");
        return sparseBooleanArray.size();
    }

    public static final boolean isEmpty(SparseBooleanArray sparseBooleanArray) {
        Intrinsics.checkParameterIsNotNull(sparseBooleanArray, "$this$isEmpty");
        return sparseBooleanArray.size() == 0;
    }

    public static final boolean isNotEmpty(SparseBooleanArray sparseBooleanArray) {
        Intrinsics.checkParameterIsNotNull(sparseBooleanArray, "$this$isNotEmpty");
        return sparseBooleanArray.size() != 0;
    }

    public static final IntIterator keyIterator(SparseBooleanArray sparseBooleanArray) {
        Intrinsics.checkParameterIsNotNull(sparseBooleanArray, "$this$keyIterator");
        return new SparseBooleanArrayKt$keyIterator$1(sparseBooleanArray);
    }

    public static final SparseBooleanArray plus(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
        Intrinsics.checkParameterIsNotNull(sparseBooleanArray, "$this$plus");
        Intrinsics.checkParameterIsNotNull(sparseBooleanArray2, "other");
        SparseBooleanArray sparseBooleanArray3 = new SparseBooleanArray(sparseBooleanArray2.size() + sparseBooleanArray.size());
        putAll(sparseBooleanArray3, sparseBooleanArray);
        putAll(sparseBooleanArray3, sparseBooleanArray2);
        return sparseBooleanArray3;
    }

    public static final void putAll(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
        Intrinsics.checkParameterIsNotNull(sparseBooleanArray, "$this$putAll");
        Intrinsics.checkParameterIsNotNull(sparseBooleanArray2, "other");
        int size = sparseBooleanArray2.size();
        for (int i = 0; i < size; i++) {
            sparseBooleanArray.put(sparseBooleanArray2.keyAt(i), sparseBooleanArray2.valueAt(i));
        }
    }

    public static final boolean remove(SparseBooleanArray sparseBooleanArray, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(sparseBooleanArray, "$this$remove");
        int indexOfKey = sparseBooleanArray.indexOfKey(i);
        if (indexOfKey < 0 || z != sparseBooleanArray.valueAt(indexOfKey)) {
            return false;
        }
        sparseBooleanArray.delete(i);
        return true;
    }

    public static final void set(SparseBooleanArray sparseBooleanArray, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(sparseBooleanArray, "$this$set");
        sparseBooleanArray.put(i, z);
    }

    public static final BooleanIterator valueIterator(SparseBooleanArray sparseBooleanArray) {
        Intrinsics.checkParameterIsNotNull(sparseBooleanArray, "$this$valueIterator");
        return new SparseBooleanArrayKt$valueIterator$1(sparseBooleanArray);
    }
}
