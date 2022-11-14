package androidx.core.util;

import android.util.SparseBooleanArray;
import kotlin.collections.IntIterator;

/* compiled from: SparseBooleanArray.kt */
public final class SparseBooleanArrayKt$keyIterator$1 extends IntIterator {
    public final /* synthetic */ SparseBooleanArray $this_keyIterator;
    public int index;

    public SparseBooleanArrayKt$keyIterator$1(SparseBooleanArray sparseBooleanArray) {
        this.$this_keyIterator = sparseBooleanArray;
    }

    public final int getIndex() {
        return this.index;
    }

    public boolean hasNext() {
        return this.index < this.$this_keyIterator.size();
    }

    public int nextInt() {
        SparseBooleanArray sparseBooleanArray = this.$this_keyIterator;
        int i = this.index;
        this.index = i + 1;
        return sparseBooleanArray.keyAt(i);
    }

    public final void setIndex(int i) {
        this.index = i;
    }
}
