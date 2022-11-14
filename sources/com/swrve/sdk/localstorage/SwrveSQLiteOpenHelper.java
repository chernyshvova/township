package com.swrve.sdk.localstorage;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.VisibleForTesting;
import com.swrve.sdk.ISwrveCommon;
import com.swrve.sdk.SwrveHelper;
import com.swrve.sdk.SwrveSDKBase;

public final class SwrveSQLiteOpenHelper extends SQLiteOpenHelper {
    public static final String CACHE_COLUMN_CATEGORY = "category";
    public static final String CACHE_COLUMN_RAW_DATA = "raw_data";
    public static final String CACHE_COLUMN_USER_ID = "user_id";
    public static final String CACHE_TABLE_NAME = "cache";
    public static final String EVENTS_COLUMN_EVENT = "event";
    public static final String EVENTS_COLUMN_ID = "_id";
    public static final String EVENTS_COLUMN_USER_ID = "user_id";
    public static final String EVENTS_TABLE_NAME = "events";
    public static final String NOTIFICATIONS_AUTHENTICATED_COLUMN_ID = "notification_id";
    public static final String NOTIFICATIONS_AUTHENTICATED_COLUMN_TIME = "time";
    public static final String NOTIFICATIONS_AUTHENTICATED_TABLE_NAME = "notifications_authenticated";
    public static final String OFFLINE_CAMPAIGNS_COLUMN_CAMPAIGN_ID = "campaign_id";
    public static final String OFFLINE_CAMPAIGNS_COLUMN_JSON = "campaign_json";
    public static final String OFFLINE_CAMPAIGNS_COLUMN_SWRVE_USER_ID = "user_id";
    public static final String OFFLINE_CAMPAIGNS_TABLE_NAME = "offline_campaigns";
    public static final Object OPEN_HELPER_LOCK = new Object();
    public static final int SWRVE_DB_VERSION = 4;
    public static final String USER_COLUMN_EXTERNAL_USER_ID = "external_user_id";
    public static final String USER_COLUMN_SWRVE_USER_ID = "swrve_user_id";
    public static final String USER_COLUMN_VERFIED = "verified";
    public static final String USER_TABLE_NAME = "users";
    public static SwrveSQLiteOpenHelper instance;
    public Context context;

    public SwrveSQLiteOpenHelper(Context context2, String str, int i) {
        super(context2, str, (SQLiteDatabase.CursorFactory) null, i);
        this.context = context2;
    }

    @VisibleForTesting
    public static void closeInstance() {
        synchronized (OPEN_HELPER_LOCK) {
            if (instance != null) {
                instance.close();
                instance = null;
            }
        }
    }

    public static SwrveSQLiteOpenHelper getInstance(Context context2, String str, int i) {
        SwrveSQLiteOpenHelper swrveSQLiteOpenHelper;
        synchronized (OPEN_HELPER_LOCK) {
            if (instance == null) {
                instance = new SwrveSQLiteOpenHelper(context2, str, i);
            }
            swrveSQLiteOpenHelper = instance;
        }
        return swrveSQLiteOpenHelper;
    }

