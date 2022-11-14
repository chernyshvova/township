package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfsk implements zzfsm {
    public final /* synthetic */ zzfsh zza;
    public final /* synthetic */ zzfrv zzb;

    public zzfsk(zzfsh zzfsh, zzfrv zzfrv) {
        this.zza = zzfsh;
        this.zzb = zzfrv;
    }

    public final <Q> zzfrn<Q> zza(Class<Q> cls) throws GeneralSecurityException {
        try {
            return new zzfsg(this.zza, this.zzb, cls);
        } catch (IllegalArgumentException e) {
            throw new GeneralSecurityException("Primitive type not supported", e);
        }
    }

    public final zzfrn<?> zzb() {
        zzfsh zzfsh = this.zza;
        return new zzfsg(zzfsh, this.zzb, zzfsh.zzh());
    }

    public final Class<?> zzc() {
        return this.zza.getClass();
    }

    public final Set<Class<?>> zzd() {
        return this.zza.zzg();
    }

    public final Class<?> zze() {
        return this.zzb.getClass();
    }
}
