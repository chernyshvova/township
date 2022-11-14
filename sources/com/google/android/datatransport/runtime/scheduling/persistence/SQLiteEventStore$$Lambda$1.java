package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final /* synthetic */ class SQLiteEventStore$$Lambda$1 implements SQLiteEventStore.Producer {
    public final SchemaManager arg$1;

    public SQLiteEventStore$$Lambda$1(SchemaManager schemaManager) {
        this.arg$1 = schemaManager;
    }

    public Object produce() {
        return this.arg$1.getWritableDatabase();
    }
}
