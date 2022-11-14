package com.google.android.gms.internal.measurement;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class zzim<K> implements Map.Entry<K, Object> {
    public Map.Entry<K, zzik> zza;

    public zzim(Map.Entry<K, zzik> entry) {
        this.zza = entry;
    }

    public final K getKey() {
        return this.zza.getKey();
    }

    public final Object getValue() {
        if (this.zza.getValue() == null) {
            return null;
        }
        return zzik.zza();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof zzjj) {
            return this.zza.getValue().zza((zzjj) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }

    public final zzik zza() {
        return this.zza.getValue();
    }
}
