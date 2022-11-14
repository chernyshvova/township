package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzgjk<K, V> extends zzgjc<K, V, V> {
    public static final zzgju<Map<Object, Object>> zza = zzgjh.zza(Collections.emptyMap());

    public /* synthetic */ zzgjk(Map map, zzgji zzgji) {
        super(map);
    }

    public static <K, V> zzgjj<K, V> zzc(int i) {
        return new zzgjj<>(i, (zzgji) null);
    }

    /* renamed from: zzd */
    public final Map<K, V> zzb() {
        LinkedHashMap zzc = zzgjd.zzc(zza().size());
        for (Map.Entry entry : zza().entrySet()) {
            zzc.put(entry.getKey(), ((zzgju) entry.getValue()).zzb());
        }
        return Collections.unmodifiableMap(zzc);
    }
}
