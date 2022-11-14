package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzeia implements zzdkb {
    public final zzedq zza;

    public zzeia(zzedq zzedq) {
        this.zza = zzedq;
    }

    public final void zza(boolean z, Context context, zzdbq zzdbq) {
        zzedq zzedq = this.zza;
        try {
            ((zzezn) zzedq.zzb).zzs(z);
            ((zzezn) zzedq.zzb).zzm();
        } catch (zzezb e) {
            zzcgs.zzj("Cannot show rewarded video.", e);
            throw new zzdka(e.getCause());
        }
    }
}
