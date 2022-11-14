package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final /* synthetic */ class SQLiteEventStore$$Lambda$17 implements SQLiteEventStore.Producer {
    public final SQLiteDatabase arg$1;

    public SQLiteEventStore$$Lambda$17(SQLiteDatabase sQLiteDatabase) {
        this.arg$1 = sQLiteDatabase;
    }

    public Object produce() {
        Object unused = this.arg$1.beginTransaction();
        return null;
    }
}
