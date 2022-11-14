package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfsj implements zzfsm {
    public final /* synthetic */ zzfrv zza;

    public zzfsj(zzfrv zzfrv) {
        this.zza = zzfrv;
    }

    public final <Q> zzfrn<Q> zza(Class<Q> cls) throws GeneralSecurityException {
        try {
            return new zzfrp(this.zza, cls);
        } catch (IllegalArgumentException e) {
            throw new GeneralSecurityException("Primitive type not supported", e);
        }
    }

    public final zzfrn<?> zzb() {
        zzfrv zzfrv = this.zza;
        return new zzfrp(zzfrv, zzfrv.zzh());
    }

    public final Class<?> zzc() {
        return this.zza.getClass();
    }

    public final Set<Class<?>> zzd() {
        return this.zza.zzg();
    }

    public final Class<?> zze() {
        return null;
    }
}
