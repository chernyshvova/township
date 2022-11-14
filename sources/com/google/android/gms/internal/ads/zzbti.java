package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbti implements zzchn<zzbso> {
    public final /* synthetic */ zzbts zza;
    public final /* synthetic */ zzbtt zzb;

    public zzbti(zzbtt zzbtt, zzbts zzbts) {
        this.zzb = zzbtt;
        this.zza = zzbts;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        zzbso zzbso = (zzbso) obj;
        synchronized (this.zzb.zza) {
            int unused = this.zzb.zzh = 0;
            if (!(this.zzb.zzg == null || this.zza == this.zzb.zzg)) {
                zze.zza("New JS engine is loaded, marking previous one as destroyable.");
                this.zzb.zzg.zzc();
            }
            zzbts unused2 = this.zzb.zzg = this.zza;
        }
    }
}
