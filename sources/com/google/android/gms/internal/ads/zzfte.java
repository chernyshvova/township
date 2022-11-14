package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfte extends zzfrv<zzfwl> {
    public zzfte() {
        super(zzfwl.class, new zzftc(zzfrh.class));
    }

    public static /* synthetic */ zzfrs zzj(int i, int i2) {
        zzfwn zzd = zzfwo.zzd();
        zzd.zza(i);
        return new zzfrs((zzfwo) zzd.zzah(), i2);
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.AesGcmKey";
    }

    public final zzfyr zzc() {
        return zzfyr.SYMMETRIC;
    }

    public final /* bridge */ /* synthetic */ zzgfk zzd(zzgcz zzgcz) throws zzgeo {
        return zzfwl.zzd(zzgcz, zzgdo.zza());
    }

    public final /* bridge */ /* synthetic */ void zze(zzgfk zzgfk) throws GeneralSecurityException {
        zzfwl zzfwl = (zzfwl) zzgfk;
        zzgbx.zzb(zzfwl.zza(), 0);
        zzgbx.zza(zzfwl.zzc().zzc());
    }

    public final zzfrt<zzfwo, zzfwl> zzi() {
        return new zzftd(this, zzfwo.class);
    }
}
