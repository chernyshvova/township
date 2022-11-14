package com.helpshift.logger.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class LogStorageSQLiteHelper extends SQLiteOpenHelper {
    public static final int DB_VERSION = 2;
    public static final String TAG = "LogSQLiteHelper";

    public LogStorageSQLiteHelper(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 2);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS LOG_MESSAGES( TIMESTAMP TEXT, MESSAGE TEXT, LEVEL TEXT, STACKTRACE TEXT, EXTRAS TEXT, SDK_VERSION TEXT  );");
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Exception e) {
            Log.e(TAG, "Error creating log storage: ", e);
        } catch (Throwable th) {
            sQLiteDatabase.endTransaction();
            throw th;
        }
        sQLiteDatabase.endTransaction();
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS LOG_MESSAGES;");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i < 2) {
            sQLiteDatabase.execSQL("ALTER TABLE LOG_MESSAGES ADD COLUMN SDK_VERSION TEXT ;");
        }
    }
}
