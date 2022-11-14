package com.google.android.datatransport.runtime.scheduling.persistence;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final class EventStoreModule_SchemaVersionFactory implements Object<Integer> {
    public static final EventStoreModule_SchemaVersionFactory INSTANCE = new EventStoreModule_SchemaVersionFactory();

    public Object get() {
        int i = SchemaManager.SCHEMA_VERSION;
        return 3;
    }
}
