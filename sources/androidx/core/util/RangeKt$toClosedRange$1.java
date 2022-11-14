package androidx.core.util;

import android.util.Range;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;

/* compiled from: Range.kt */
public final class RangeKt$toClosedRange$1 implements ClosedRange<T> {
    public final /* synthetic */ Range $this_toClosedRange;

    public RangeKt$toClosedRange$1(Range<T> range) {
        this.$this_toClosedRange = range;
    }

    public boolean contains(T t) {
        Intrinsics.checkParameterIsNotNull(t, "value");
        Intrinsics.checkNotNullParameter(t, "value");
        return t.compareTo(getStart()) >= 0 && t.compareTo(getEndInclusive()) <= 0;
    }

    public T getEndInclusive() {
        return this.$this_toClosedRange.getUpper();
    }

    public T getStart() {
        return this.$this_toClosedRange.getLower();
    }

    public boolean isEmpty() {
        return getStart().compareTo(getEndInclusive()) > 0;
    }
}
