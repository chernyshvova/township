package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzwv {
    public final int zza;
    public final int zzb;
    public final long zzc;
    public final long zzd;
    public final long zze;
    public final zzkc zzf;
    public final int zzg;
    @Nullable
    public final long[] zzh;
    @Nullable
    public final long[] zzi;
    public final int zzj;
    @Nullable
    public final zzww[] zzk;

    public zzwv(int i, int i2, long j, long j2, long j3, zzkc zzkc, int i3, @Nullable zzww[] zzwwArr, int i4, @Nullable long[] jArr, @Nullable long[] jArr2) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = j;
        this.zzd = j2;
        this.zze = j3;
        this.zzf = zzkc;
        this.zzg = i3;
        this.zzk = zzwwArr;
        this.zzj = i4;
        this.zzh = jArr;
        this.zzi = jArr2;
    }

    @Nullable
    public final zzww zza(int i) {
        return this.zzk[i];
    }
}
