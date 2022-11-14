package androidx.core.util;

import android.util.SparseLongArray;
import kotlin.collections.LongIterator;

/* compiled from: SparseLongArray.kt */
public final class SparseLongArrayKt$valueIterator$1 extends LongIterator {
    public final /* synthetic */ SparseLongArray $this_valueIterator;
    public int index;

    public SparseLongArrayKt$valueIterator$1(SparseLongArray sparseLongArray) {
        this.$this_valueIterator = sparseLongArray;
    }

    public final int getIndex() {
        return this.index;
    }

    public boolean hasNext() {
        return this.index < this.$this_valueIterator.size();
    }

    public long nextLong() {
        SparseLongArray sparseLongArray = this.$this_valueIterator;
        int i = this.index;
        this.index = i + 1;
        return sparseLongArray.valueAt(i);
    }

    public final void setIndex(int i) {
        this.index = i;
    }
}
