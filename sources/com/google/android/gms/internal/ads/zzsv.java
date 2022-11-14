package com.google.android.gms.internal.ads;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzsv implements zztv {
    public final int zza;
    public final int[] zzb;
    public final long[] zzc;
    public final long[] zzd;
    public final long[] zze;
    public final long zzf;

    public zzsv(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.zzb = iArr;
        this.zzc = jArr;
        this.zzd = jArr2;
        this.zze = jArr3;
        int length = iArr.length;
        this.zza = length;
        if (length > 0) {
            int i = length - 1;
            this.zzf = jArr2[i] + jArr3[i];
            return;
        }
        this.zzf = 0;
    }

    public final String toString() {
        int i = this.zza;
        String arrays = Arrays.toString(this.zzb);
        String arrays2 = Arrays.toString(this.zzc);
        String arrays3 = Arrays.toString(this.zze);
        String arrays4 = Arrays.toString(this.zzd);
        int length = String.valueOf(arrays).length();
        int length2 = String.valueOf(arrays2).length();
        StringBuilder sb = new StringBuilder(length + 71 + length2 + String.valueOf(arrays3).length() + String.valueOf(arrays4).length());
        sb.append("ChunkIndex(length=");
        sb.append(i);
        sb.append(", sizes=");
        sb.append(arrays);
        GeneratedOutlineSupport.outline34(sb, ", offsets=", arrays2, ", timeUs=", arrays3);
        return GeneratedOutlineSupport.outline19(sb, ", durationsUs=", arrays4, ")");
    }

    public final boolean zza() {
        return true;
    }

    public final zztt zzb(long j) {
        int zzD = zzalh.zzD(this.zze, j, true, true);
        zztw zztw = new zztw(this.zze[zzD], this.zzc[zzD]);
        if (zztw.zzb >= j || zzD == this.zza - 1) {
            return new zztt(zztw, zztw);
        }
        int i = zzD + 1;
        return new zztt(zztw, new zztw(this.zze[i], this.zzc[i]));
    }

    public final long zzc() {
        return this.zzf;
    }
}
