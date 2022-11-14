package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;

/* compiled from: Strings.kt */
public final class DelimitedRangesSequence$iterator$1 implements Iterator<IntRange>, KMappedMarker {
    public int counter;
    public int currentStartIndex;
    public IntRange nextItem;
    public int nextSearchIndex;
    public int nextState = -1;
    public final /* synthetic */ DelimitedRangesSequence this$0;

    public DelimitedRangesSequence$iterator$1(DelimitedRangesSequence delimitedRangesSequence) {
        this.this$0 = delimitedRangesSequence;
        int i = delimitedRangesSequence.startIndex;
        int length = delimitedRangesSequence.input.length();
        if (length >= 0) {
            if (i < 0) {
                i = 0;
            } else if (i > length) {
                i = length;
            }
            this.currentStartIndex = i;
            this.nextSearchIndex = i;
            return;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + length + " is less than minimum " + 0 + '.');
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0019, code lost:
        if (r4 < r0) goto L_0x001b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void calcNext() {
        /*
            r6 = this;
            int r0 = r6.nextSearchIndex
            r1 = 0
            if (r0 >= 0) goto L_0x000c
            r6.nextState = r1
            r0 = 0
            r6.nextItem = r0
            goto L_0x0086
        L_0x000c:
            kotlin.text.DelimitedRangesSequence r0 = r6.this$0
            int r0 = r0.limit
            r2 = -1
            r3 = 1
            if (r0 <= 0) goto L_0x001b
            int r4 = r6.counter
            int r4 = r4 + r3
            r6.counter = r4
            if (r4 >= r0) goto L_0x0027
        L_0x001b:
            int r0 = r6.nextSearchIndex
            kotlin.text.DelimitedRangesSequence r4 = r6.this$0
            java.lang.CharSequence r4 = r4.input
            int r4 = r4.length()
            if (r0 <= r4) goto L_0x003b
        L_0x0027:
            int r0 = r6.currentStartIndex
            kotlin.ranges.IntRange r1 = new kotlin.ranges.IntRange
            kotlin.text.DelimitedRangesSequence r4 = r6.this$0
            java.lang.CharSequence r4 = r4.input
            int r4 = kotlin.text.CharsKt__CharKt.getLastIndex(r4)
            r1.<init>(r0, r4)
            r6.nextItem = r1
            r6.nextSearchIndex = r2
            goto L_0x0084
        L_0x003b:
            kotlin.text.DelimitedRangesSequence r0 = r6.this$0
            kotlin.jvm.functions.Function2<java.lang.CharSequence, java.lang.Integer, kotlin.Pair<java.lang.Integer, java.lang.Integer>> r4 = r0.getNextMatch
            java.lang.CharSequence r0 = r0.input
            int r5 = r6.nextSearchIndex
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.Object r0 = r4.invoke(r0, r5)
            kotlin.Pair r0 = (kotlin.Pair) r0
            if (r0 != 0) goto L_0x0063
            int r0 = r6.currentStartIndex
            kotlin.ranges.IntRange r1 = new kotlin.ranges.IntRange
            kotlin.text.DelimitedRangesSequence r4 = r6.this$0
            java.lang.CharSequence r4 = r4.input
            int r4 = kotlin.text.CharsKt__CharKt.getLastIndex(r4)
            r1.<init>(r0, r4)
            r6.nextItem = r1
            r6.nextSearchIndex = r2
            goto L_0x0084
        L_0x0063:
            A r2 = r0.first
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            B r0 = r0.second
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            int r4 = r6.currentStartIndex
            kotlin.ranges.IntRange r4 = com.android.billingclient.api.zzam.until(r4, r2)
            r6.nextItem = r4
            int r2 = r2 + r0
            r6.currentStartIndex = r2
            if (r0 != 0) goto L_0x0081
            r1 = 1
        L_0x0081:
            int r2 = r2 + r1
            r6.nextSearchIndex = r2
        L_0x0084:
            r6.nextState = r3
        L_0x0086:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.DelimitedRangesSequence$iterator$1.calcNext():void");
    }

    public boolean hasNext() {
        if (this.nextState == -1) {
            calcNext();
        }
        return this.nextState == 1;
    }

    public Object next() {
        if (this.nextState == -1) {
            calcNext();
        }
        if (this.nextState != 0) {
            IntRange intRange = this.nextItem;
            if (intRange != null) {
                this.nextItem = null;
                this.nextState = -1;
                return intRange;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.ranges.IntRange");
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
