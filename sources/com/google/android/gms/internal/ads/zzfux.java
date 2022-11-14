package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfux {
    @Deprecated
    public static final zzgab zza;
    @Deprecated
    public static final zzgab zzb;
    @Deprecated
    public static final zzgab zzc;

    static {
        new zzfuw();
        zzgab zzc2 = zzgab.zzc();
        zza = zzc2;
        zzb = zzc2;
        zzc = zzc2;
        try {
            zza();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzfsn.zze(new zzfva());
        zzfsn.zzc(new zzfuw(), true);
        zzfsn.zzc(new zzfut(), true);
    }
}
