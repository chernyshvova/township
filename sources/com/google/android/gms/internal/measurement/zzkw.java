package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class zzkw implements Iterator<String> {
    public Iterator<String> zza = this.zzb.zza.iterator();
    public final /* synthetic */ zzku zzb;

    public zzkw(zzku zzku) {
        this.zzb = zzku;
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* synthetic */ Object next() {
        return this.zza.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
