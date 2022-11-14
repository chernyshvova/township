package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzsw implements zztv {
    public final long zza;
    public final long zzb;
    public final int zzc;
    public final long zzd;
    public final int zze;
    public final long zzf;

    public zzsw(long j, long j2, int i, int i2) {
        this.zza = j;
        this.zzb = j2;
        this.zzc = i2 == -1 ? 1 : i2;
        this.zze = i;
        if (j == -1) {
            this.zzd = -1;
            this.zzf = -9223372036854775807L;
            return;
        }
        this.zzd = j - j2;
        this.zzf = zze(j, j2, i);
    }

    public static long zze(long j, long j2, int i) {
        return (Math.max(0, j - j2) * 8000000) / ((long) i);
    }

    public final boolean zza() {
        return this.zzd != -1;
    }

    public final zztt zzb(long j) {
        long j2 = this.zzd;
        if (j2 != -1) {
            int i = this.zze;
            long j3 = (long) this.zzc;
            long zzy = this.zzb + zzalh.zzy((((((long) i) * j) / 8000000) / j3) * j3, 0, j2 - j3);
            long zzd2 = zzd(zzy);
            zztw zztw = new zztw(zzd2, zzy);
            if (zzd2 < j) {
                long j4 = zzy + ((long) this.zzc);
                if (j4 < this.zza) {
                    return new zztt(zztw, new zztw(zzd(j4), j4));
                }
            }
            return new zztt(zztw, zztw);
        }
        zztw zztw2 = new zztw(0, this.zzb);
        return new zztt(zztw2, zztw2);
    }

    public final long zzc() {
        return this.zzf;
    }

    public final long zzd(long j) {
        return zze(j, this.zzb, this.zze);
    }
}
