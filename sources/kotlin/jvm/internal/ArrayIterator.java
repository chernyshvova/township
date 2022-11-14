package kotlin.jvm.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: ArrayIterator.kt */
public final class ArrayIterator<T> implements Iterator<T>, KMappedMarker {
    public final T[] array;
    public int index;

    public ArrayIterator(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "array");
        this.array = tArr;
    }

    public boolean hasNext() {
        return this.index < this.array.length;
    }

    public T next() {
        try {
            T[] tArr = this.array;
            int i = this.index;
            this.index = i + 1;
            return tArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.index--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
