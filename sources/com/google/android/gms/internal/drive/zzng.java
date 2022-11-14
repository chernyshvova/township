package com.google.android.gms.internal.drive;

import com.playrix.gplay.billing.Base64;

public final class zzng {
    public static void zza(byte b, char[] cArr, int i) {
        cArr[i] = (char) b;
    }

    public static boolean zzd(byte b) {
        return b >= 0;
    }

    public static boolean zze(byte b) {
        return b < -32;
    }

    public static boolean zzf(byte b) {
        return b < -16;
    }

    public static boolean zzg(byte b) {
        return b > -65;
    }

    public static void zza(byte b, byte b2, char[] cArr, int i) throws zzkq {
        if (b < -62 || zzg(b2)) {
            throw zzkq.zzdn();
        }
        cArr[i] = (char) (((b & 31) << 6) | (b2 & 63));
    }

    public static void zza(byte b, byte b2, byte b3, char[] cArr, int i) throws zzkq {
        if (zzg(b2) || ((b == -32 && b2 < -96) || ((b == -19 && b2 >= -96) || zzg(b3)))) {
            throw zzkq.zzdn();
        }
        cArr[i] = (char) (((b & 15) << 12) | ((b2 & 63) << 6) | (b3 & 63));
    }

    public static void zza(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) throws zzkq {
        if (!zzg(b2)) {
            if ((((b2 + 112) + (b << 28)) >> 30) == 0 && !zzg(b3) && !zzg(b4)) {
                byte b5 = ((b & 7) << 18) | ((b2 & 63) << 12) | ((b3 & 63) << 6) | (b4 & 63);
                cArr[i] = (char) ((b5 >>> 10) + 55232);
                cArr[i + 1] = (char) ((b5 & Base64.EQUALS_SIGN_ENC) + 56320);
                return;
            }
        }
        throw zzkq.zzdn();
    }
}
