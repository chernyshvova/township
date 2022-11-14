package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzftu extends zzfrv<zzgae> {
    public zzftu() {
        super(zzgae.class, new zzfts(zzfrh.class));
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key";
    }

    public final zzfyr zzc() {
        return zzfyr.SYMMETRIC;
    }

    public final /* bridge */ /* synthetic */ zzgfk zzd(zzgcz zzgcz) throws zzgeo {
        return zzgae.zzd(zzgcz, zzgdo.zza());
    }

    public final /* bridge */ /* synthetic */ void zze(zzgfk zzgfk) throws GeneralSecurityException {
        zzgae zzgae = (zzgae) zzgfk;
        zzgbx.zzb(zzgae.zza(), 0);
        if (zzgae.zzc().zzc() != 32) {
            throw new GeneralSecurityException("invalid XChaCha20Poly1305Key: incorrect key length");
        }
    }

    public final zzfrt<zzgah, zzgae> zzi() {
        return new zzftt(this, zzgah.class);
    }
}
