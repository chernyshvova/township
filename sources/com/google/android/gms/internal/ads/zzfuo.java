package com.google.android.gms.internal.ads;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfuo {
    public static void zza(zzfxr zzfxr) throws GeneralSecurityException {
        zzgbc.zzd(zzc(zzfxr.zza().zza()));
        zzb(zzfxr.zza().zzc());
        if (zzfxr.zzd() != zzfxi.UNKNOWN_FORMAT) {
            zzfsn.zzg(zzfxr.zzc().zza());
            return;
        }
        throw new GeneralSecurityException("unknown EC point format");
    }

    public static String zzb(zzfye zzfye) throws NoSuchAlgorithmException {
        zzfxi zzfxi = zzfxi.UNKNOWN_FORMAT;
        zzfyc zzfyc = zzfyc.UNKNOWN_CURVE;
        zzfye zzfye2 = zzfye.UNKNOWN_HASH;
        int ordinal = zzfye.ordinal();
        if (ordinal == 1) {
            return "HmacSha1";
        }
        if (ordinal == 2) {
            return "HmacSha384";
        }
        if (ordinal == 3) {
            return "HmacSha256";
        }
        if (ordinal == 4) {
            return "HmacSha512";
        }
        if (ordinal == 5) {
            return "HmacSha224";
        }
        String valueOf = String.valueOf(zzfye);
        throw new NoSuchAlgorithmException(GeneratedOutlineSupport.outline18(new StringBuilder(valueOf.length() + 27), "hash unsupported for HMAC: ", valueOf));
    }

    public static int zzc(zzfyc zzfyc) throws GeneralSecurityException {
        zzfxi zzfxi = zzfxi.UNKNOWN_FORMAT;
        zzfyc zzfyc2 = zzfyc.UNKNOWN_CURVE;
        zzfye zzfye = zzfye.UNKNOWN_HASH;
        int ordinal = zzfyc.ordinal();
        int i = 1;
        if (ordinal != 1) {
            i = 2;
            if (ordinal != 2) {
                if (ordinal == 3) {
                    return 3;
                }
                String valueOf = String.valueOf(zzfyc);
                throw new GeneralSecurityException(GeneratedOutlineSupport.outline18(new StringBuilder(valueOf.length() + 20), "unknown curve type: ", valueOf));
            }
        }
        return i;
    }

    public static int zzd(zzfxi zzfxi) throws GeneralSecurityException {
        zzfxi zzfxi2 = zzfxi.UNKNOWN_FORMAT;
        zzfyc zzfyc = zzfyc.UNKNOWN_CURVE;
        zzfye zzfye = zzfye.UNKNOWN_HASH;
        int ordinal = zzfxi.ordinal();
        int i = 1;
        if (ordinal != 1) {
            i = 2;
            if (ordinal != 2) {
                if (ordinal == 3) {
                    return 3;
                }
                String valueOf = String.valueOf(zzfxi);
                throw new GeneralSecurityException(GeneratedOutlineSupport.outline18(new StringBuilder(valueOf.length() + 22), "unknown point format: ", valueOf));
            }
        }
        return i;
    }
}
