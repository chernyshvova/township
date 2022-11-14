package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Set;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdbp extends zzdgf<zzdbt> implements zzdbh {
    @VisibleForTesting
    public zzdbp(Set<zzdhz<zzdbt>> set) {
        super(set);
    }

    public final void zza(zzbdd zzbdd) {
        zzr(new zzdbm(zzbdd));
    }

    public final void zzc(zzdka zzdka) {
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzgH)).booleanValue()) {
            zzr(new zzdbn(zzdka));
        }
    }

    public final void zzd() {
        zzr(zzdbo.zza);
    }
}
