package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzftb extends zzfrv<zzfwc> {
    public zzftb() {
        super(zzfwc.class, new zzfsz(zzfrh.class));
    }

    public static /* synthetic */ zzfrs zzj(int i, int i2, int i3) {
        zzfwe zze = zzfwf.zze();
        zze.zzb(i);
        zzfwh zzc = zzfwi.zzc();
        zzc.zza(16);
        zze.zza((zzfwi) zzc.zzah());
        return new zzfrs((zzfwf) zze.zzah(), i3);
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    public final zzfyr zzc() {
        return zzfyr.SYMMETRIC;
    }

    public final /* bridge */ /* synthetic */ zzgfk zzd(zzgcz zzgcz) throws zzgeo {
        return zzfwc.zze(zzgcz, zzgdo.zza());
    }

    public final /* bridge */ /* synthetic */ void zze(zzgfk zzgfk) throws GeneralSecurityException {
        zzfwc zzfwc = (zzfwc) zzgfk;
        zzgbx.zzb(zzfwc.zza(), 0);
        zzgbx.zza(zzfwc.zzd().zzc());
        if (zzfwc.zzc().zza() != 12 && zzfwc.zzc().zza() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }

    public final zzfrt<zzfwf, zzfwc> zzi() {
        return new zzfta(this, zzfwf.class);
    }
}
