package com.helpshift.p042db.base;

import android.database.sqlite.SQLiteDatabase;

/* renamed from: com.helpshift.db.base.IMigrator */
public interface IMigrator {
    void migrate(SQLiteDatabase sQLiteDatabase) throws Exception;
}
