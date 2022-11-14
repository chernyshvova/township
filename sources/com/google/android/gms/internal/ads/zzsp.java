package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzsp {
    public final long zza;
    public final long zzb;
    public final long zzc;
    public long zzd = 0;
    public long zze;
    public long zzf;
    public long zzg;
    public long zzh;

    public zzsp(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        this.zza = j;
        long j8 = j2;
        this.zzb = j8;
        long j9 = j4;
        this.zze = j9;
        long j10 = j5;
        this.zzf = j10;
        long j11 = j6;
        this.zzg = j11;
        long j12 = j7;
        this.zzc = j12;
        this.zzh = zza(j8, 0, j9, j10, j11, j12);
    }

    public static long zza(long j, long j2, long j3, long j4, long j5, long j6) {
        if (j4 + 1 >= j5 || 1 + j2 >= j3) {
            return j4;
        }
        long j7 = (long) ((((float) (j5 - j4)) / ((float) (j3 - j2))) * ((float) (j - j2)));
        return zzalh.zzy(((j4 + j7) - j6) - (j7 / 20), j4, -1 + j5);
    }

    public static /* synthetic */ void zzg(zzsp zzsp, long j, long j2) {
        zzsp.zze = j;
        zzsp.zzg = j2;
        zzsp.zzi();
    }

    public static /* synthetic */ void zzh(zzsp zzsp, long j, long j2) {
        zzsp.zzd = j;
        zzsp.zzf = j2;
        zzsp.zzi();
    }

    private final void zzi() {
        this.zzh = zza(this.zzb, this.zzd, this.zze, this.zzf, this.zzg, this.zzc);
    }
}
