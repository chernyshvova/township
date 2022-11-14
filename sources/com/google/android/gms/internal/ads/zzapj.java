package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzapj implements zzaps {
    public final int[] zza;
    public final long[] zzb;
    public final long[] zzc;
    public final long[] zzd;
    public final long zze;

    public zzapj(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.zza = iArr;
        this.zzb = jArr;
        this.zzc = jArr2;
        this.zzd = jArr3;
        int length = iArr.length;
        if (length > 0) {
            int i = length - 1;
            this.zze = jArr2[i] + jArr3[i];
            return;
        }
        this.zze = 0;
    }

    public final boolean zza() {
        return true;
    }

    public final long zzb() {
        return this.zze;
    }

    public final long zzc(long j) {
        return this.zzb[zzava.zzh(this.zzd, j, true, true)];
    }
}
