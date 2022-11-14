package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzggs implements Iterator<String> {
    public final Iterator<String> zza = this.zzb.zza.iterator();
    public final /* synthetic */ zzggt zzb;

    public zzggs(zzggt zzggt) {
        this.zzb = zzggt;
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        return this.zza.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
