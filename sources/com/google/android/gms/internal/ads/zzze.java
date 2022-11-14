package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzze implements zzss {
    public final zzale zza;
    public final zzakr zzb = new zzakr();
    public final int zzc;

    public zzze(int i, zzale zzale, int i2) {
        this.zzc = i;
        this.zza = zzale;
    }

    public final zzsr zza(zztb zztb, long j) throws IOException {
        int zza2;
        int i;
        long j2;
        long zzn = zztb.zzn();
        int min = (int) Math.min(112800, zztb.zzo() - zzn);
        this.zzb.zza(min);
        ((zzsx) zztb).zzh(this.zzb.zzi(), 0, min, false);
        zzakr zzakr = this.zzb;
        int zze = zzakr.zze();
        long j3 = -1;
        long j4 = -1;
        long j5 = -9223372036854775807L;
        while (zzakr.zzd() >= 188 && (i = zza2 + 188) <= zze) {
            long zzb2 = zzzq.zzb(zzakr, (zza2 = zzzq.zza(zzakr.zzi(), zzakr.zzg(), zze)), this.zzc);
            if (zzb2 != -9223372036854775807L) {
                long zze2 = this.zza.zze(zzb2);
                if (zze2 > j) {
                    if (j5 == -9223372036854775807L) {
                        return zzsr.zza(zze2, zzn);
                    }
                    j2 = zzn + j4;
                } else if (100000 + zze2 > j) {
                    j2 = zzn + ((long) zza2);
                } else {
                    j4 = (long) zza2;
                    j5 = zze2;
                }
                return zzsr.zzc(j2);
            }
            zzakr.zzh(i);
            j3 = (long) i;
        }
        return j5 != -9223372036854775807L ? zzsr.zzb(j5, zzn + j3) : zzsr.zza;
    }

    public final void zzb() {
        zzakr zzakr = this.zzb;
        byte[] bArr = zzalh.zzf;
        int length = bArr.length;
        zzakr.zzb(bArr, 0);
    }
}
