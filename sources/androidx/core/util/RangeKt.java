package androidx.core.util;

import android.util.Range;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;

/* compiled from: Range.kt */
public final class RangeKt {
    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> and(Range<T> range, Range<T> range2) {
        Intrinsics.checkParameterIsNotNull(range, "$this$and");
        Intrinsics.checkParameterIsNotNull(range2, "other");
        Range<T> intersect = range.intersect(range2);
        Intrinsics.checkExpressionValueIsNotNull(intersect, "intersect(other)");
        return intersect;
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> plus(Range<T> range, T t) {
        Intrinsics.checkParameterIsNotNull(range, "$this$plus");
        Intrinsics.checkParameterIsNotNull(t, "value");
        Range<T> extend = range.extend(t);
        Intrinsics.checkExpressionValueIsNotNull(extend, "extend(value)");
        return extend;
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> rangeTo(T t, T t2) {
        Intrinsics.checkParameterIsNotNull(t, "$this$rangeTo");
        Intrinsics.checkParameterIsNotNull(t2, "that");
        return new Range<>(t, t2);
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> ClosedRange<T> toClosedRange(Range<T> range) {
        Intrinsics.checkParameterIsNotNull(range, "$this$toClosedRange");
        return new RangeKt$toClosedRange$1(range);
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> toRange(ClosedRange<T> closedRange) {
        Intrinsics.checkParameterIsNotNull(closedRange, "$this$toRange");
        return new Range<>(closedRange.getStart(), closedRange.getEndInclusive());
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> plus(Range<T> range, Range<T> range2) {
        Intrinsics.checkParameterIsNotNull(range, "$this$plus");
        Intrinsics.checkParameterIsNotNull(range2, "other");
        Range<T> extend = range.extend(range2);
        Intrinsics.checkExpressionValueIsNotNull(extend, "extend(other)");
        return extend;
    }
}
