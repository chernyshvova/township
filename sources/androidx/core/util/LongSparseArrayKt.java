package androidx.core.util;

import android.util.LongSparseArray;
import androidx.annotation.RequiresApi;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.LongIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LongSparseArray.kt */
public final class LongSparseArrayKt {
    @RequiresApi(16)
    public static final <T> boolean contains(LongSparseArray<T> longSparseArray, long j) {
        Intrinsics.checkParameterIsNotNull(longSparseArray, "$this$contains");
        return longSparseArray.indexOfKey(j) >= 0;
    }

    @RequiresApi(16)
    public static final <T> boolean containsKey(LongSparseArray<T> longSparseArray, long j) {
        Intrinsics.checkParameterIsNotNull(longSparseArray, "$this$containsKey");
        return longSparseArray.indexOfKey(j) >= 0;
    }

    @RequiresApi(16)
    public static final <T> boolean containsValue(LongSparseArray<T> longSparseArray, T t) {
        Intrinsics.checkParameterIsNotNull(longSparseArray, "$this$containsValue");
        return longSparseArray.indexOfValue(t) >= 0;
    }

    @RequiresApi(16)
    public static final <T> void forEach(LongSparseArray<T> longSparseArray, Function2<? super Long, ? super T, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(longSparseArray, "$this$forEach");
        Intrinsics.checkParameterIsNotNull(function2, "action");
        int size = longSparseArray.size();
        for (int i = 0; i < size; i++) {
            function2.invoke(Long.valueOf(longSparseArray.keyAt(i)), longSparseArray.valueAt(i));
        }
    }

    @RequiresApi(16)
    public static final <T> T getOrDefault(LongSparseArray<T> longSparseArray, long j, T t) {
        Intrinsics.checkParameterIsNotNull(longSparseArray, "$this$getOrDefault");
        T t2 = longSparseArray.get(j);
        return t2 != null ? t2 : t;
    }

    @RequiresApi(16)
    public static final <T> T getOrElse(LongSparseArray<T> longSparseArray, long j, Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(longSparseArray, "$this$getOrElse");
        Intrinsics.checkParameterIsNotNull(function0, "defaultValue");
        T t = longSparseArray.get(j);
        return t != null ? t : function0.invoke();
    }

    @RequiresApi(16)
    public static final <T> int getSize(LongSparseArray<T> longSparseArray) {
        Intrinsics.checkParameterIsNotNull(longSparseArray, "$this$size");
        return longSparseArray.size();
    }

    @RequiresApi(16)
    public static final <T> boolean isEmpty(LongSparseArray<T> longSparseArray) {
        Intrinsics.checkParameterIsNotNull(longSparseArray, "$this$isEmpty");
        return longSparseArray.size() == 0;
    }

    @RequiresApi(16)
    public static final <T> boolean isNotEmpty(LongSparseArray<T> longSparseArray) {
        Intrinsics.checkParameterIsNotNull(longSparseArray, "$this$isNotEmpty");
        return longSparseArray.size() != 0;
    }

    @RequiresApi(16)
    public static final <T> LongIterator keyIterator(LongSparseArray<T> longSparseArray) {
        Intrinsics.checkParameterIsNotNull(longSparseArray, "$this$keyIterator");
        return new LongSparseArrayKt$keyIterator$1(longSparseArray);
    }

    @RequiresApi(16)
    public static final <T> LongSparseArray<T> plus(LongSparseArray<T> longSparseArray, LongSparseArray<T> longSparseArray2) {
        Intrinsics.checkParameterIsNotNull(longSparseArray, "$this$plus");
        Intrinsics.checkParameterIsNotNull(longSparseArray2, "other");
        LongSparseArray<T> longSparseArray3 = new LongSparseArray<>(longSparseArray2.size() + longSparseArray.size());
        putAll(longSparseArray3, longSparseArray);
        putAll(longSparseArray3, longSparseArray2);
        return longSparseArray3;
    }

    @RequiresApi(16)
    public static final <T> void putAll(LongSparseArray<T> longSparseArray, LongSparseArray<T> longSparseArray2) {
        Intrinsics.checkParameterIsNotNull(longSparseArray, "$this$putAll");
        Intrinsics.checkParameterIsNotNull(longSparseArray2, "other");
        int size = longSparseArray2.size();
        for (int i = 0; i < size; i++) {
            longSparseArray.put(longSparseArray2.keyAt(i), longSparseArray2.valueAt(i));
        }
    }

    @RequiresApi(16)
    public static final <T> boolean remove(LongSparseArray<T> longSparseArray, long j, T t) {
        Intrinsics.checkParameterIsNotNull(longSparseArray, "$this$remove");
        int indexOfKey = longSparseArray.indexOfKey(j);
        if (indexOfKey < 0 || !Intrinsics.areEqual(t, longSparseArray.valueAt(indexOfKey))) {
            return false;
        }
        longSparseArray.removeAt(indexOfKey);
        return true;
    }

    @RequiresApi(16)
    public static final <T> void set(LongSparseArray<T> longSparseArray, long j, T t) {
        Intrinsics.checkParameterIsNotNull(longSparseArray, "$this$set");
        longSparseArray.put(j, t);
    }

    @RequiresApi(16)
    public static final <T> Iterator<T> valueIterator(LongSparseArray<T> longSparseArray) {
        Intrinsics.checkParameterIsNotNull(longSparseArray, "$this$valueIterator");
        return new LongSparseArrayKt$valueIterator$1(longSparseArray);
    }
}
