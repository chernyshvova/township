package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzarb {
    public final int zza;
    public final long[] zzb;
    public final int[] zzc;
    public final int zzd;
    public final long[] zze;
    public final int[] zzf;

    public zzarb(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2) {
        int length = jArr2.length;
        boolean z = true;
        zzaul.zza(iArr.length == length);
        int length2 = jArr.length;
        zzaul.zza(length2 == length);
        zzaul.zza(iArr2.length != length ? false : z);
        this.zzb = jArr;
        this.zzc = iArr;
        this.zzd = i;
        this.zze = jArr2;
        this.zzf = iArr2;
        this.zza = length2;
    }

    public final int zza(long j) {
        for (int zzh = zzava.zzh(this.zze, j, true, false); zzh >= 0; zzh--) {
            if ((this.zzf[zzh] & 1) != 0) {
                return zzh;
            }
        }
        return -1;
    }

    public final int zzb(long j) {
        for (int zzi = zzava.zzi(this.zze, j, true, false); zzi < this.zze.length; zzi++) {
            if ((this.zzf[zzi] & 1) != 0) {
                return zzi;
            }
        }
        return -1;
    }
}
