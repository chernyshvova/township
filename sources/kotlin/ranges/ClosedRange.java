package kotlin.ranges;

import java.lang.Comparable;

/* compiled from: Range.kt */
public interface ClosedRange<T extends Comparable<? super T>> {
    T getEndInclusive();

    T getStart();
}
