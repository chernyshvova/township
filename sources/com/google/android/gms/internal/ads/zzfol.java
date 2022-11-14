package com.google.android.gms.internal.ads;

import java.util.ListIterator;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzfol<F, T> extends zzfok<F, T> implements ListIterator<T> {
    public zzfol(ListIterator<? extends F> listIterator) {
        super(listIterator);
    }

    public final void add(T t) {
        throw new UnsupportedOperationException();
    }

    public final boolean hasPrevious() {
        return ((ListIterator) this.zzb).hasPrevious();
    }

    public final int nextIndex() {
        return ((ListIterator) this.zzb).nextIndex();
    }

    public final T previous() {
        return zza(((ListIterator) this.zzb).previous());
    }

    public final int previousIndex() {
        return ((ListIterator) this.zzb).previousIndex();
    }

    public final void set(T t) {
        throw new UnsupportedOperationException();
    }
}
