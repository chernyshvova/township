package com.helpshift.storage;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import com.helpshift.p042db.key_value.KeyValueDatabaseContract;
import com.helpshift.p042db.key_value.KeyValueDbStorageHelper;
import com.helpshift.util.HSLogger;

public class RetryKeyValueDbStorage extends BaseRetryKeyValueStorage {
    public static final String backupFileName = "__hs__kv_backup";
    public final Context context;
    public SQLiteOpenHelper sqLiteOpenHelper;

    public RetryKeyValueDbStorage(Context context2) {
        this.context = context2;
        KeyValueDbStorageHelper keyValueDbStorageHelper = new KeyValueDbStorageHelper(context2, new KeyValueDatabaseContract());
        this.sqLiteOpenHelper = keyValueDbStorageHelper;
        this.keyValueStorage = new KeyValueDbStorage(keyValueDbStorageHelper);
    }

    public void reInitiateDbInstance() {
        try {
            if (this.sqLiteOpenHelper != null) {
                this.sqLiteOpenHelper.close();
            }
        } catch (Exception e) {
            HSLogger.m3242e(BaseRetryKeyValueStorage.TAG, "Error in closing DB", e);
        }
        KeyValueDbStorageHelper keyValueDbStorageHelper = new KeyValueDbStorageHelper(this.context, new KeyValueDatabaseContract());
        this.sqLiteOpenHelper = keyValueDbStorageHelper;
        this.keyValueStorage = new KeyValueDbStorage(keyValueDbStorageHelper);
    }
}
