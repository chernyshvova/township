package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbtj implements zzchl {
    public final /* synthetic */ zzbts zza;
    public final /* synthetic */ zzbtt zzb;

    public zzbtj(zzbtt zzbtt, zzbts zzbts) {
        this.zzb = zzbtt;
        this.zza = zzbts;
    }

    public final void zza() {
        synchronized (this.zzb.zza) {
            int unused = this.zzb.zzh = 1;
            zze.zza("Failed loading new engine. Marking new engine destroyable.");
            this.zza.zzc();
        }
    }
}
