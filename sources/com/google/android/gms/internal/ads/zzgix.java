package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgix<E> extends AbstractList<E> {
    public static final zzgiy zzc = zzgiy.zzb(zzgix.class);
    public final List<E> zza;
    public final Iterator<E> zzb;

    public zzgix(List<E> list, Iterator<E> it) {
        this.zza = list;
        this.zzb = it;
    }

    public final E get(int i) {
        if (this.zza.size() > i) {
            return this.zza.get(i);
        }
        if (this.zzb.hasNext()) {
            this.zza.add(this.zzb.next());
            return get(i);
        }
        throw new NoSuchElementException();
    }

    public final Iterator<E> iterator() {
        return new zzgiw(this);
    }

    public final int size() {
        zzc.zza("potentially expensive size() call");
        zzc.zza("blowup running");
        while (this.zzb.hasNext()) {
            this.zza.add(this.zzb.next());
        }
        return this.zza.size();
    }
}
