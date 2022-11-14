package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfuw extends zzfrv<zzfyh> {
    public zzfuw() {
        super(zzfyh.class, new zzfuu(zzfrz.class));
    }

    public static /* synthetic */ zzfrs zzk(int i, int i2, zzfye zzfye, int i3) {
        zzfyj zze = zzfyk.zze();
        zzfym zzd = zzfyn.zzd();
        zzd.zza(zzfye);
        zzd.zzb(i2);
        zze.zza((zzfyn) zzd.zzah());
        zze.zzb(i);
        return new zzfrs((zzfyk) zze.zzah(), i3);
    }

    public static final void zzl(zzfyh zzfyh) throws GeneralSecurityException {
        zzgbx.zzb(zzfyh.zza(), 0);
        if (zzfyh.zzd().zzc() >= 16) {
            zzm(zzfyh.zzc());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }

    public static void zzm(zzfyn zzfyn) throws GeneralSecurityException {
        if (zzfyn.zzc() >= 10) {
            zzfye zzfye = zzfye.UNKNOWN_HASH;
            int ordinal = zzfyn.zza().ordinal();
            if (ordinal != 1) {
                if (ordinal != 2) {
                    if (ordinal != 3) {
                        if (ordinal != 4) {
                            if (ordinal != 5) {
                                throw new GeneralSecurityException("unknown hash type");
                            } else if (zzfyn.zzc() > 28) {
                                throw new GeneralSecurityException("tag size too big");
                            }
                        } else if (zzfyn.zzc() > 64) {
                            throw new GeneralSecurityException("tag size too big");
                        }
                    } else if (zzfyn.zzc() > 32) {
                        throw new GeneralSecurityException("tag size too big");
                    }
                } else if (zzfyn.zzc() > 48) {
                    throw new GeneralSecurityException("tag size too big");
                }
            } else if (zzfyn.zzc() > 20) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else {
            throw new GeneralSecurityException("tag size too small");
        }
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    public final zzfyr zzc() {
        return zzfyr.SYMMETRIC;
    }

    public final /* bridge */ /* synthetic */ zzgfk zzd(zzgcz zzgcz) throws zzgeo {
        return zzfyh.zze(zzgcz, zzgdo.zza());
    }

    public final /* bridge */ /* synthetic */ void zze(zzgfk zzgfk) throws GeneralSecurityException {
        zzl((zzfyh) zzgfk);
    }

    public final zzfrt<zzfyk, zzfyh> zzi() {
        return new zzfuv(this, zzfyk.class);
    }
}
