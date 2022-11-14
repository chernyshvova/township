package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzagv {
    public final int zza;
    public final String[] zzb;
    public final int[] zzc;
    public final zzaft[] zzd;
    public final int[] zze;
    public final int[][][] zzf;
    public final zzaft zzg;

    public zzagv(String[] strArr, int[] iArr, zzaft[] zzaftArr, int[] iArr2, int[][][] iArr3, zzaft zzaft) {
        this.zzb = strArr;
        this.zzc = iArr;
        this.zzd = zzaftArr;
        this.zzf = iArr3;
        this.zze = iArr2;
        this.zzg = zzaft;
        this.zza = iArr.length;
    }

    public final int zza() {
        return this.zza;
    }

    public final int zzb(int i) {
        return this.zzc[i];
    }

    public final zzaft zzc(int i) {
        return this.zzd[i];
    }
}
