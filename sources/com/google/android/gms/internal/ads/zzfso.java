package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfso {
    public static final Charset zza = Charset.forName("UTF-8");

    public static zzfzk zza(zzfzf zzfzf) {
        zzfzh zza2 = zzfzk.zza();
        zza2.zza(zzfzf.zza());
        for (zzfze next : zzfzf.zzc()) {
            zzfzi zza3 = zzfzj.zza();
            zza3.zza(next.zzc().zza());
            zza3.zzb(next.zzd());
            zza3.zzd(next.zzf());
            zza3.zzc(next.zze());
            zza2.zzb((zzfzj) zza3.zzah());
        }
        return (zzfzk) zza2.zzah();
    }

    public static void zzb(zzfzf zzfzf) throws GeneralSecurityException {
        int zza2 = zzfzf.zza();
        int i = 0;
        boolean z = false;
        boolean z2 = true;
        for (zzfze next : zzfzf.zzc()) {
            if (next.zzd() == zzfyu.ENABLED) {
                if (!next.zza()) {
                    throw new GeneralSecurityException(String.format("key %d has no key data", new Object[]{Integer.valueOf(next.zze())}));
                } else if (next.zzf() == zzfzy.UNKNOWN_PREFIX) {
                    throw new GeneralSecurityException(String.format("key %d has unknown prefix", new Object[]{Integer.valueOf(next.zze())}));
                } else if (next.zzd() != zzfyu.UNKNOWN_STATUS) {
                    if (next.zze() == zza2) {
                        if (!z) {
                            z = true;
                        } else {
                            throw new GeneralSecurityException("keyset contains multiple primary keys");
                        }
                    }
                    z2 &= next.zzc().zzd() == zzfyr.ASYMMETRIC_PUBLIC;
                    i++;
                } else {
                    throw new GeneralSecurityException(String.format("key %d has unknown status", new Object[]{Integer.valueOf(next.zze())}));
                }
            }
        }
        if (i == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        } else if (!z && !z2) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }
}
