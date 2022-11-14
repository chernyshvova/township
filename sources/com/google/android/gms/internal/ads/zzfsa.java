package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfsa {
    @Deprecated
    public static final zzfrw zza(byte[] bArr) throws GeneralSecurityException {
        try {
            zzfzf zze = zzfzf.zze(bArr, zzgdo.zza());
            for (zzfze next : zze.zzc()) {
                if (next.zzc().zzd() == zzfyr.UNKNOWN_KEYMATERIAL || next.zzc().zzd() == zzfyr.SYMMETRIC || next.zzc().zzd() == zzfyr.ASYMMETRIC_PRIVATE) {
                    throw new GeneralSecurityException("keyset contains secret key material");
                }
            }
            return zzfrw.zza(zze);
        } catch (zzgeo unused) {
            throw new GeneralSecurityException("invalid keyset");
        }
    }
}
