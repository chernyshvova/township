package com.google.android.gms.internal.ads;

import java.util.LinkedHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzgjb<K, V, V2> {
    public final LinkedHashMap<K, zzgju<V>> zza;

    public zzgjb(int i) {
        this.zza = zzgjd.zzc(i);
    }

    public final zzgjb<K, V, V2> zza(K k, zzgju<V> zzgju) {
        LinkedHashMap<K, zzgju<V>> linkedHashMap = this.zza;
        zzgjp.zza(k, "key");
        zzgjp.zza(zzgju, "provider");
        linkedHashMap.put(k, zzgju);
        return this;
    }
}
