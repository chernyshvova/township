package androidx.core.util;

import android.util.SparseLongArray;
import androidx.annotation.RequiresApi;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.collections.LongIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SparseLongArray.kt */
public final class SparseLongArrayKt {
    @RequiresApi(18)
    public static final boolean contains(SparseLongArray sparseLongArray, int i) {
        Intrinsics.checkParameterIsNotNull(sparseLongArray, "$this$contains");
        return sparseLongArray.indexOfKey(i) >= 0;
    }

    @RequiresApi(18)
    public static final boolean containsKey(SparseLongArray sparseLongArray, int i) {
        Intrinsics.checkParameterIsNotNull(sparseLongArray, "$this$containsKey");
        return sparseLongArray.indexOfKey(i) >= 0;
    }

    @RequiresApi(18)
    public static final boolean containsValue(SparseLongArray sparseLongArray, long j) {
        Intrinsics.checkParameterIsNotNull(sparseLongArray, "$this$containsValue");
        return sparseLongArray.indexOfValue(j) >= 0;
    }

    @RequiresApi(18)
    public static final void forEach(SparseLongArray sparseLongArray, Function2<? super Integer, ? super Long, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(sparseLongArray, "$this$forEach");
        Intrinsics.checkParameterIsNotNull(function2, "action");
        int size = sparseLongArray.size();
        for (int i = 0; i < size; i++) {
            function2.invoke(Integer.valueOf(sparseLongArray.keyAt(i)), Long.valueOf(sparseLongArray.valueAt(i)));
        }
    }

    @RequiresApi(18)
    public static final long getOrDefault(SparseLongArray sparseLongArray, int i, long j) {
        Intrinsics.checkParameterIsNotNull(sparseLongArray, "$this$getOrDefault");
        return sparseLongArray.get(i, j);
    }

    @RequiresApi(18)
    public static final long getOrElse(SparseLongArray sparseLongArray, int i, Function0<Long> function0) {
        Intrinsics.checkParameterIsNotNull(sparseLongArray, "$this$getOrElse");
        Intrinsics.checkParameterIsNotNull(function0, "defaultValue");
        int indexOfKey = sparseLongArray.indexOfKey(i);
        return indexOfKey >= 0 ? sparseLongArray.valueAt(indexOfKey) : function0.invoke().longValue();
    }

    @RequiresApi(18)
    public static final int getSize(SparseLongArray sparseLongArray) {
        Intrinsics.checkParameterIsNotNull(sparseLongArray, "$this$size");
        return sparseLongArray.size();
    }

    @RequiresApi(18)
    public static final boolean isEmpty(SparseLongArray sparseLongArray) {
        Intrinsics.checkParameterIsNotNull(sparseLongArray, "$this$isEmpty");
        return sparseLongArray.size() == 0;
    }

    @RequiresApi(18)
    public static final boolean isNotEmpty(SparseLongArray sparseLongArray) {
        Intrinsics.checkParameterIsNotNull(sparseLongArray, "$this$isNotEmpty");
        return sparseLongArray.size() != 0;
    }

    @RequiresApi(18)
    public static final IntIterator keyIterator(SparseLongArray sparseLongArray) {
        Intrinsics.checkParameterIsNotNull(sparseLongArray, "$this$keyIterator");
        return new SparseLongArrayKt$keyIterator$1(sparseLongArray);
    }

    @RequiresApi(18)
    public static final SparseLongArray plus(SparseLongArray sparseLongArray, SparseLongArray sparseLongArray2) {
        Intrinsics.checkParameterIsNotNull(sparseLongArray, "$this$plus");
        Intrinsics.checkParameterIsNotNull(sparseLongArray2, "other");
        SparseLongArray sparseLongArray3 = new SparseLongArray(sparseLongArray2.size() + sparseLongArray.size());
        putAll(sparseLongArray3, sparseLongArray);
        putAll(sparseLongArray3, sparseLongArray2);
        return sparseLongArray3;
    }

    @RequiresApi(18)
    public static final void putAll(SparseLongArray sparseLongArray, SparseLongArray sparseLongArray2) {
        Intrinsics.checkParameterIsNotNull(sparseLongArray, "$this$putAll");
        Intrinsics.checkParameterIsNotNull(sparseLongArray2, "other");
        int size = sparseLongArray2.size();
        for (int i = 0; i < size; i++) {
            sparseLongArray.put(sparseLongArray2.keyAt(i), sparseLongArray2.valueAt(i));
        }
    }

    @RequiresApi(18)
    public static final boolean remove(SparseLongArray sparseLongArray, int i, long j) {
        Intrinsics.checkParameterIsNotNull(sparseLongArray, "$this$remove");
        int indexOfKey = sparseLongArray.indexOfKey(i);
        if (indexOfKey < 0 || j != sparseLongArray.valueAt(indexOfKey)) {
            return false;
        }
        sparseLongArray.removeAt(indexOfKey);
        return true;
    }

    @RequiresApi(18)
    public static final void set(SparseLongArray sparseLongArray, int i, long j) {
        Intrinsics.checkParameterIsNotNull(sparseLongArray, "$this$set");
        sparseLongArray.put(i, j);
    }

    @RequiresApi(18)
    public static final LongIterator valueIterator(SparseLongArray sparseLongArray) {
        Intrinsics.checkParameterIsNotNull(sparseLongArray, "$this$valueIterator");
        return new SparseLongArrayKt$valueIterator$1(sparseLongArray);
    }
}
