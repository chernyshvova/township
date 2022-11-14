package kotlin.ranges;

import kotlin.collections.CharIterator;

/* compiled from: ProgressionIterators.kt */
public final class CharProgressionIterator extends CharIterator {
    public final int finalElement;
    public boolean hasNext;
    public int next;
    public final int step;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: char} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CharProgressionIterator(char r3, char r4, int r5) {
        /*
            r2 = this;
            r2.<init>()
            r2.step = r5
            r2.finalElement = r4
            r0 = 1
            r1 = 0
            int r4 = kotlin.jvm.internal.Intrinsics.compare(r3, r4)
            if (r5 <= 0) goto L_0x0012
            if (r4 > 0) goto L_0x0015
            goto L_0x0016
        L_0x0012:
            if (r4 < 0) goto L_0x0015
            goto L_0x0016
        L_0x0015:
            r0 = 0
        L_0x0016:
            r2.hasNext = r0
            if (r0 == 0) goto L_0x001b
            goto L_0x001d
        L_0x001b:
            int r3 = r2.finalElement
        L_0x001d:
            r2.next = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.ranges.CharProgressionIterator.<init>(char, char, int):void");
    }

    public boolean hasNext() {
        return this.hasNext;
    }
}
