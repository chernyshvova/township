package com.google.android.gms.internal.ads;

import com.playrix.gplay.billing.Base64;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzyx {
    public final zzale zza = new zzale(0);
    public final zzakr zzb = new zzakr();
    public boolean zzc;
    public boolean zzd;
    public boolean zze;
    public long zzf = -9223372036854775807L;
    public long zzg = -9223372036854775807L;
    public long zzh = -9223372036854775807L;

    public static long zze(zzakr zzakr) {
        zzakr zzakr2 = zzakr;
        int zzg2 = zzakr.zzg();
        if (zzakr.zzd() < 9) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[9];
        zzakr2.zzm(bArr, 0, 9);
        zzakr2.zzh(zzg2);
        if ((bArr[0] & 196) != 68 || (bArr[2] & 4) != 4 || (bArr[4] & 4) != 4 || (bArr[5] & 1) != 1 || (bArr[8] & 3) != 3) {
            return -9223372036854775807L;
        }
        long j = (long) bArr[0];
        byte b = bArr[1];
        long j2 = (long) bArr[2];
        return ((((long) bArr[3]) & 255) << 5) | ((j & 3) << 28) | (((56 & j) >> 3) << 30) | ((((long) b) & 255) << 20) | (((j2 & 248) >> 3) << 15) | ((j2 & 3) << 13) | ((((long) bArr[4]) & 248) >> 3);
    }

    private final int zzf(zztb zztb) {
        zzakr zzakr = this.zzb;
        byte[] bArr = zzalh.zzf;
        int length = bArr.length;
        zzakr.zzb(bArr, 0);
        this.zzc = true;
        zztb.zzl();
        return 0;
    }

    public static final int zzg(byte[] bArr, int i) {
        return (bArr[i + 3] & Base64.EQUALS_SIGN_ENC) | ((bArr[i] & Base64.EQUALS_SIGN_ENC) << 24) | ((bArr[i + 1] & Base64.EQUALS_SIGN_ENC) << 16) | ((bArr[i + 2] & Base64.EQUALS_SIGN_ENC) << 8);
    }

    public final boolean zza() {
        return this.zzc;
    }

    public final zzale zzb() {
        return this.zza;
    }

    public final int zzc(zztb zztb, zzts zzts) throws IOException {
        long j = -9223372036854775807L;
        if (!this.zze) {
            long zzo = zztb.zzo();
            int min = (int) Math.min(20000, zzo);
            long j2 = zzo - ((long) min);
            if (zztb.zzn() != j2) {
                zzts.zza = j2;
                return 1;
            }
            this.zzb.zza(min);
            zztb.zzl();
            ((zzsx) zztb).zzh(this.zzb.zzi(), 0, min, false);
            zzakr zzakr = this.zzb;
            int zzg2 = zzakr.zzg();
            int zze2 = zzakr.zze() - 4;
            while (true) {
                if (zze2 < zzg2) {
                    break;
                }
                if (zzg(zzakr.zzi(), zze2) == 442) {
                    zzakr.zzh(zze2 + 4);
                    long zze3 = zze(zzakr);
                    if (zze3 != -9223372036854775807L) {
                        j = zze3;
                        break;
                    }
                }
                zze2--;
            }
            this.zzg = j;
            this.zze = true;
            return 0;
        } else if (this.zzg == -9223372036854775807L) {
            zzf(zztb);
            return 0;
        } else if (!this.zzd) {
            int min2 = (int) Math.min(20000, zztb.zzo());
            if (zztb.zzn() != 0) {
                zzts.zza = 0;
                return 1;
            }
            this.zzb.zza(min2);
            zztb.zzl();
            ((zzsx) zztb).zzh(this.zzb.zzi(), 0, min2, false);
            zzakr zzakr2 = this.zzb;
            int zzg3 = zzakr2.zzg();
            int zze4 = zzakr2.zze();
            while (true) {
                if (zzg3 >= zze4 - 3) {
                    break;
                }
                if (zzg(zzakr2.zzi(), zzg3) == 442) {
                    zzakr2.zzh(zzg3 + 4);
                    long zze5 = zze(zzakr2);
                    if (zze5 != -9223372036854775807L) {
                        j = zze5;
                        break;
                    }
                }
                zzg3++;
            }
            this.zzf = j;
            this.zzd = true;
            return 0;
        } else {
            long j3 = this.zzf;
            if (j3 == -9223372036854775807L) {
                zzf(zztb);
                return 0;
            }
            this.zzh = this.zza.zze(this.zzg) - this.zza.zze(j3);
            zzf(zztb);
            return 0;
        }
    }

    public final long zzd() {
        return this.zzh;
    }
}
