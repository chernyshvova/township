package com.helpshift.p042db.base;

import android.database.sqlite.SQLiteDatabase;

/* renamed from: com.helpshift.db.base.DropAndCreateDatabaseMigrator */
public class DropAndCreateDatabaseMigrator implements IMigrator {
    public DatabaseContract contract;

    public DropAndCreateDatabaseMigrator(DatabaseContract databaseContract) {
        this.contract = databaseContract;
    }

    private void createAllTables(SQLiteDatabase sQLiteDatabase) {
        for (String execSQL : this.contract.getCreateTableQueries()) {
            sQLiteDatabase.execSQL(execSQL);
        }
    }

    private void dropAllTables(SQLiteDatabase sQLiteDatabase) {
        for (String str : this.contract.getTableNames()) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
        }
    }

    public void migrate(SQLiteDatabase sQLiteDatabase) {
        dropAllTables(sQLiteDatabase);
        createAllTables(sQLiteDatabase);
    }
}
