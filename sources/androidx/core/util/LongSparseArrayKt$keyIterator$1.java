package androidx.core.util;

import android.util.LongSparseArray;
import kotlin.collections.LongIterator;

/* compiled from: LongSparseArray.kt */
public final class LongSparseArrayKt$keyIterator$1 extends LongIterator {
    public final /* synthetic */ LongSparseArray $this_keyIterator;
    public int index;

    public LongSparseArrayKt$keyIterator$1(LongSparseArray<T> longSparseArray) {
        this.$this_keyIterator = longSparseArray;
    }

    public final int getIndex() {
        return this.index;
    }

    public boolean hasNext() {
        return this.index < this.$this_keyIterator.size();
    }

    public long nextLong() {
        LongSparseArray longSparseArray = this.$this_keyIterator;
        int i = this.index;
        this.index = i + 1;
        return longSparseArray.keyAt(i);
    }

    public final void setIndex(int i) {
        this.index = i;
    }
}
