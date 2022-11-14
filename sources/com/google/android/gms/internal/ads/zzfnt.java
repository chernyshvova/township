package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfnt<K, V> extends zzfkq<K, V> {
    public final transient zzfkn<? extends List<V>> zza;

    public zzfnt(Map<K, Collection<V>> map, zzfkn<? extends List<V>> zzfkn) {
        super(map);
        this.zza = zzfkn;
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [java.util.Collection, java.lang.Object] */
    public final /* bridge */ /* synthetic */ Collection zzc() {
        return this.zza.zza();
    }

    public final Set<K> zzh() {
        return zzi();
    }

    public final Map<K, Collection<V>> zzl() {
        return zzm();
    }
}
