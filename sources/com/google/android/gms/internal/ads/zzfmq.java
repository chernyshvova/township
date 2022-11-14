package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfmq extends zzfom {
    public final Iterator<? extends zzfmg> zza = ((zzfml) this.zzc.zzb.values()).listIterator(0);
    public Iterator zzb = zzfmx.zza;
    public final /* synthetic */ zzfmt zzc;

    public zzfmq(zzfmt zzfmt) {
        this.zzc = zzfmt;
    }

    public final boolean hasNext() {
        return this.zzb.hasNext() || this.zza.hasNext();
    }

    public final Object next() {
        if (!this.zzb.hasNext()) {
            this.zzb = ((zzfmg) this.zza.next()).iterator();
        }
        return this.zzb.next();
    }
}
