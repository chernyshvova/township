package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfsi implements zzfsm {
    public final /* synthetic */ zzfrn zza;

    public zzfsi(zzfrn zzfrn) {
        this.zza = zzfrn;
    }

    public final <Q> zzfrn<Q> zza(Class<Q> cls) throws GeneralSecurityException {
        if (this.zza.zze().equals(cls)) {
            return this.zza;
        }
        throw new InternalError("This should never be called, as we always first check supportedPrimitives.");
    }

    public final zzfrn<?> zzb() {
        return this.zza;
    }

    public final Class<?> zzc() {
        return this.zza.getClass();
    }

    public final Set<Class<?>> zzd() {
        return Collections.singleton(this.zza.zze());
    }

    public final Class<?> zze() {
        return null;
    }
}
