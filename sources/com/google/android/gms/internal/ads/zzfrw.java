package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfrw {
    public final zzfzf zza;

    public zzfrw(zzfzf zzfzf) {
        this.zza = zzfzf;
    }

    public static final zzfrw zza(zzfzf zzfzf) throws GeneralSecurityException {
        if (zzfzf != null && zzfzf.zzd() > 0) {
            return new zzfrw(zzfzf);
        }
        throw new GeneralSecurityException("empty keyset");
    }

    public final String toString() {
        return zzfso.zza(this.zza).toString();
    }

    public final <P> P zzb(Class<P> cls) throws GeneralSecurityException {
        String str;
        Class<?> zzn = zzfsn.zzn(cls);
        if (zzn == null) {
            String name = cls.getName();
            if (name.length() != 0) {
                str = "No wrapper found for ".concat(name);
            } else {
                str = new String("No wrapper found for ");
            }
            throw new GeneralSecurityException(str);
        }
        zzfso.zzb(this.zza);
        zzfse<P> zzb = zzfse.zzb(zzn);
        for (zzfze next : this.zza.zzc()) {
            if (next.zzd() == zzfyu.ENABLED) {
                zzfsc<P> zzd = zzb.zzd(zzfsn.zzk(next.zzc(), zzn), next);
                if (next.zze() == this.zza.zza()) {
                    zzb.zzc(zzd);
                }
            }
        }
        return zzfsn.zzl(zzb, cls);
    }
}
