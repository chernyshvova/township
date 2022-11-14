package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzhh<T> {
    public final Map<String, AtomicReference<T>> zza = new HashMap();

    public final AtomicReference<T> zza(String str) {
        synchronized (this) {
            if (!this.zza.containsKey(str)) {
                this.zza.put(str, new AtomicReference());
            }
        }
        return this.zza.get(str);
    }
}
