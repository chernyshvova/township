package com.google.android.gms.ads.initialization;

import androidx.annotation.RecentlyNonNull;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public interface InitializationStatus {
    @RecentlyNonNull
    Map<String, AdapterStatus> getAdapterStatusMap();
}
