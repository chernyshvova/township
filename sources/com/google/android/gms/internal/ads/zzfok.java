package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzfok<F, T> implements Iterator<T> {
    public final Iterator<? extends F> zzb;

    public zzfok(Iterator<? extends F> it) {
        if (it != null) {
            this.zzb = it;
            return;
        }
        throw null;
    }

    public final boolean hasNext() {
        return this.zzb.hasNext();
    }

    public final T next() {
        return zza(this.zzb.next());
    }

    public final void remove() {
        this.zzb.remove();
    }

    public abstract T zza(F f);
}
