package com.google.android.gms.internal.ads;

import com.google.android.gms.drive.DriveFile;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzwy {
    public final zzwv zza;
    public final int zzb;
    public final long[] zzc;
    public final int[] zzd;
    public final int zze;
    public final long[] zzf;
    public final int[] zzg;
    public final long zzh;

    public zzwy(zzwv zzwv, long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2, long j) {
        int length = iArr.length;
        int length2 = jArr2.length;
        boolean z = true;
        zzajg.zza(length == length2);
        int length3 = jArr.length;
        zzajg.zza(length3 == length2);
        int length4 = iArr2.length;
        zzajg.zza(length4 != length2 ? false : z);
        this.zza = zzwv;
        this.zzc = jArr;
        this.zzd = iArr;
        this.zze = i;
        this.zzf = jArr2;
        this.zzg = iArr2;
        this.zzh = j;
        this.zzb = length3;
        if (length4 > 0) {
            int i2 = length4 - 1;
            iArr2[i2] = iArr2[i2] | DriveFile.MODE_WRITE_ONLY;
        }
    }

    public final int zza(long j) {
        for (int zzD = zzalh.zzD(this.zzf, j, true, false); zzD >= 0; zzD--) {
            if ((this.zzg[zzD] & 1) != 0) {
                return zzD;
            }
        }
        return -1;
    }

    public final int zzb(long j) {
        for (int zzE = zzalh.zzE(this.zzf, j, true, false); zzE < this.zzf.length; zzE++) {
            if ((this.zzg[zzE] & 1) != 0) {
                return zzE;
            }
        }
        return -1;
    }
}
