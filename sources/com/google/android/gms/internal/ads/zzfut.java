package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfut extends zzfrv<zzfve> {
    public zzfut() {
        super(zzfve.class, new zzfur(zzfrz.class));
    }

    public static void zzl(zzfvk zzfvk) throws GeneralSecurityException {
        if (zzfvk.zza() < 10) {
            throw new GeneralSecurityException("tag size too short");
        } else if (zzfvk.zza() > 16) {
            throw new GeneralSecurityException("tag size too long");
        }
    }

    public static void zzm(int i) throws GeneralSecurityException {
        if (i != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
        }
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.AesCmacKey";
    }

    public final zzfyr zzc() {
        return zzfyr.SYMMETRIC;
    }

    public final /* bridge */ /* synthetic */ zzgfk zzd(zzgcz zzgcz) throws zzgeo {
        return zzfve.zze(zzgcz, zzgdo.zza());
    }

    public final /* bridge */ /* synthetic */ void zze(zzgfk zzgfk) throws GeneralSecurityException {
        zzfve zzfve = (zzfve) zzgfk;
        zzgbx.zzb(zzfve.zza(), 0);
        zzm(zzfve.zzc().zzc());
        zzl(zzfve.zzd());
    }

    public final zzfrt<zzfvh, zzfve> zzi() {
        return new zzfus(this, zzfvh.class);
    }
}
