package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzb;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcgb extends zzb {
    public final /* synthetic */ zzcgd zza;

    public zzcgb(zzcgd zzcgd) {
        this.zza = zzcgd;
    }

    public final void zza() {
        zzbjq zzbjq = new zzbjq(this.zza.zze, this.zza.zzf.zza);
        synchronized (this.zza.zza) {
            try {
                zzs.zzl();
                zzbjt.zza(this.zza.zzg, zzbjq);
            } catch (IllegalArgumentException e) {
                zzcgs.zzj("Cannot config CSI reporter.", e);
            }
        }
    }
}
