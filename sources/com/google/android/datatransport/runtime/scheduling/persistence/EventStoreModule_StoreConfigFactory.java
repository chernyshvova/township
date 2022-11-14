package com.google.android.datatransport.runtime.scheduling.persistence;

import com.android.billingclient.api.zzam;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final class EventStoreModule_StoreConfigFactory implements Object<EventStoreConfig> {
    public static final EventStoreModule_StoreConfigFactory INSTANCE = new EventStoreModule_StoreConfigFactory();

    public Object get() {
        EventStoreConfig eventStoreConfig = EventStoreConfig.DEFAULT;
        zzam.checkNotNull1(eventStoreConfig, "Cannot return null from a non-@Nullable @Provides method");
        return eventStoreConfig;
    }
}
