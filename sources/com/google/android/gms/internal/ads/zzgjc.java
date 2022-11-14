package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzgjc<K, V, V2> implements zzgjg<Map<K, V2>> {
    public final Map<K, zzgju<V>> zza;

    public zzgjc(Map<K, zzgju<V>> map) {
        this.zza = Collections.unmodifiableMap(map);
    }

    public final Map<K, zzgju<V>> zza() {
        return this.zza;
    }
}
