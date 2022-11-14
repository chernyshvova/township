package androidx.core.util;

import android.util.SparseBooleanArray;
import kotlin.collections.BooleanIterator;

/* compiled from: SparseBooleanArray.kt */
public final class SparseBooleanArrayKt$valueIterator$1 extends BooleanIterator {
    public final /* synthetic */ SparseBooleanArray $this_valueIterator;
    public int index;

    public SparseBooleanArrayKt$valueIterator$1(SparseBooleanArray sparseBooleanArray) {
        this.$this_valueIterator = sparseBooleanArray;
    }

    public final int getIndex() {
        return this.index;
    }

    public boolean hasNext() {
        return this.index < this.$this_valueIterator.size();
    }

    public boolean nextBoolean() {
        SparseBooleanArray sparseBooleanArray = this.$this_valueIterator;
        int i = this.index;
        this.index = i + 1;
        return sparseBooleanArray.valueAt(i);
    }

    public final void setIndex(int i) {
        this.index = i;
    }
}
