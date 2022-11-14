package androidx.core.util;

import android.util.SparseIntArray;
import kotlin.collections.IntIterator;

/* compiled from: SparseIntArray.kt */
public final class SparseIntArrayKt$keyIterator$1 extends IntIterator {
    public final /* synthetic */ SparseIntArray $this_keyIterator;
    public int index;

    public SparseIntArrayKt$keyIterator$1(SparseIntArray sparseIntArray) {
        this.$this_keyIterator = sparseIntArray;
    }

    public final int getIndex() {
        return this.index;
    }

    public boolean hasNext() {
        return this.index < this.$this_keyIterator.size();
    }

    public int nextInt() {
        SparseIntArray sparseIntArray = this.$this_keyIterator;
        int i = this.index;
        this.index = i + 1;
        return sparseIntArray.keyAt(i);
    }

    public final void setIndex(int i) {
        this.index = i;
    }
}
