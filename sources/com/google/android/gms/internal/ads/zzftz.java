package com.google.android.gms.internal.ads;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzftz extends zzfrv<zzfwx> {
    public zzftz() {
        super(zzfwx.class, new zzftx(zzfrk.class));
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.AesSivKey";
    }

    public final zzfyr zzc() {
        return zzfyr.SYMMETRIC;
    }

    public final /* bridge */ /* synthetic */ zzgfk zzd(zzgcz zzgcz) throws zzgeo {
        return zzfwx.zzd(zzgcz, zzgdo.zza());
    }

    public final /* bridge */ /* synthetic */ void zze(zzgfk zzgfk) throws GeneralSecurityException {
        zzfwx zzfwx = (zzfwx) zzgfk;
        zzgbx.zzb(zzfwx.zza(), 0);
        if (zzfwx.zzc().zzc() != 64) {
            throw new InvalidKeyException(GeneratedOutlineSupport.outline10(61, "invalid key size: ", zzfwx.zzc().zzc(), ". Valid keys must have 64 bytes."));
        }
    }

    public final zzfrt<zzfxa, zzfwx> zzi() {
        return new zzfty(this, zzfxa.class);
    }
}
