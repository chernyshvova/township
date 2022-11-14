package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfkt implements Iterator<Map.Entry> {
    public final Iterator<Map.Entry> zza = this.zzc.zza.entrySet().iterator();
    @NullableDecl
    public Collection zzb;
    public final /* synthetic */ zzfku zzc;

    public zzfkt(zzfku zzfku) {
        this.zzc = zzfku;
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        Map.Entry next = this.zza.next();
        this.zzb = (Collection) next.getValue();
        return this.zzc.zzb(next);
    }

    public final void remove() {
        zzfke.zzb(this.zzb != null, "no calls to next() since the last call to remove()");
        this.zza.remove();
        zzflh.zzr(this.zzc.zzb, this.zzb.size());
        this.zzb.clear();
        this.zzb = null;
    }
}
