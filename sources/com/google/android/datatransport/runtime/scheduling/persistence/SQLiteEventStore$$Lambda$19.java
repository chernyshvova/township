package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final /* synthetic */ class SQLiteEventStore$$Lambda$19 implements SQLiteEventStore.Function {
    public static final SQLiteEventStore$$Lambda$19 instance = new SQLiteEventStore$$Lambda$19();

    public Object apply(Object obj) {
        return SQLiteEventStore.lambda$loadActiveContexts$8((Cursor) obj);
    }
}
