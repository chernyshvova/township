package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgiw implements Iterator {
    public int zza = 0;
    public final /* synthetic */ zzgix zzb;

    public zzgiw(zzgix zzgix) {
        this.zzb = zzgix;
    }

    public final boolean hasNext() {
        return this.zza < this.zzb.zza.size() || this.zzb.zzb.hasNext();
    }

    public final Object next() {
        if (this.zza < this.zzb.zza.size()) {
            List<E> list = this.zzb.zza;
            int i = this.zza;
            this.zza = i + 1;
            return list.get(i);
        }
        zzgix zzgix = this.zzb;
        zzgix.zza.add(zzgix.zzb.next());
        return next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
