package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfuu extends zzfru<zzfrz, zzfyh> {
    public zzfuu(Class cls) {
        super(cls);
    }

    public final /* bridge */ /* synthetic */ Object zzb(Object obj) throws GeneralSecurityException {
        zzfyh zzfyh = (zzfyh) obj;
        zzfye zza = zzfyh.zzc().zza();
        SecretKeySpec secretKeySpec = new SecretKeySpec(zzfyh.zzd().zzz(), "HMAC");
        int zzc = zzfyh.zzc().zzc();
        zzfye zzfye = zzfye.UNKNOWN_HASH;
        int ordinal = zza.ordinal();
        if (ordinal == 1) {
            return new zzgbt(new zzgbs("HMACSHA1", secretKeySpec), zzc);
        }
        if (ordinal == 2) {
            return new zzgbt(new zzgbs("HMACSHA384", secretKeySpec), zzc);
        }
        if (ordinal == 3) {
            return new zzgbt(new zzgbs("HMACSHA256", secretKeySpec), zzc);
        }
        if (ordinal == 4) {
            return new zzgbt(new zzgbs("HMACSHA512", secretKeySpec), zzc);
        }
        if (ordinal == 5) {
            return new zzgbt(new zzgbs("HMACSHA224", secretKeySpec), zzc);
        }
        throw new GeneralSecurityException("unknown hash");
    }
}
