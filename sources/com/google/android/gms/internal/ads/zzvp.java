package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.cardview.widget.RoundRectDrawableWithShadow;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzvp implements zzvu {
    public final long[] zza;
    public final long[] zzb;
    public final long zzc;

    public zzvp(long[] jArr, long[] jArr2, long j) {
        this.zza = jArr;
        this.zzb = jArr2;
        this.zzc = j == -9223372036854775807L ? zzig.zzb(jArr2[jArr2.length - 1]) : j;
    }

    public static zzvp zzd(long j, zzack zzack, long j2) {
        int length = zzack.zzd.length;
        int i = length + 1;
        long[] jArr = new long[i];
        long[] jArr2 = new long[i];
        jArr[0] = j;
        long j3 = 0;
        jArr2[0] = 0;
        for (int i2 = 1; i2 <= length; i2++) {
            int i3 = i2 - 1;
            j += (long) (zzack.zzb + zzack.zzd[i3]);
            j3 += (long) (zzack.zzc + zzack.zze[i3]);
            jArr[i2] = j;
            jArr2[i2] = j3;
        }
        return new zzvp(jArr, jArr2, j2);
    }

    public static Pair<Long, Long> zzg(long j, long[] jArr, long[] jArr2) {
        double d;
        int zzD = zzalh.zzD(jArr, j, true, true);
        long j2 = jArr[zzD];
        long j3 = jArr2[zzD];
        int i = zzD + 1;
        if (i == jArr.length) {
            return Pair.create(Long.valueOf(j2), Long.valueOf(j3));
        }
        long j4 = jArr[i];
        long j5 = jArr2[i];
        if (j4 == j2) {
            d = RoundRectDrawableWithShadow.COS_45;
        } else {
            double d2 = (double) j;
            double d3 = (double) j2;
            Double.isNaN(d2);
            Double.isNaN(d3);
            double d4 = (double) (j4 - j2);
            Double.isNaN(d4);
            d = (d2 - d3) / d4;
        }
        Long valueOf = Long.valueOf(j);
        double d5 = (double) (j5 - j3);
        Double.isNaN(d5);
        return Pair.create(valueOf, Long.valueOf(((long) (d * d5)) + j3));
    }

    public final boolean zza() {
        return true;
    }

    public final zztt zzb(long j) {
        Pair<Long, Long> zzg = zzg(zzig.zza(zzalh.zzy(j, 0, this.zzc)), this.zzb, this.zza);
        long longValue = ((Long) zzg.first).longValue();
        zztw zztw = new zztw(zzig.zzb(longValue), ((Long) zzg.second).longValue());
        return new zztt(zztw, zztw);
    }

    public final long zzc() {
        return this.zzc;
    }

    public final long zze(long j) {
        return zzig.zzb(((Long) zzg(j, this.zza, this.zzb).second).longValue());
    }

    public final long zzf() {
        return -1;
    }
}
