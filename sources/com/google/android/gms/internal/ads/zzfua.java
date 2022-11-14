package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfua {
    public static final String zza = "type.googleapis.com/google.crypto.tink.AesSivKey";
    @Deprecated
    public static final zzgab zzb = zzgab.zzc();
    @Deprecated
    public static final zzgab zzc = zzgab.zzc();

    static {
        new zzftz();
        try {
            zzfsn.zze(new zzfuc());
            zzfsn.zzc(new zzftz(), true);
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}
