package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbrv implements InitializationStatus {
    public final Map<String, AdapterStatus> zza;

    public zzbrv(Map<String, AdapterStatus> map) {
        this.zza = map;
    }

    public final Map<String, AdapterStatus> getAdapterStatusMap() {
        return this.zza;
    }
}
