package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfoa<K, V> extends zzfmv<Map.Entry<K, V>> {
    public final transient zzfmp<K, V> zza;
    public final transient Object[] zzb;
    public final transient int zzc;

    public zzfoa(zzfmp<K, V> zzfmp, Object[] objArr, int i, int i2) {
        this.zza = zzfmp;
        this.zzb = objArr;
        this.zzc = i2;
    }

    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value == null || !value.equals(this.zza.get(key))) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final /* bridge */ /* synthetic */ Iterator iterator() {
        return zze().listIterator(0);
    }

    public final int size() {
        return this.zzc;
    }

    public final zzfom<Map.Entry<K, V>> zza() {
        return zze().listIterator(0);
    }

    public final boolean zzf() {
        throw null;
    }

    public final int zzg(Object[] objArr, int i) {
        return zze().zzg(objArr, i);
    }

    public final zzfml<Map.Entry<K, V>> zzk() {
        return new zzfnz(this);
    }
}
