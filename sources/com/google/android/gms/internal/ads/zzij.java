package com.google.android.gms.internal.ads;

import android.os.SystemClock;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzij {
    public final long zza;
    public final long zzb;
    public long zzc = -9223372036854775807L;
    public long zzd = -9223372036854775807L;
    public long zze = -9223372036854775807L;
    public long zzf = -9223372036854775807L;
    public long zzg = -9223372036854775807L;
    public long zzh = -9223372036854775807L;
    public float zzi = 1.03f;
    public float zzj = 0.97f;
    public float zzk = 1.0f;
    public long zzl = -9223372036854775807L;
    public long zzm = -9223372036854775807L;
    public long zzn = -9223372036854775807L;

    public /* synthetic */ zzij(float f, float f2, long j, float f3, long j2, long j3, float f4, zzih zzih) {
        this.zza = j2;
        this.zzb = j3;
    }

    private final void zzf() {
        long j = this.zzc;
        if (j != -9223372036854775807L) {
            long j2 = this.zzd;
            if (j2 != -9223372036854775807L) {
                j = j2;
            }
            long j3 = this.zzf;
            if (j3 != -9223372036854775807L && j < j3) {
                j = j3;
            }
            long j4 = this.zzg;
            if (j4 != -9223372036854775807L && j > j4) {
                j = j4;
            }
        } else {
            j = -9223372036854775807L;
        }
        if (this.zze != j) {
            this.zze = j;
            this.zzh = j;
            this.zzm = -9223372036854775807L;
            this.zzn = -9223372036854775807L;
            this.zzl = -9223372036854775807L;
        }
    }

    public static long zzg(long j, long j2, float f) {
        return (long) ((((float) j2) * 9.999871E-4f) + (((float) j) * 0.999f));
    }

    public final void zza(zzko zzko) {
        long j = zzko.zzb;
        this.zzc = zzig.zzb(-9223372036854775807L);
        this.zzf = zzig.zzb(-9223372036854775807L);
        this.zzg = zzig.zzb(-9223372036854775807L);
        this.zzj = 0.97f;
        this.zzi = 1.03f;
        zzf();
    }

    public final void zzb(long j) {
        this.zzd = j;
        zzf();
    }

    public final void zzc() {
        long j = this.zzh;
        if (j != -9223372036854775807L) {
            long j2 = j + this.zzb;
            this.zzh = j2;
            long j3 = this.zzg;
            if (j3 != -9223372036854775807L && j2 > j3) {
                this.zzh = j3;
            }
            this.zzl = -9223372036854775807L;
        }
    }

    public final float zzd(long j, long j2) {
        long j3;
        if (this.zzc == -9223372036854775807L) {
            return 1.0f;
        }
        long j4 = j - j2;
        long j5 = this.zzm;
        if (j5 == -9223372036854775807L) {
            this.zzm = j4;
            this.zzn = 0;
        } else {
            long max = Math.max(j4, zzg(j5, j4, 0.999f));
            this.zzm = max;
            this.zzn = zzg(this.zzn, Math.abs(j4 - max), 0.999f);
        }
        if (this.zzl != -9223372036854775807L && SystemClock.elapsedRealtime() - this.zzl < 1000) {
            return this.zzk;
        }
        this.zzl = SystemClock.elapsedRealtime();
        long j6 = (this.zzn * 3) + this.zzm;
        if (this.zzh > j6) {
            long zzb2 = zzig.zzb(1000);
            float f = (float) zzb2;
            long[] jArr = {j6, this.zze, this.zzh - (((long) ((this.zzk - 4.0f) * f)) + ((long) ((this.zzi - 4.0f) * f)))};
            j3 = jArr[0];
            for (int i = 1; i < 3; i++) {
                long j7 = jArr[i];
                if (j7 > j3) {
                    j3 = j7;
                }
            }
            this.zzh = j3;
        } else {
            j3 = zzalh.zzy(j - ((long) (Math.max(0.0f, this.zzk - 4.0f) / 1.0E-7f)), this.zzh, j6);
            this.zzh = j3;
            long j8 = this.zzg;
            if (j8 != -9223372036854775807L && j3 > j8) {
                this.zzh = j8;
                j3 = j8;
            }
        }
        long j9 = j - j3;
        if (Math.abs(j9) < this.zza) {
            this.zzk = 1.0f;
            return 1.0f;
        }
        float zzz = zzalh.zzz((((float) j9) * 1.0E-7f) + 1.0f, this.zzj, this.zzi);
        this.zzk = zzz;
        return zzz;
    }

    public final long zze() {
        return this.zzh;
    }
}
