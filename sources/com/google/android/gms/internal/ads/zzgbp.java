package com.google.android.gms.internal.ads;

import com.playrix.gplay.billing.Base64;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgbp {
    public static byte[] zza(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        if (bArr3.length == 32) {
            long zzc = zzc(bArr3, 0, 0);
            int i = 2;
            long zzc2 = zzc(bArr3, 3, 2) & 67108611;
            long zzc3 = zzc(bArr3, 6, 4) & 67092735;
            long zzc4 = zzc(bArr3, 9, 6) & 66076671;
            long zzc5 = zzc(bArr3, 12, 8) & 1048575;
            long j = zzc2 * 5;
            long j2 = zzc3 * 5;
            long j3 = zzc4 * 5;
            long j4 = zzc5 * 5;
            int i2 = 17;
            byte[] bArr5 = new byte[17];
            long j5 = 0;
            long j6 = 0;
            long j7 = 0;
            long j8 = 0;
            long j9 = 0;
            int i3 = 0;
            while (true) {
                int length = bArr4.length;
                if (i3 < length) {
                    int min = Math.min(16, length - i3);
                    System.arraycopy(bArr4, i3, bArr5, 0, min);
                    bArr5[min] = 1;
                    if (min != 16) {
                        Arrays.fill(bArr5, min + 1, i2, (byte) 0);
                    }
                    long zzc6 = zzc(bArr5, 0, 0) + j9;
                    long zzc7 = zzc(bArr5, 3, i) + j6;
                    long zzc8 = zzc(bArr5, 6, 4) + j5;
                    long zzc9 = zzc(bArr5, 9, 6) + j7;
                    long zzc10 = j8 + (zzc(bArr5, 12, 8) | ((long) (bArr5[16] << 24)));
                    long j10 = (zzc10 * j) + (zzc9 * j2) + (zzc8 * j3) + (zzc7 * j4) + (zzc6 * zzc);
                    long j11 = (zzc10 * j2) + (zzc9 * j3) + (zzc8 * j4) + (zzc7 * zzc) + (zzc6 * zzc2) + (j10 >> 26);
                    long j12 = (zzc10 * j3) + (zzc9 * j4) + (zzc8 * zzc) + (zzc7 * zzc2) + (zzc6 * zzc3) + (j11 >> 26);
                    long j13 = (zzc10 * j4) + (zzc9 * zzc) + (zzc8 * zzc2) + (zzc7 * zzc3) + (zzc6 * zzc4) + (j12 >> 26);
                    long j14 = zzc9 * zzc2;
                    long j15 = zzc10 * zzc;
                    long j16 = j15 + j14 + (zzc8 * zzc3) + (zzc7 * zzc4) + (zzc6 * zzc5) + (j13 >> 26);
                    long j17 = ((j16 >> 26) * 5) + (j10 & 67108863);
                    j9 = j17 & 67108863;
                    j6 = (j11 & 67108863) + (j17 >> 26);
                    i3 += 16;
                    j8 = j16 & 67108863;
                    j7 = j13 & 67108863;
                    j5 = j12 & 67108863;
                    i2 = 17;
                    i = 2;
                } else {
                    long j18 = j5 + (j6 >> 26);
                    long j19 = j18 & 67108863;
                    long j20 = j7 + (j18 >> 26);
                    long j21 = j20 & 67108863;
                    long j22 = j8 + (j20 >> 26);
                    long j23 = j22 & 67108863;
                    long j24 = ((j22 >> 26) * 5) + j9;
                    long j25 = j24 & 67108863;
                    long j26 = (j6 & 67108863) + (j24 >> 26);
                    long j27 = j25 + 5;
                    long j28 = (j27 >> 26) + j26;
                    long j29 = j19 + (j28 >> 26);
                    long j30 = j21 + (j29 >> 26);
                    long j31 = (j23 + (j30 >> 26)) - 67108864;
                    long j32 = j31 >> 63;
                    long j33 = j32 ^ -1;
                    long j34 = (j28 & 67108863 & j33) | (j26 & j32);
                    long j35 = (j19 & j32) | (j29 & 67108863 & j33);
                    long j36 = (j21 & j32) | (j30 & 67108863 & j33);
                    long zzb = zzb(bArr3, 16) + (((j25 & j32) | (j27 & 67108863 & j33) | (j34 << 26)) & 4294967295L);
                    long zzb2 = zzb(bArr3, 20) + (((j34 >> 6) | (j35 << 20)) & 4294967295L) + (zzb >> 32);
                    long zzb3 = zzb(bArr3, 24) + (((j35 >> 12) | (j36 << 14)) & 4294967295L) + (zzb2 >> 32);
                    long zzb4 = zzb(bArr3, 28);
                    byte[] bArr6 = new byte[16];
                    zzd(bArr6, zzb & 4294967295L, 0);
                    zzd(bArr6, zzb2 & 4294967295L, 4);
                    zzd(bArr6, zzb3 & 4294967295L, 8);
                    zzd(bArr6, ((((j36 >> 18) | (((j23 & j32) | (j31 & j33)) << 8)) & 4294967295L) + zzb4 + (zzb3 >> 32)) & 4294967295L, 12);
                    return bArr6;
                }
            }
        } else {
            throw new IllegalArgumentException("The key length in bytes must be 32.");
        }
    }

    public static long zzb(byte[] bArr, int i) {
        return ((long) (((bArr[i + 3] & Base64.EQUALS_SIGN_ENC) << 24) | (bArr[i] & Base64.EQUALS_SIGN_ENC) | ((bArr[i + 1] & Base64.EQUALS_SIGN_ENC) << 8) | ((bArr[i + 2] & Base64.EQUALS_SIGN_ENC) << 16))) & 4294967295L;
    }

    public static long zzc(byte[] bArr, int i, int i2) {
        return (zzb(bArr, i) >> i2) & 67108863;
    }

    public static void zzd(byte[] bArr, long j, int i) {
        int i2 = 0;
        while (i2 < 4) {
            bArr[i + i2] = (byte) ((int) (255 & j));
            i2++;
            j >>= 8;
        }
    }
}
