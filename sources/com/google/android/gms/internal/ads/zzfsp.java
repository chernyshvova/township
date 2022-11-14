package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfsp {
    public static final String zza = "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    public static final String zzb = "type.googleapis.com/google.crypto.tink.AesGcmKey";
    @Deprecated
    public static final zzgab zzc;
    @Deprecated
    public static final zzgab zzd;
    @Deprecated
    public static final zzgab zze;

    static {
        new zzfsv();
        new zzfte();
        new zzfth();
        new zzftb();
        new zzftn();
        new zzftr();
        new zzftk();
        new zzftu();
        zzgab zzc2 = zzgab.zzc();
        zzc = zzc2;
        zzd = zzc2;
        zze = zzc2;
        try {
            zza();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzfsn.zze(new zzfss());
        zzfux.zza();
        zzfsn.zzc(new zzfsv(), true);
        zzfsn.zzc(new zzfte(), true);
        zzfsn.zzc(new zzftb(), true);
        zzfth.zzj(true);
        zzfsn.zzc(new zzftk(), true);
        zzfsn.zzc(new zzftn(), true);
        zzfsn.zzc(new zzftr(), true);
        zzfsn.zzc(new zzftu(), true);
    }
}
