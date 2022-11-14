package com.google.android.gms.internal.ads;

import com.playrix.gplay.billing.Base64;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzggz {
    public static /* synthetic */ boolean zza(byte b) {
        return b >= 0;
    }

    public static /* synthetic */ boolean zzb(byte b) {
        return b < -32;
    }

    public static /* synthetic */ void zzc(byte b, byte b2, char[] cArr, int i) throws zzgeo {
        if (b < -62 || zzg(b2)) {
            throw zzgeo.zzl();
        }
        cArr[i] = (char) (((b & 31) << 6) | (b2 & 63));
    }

    public static /* synthetic */ boolean zzd(byte b) {
        return b < -16;
    }

    public static /* synthetic */ void zze(byte b, byte b2, byte b3, char[] cArr, int i) throws zzgeo {
        if (!zzg(b2)) {
            if (b == -32) {
                if (b2 >= -96) {
                    b = -32;
                }
            }
            if (b == -19) {
                if (b2 < -96) {
                    b = -19;
                }
            }
            if (!zzg(b3)) {
                cArr[i] = (char) (((b & 15) << 12) | ((b2 & 63) << 6) | (b3 & 63));
                return;
            }
        }
        throw zzgeo.zzl();
    }

    public static /* synthetic */ void zzf(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) throws zzgeo {
        if (!zzg(b2)) {
            if ((((b2 + 112) + (b << 28)) >> 30) == 0 && !zzg(b3) && !zzg(b4)) {
                byte b5 = ((b & 7) << 18) | ((b2 & 63) << 12) | ((b3 & 63) << 6) | (b4 & 63);
                cArr[i] = (char) ((b5 >>> 10) + 55232);
                cArr[i + 1] = (char) ((b5 & Base64.EQUALS_SIGN_ENC) + 56320);
                return;
            }
        }
        throw zzgeo.zzl();
    }

    public static boolean zzg(byte b) {
        return b > -65;
    }
}
