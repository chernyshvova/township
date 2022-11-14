package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import javax.inject.Provider;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final class SchemaManager_Factory implements Object<SchemaManager> {
    public final Provider<Context> contextProvider;
    public final Provider<Integer> schemaVersionProvider;

    public SchemaManager_Factory(Provider<Context> provider, Provider<Integer> provider2) {
        this.contextProvider = provider;
        this.schemaVersionProvider = provider2;
    }

    public Object get() {
        return new SchemaManager(this.contextProvider.get(), this.schemaVersionProvider.get().intValue());
    }
}
