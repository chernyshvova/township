package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfsy extends zzfrv<zzfvt> {
    public zzfsy() {
        super(zzfvt.class, new zzfsw(zzgbo.class));
    }

    public static final void zzk(zzfvt zzfvt) throws GeneralSecurityException {
        zzgbx.zzb(zzfvt.zza(), 0);
        zzgbx.zza(zzfvt.zzd().zzc());
        zzl(zzfvt.zzc());
    }

    public static final void zzl(zzfvz zzfvz) throws GeneralSecurityException {
        if (zzfvz.zza() < 12 || zzfvz.zza() > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.AesCtrKey";
    }

    public final zzfyr zzc() {
        return zzfyr.SYMMETRIC;
    }

    public final /* bridge */ /* synthetic */ zzgfk zzd(zzgcz zzgcz) throws zzgeo {
        return zzfvt.zze(zzgcz, zzgdo.zza());
    }

    public final /* bridge */ /* synthetic */ void zze(zzgfk zzgfk) throws GeneralSecurityException {
        zzk((zzfvt) zzgfk);
    }

    public final zzfrt<zzfvw, zzfvt> zzi() {
        return new zzfsx(this, zzfvw.class);
    }
}
