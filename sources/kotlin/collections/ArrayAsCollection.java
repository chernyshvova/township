package kotlin.collections;

import androidx.lifecycle.SavedStateHandle;
import com.android.billingclient.api.zzam;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.ArrayIterator;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: Collections.kt */
public final class ArrayAsCollection<T> implements Collection<T>, KMappedMarker {
    public final boolean isVarargs;
    public final T[] values;

    public ArrayAsCollection(T[] tArr, boolean z) {
        Intrinsics.checkNotNullParameter(tArr, SavedStateHandle.VALUES);
        this.values = tArr;
        this.isVarargs = z;
    }

    public boolean add(T t) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(Object obj) {
        return zzam.contains(this.values, obj);
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        if (collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        return this.values.length == 0;
    }

    public Iterator<T> iterator() {
        T[] tArr = this.values;
        Intrinsics.checkNotNullParameter(tArr, "array");
        return new ArrayIterator(tArr);
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final int size() {
        return this.values.length;
    }

    public final Object[] toArray() {
        T[] tArr = this.values;
        boolean z = this.isVarargs;
        Class<Object[]> cls = Object[].class;
        Intrinsics.checkNotNullParameter(tArr, "$this$copyToArrayOfAny");
        if (z && Intrinsics.areEqual(tArr.getClass(), cls)) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length, cls);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(… Array<Any?>::class.java)");
        return copyOf;
    }

    public <T> T[] toArray(T[] tArr) {
        return CollectionToArray.toArray(this, tArr);
    }
}
