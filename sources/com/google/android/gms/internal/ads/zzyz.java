package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzyz {
    public final zzyc zza;
    public final zzale zzb;
    public final zzakq zzc = new zzakq(new byte[64], 64);
    public boolean zzd;
    public boolean zze;
    public boolean zzf;

    public zzyz(zzyc zzyc, zzale zzale) {
        this.zza = zzyc;
        this.zzb = zzale;
    }

    public final void zza() {
        this.zzf = false;
        this.zza.zza();
    }

    public final void zzb(zzakr zzakr) throws zzlg {
        long j;
        zzakr.zzm(this.zzc.zza, 0, 3);
        this.zzc.zzd(0);
        this.zzc.zzf(8);
        this.zzd = this.zzc.zzg();
        this.zze = this.zzc.zzg();
        this.zzc.zzf(6);
        zzakr.zzm(this.zzc.zza, 0, this.zzc.zzh(8));
        this.zzc.zzd(0);
        if (this.zzd) {
            this.zzc.zzf(4);
            int zzh = this.zzc.zzh(3);
            this.zzc.zzf(1);
            int zzh2 = this.zzc.zzh(15);
            this.zzc.zzf(1);
            long zzh3 = (((long) zzh) << 30) | ((long) (zzh2 << 15)) | ((long) this.zzc.zzh(15));
            this.zzc.zzf(1);
            if (!this.zzf && this.zze) {
                this.zzc.zzf(4);
                int zzh4 = this.zzc.zzh(3);
                this.zzc.zzf(1);
                int zzh5 = this.zzc.zzh(15);
                this.zzc.zzf(1);
                int zzh6 = this.zzc.zzh(15);
                this.zzc.zzf(1);
                this.zzb.zze(((long) (zzh5 << 15)) | (((long) zzh4) << 30) | ((long) zzh6));
                this.zzf = true;
            }
            j = this.zzb.zze(zzh3);
        } else {
            j = 0;
        }
        this.zza.zzc(j, 4);
        this.zza.zzd(zzakr);
        this.zza.zze();
    }
}
