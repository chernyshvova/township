package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzfld implements Iterator {
    public final Iterator zza;
    public final Collection zzb = this.zzc.zzb;
    public final /* synthetic */ zzfle zzc;

    public zzfld(zzfle zzfle) {
        Iterator it;
        this.zzc = zzfle;
        Collection collection = zzfle.zzb;
        if (collection instanceof List) {
            it = ((List) collection).listIterator();
        } else {
            it = collection.iterator();
        }
        this.zza = it;
    }

    public zzfld(zzfle zzfle, Iterator it) {
        this.zzc = zzfle;
        this.zza = it;
    }

    public final boolean hasNext() {
        zza();
        return this.zza.hasNext();
    }

    public final Object next() {
        zza();
        return this.zza.next();
    }

    public final void remove() {
        this.zza.remove();
        zzflh.zzo(this.zzc.zze);
        this.zzc.zzb();
    }

    public final void zza() {
        this.zzc.zza();
        if (this.zzc.zzb != this.zzb) {
            throw new ConcurrentModificationException();
        }
    }
}
