package androidx.core.util;

import android.util.SparseArray;
import kotlin.collections.IntIterator;

/* compiled from: SparseArray.kt */
public final class SparseArrayKt$keyIterator$1 extends IntIterator {
    public final /* synthetic */ SparseArray $this_keyIterator;
    public int index;

    public SparseArrayKt$keyIterator$1(SparseArray<T> sparseArray) {
        this.$this_keyIterator = sparseArray;
    }

    public final int getIndex() {
        return this.index;
    }

    public boolean hasNext() {
        return this.index < this.$this_keyIterator.size();
    }

    public int nextInt() {
        SparseArray sparseArray = this.$this_keyIterator;
        int i = this.index;
        this.index = i + 1;
        return sparseArray.keyAt(i);
    }

    public final void setIndex(int i) {
        this.index = i;
    }
}
