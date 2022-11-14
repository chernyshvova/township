package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzfru<PrimitiveT, KeyT> {
    public final Class<PrimitiveT> zza;

    public zzfru(Class<PrimitiveT> cls) {
        this.zza = cls;
    }

    public final Class<PrimitiveT> zza() {
        return this.zza;
    }

    public abstract PrimitiveT zzb(KeyT keyt) throws GeneralSecurityException;
}
