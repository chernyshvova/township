package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfsv extends zzfrv<zzfvn> {
    public zzfsv() {
        super(zzfvn.class, new zzfst(zzfrh.class));
    }

    public static /* synthetic */ zzfrs zzj(int i, int i2, int i3, int i4, zzfye zzfye, int i5) {
        zzfvv zze = zzfvw.zze();
        zzfvy zzc = zzfvz.zzc();
        zzc.zza(16);
        zze.zza((zzfvz) zzc.zzah());
        zze.zzb(i);
        zzfyj zze2 = zzfyk.zze();
        zzfym zzd = zzfyn.zzd();
        zzd.zza(zzfye);
        zzd.zzb(i4);
        zze2.zza((zzfyn) zzd.zzah());
        zze2.zzb(32);
        zzfvp zze3 = zzfvq.zze();
        zze3.zza((zzfvw) zze.zzah());
        zze3.zzb((zzfyk) zze2.zzah());
        return new zzfrs((zzfvq) zze3.zzah(), i5);
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    public final zzfyr zzc() {
        return zzfyr.SYMMETRIC;
    }

    public final /* bridge */ /* synthetic */ zzgfk zzd(zzgcz zzgcz) throws zzgeo {
        return zzfvn.zze(zzgcz, zzgdo.zza());
    }

    public final /* bridge */ /* synthetic */ void zze(zzgfk zzgfk) throws GeneralSecurityException {
        zzfvn zzfvn = (zzfvn) zzgfk;
        zzgbx.zzb(zzfvn.zza(), 0);
        new zzfsy();
        zzfsy.zzk(zzfvn.zzc());
        new zzfuw();
        zzfuw.zzl(zzfvn.zzd());
    }

    public final zzfrt<zzfvq, zzfvn> zzi() {
        return new zzfsu(this, zzfvq.class);
    }
}