    public synchronized void close() {
        synchronized (OPEN_HELPER_LOCK) {
            super.close();
            instance = null;
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY AUTOINCREMENT, user_id TEXT NOT NULL, event TEXT NOT NULL);");
        sQLiteDatabase.execSQL("CREATE TABLE cache (user_id TEXT NOT NULL, category TEXT NOT NULL, raw_data TEXT NOT NULL, PRIMARY KEY (user_id,category));");
        sQLiteDatabase.execSQL("CREATE TABLE users (swrve_user_id TEXT NOT NULL, external_user_id TEXT NOT NULL,verified BOOL NOT NULL,PRIMARY KEY (swrve_user_id,external_user_id));");
        sQLiteDatabase.execSQL("CREATE TABLE notifications_authenticated (notification_id INTEGER NOT NULL, time INTEGER NOT NULL, PRIMARY KEY (notification_id));");
        sQLiteDatabase.execSQL("CREATE INDEX notifications_authenticated_time_idx ON notifications_authenticated(time);");
        sQLiteDatabase.execSQL("CREATE TABLE offline_campaigns (user_id TEXT NOT NULL, campaign_id TEXT NOT NULL,campaign_json TEXT NOT NULL,PRIMARY KEY (user_id,campaign_id));");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        String userId = SwrveSDKBase.getUserId();
        if (i == 1) {
            sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN user_id TEXT");
            if (SwrveHelper.isNotNullOrEmpty(userId)) {
                sQLiteDatabase.execSQL("UPDATE events SET user_id='" + userId + "' WHERE user_id IS NULL OR user_id = ''");
            } else {
                sQLiteDatabase.execSQL("DELETE FROM events");
            }
            sQLiteDatabase.execSQL("ALTER TABLE server_cache RENAME TO cache");
            if (SwrveHelper.isNotNullOrEmpty(userId)) {
                sQLiteDatabase.execSQL("UPDATE cache SET user_id='" + userId + "' WHERE user_id='SwrveSDK.installTime'");
                sQLiteDatabase.execSQL("UPDATE cache SET user_id='" + userId + "' WHERE user_id='seqnum'");
                sQLiteDatabase.execSQL("UPDATE cache SET user_id='" + userId + "' WHERE user_id='RegistrationId'");
                sQLiteDatabase.execSQL("UPDATE cache SET user_id='" + userId + "' WHERE user_id='AppVersion'");
                sQLiteDatabase.execSQL("UPDATE cache SET user_id='" + userId + "' WHERE user_id='GoogleAdvertisingId'");
                sQLiteDatabase.execSQL("UPDATE cache SET user_id='" + userId + "' WHERE user_id='GoogleAdvertisingLimitAdTrackingEnabled'");
            }
            sQLiteDatabase.execSQL("UPDATE cache SET user_id='' WHERE user_id='device_id'");
        } else if (i != 2) {
            if (i != 3) {
                return;
            }
            sQLiteDatabase.execSQL("CREATE TABLE offline_campaigns (swrve_user_id TEXT NOT NULL, campaign_id TEXT NOT NULL, campaign_json_data TEXT NOT NULL, PRIMARY KEY (swrve_user_id, campaign_id));");
        }
        sQLiteDatabase.execSQL("CREATE TABLE users (swrve_user_id TEXT NOT NULL, external_user_id TEXT NOT NULL, verified BOOL NOT NULL, PRIMARY KEY (swrve_user_id, external_user_id));");
        sQLiteDatabase.execSQL("CREATE TABLE notifications_authenticated (notification_id INTEGER NOT NULL, time INTEGER NOT NULL, PRIMARY KEY (notification_id))");
        sQLiteDatabase.execSQL("CREATE INDEX notifications_authenticated_time_idx ON notifications_authenticated(time)");
        SharedPreferences sharedPreferences = this.context.getSharedPreferences(ISwrveCommon.SDK_PREFS_NAME, 0);
        String string = sharedPreferences.getString("campaigns_and_resources_etag", "");
        if (SwrveHelper.isNotNullOrEmpty(userId)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("user_id", userId);
            contentValues.put("category", ISwrveCommon.CACHE_ETAG);
            contentValues.put(CACHE_COLUMN_RAW_DATA, string);
            sQLiteDatabase.insertOrThrow(CACHE_TABLE_NAME, (String) null, contentValues);
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.remove("campaigns_and_resources_etag");
        edit.apply();
        if (SwrveHelper.isNotNullOrEmpty(userId)) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM cache WHERE category='SwrveSDK.installTime'", (String[]) null);
            rawQuery.moveToFirst();
            if (!rawQuery.isAfterLast()) {
                String string2 = rawQuery.getString(rawQuery.getColumnIndex(CACHE_COLUMN_RAW_DATA));
                if (SwrveHelper.isNotNullOrEmpty(string2)) {
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("user_id", userId);
                    contentValues2.put("category", ISwrveCommon.CACHE_USER_JOINED_TIME);
                    contentValues2.put(CACHE_COLUMN_RAW_DATA, string2);
                    sQLiteDatabase.insertOrThrow(CACHE_TABLE_NAME, (String) null, contentValues2);
                }
            }
        }
        sQLiteDatabase.execSQL("DELETE FROM cache WHERE user_id='' AND category='SwrveSDK.installTime'");
        sQLiteDatabase.execSQL("CREATE TABLE offline_campaigns (swrve_user_id TEXT NOT NULL, campaign_id TEXT NOT NULL, campaign_json_data TEXT NOT NULL, PRIMARY KEY (swrve_user_id, campaign_id));");
    }
}
