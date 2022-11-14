package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfnn extends zzfnr {
    public final /* synthetic */ Comparator zza;

    public zzfnn(Comparator comparator) {
        this.zza = comparator;
    }

    public final <K, V> Map<K, Collection<V>> zza() {
        return new TreeMap(this.zza);
    }
}
