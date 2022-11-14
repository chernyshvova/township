package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public final /* synthetic */ class SchemaManager$$Lambda$1 implements SchemaManager.Migration {
    public static final SchemaManager$$Lambda$1 instance = new SchemaManager$$Lambda$1();

    public void upgrade(SQLiteDatabase sQLiteDatabase) {
        SchemaManager.lambda$static$0(sQLiteDatabase);
    }
}
