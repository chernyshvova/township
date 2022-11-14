package androidx.core.util;

import android.util.SparseIntArray;
import kotlin.collections.IntIterator;

/* compiled from: SparseIntArray.kt */
public final class SparseIntArrayKt$valueIterator$1 extends IntIterator {
    public final /* synthetic */ SparseIntArray $this_valueIterator;
    public int index;

    public SparseIntArrayKt$valueIterator$1(SparseIntArray sparseIntArray) {
        this.$this_valueIterator = sparseIntArray;
    }

    public final int getIndex() {
        return this.index;
    }

    public boolean hasNext() {
        return this.index < this.$this_valueIterator.size();
    }

    public int nextInt() {
        SparseIntArray sparseIntArray = this.$this_valueIterator;
        int i = this.index;
        this.index = i + 1;
        return sparseIntArray.valueAt(i);
    }

    public final void setIndex(int i) {
        this.index = i;
    }
}
