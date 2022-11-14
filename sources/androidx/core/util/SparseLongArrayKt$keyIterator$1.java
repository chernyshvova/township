package androidx.core.util;

import android.util.SparseLongArray;
import kotlin.collections.IntIterator;

/* compiled from: SparseLongArray.kt */
public final class SparseLongArrayKt$keyIterator$1 extends IntIterator {
    public final /* synthetic */ SparseLongArray $this_keyIterator;
    public int index;

    public SparseLongArrayKt$keyIterator$1(SparseLongArray sparseLongArray) {
        this.$this_keyIterator = sparseLongArray;
    }

    public final int getIndex() {
        return this.index;
    }

    public boolean hasNext() {
        return this.index < this.$this_keyIterator.size();
    }

    public int nextInt() {
        SparseLongArray sparseLongArray = this.$this_keyIterator;
        int i = this.index;
        this.index = i + 1;
        return sparseLongArray.keyAt(i);
    }

    public final void setIndex(int i) {
        this.index = i;
    }
}
