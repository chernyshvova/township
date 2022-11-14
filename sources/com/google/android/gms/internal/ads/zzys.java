package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzys implements zzzb {
    public zzkc zza;
    public zzale zzb;
    public zztz zzc;

    public zzys(String str) {
        zzkb zzkb = new zzkb();
        zzkb.zzj(str);
        this.zza = zzkb.zzD();
    }

    public final void zza(zzale zzale, zztd zztd, zzzo zzzo) {
        this.zzb = zzale;
        zzzo.zza();
        zztz zza2 = zztd.zza(zzzo.zzb(), 5);
        this.zzc = zza2;
        zza2.zza(this.zza);
    }

    public final void zzb(zzakr zzakr) {
        zzajg.zze(this.zzb);
        int i = zzalh.zza;
        long zzc2 = this.zzb.zzc();
        if (zzc2 != -9223372036854775807L) {
            zzkc zzkc = this.zza;
            if (zzc2 != zzkc.zzp) {
                zzkb zza2 = zzkc.zza();
                zza2.zzn(zzc2);
                zzkc zzD = zza2.zzD();
                this.zza = zzD;
                this.zzc.zza(zzD);
            }
            int zzd = zzakr.zzd();
            zztx.zzb(this.zzc, zzakr, zzd);
            this.zzc.zzd(this.zzb.zzb(), 1, zzd, 0, (zzty) null);
        }
    }
}
