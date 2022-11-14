package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdbv extends zzdgf<zzdbx> {
    public boolean zzb = false;

    public zzdbv(Set<zzdhz<zzdbx>> set) {
        super(set);
    }

    public final synchronized void zza() {
        if (!this.zzb) {
            zzr(zzdbu.zza);
            this.zzb = true;
        }
    }
}
