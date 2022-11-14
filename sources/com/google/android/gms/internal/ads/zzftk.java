package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzftk extends zzfrv<zzfxd> {
    public zzftk() {
        super(zzfxd.class, new zzfti(zzfrh.class));
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
    }

    public final zzfyr zzc() {
        return zzfyr.SYMMETRIC;
    }

    public final /* bridge */ /* synthetic */ zzgfk zzd(zzgcz zzgcz) throws zzgeo {
        return zzfxd.zzd(zzgcz, zzgdo.zza());
    }

    public final /* bridge */ /* synthetic */ void zze(zzgfk zzgfk) throws GeneralSecurityException {
        zzfxd zzfxd = (zzfxd) zzgfk;
        zzgbx.zzb(zzfxd.zza(), 0);
        if (zzfxd.zzc().zzc() != 32) {
            throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
        }
    }

    public final zzfrt<zzfxg, zzfxd> zzi() {
        return new zzftj(this, zzfxg.class);
    }
}
