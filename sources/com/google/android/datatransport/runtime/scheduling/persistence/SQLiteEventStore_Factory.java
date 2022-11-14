package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.time.Clock;
import javax.inject.Provider;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final class SQLiteEventStore_Factory implements Object<SQLiteEventStore> {
    public final Provider<Clock> clockProvider;
    public final Provider<EventStoreConfig> configProvider;
    public final Provider<SchemaManager> schemaManagerProvider;
    public final Provider<Clock> wallClockProvider;

    public SQLiteEventStore_Factory(Provider<Clock> provider, Provider<Clock> provider2, Provider<EventStoreConfig> provider3, Provider<SchemaManager> provider4) {
        this.wallClockProvider = provider;
        this.clockProvider = provider2;
        this.configProvider = provider3;
        this.schemaManagerProvider = provider4;
    }

    public Object get() {
        return new SQLiteEventStore(this.wallClockProvider.get(), this.clockProvider.get(), this.configProvider.get(), this.schemaManagerProvider.get());
    }
}
