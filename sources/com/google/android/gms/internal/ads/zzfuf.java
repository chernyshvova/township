package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfuf extends zzfsh<zzfxu, zzfxx> {
    public static final byte[] zza = new byte[0];

    public zzfuf() {
        super(zzfxu.class, zzfxx.class, new zzfud(zzfrl.class));
    }

    public static /* synthetic */ zzfrs zzk(zzfyc zzfyc, zzfye zzfye, zzfxi zzfxi, zzfrq zzfrq, byte[] bArr, int i) {
        zzfzy zzfzy;
        zzfxn zzd = zzfxo.zzd();
        zzfxz zze = zzfya.zze();
        zze.zza(zzfyc);
        zze.zzb(zzfye);
        zze.zzc(zzgcz.zzt(bArr));
        zzfya zzfya = (zzfya) zze.zzah();
        zzfyw zze2 = zzfyx.zze();
        zze2.zza(zzfrq.zza());
        zze2.zzb(zzgcz.zzt(zzfrq.zzb()));
        int zzd2 = zzfrq.zzd() - 1;
        if (zzd2 == 0) {
            zzfzy = zzfzy.TINK;
        } else if (zzd2 == 1) {
            zzfzy = zzfzy.LEGACY;
        } else if (zzd2 != 2) {
            zzfzy = zzfzy.CRUNCHY;
        } else {
            zzfzy = zzfzy.RAW;
        }
        zze2.zzc(zzfzy);
        zzfxk zzc = zzfxl.zzc();
        zzc.zza((zzfyx) zze2.zzah());
        zzfxq zze3 = zzfxr.zze();
        zze3.zza(zzfya);
        zze3.zzb((zzfxl) zzc.zzah());
        zze3.zzc(zzfxi);
        zzd.zza((zzfxr) zze3.zzah());
        return new zzfrs((zzfxo) zzd.zzah(), i);
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    }

    public final zzfyr zzc() {
        return zzfyr.ASYMMETRIC_PRIVATE;
    }

    public final /* bridge */ /* synthetic */ zzgfk zzd(zzgcz zzgcz) throws zzgeo {
        return zzfxu.zze(zzgcz, zzgdo.zza());
    }

    public final /* bridge */ /* synthetic */ void zze(zzgfk zzgfk) throws GeneralSecurityException {
        zzfxu zzfxu = (zzfxu) zzgfk;
        if (!zzfxu.zzd().zzr()) {
            zzgbx.zzb(zzfxu.zza(), 0);
            zzfuo.zza(zzfxu.zzc().zzc());
            return;
        }
        throw new GeneralSecurityException("invalid ECIES private key");
    }

    public final zzfrt<zzfxo, zzfxu> zzi() {
        return new zzfue(this, zzfxo.class);
    }
}
