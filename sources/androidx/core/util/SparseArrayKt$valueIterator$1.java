package androidx.core.util;

import android.util.SparseArray;
import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: SparseArray.kt */
public final class SparseArrayKt$valueIterator$1 implements Iterator<T>, KMappedMarker {
    public final /* synthetic */ SparseArray $this_valueIterator;
    public int index;

    public SparseArrayKt$valueIterator$1(SparseArray<T> sparseArray) {
        this.$this_valueIterator = sparseArray;
    }

    public final int getIndex() {
        return this.index;
    }

    public boolean hasNext() {
        return this.index < this.$this_valueIterator.size();
    }

    public T next() {
        SparseArray sparseArray = this.$this_valueIterator;
        int i = this.index;
        this.index = i + 1;
        return sparseArray.valueAt(i);
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setIndex(int i) {
        this.index = i;
    }
}
