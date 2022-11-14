package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzzi implements zzzb {
    public final /* synthetic */ zzzk zza;
    public final zzakq zzb = new zzakq(new byte[4], 4);

    public zzzi(zzzk zzzk) {
        this.zza = zzzk;
    }

    public final void zza(zzale zzale, zztd zztd, zzzo zzzo) {
    }

    public final void zzb(zzakr zzakr) {
        if (zzakr.zzn() == 0 && (zzakr.zzn() & 128) != 0) {
            zzakr.zzk(6);
            int zzd = zzakr.zzd() / 4;
            for (int i = 0; i < zzd; i++) {
                zzakr.zzl(this.zzb, 4);
                int zzh = this.zzb.zzh(16);
                this.zzb.zzf(3);
                if (zzh == 0) {
                    this.zzb.zzf(13);
                } else {
                    int zzh2 = this.zzb.zzh(13);
                    if (this.zza.zzf.get(zzh2) == null) {
                        this.zza.zzf.put(zzh2, new zzzc(new zzzj(this.zza, zzh2)));
                        zzzk.zzb(this.zza);
                    }
                }
            }
            this.zza.zzf.remove(0);
        }
    }
}
