package com.helpshift.logger.database;

import android.content.Context;
import android.util.Log;

public class LogSQLiteStorage implements LogStorage {
    public static final int MAX_ROWS = 100;
    public static final String TAG = "LogSqliteStorage";
    public static final Object syncLock = new Object();
    public LogStorageSQLiteHelper logStorageSQLiteHelper;

    public LogSQLiteStorage(Context context, String str) {
        this.logStorageSQLiteHelper = new LogStorageSQLiteHelper(context, str);
    }

    public void deleteAll() {
        synchronized (syncLock) {
            try {
                this.logStorageSQLiteHelper.getWritableDatabase().execSQL("DELETE FROM LOG_MESSAGES");
            } catch (Exception e) {
                Log.e(TAG, "Error deleting all logs from db", e);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002a, code lost:
        if (r2 != null) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0014, code lost:
        if (r2 != null) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0032 A[Catch:{ all -> 0x002f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.helpshift.logger.model.LogModel> getAll() {
        /*
            r7 = this;
            java.lang.Object r0 = syncLock
            monitor-enter(r0)
            r1 = 0
            com.helpshift.logger.database.LogStorageSQLiteHelper r2 = r7.logStorageSQLiteHelper     // Catch:{ Exception -> 0x0021, all -> 0x001c }
            android.database.sqlite.SQLiteDatabase r2 = r2.getReadableDatabase()     // Catch:{ Exception -> 0x0021, all -> 0x001c }
            java.lang.String r3 = "SELECT * FROM LOG_MESSAGES"
            android.database.Cursor r2 = r2.rawQuery(r3, r1)     // Catch:{ Exception -> 0x0021, all -> 0x001c }
            java.util.List r1 = com.helpshift.logger.adapters.LogStorageModelAdapter.fromCursor(r2)     // Catch:{ Exception -> 0x001a }
            if (r2 == 0) goto L_0x002d
        L_0x0016:
            r2.close()     // Catch:{ all -> 0x0036 }
            goto L_0x002d
        L_0x001a:
            r3 = move-exception
            goto L_0x0023
        L_0x001c:
            r2 = move-exception
            r6 = r2
            r2 = r1
            r1 = r6
            goto L_0x0030
        L_0x0021:
            r3 = move-exception
            r2 = r1
        L_0x0023:
            java.lang.String r4 = "LogSqliteStorage"
            java.lang.String r5 = "Error getting all log messages : "
            android.util.Log.e(r4, r5, r3)     // Catch:{ all -> 0x002f }
            if (r2 == 0) goto L_0x002d
            goto L_0x0016
        L_0x002d:
            monitor-exit(r0)     // Catch:{ all -> 0x0036 }
            return r1
        L_0x002f:
            r1 = move-exception
        L_0x0030:
            if (r2 == 0) goto L_0x0035
            r2.close()     // Catch:{ all -> 0x0036 }
        L_0x0035:
            throw r1     // Catch:{ all -> 0x0036 }
        L_0x0036:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0036 }
            goto L_0x003a
        L_0x0039:
            throw r1
        L_0x003a:
            goto L_0x0039
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.logger.database.LogSQLiteStorage.getAll():java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0071, code lost:
        if (r3 == null) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0077, code lost:
        r10 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0079, code lost:
        r10 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007b, code lost:
        r10 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x007c, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x007d, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x007f, code lost:
        r10 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0080, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0081, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0077 A[ExcHandler: all (th java.lang.Throwable), PHI: r3 
      PHI: (r3v10 android.database.Cursor) = (r3v12 android.database.Cursor), (r3v14 android.database.Cursor) binds: [B:19:0x003c, B:11:0x0015] A[DONT_GENERATE, DONT_INLINE], Splitter:B:11:0x0015] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007b A[ExcHandler: all (th java.lang.Throwable), Splitter:B:5:0x000a] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0091 A[SYNTHETIC, Splitter:B:46:0x0091] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x009f A[Catch:{ Exception -> 0x0069 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a5 A[SYNTHETIC, Splitter:B:58:0x00a5] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00b5 A[Catch:{ Exception -> 0x0069 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void insert(com.helpshift.logger.model.LogModel r10) {
        /*
            r9 = this;
            java.lang.Object r0 = syncLock
            monitor-enter(r0)
            r1 = 0
            com.helpshift.logger.database.LogStorageSQLiteHelper r2 = r9.logStorageSQLiteHelper     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
            android.database.sqlite.SQLiteDatabase r2 = r2.getWritableDatabase()     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
            r2.beginTransaction()     // Catch:{ Exception -> 0x007f, all -> 0x007b }
            java.lang.String r3 = "SELECT rowid FROM LOG_MESSAGES"
            android.database.Cursor r3 = r2.rawQuery(r3, r1)     // Catch:{ Exception -> 0x0038, all -> 0x007b }
            if (r3 == 0) goto L_0x0059
            int r4 = r3.getCount()     // Catch:{ Exception -> 0x0036, all -> 0x0077 }
            r5 = 100
            if (r4 < r5) goto L_0x0059
            r3.moveToFirst()     // Catch:{ Exception -> 0x0036, all -> 0x0077 }
            r4 = 0
            int r5 = r3.getInt(r4)     // Catch:{ Exception -> 0x0036, all -> 0x0077 }
            java.lang.String r6 = "LOG_MESSAGES"
            java.lang.String r7 = "rowid = ?"
            r8 = 1
            java.lang.String[] r8 = new java.lang.String[r8]     // Catch:{ Exception -> 0x0036, all -> 0x0077 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x0036, all -> 0x0077 }
            r8[r4] = r5     // Catch:{ Exception -> 0x0036, all -> 0x0077 }
            r2.delete(r6, r7, r8)     // Catch:{ Exception -> 0x0036, all -> 0x0077 }
            goto L_0x0059
        L_0x0036:
            r4 = move-exception
            goto L_0x003a
        L_0x0038:
            r4 = move-exception
            r3 = r1
        L_0x003a:
            java.lang.String r5 = "LogSqliteStorage"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            r6.<init>()     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            java.lang.String r7 = "Error in rotation of logs + "
            r6.append(r7)     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            java.lang.String r4 = r4.getMessage()     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            r6.append(r4)     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            java.lang.String r4 = r6.toString()     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            android.util.Log.w(r5, r4)     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            java.lang.String r4 = "LOG_MESSAGES"
            r2.delete(r4, r1, r1)     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
        L_0x0059:
            java.lang.String r4 = "LOG_MESSAGES"
            android.content.ContentValues r10 = com.helpshift.logger.adapters.LogStorageModelAdapter.toContentValues(r10)     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            r2.insert(r4, r1, r10)     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            r2.setTransactionSuccessful()     // Catch:{ Exception -> 0x0079, all -> 0x0077 }
            r2.endTransaction()     // Catch:{ Exception -> 0x0069 }
            goto L_0x0071
        L_0x0069:
            r10 = move-exception
            java.lang.String r1 = "LogSqliteStorage"
            java.lang.String r2 = "Error inserting log inside finally block: "
            android.util.Log.e(r1, r2, r10)     // Catch:{ all -> 0x00a9 }
        L_0x0071:
            if (r3 == 0) goto L_0x00a0
        L_0x0073:
            r3.close()     // Catch:{ all -> 0x00a9 }
            goto L_0x00a0
        L_0x0077:
            r10 = move-exception
            goto L_0x007d
        L_0x0079:
            r10 = move-exception
            goto L_0x0081
        L_0x007b:
            r10 = move-exception
            r3 = r1
        L_0x007d:
            r1 = r2
            goto L_0x00a3
        L_0x007f:
            r10 = move-exception
            r3 = r1
        L_0x0081:
            r1 = r2
            goto L_0x0088
        L_0x0083:
            r10 = move-exception
            r3 = r1
            goto L_0x00a3
        L_0x0086:
            r10 = move-exception
            r3 = r1
        L_0x0088:
            java.lang.String r2 = "LogSqliteStorage"
            java.lang.String r4 = "Error inserting log : "
            android.util.Log.e(r2, r4, r10)     // Catch:{ all -> 0x00a2 }
            if (r1 == 0) goto L_0x009d
            r1.endTransaction()     // Catch:{ Exception -> 0x0095 }
            goto L_0x009d
        L_0x0095:
            r10 = move-exception
            java.lang.String r1 = "LogSqliteStorage"
            java.lang.String r2 = "Error inserting log inside finally block: "
            android.util.Log.e(r1, r2, r10)     // Catch:{ all -> 0x00a9 }
        L_0x009d:
            if (r3 == 0) goto L_0x00a0
            goto L_0x0073
        L_0x00a0:
            monitor-exit(r0)     // Catch:{ all -> 0x00a9 }
            return
        L_0x00a2:
            r10 = move-exception
        L_0x00a3:
            if (r1 == 0) goto L_0x00b3
            r1.endTransaction()     // Catch:{ Exception -> 0x00ab }
            goto L_0x00b3
        L_0x00a9:
            r10 = move-exception
            goto L_0x00b9
        L_0x00ab:
            r1 = move-exception
            java.lang.String r2 = "LogSqliteStorage"
            java.lang.String r4 = "Error inserting log inside finally block: "
            android.util.Log.e(r2, r4, r1)     // Catch:{ all -> 0x00a9 }
        L_0x00b3:
            if (r3 == 0) goto L_0x00b8
            r3.close()     // Catch:{ all -> 0x00a9 }
        L_0x00b8:
            throw r10     // Catch:{ all -> 0x00a9 }
        L_0x00b9:
            monitor-exit(r0)     // Catch:{ all -> 0x00a9 }
            goto L_0x00bc
        L_0x00bb:
            throw r10
        L_0x00bc:
            goto L_0x00bb
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.logger.database.LogSQLiteStorage.insert(com.helpshift.logger.model.LogModel):void");
    }
}
