package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcoh {
    public final int zza;
    public final int zzb;
    public final int zzc;

    public zzcoh(int i, int i2, int i3) {
        this.zzc = i;
        this.zzb = i2;
        this.zza = i3;
    }

    public static zzcoh zza(zzbdp zzbdp) {
        if (zzbdp.zzd) {
            return new zzcoh(3, 0, 0);
        }
        if (zzbdp.zzi) {
            return new zzcoh(2, 0, 0);
        }
        if (zzbdp.zzh) {
            return zzb();
        }
        return zzc(zzbdp.zzf, zzbdp.zzc);
    }

    public static zzcoh zzb() {
        return new zzcoh(0, 0, 0);
    }

    public static zzcoh zzc(int i, int i2) {
        return new zzcoh(1, i, i2);
    }

    public static zzcoh zzd() {
        return new zzcoh(4, 0, 0);
    }

    public static zzcoh zze() {
        return new zzcoh(5, 0, 0);
    }

    public final boolean zzf() {
        return this.zzc == 2;
    }

    public final boolean zzg() {
        return this.zzc == 3;
    }

    public final boolean zzh() {
        return this.zzc == 0;
    }

    public final boolean zzi() {
        return this.zzc == 4;
    }

    public final boolean zzj() {
        return this.zzc == 5;
    }
}
