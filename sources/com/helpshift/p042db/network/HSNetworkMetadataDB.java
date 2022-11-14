package com.helpshift.p042db.network;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.helpshift.common.domain.network.HSUrlMetadata;
import com.helpshift.p042db.network.tables.UrlMetadataTable;
import com.helpshift.util.DatabaseUtils;
import com.helpshift.util.HSLogger;

/* renamed from: com.helpshift.db.network.HSNetworkMetadataDB */
public class HSNetworkMetadataDB {
    public static final String TAG = "Helpshift_NetworkDB";
    public static HSNetworkMetadataDB mInstance;
    public final HSNetworkDBHelper hsNetworkDbHelper;

    public HSNetworkMetadataDB(Context context) {
        this.hsNetworkDbHelper = new HSNetworkDBHelper(context, new HSNetworkDatabaseContract());
    }

    private HSUrlMetadata cursorToUrlMetadata(Cursor cursor) {
        String string = cursor.getString(cursor.getColumnIndex("url"));
        String string2 = cursor.getString(cursor.getColumnIndex(UrlMetadataTable.Columns.ETAG));
        int columnIndex = cursor.getColumnIndex(UrlMetadataTable.Columns.LAST_FETCH_TS);
        return new HSUrlMetadata(string, string2, cursor.isNull(columnIndex) ? 0 : cursor.getLong(columnIndex), DatabaseUtils.parseBooleanColumnSafe(cursor, UrlMetadataTable.Columns.IS_LAST_FETCH_SUCCESS, false));
    }

    public static synchronized HSNetworkMetadataDB getInstance(Context context) {
        HSNetworkMetadataDB hSNetworkMetadataDB;
        synchronized (HSNetworkMetadataDB.class) {
            if (mInstance == null) {
                mInstance = new HSNetworkMetadataDB(context);
            }
            hSNetworkMetadataDB = mInstance;
        }
        return hSNetworkMetadataDB;
    }

    private ContentValues metadataToContentValues(HSUrlMetadata hSUrlMetadata) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(UrlMetadataTable.Columns.LAST_FETCH_TS, Long.valueOf(hSUrlMetadata.lastFetchTimestamp));
        contentValues.put(UrlMetadataTable.Columns.ETAG, hSUrlMetadata.etag);
        contentValues.put(UrlMetadataTable.Columns.IS_LAST_FETCH_SUCCESS, Integer.valueOf(hSUrlMetadata.isLastFetchSuccessful ? 1 : 0));
        return contentValues;
    }

    private synchronized boolean updateUrlMetadataWithValues(String str, ContentValues contentValues) {
        boolean z;
        int i;
        z = true;
        try {
            i = this.hsNetworkDbHelper.getWritableDatabase().update(UrlMetadataTable.TABLE_NAME, contentValues, "url = ?", new String[]{str});
        } catch (Exception unused) {
            HSLogger.m3241e(TAG, "Error in updating the metadata of url");
            i = 0;
        }
        if (i <= 0) {
            z = false;
        }
        return z;
    }

    public synchronized boolean deleteAllUrlsMetadata() {
        try {
            this.hsNetworkDbHelper.getWritableDatabase().delete(UrlMetadataTable.TABLE_NAME, (String) null, (String[]) null);
        } catch (Exception unused) {
            HSLogger.m3241e(TAG, "Error in deleting urls metadata");
            return false;
        }
        return true;
    }

    public synchronized boolean deleteMetadataForUrl(String str) {
        try {
            this.hsNetworkDbHelper.getWritableDatabase().delete(UrlMetadataTable.TABLE_NAME, "url = ? ", new String[]{str});
        } catch (Exception unused) {
            HSLogger.m3241e(TAG, "Error in deleting metadata for url");
            return false;
        }
        return true;
    }

    public synchronized boolean insertMetadataForUrl(String str, HSUrlMetadata hSUrlMetadata) {
        long j;
        ContentValues metadataToContentValues = metadataToContentValues(hSUrlMetadata);
        metadataToContentValues.put("url", str);
        try {
            j = this.hsNetworkDbHelper.getWritableDatabase().insert(UrlMetadataTable.TABLE_NAME, (String) null, metadataToContentValues);
        } catch (Exception unused) {
            HSLogger.m3241e(TAG, "Error in inserting metadata of url");
            j = -1;
        }
        return j != -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0035, code lost:
        if (r0 != null) goto L_0x0024;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x003d A[SYNTHETIC, Splitter:B:26:0x003d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.helpshift.common.domain.network.HSUrlMetadata readMetadataForUrl(java.lang.String r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            java.lang.String r3 = "url = ? "
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch:{ all -> 0x0041 }
            r0 = 0
            r4[r0] = r10     // Catch:{ all -> 0x0041 }
            r10 = 0
            com.helpshift.db.network.HSNetworkDBHelper r0 = r9.hsNetworkDbHelper     // Catch:{ Exception -> 0x002d, all -> 0x0028 }
            android.database.sqlite.SQLiteDatabase r0 = r0.getReadableDatabase()     // Catch:{ Exception -> 0x002d, all -> 0x0028 }
            java.lang.String r1 = "hs_url_metadata_table"
            r2 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x002d, all -> 0x0028 }
            boolean r1 = r0.moveToFirst()     // Catch:{ Exception -> 0x002e }
            if (r1 == 0) goto L_0x0024
            com.helpshift.common.domain.network.HSUrlMetadata r10 = r9.cursorToUrlMetadata(r0)     // Catch:{ Exception -> 0x002e }
        L_0x0024:
            r0.close()     // Catch:{ all -> 0x0041 }
            goto L_0x0038
        L_0x0028:
            r0 = move-exception
            r8 = r0
            r0 = r10
            r10 = r8
            goto L_0x003b
        L_0x002d:
            r0 = r10
        L_0x002e:
            java.lang.String r1 = "Helpshift_NetworkDB"
            java.lang.String r2 = "error in reading the metadata of url"
            com.helpshift.util.HSLogger.m3241e(r1, r2)     // Catch:{ all -> 0x003a }
            if (r0 == 0) goto L_0x0038
            goto L_0x0024
        L_0x0038:
            monitor-exit(r9)
            return r10
        L_0x003a:
            r10 = move-exception
        L_0x003b:
            if (r0 == 0) goto L_0x0040
            r0.close()     // Catch:{ all -> 0x0041 }
        L_0x0040:
            throw r10     // Catch:{ all -> 0x0041 }
        L_0x0041:
            r10 = move-exception
            monitor-exit(r9)
            goto L_0x0045
        L_0x0044:
            throw r10
        L_0x0045:
            goto L_0x0044
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.p042db.network.HSNetworkMetadataDB.readMetadataForUrl(java.lang.String):com.helpshift.common.domain.network.HSUrlMetadata");
    }

    public synchronized boolean updateLastFetchTimestampForUrl(String str, long j, boolean z) {
        ContentValues contentValues;
        contentValues = new ContentValues();
        contentValues.put(UrlMetadataTable.Columns.LAST_FETCH_TS, Long.valueOf(j));
        contentValues.put(UrlMetadataTable.Columns.IS_LAST_FETCH_SUCCESS, Integer.valueOf(z ? 1 : 0));
        return updateUrlMetadataWithValues(str, contentValues);
    }

    public synchronized boolean updateMetadataForUrl(String str, HSUrlMetadata hSUrlMetadata) {
        return updateUrlMetadataWithValues(str, metadataToContentValues(hSUrlMetadata));
    }
}
