package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzwa {
    public final int zza;
    public int zzb;
    public int zzc;
    public long zzd;
    public final boolean zze;
    public final zzakr zzf;
    public final zzakr zzg;
    public int zzh;
    public int zzi;

    public zzwa(zzakr zzakr, zzakr zzakr2, boolean z) throws zzlg {
        this.zzg = zzakr;
        this.zzf = zzakr2;
        this.zze = z;
        zzakr2.zzh(12);
        this.zza = zzakr2.zzB();
        zzakr.zzh(12);
        this.zzi = zzakr.zzB();
        zzte.zza(zzakr.zzv() != 1 ? false : true, "first_chunk must be 1");
        this.zzb = -1;
    }

    public final boolean zza() {
        long j;
        int i = this.zzb + 1;
        this.zzb = i;
        if (i == this.zza) {
            return false;
        }
        if (this.zze) {
            j = this.zzf.zzD();
        } else {
            j = this.zzf.zzt();
        }
        this.zzd = j;
        if (this.zzb == this.zzh) {
            this.zzc = this.zzg.zzB();
            this.zzg.zzk(4);
            int i2 = -1;
            int i3 = this.zzi - 1;
            this.zzi = i3;
            if (i3 > 0) {
                i2 = -1 + this.zzg.zzB();
            }
            this.zzh = i2;
        }
        return true;
    }
}
