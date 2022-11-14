package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzzq {
    public static int zza(byte[] bArr, int i, int i2) {
        while (i < i2 && bArr[i] != 71) {
            i++;
        }
        return i;
    }

    public static long zzb(zzakr zzakr, int i, int i2) {
        zzakr.zzh(i);
        if (zzakr.zzd() < 5) {
            return -9223372036854775807L;
        }
        int zzv = zzakr.zzv();
        if ((8388608 & zzv) != 0 || ((zzv >> 8) & 8191) != i2 || (zzv & 32) == 0 || zzakr.zzn() < 7 || zzakr.zzd() < 7 || (zzakr.zzn() & 16) != 16) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[6];
        zzakr.zzm(bArr, 0, 6);
        byte b = bArr[0];
        byte b2 = bArr[1];
        byte b3 = bArr[2];
        long j = ((long) bArr[3]) & 255;
        return ((((long) b2) & 255) << 17) | ((((long) b) & 255) << 25) | ((((long) b3) & 255) << 9) | (j + j) | ((((long) bArr[4]) & 255) >> 7);
    }
}
