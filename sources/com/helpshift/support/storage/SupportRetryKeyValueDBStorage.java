package com.helpshift.support.storage;

import android.content.Context;
import com.helpshift.storage.BaseRetryKeyValueStorage;
import com.helpshift.storage.KeyValueDbStorage;
import com.helpshift.support.p043db.support_key_value.SupportKeyValueDatabaseContract;
import com.helpshift.support.p043db.support_key_value.SupportKeyValueDbStorageHelper;
import com.helpshift.util.HSLogger;

public class SupportRetryKeyValueDBStorage extends BaseRetryKeyValueStorage {
    public final Context context;
    public SupportKeyValueDbStorageHelper sqLiteOpenHelper;

    public SupportRetryKeyValueDBStorage(Context context2) {
        this.context = context2;
        SupportKeyValueDbStorageHelper supportKeyValueDbStorageHelper = new SupportKeyValueDbStorageHelper(context2, new SupportKeyValueDatabaseContract());
        this.sqLiteOpenHelper = supportKeyValueDbStorageHelper;
        this.keyValueStorage = new KeyValueDbStorage(supportKeyValueDbStorageHelper);
    }

    public void reInitiateDbInstance() {
        try {
            if (this.sqLiteOpenHelper != null) {
                this.sqLiteOpenHelper.close();
            }
        } catch (Exception e) {
            HSLogger.m3242e(BaseRetryKeyValueStorage.TAG, "Error in closing DB", e);
        }
        SupportKeyValueDbStorageHelper supportKeyValueDbStorageHelper = new SupportKeyValueDbStorageHelper(this.context, new SupportKeyValueDatabaseContract());
        this.sqLiteOpenHelper = supportKeyValueDbStorageHelper;
        this.keyValueStorage = new KeyValueDbStorage(supportKeyValueDbStorageHelper);
    }
}
