package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzwe implements zzwb {
    public final zzakr zza;
    public final int zzb = this.zza.zzB();
    public final int zzc = (this.zza.zzB() & 255);
    public int zzd;
    public int zze;

    public zzwe(zzvy zzvy) {
        zzakr zzakr = zzvy.zza;
        this.zza = zzakr;
        zzakr.zzh(12);
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        return -1;
    }

    public final int zzc() {
        int i = this.zzc;
        if (i == 8) {
            return this.zza.zzn();
        }
        if (i == 16) {
            return this.zza.zzo();
        }
        int i2 = this.zzd;
        this.zzd = i2 + 1;
        if (i2 % 2 != 0) {
            return this.zze & 15;
        }
        int zzn = this.zza.zzn();
        this.zze = zzn;
        return (zzn & 240) >> 4;
    }
}
