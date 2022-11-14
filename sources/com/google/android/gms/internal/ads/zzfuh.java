package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfuh extends zzfrv<zzfxx> {
    public zzfuh() {
        super(zzfxx.class, new zzfug(zzfrm.class));
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey";
    }

    public final zzfyr zzc() {
        return zzfyr.ASYMMETRIC_PUBLIC;
    }

    public final /* bridge */ /* synthetic */ zzgfk zzd(zzgcz zzgcz) throws zzgeo {
        return zzfxx.zzf(zzgcz, zzgdo.zza());
    }

    public final /* bridge */ /* synthetic */ void zze(zzgfk zzgfk) throws GeneralSecurityException {
        zzfxx zzfxx = (zzfxx) zzgfk;
        zzgbx.zzb(zzfxx.zza(), 0);
        zzfuo.zza(zzfxx.zzc());
    }
}
