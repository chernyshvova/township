package com.google.android.gms.internal.ads;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.internal.ads.zzgfk;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzfrv<KeyProtoT extends zzgfk> {
    public final Class<KeyProtoT> zza;
    public final Map<Class<?>, zzfru<?, KeyProtoT>> zzb;
    public final Class<?> zzc;

    @SafeVarargs
    public zzfrv(Class<KeyProtoT> cls, zzfru<?, KeyProtoT>... zzfruArr) {
        String str;
        this.zza = cls;
        HashMap hashMap = new HashMap();
        for (int i = 0; i <= 0; i++) {
            zzfru<?, KeyProtoT> zzfru = zzfruArr[i];
            if (hashMap.containsKey(zzfru.zza())) {
                String valueOf = String.valueOf(zzfru.zza().getCanonicalName());
                if (valueOf.length() != 0) {
                    str = "KeyTypeManager constructed with duplicate factories for primitive ".concat(valueOf);
                } else {
                    str = new String("KeyTypeManager constructed with duplicate factories for primitive ");
                }
                throw new IllegalArgumentException(str);
            }
            hashMap.put(zzfru.zza(), zzfru);
        }
        this.zzc = zzfruArr[0].zza();
        this.zzb = Collections.unmodifiableMap(hashMap);
    }

    public final Class<KeyProtoT> zza() {
        return this.zza;
    }

    public abstract String zzb();

    public abstract zzfyr zzc();

    public abstract KeyProtoT zzd(zzgcz zzgcz) throws zzgeo;

    public abstract void zze(KeyProtoT keyprotot) throws GeneralSecurityException;

    public final <P> P zzf(KeyProtoT keyprotot, Class<P> cls) throws GeneralSecurityException {
        zzfru zzfru = this.zzb.get(cls);
        if (zzfru != null) {
            return zzfru.zzb(keyprotot);
        }
        String canonicalName = cls.getCanonicalName();
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline19(new StringBuilder(String.valueOf(canonicalName).length() + 41), "Requested primitive class ", canonicalName, " not supported."));
    }

    public final Set<Class<?>> zzg() {
        return this.zzb.keySet();
    }

    public final Class<?> zzh() {
        return this.zzc;
    }

    public zzfrt<?, KeyProtoT> zzi() {
        throw new UnsupportedOperationException("Creating keys is not supported.");
    }
}
