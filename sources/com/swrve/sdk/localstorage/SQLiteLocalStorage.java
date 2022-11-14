package com.swrve.sdk.localstorage;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import com.swrve.sdk.SwrveHelper;
import com.swrve.sdk.SwrveLogger;
import com.swrve.sdk.SwrveUser;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class SQLiteLocalStorage implements LocalStorage {
    public SQLiteDatabase database;

    public SQLiteLocalStorage(Context context, String str, long j) {
        SQLiteDatabase writableDatabase = SwrveSQLiteOpenHelper.getInstance(context, str, 4).getWritableDatabase();
        this.database = writableDatabase;
        writableDatabase.setMaximumSize(j);
    }

    private void insertOrUpdate(String str, ContentValues contentValues, String str2, String[] strArr) {
        if (this.database.isOpen() && this.database.update(str, contentValues, str2, strArr) == 0) {
            this.database.insertOrThrow(str, (String) null, contentValues);
        }
    }

    public long addEvent(String str, String str2) throws SQLException {
        if (!this.database.isOpen()) {
            return 0;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("user_id", str);
        contentValues.put("event", str2);
        return this.database.insertOrThrow("events", (String) null, contentValues);
    }

    public void deleteNotificationsAuthenticated() {
        try {
            if (this.database.isOpen()) {
                this.database.delete(SwrveSQLiteOpenHelper.NOTIFICATIONS_AUTHENTICATED_TABLE_NAME, (String) null, (String[]) null);
            }
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception deleting current notifications.", e, new Object[0]);
        }
    }

    public synchronized void deleteUser(String str) {
        try {
            if (this.database.isOpen()) {
                this.database.delete(SwrveSQLiteOpenHelper.USER_TABLE_NAME, "swrve_user_id= ?", new String[]{str});
            }
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception deleting user for userId: %s", e, str);
        }
        return;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.swrve.sdk.localstorage.SwrveCacheItem} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x008a, code lost:
        if (r2 != null) goto L_0x0062;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0091  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.swrve.sdk.localstorage.SwrveCacheItem getCacheItem(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            r0 = 0
            r1 = 0
            if (r13 == 0) goto L_0x0095
            if (r14 != 0) goto L_0x0008
            goto L_0x0095
        L_0x0008:
            android.database.sqlite.SQLiteDatabase r2 = r12.database
            boolean r2 = r2.isOpen()
            if (r2 == 0) goto L_0x00a2
            android.database.sqlite.SQLiteDatabase r3 = r12.database     // Catch:{ Exception -> 0x006a, all -> 0x0068 }
            java.lang.String r4 = "cache"
            java.lang.String r2 = "raw_data"
            java.lang.String[] r5 = new java.lang.String[]{r2}     // Catch:{ Exception -> 0x006a, all -> 0x0068 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x006a, all -> 0x0068 }
            r2.<init>()     // Catch:{ Exception -> 0x006a, all -> 0x0068 }
            java.lang.String r6 = "user_id= \""
            r2.append(r6)     // Catch:{ Exception -> 0x006a, all -> 0x0068 }
            r2.append(r13)     // Catch:{ Exception -> 0x006a, all -> 0x0068 }
            java.lang.String r6 = "\" AND "
            r2.append(r6)     // Catch:{ Exception -> 0x006a, all -> 0x0068 }
            java.lang.String r6 = "category"
            r2.append(r6)     // Catch:{ Exception -> 0x006a, all -> 0x0068 }
            java.lang.String r6 = "= \""
            r2.append(r6)     // Catch:{ Exception -> 0x006a, all -> 0x0068 }
            r2.append(r14)     // Catch:{ Exception -> 0x006a, all -> 0x0068 }
            java.lang.String r6 = "\""
            r2.append(r6)     // Catch:{ Exception -> 0x006a, all -> 0x0068 }
            java.lang.String r6 = r2.toString()     // Catch:{ Exception -> 0x006a, all -> 0x0068 }
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            java.lang.String r11 = "1"
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x006a, all -> 0x0068 }
            r2.moveToFirst()     // Catch:{ Exception -> 0x0066 }
            boolean r3 = r2.isAfterLast()     // Catch:{ Exception -> 0x0066 }
            if (r3 != 0) goto L_0x0062
            java.lang.String r3 = r2.getString(r1)     // Catch:{ Exception -> 0x0066 }
            r2.moveToNext()     // Catch:{ Exception -> 0x0066 }
            com.swrve.sdk.localstorage.SwrveCacheItem r4 = new com.swrve.sdk.localstorage.SwrveCacheItem     // Catch:{ Exception -> 0x0066 }
            r4.<init>(r13, r14, r3)     // Catch:{ Exception -> 0x0066 }
            r0 = r4
        L_0x0062:
            r2.close()
            goto L_0x00a2
        L_0x0066:
            r3 = move-exception
            goto L_0x006c
        L_0x0068:
            r13 = move-exception
            goto L_0x008f
        L_0x006a:
            r3 = move-exception
            r2 = r0
        L_0x006c:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x008d }
            r4.<init>()     // Catch:{ all -> 0x008d }
            java.lang.String r5 = "Exception occurred getting cache userId:"
            r4.append(r5)     // Catch:{ all -> 0x008d }
            r4.append(r13)     // Catch:{ all -> 0x008d }
            java.lang.String r13 = " category:"
            r4.append(r13)     // Catch:{ all -> 0x008d }
            r4.append(r14)     // Catch:{ all -> 0x008d }
            java.lang.String r13 = r4.toString()     // Catch:{ all -> 0x008d }
            java.lang.Object[] r14 = new java.lang.Object[r1]     // Catch:{ all -> 0x008d }
            com.swrve.sdk.SwrveLogger.m2753e(r13, r3, r14)     // Catch:{ all -> 0x008d }
            if (r2 == 0) goto L_0x00a2
            goto L_0x0062
        L_0x008d:
            r13 = move-exception
            r0 = r2
        L_0x008f:
            if (r0 == 0) goto L_0x0094
            r0.close()
        L_0x0094:
            throw r13
        L_0x0095:
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r1] = r13
            r13 = 1
            r2[r13] = r14
            java.lang.String r13 = "Cannot use null value in getCacheItem. userId:%s category:%s rawData:%s."
            com.swrve.sdk.SwrveLogger.m2754e(r13, r2)
        L_0x00a2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swrve.sdk.localstorage.SQLiteLocalStorage.getCacheItem(java.lang.String, java.lang.String):com.swrve.sdk.localstorage.SwrveCacheItem");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v2, resolved type: java.lang.String} */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0081, code lost:
        if (r3 == null) goto L_0x008d;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.LinkedHashMap<java.lang.Long, java.lang.String> getFirstNEvents(java.lang.Integer r14, java.lang.String r15) {
        /*
            r13 = this;
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            r1 = 1
            r2 = 0
            if (r15 != 0) goto L_0x0014
            java.lang.Object[] r14 = new java.lang.Object[r1]
            r14[r2] = r15
            java.lang.String r15 = "Cannot use null value userId for getFirstNEvents. userId:%s."
            com.swrve.sdk.SwrveLogger.m2754e(r15, r14)
            goto L_0x008d
        L_0x0014:
            android.database.sqlite.SQLiteDatabase r3 = r13.database
            boolean r3 = r3.isOpen()
            if (r3 == 0) goto L_0x008d
            r3 = 0
            java.lang.String r5 = "events"
            java.lang.String r4 = "_id"
            java.lang.String r6 = "event"
            java.lang.String[] r6 = new java.lang.String[]{r4, r6}     // Catch:{ Exception -> 0x0062 }
            java.lang.String r7 = "user_id = ?"
            java.lang.String[] r8 = new java.lang.String[r1]     // Catch:{ Exception -> 0x0062 }
            r8[r2] = r15     // Catch:{ Exception -> 0x0062 }
            r9 = 0
            r10 = 0
            if (r14 != 0) goto L_0x0033
            r12 = r3
            goto L_0x003c
        L_0x0033:
            int r4 = r14.intValue()     // Catch:{ Exception -> 0x0062 }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ Exception -> 0x0062 }
            r12 = r4
        L_0x003c:
            android.database.sqlite.SQLiteDatabase r4 = r13.database     // Catch:{ Exception -> 0x0062 }
            java.lang.String r11 = "_id"
            android.database.Cursor r3 = r4.query(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x0062 }
            r3.moveToFirst()     // Catch:{ Exception -> 0x0062 }
        L_0x0047:
            boolean r4 = r3.isAfterLast()     // Catch:{ Exception -> 0x0062 }
            if (r4 != 0) goto L_0x0083
            long r4 = r3.getLong(r2)     // Catch:{ Exception -> 0x0062 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ Exception -> 0x0062 }
            java.lang.String r5 = r3.getString(r1)     // Catch:{ Exception -> 0x0062 }
            r0.put(r4, r5)     // Catch:{ Exception -> 0x0062 }
            r3.moveToNext()     // Catch:{ Exception -> 0x0062 }
            goto L_0x0047
        L_0x0060:
            r14 = move-exception
            goto L_0x0087
        L_0x0062:
            r1 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0060 }
            r4.<init>()     // Catch:{ all -> 0x0060 }
            java.lang.String r5 = "Error getting "
            r4.append(r5)     // Catch:{ all -> 0x0060 }
            r4.append(r14)     // Catch:{ all -> 0x0060 }
            java.lang.String r14 = " events for user:"
            r4.append(r14)     // Catch:{ all -> 0x0060 }
            r4.append(r15)     // Catch:{ all -> 0x0060 }
            java.lang.String r14 = r4.toString()     // Catch:{ all -> 0x0060 }
            java.lang.Object[] r15 = new java.lang.Object[r2]     // Catch:{ all -> 0x0060 }
            com.swrve.sdk.SwrveLogger.m2753e(r14, r1, r15)     // Catch:{ all -> 0x0060 }
            if (r3 == 0) goto L_0x008d
        L_0x0083:
            r3.close()
            goto L_0x008d
        L_0x0087:
            if (r3 == 0) goto L_0x008c
            r3.close()
        L_0x008c:
            throw r14
        L_0x008d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swrve.sdk.localstorage.SQLiteLocalStorage.getFirstNEvents(java.lang.Integer, java.lang.String):java.util.LinkedHashMap");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0046, code lost:
        if (r1 == null) goto L_0x0052;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<java.lang.Integer> getNotificationsAuthenticated() {
        /*
            r12 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r12.database
            boolean r1 = r1.isOpen()
            if (r1 == 0) goto L_0x0052
            r1 = 0
            r2 = 0
            java.lang.String r4 = "notifications_authenticated"
            java.lang.String r3 = "notification_id"
            java.lang.String[] r5 = new java.lang.String[]{r3}     // Catch:{ Exception -> 0x003e }
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.sqlite.SQLiteDatabase r3 = r12.database     // Catch:{ Exception -> 0x003e }
            java.lang.String r10 = "notification_id"
            r11 = 0
            android.database.Cursor r1 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x003e }
            r1.moveToFirst()     // Catch:{ Exception -> 0x003e }
        L_0x0027:
            boolean r3 = r1.isAfterLast()     // Catch:{ Exception -> 0x003e }
            if (r3 != 0) goto L_0x0048
            int r3 = r1.getInt(r2)     // Catch:{ Exception -> 0x003e }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x003e }
            r0.add(r3)     // Catch:{ Exception -> 0x003e }
            r1.moveToNext()     // Catch:{ Exception -> 0x003e }
            goto L_0x0027
        L_0x003c:
            r0 = move-exception
            goto L_0x004c
        L_0x003e:
            r3 = move-exception
            java.lang.String r4 = "Error getting notifications from db"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x003c }
            com.swrve.sdk.SwrveLogger.m2753e(r4, r3, r2)     // Catch:{ all -> 0x003c }
            if (r1 == 0) goto L_0x0052
        L_0x0048:
            r1.close()
            goto L_0x0052
        L_0x004c:
            if (r1 == 0) goto L_0x0051
            r1.close()
        L_0x0051:
            throw r0
        L_0x0052:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swrve.sdk.localstorage.SQLiteLocalStorage.getNotificationsAuthenticated():java.util.List");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0085  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getOfflineCampaign(java.lang.String r8, java.lang.String r9) {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
            if (r8 == 0) goto L_0x0089
            if (r9 != 0) goto L_0x0008
            goto L_0x0089
        L_0x0008:
            android.database.sqlite.SQLiteDatabase r2 = r7.database
            boolean r2 = r2.isOpen()
            if (r2 == 0) goto L_0x0096
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x005c }
            r2.<init>()     // Catch:{ Exception -> 0x005c }
            java.lang.String r3 = "SELECT campaign_json FROM offline_campaigns WHERE user_id = '"
            r2.append(r3)     // Catch:{ Exception -> 0x005c }
            r2.append(r8)     // Catch:{ Exception -> 0x005c }
            java.lang.String r3 = "' AND "
            r2.append(r3)     // Catch:{ Exception -> 0x005c }
            java.lang.String r3 = "campaign_id"
            r2.append(r3)     // Catch:{ Exception -> 0x005c }
            java.lang.String r3 = " = '"
            r2.append(r3)     // Catch:{ Exception -> 0x005c }
            r2.append(r9)     // Catch:{ Exception -> 0x005c }
            java.lang.String r3 = "' "
            r2.append(r3)     // Catch:{ Exception -> 0x005c }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x005c }
            android.database.sqlite.SQLiteDatabase r3 = r7.database     // Catch:{ Exception -> 0x005c }
            android.database.Cursor r2 = r3.rawQuery(r2, r1)     // Catch:{ Exception -> 0x005c }
            r2.moveToFirst()     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
            boolean r3 = r2.isAfterLast()     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
            if (r3 != 0) goto L_0x004e
            java.lang.String r1 = r2.getString(r0)     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
            r2.moveToNext()     // Catch:{ Exception -> 0x0055, all -> 0x0052 }
        L_0x004e:
            r2.close()
            goto L_0x0096
        L_0x0052:
            r8 = move-exception
            r1 = r2
            goto L_0x0083
        L_0x0055:
            r3 = move-exception
            r6 = r2
            r2 = r1
            r1 = r6
            goto L_0x005e
        L_0x005a:
            r8 = move-exception
            goto L_0x0083
        L_0x005c:
            r3 = move-exception
            r2 = r1
        L_0x005e:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x005a }
            r4.<init>()     // Catch:{ all -> 0x005a }
            java.lang.String r5 = "Exception occurred getting cache userId:"
            r4.append(r5)     // Catch:{ all -> 0x005a }
            r4.append(r8)     // Catch:{ all -> 0x005a }
            java.lang.String r8 = " category:"
            r4.append(r8)     // Catch:{ all -> 0x005a }
            r4.append(r9)     // Catch:{ all -> 0x005a }
            java.lang.String r8 = r4.toString()     // Catch:{ all -> 0x005a }
            java.lang.Object[] r9 = new java.lang.Object[r0]     // Catch:{ all -> 0x005a }
            com.swrve.sdk.SwrveLogger.m2753e(r8, r3, r9)     // Catch:{ all -> 0x005a }
            if (r1 == 0) goto L_0x0081
            r1.close()
        L_0x0081:
            r1 = r2
            goto L_0x0096
        L_0x0083:
            if (r1 == 0) goto L_0x0088
            r1.close()
        L_0x0088:
            throw r8
        L_0x0089:
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r0] = r8
            r8 = 1
            r2[r8] = r9
            java.lang.String r8 = "Cannot use null value in getofflineCampaign. userId:%s category:%s rawData:%s."
            com.swrve.sdk.SwrveLogger.m2754e(r8, r2)
        L_0x0096:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swrve.sdk.localstorage.SQLiteLocalStorage.getOfflineCampaign(java.lang.String, java.lang.String):java.lang.String");
    }

    public String getSecureCacheEntryForUser(String str, String str2, String str3) throws SecurityException {
        String str4;
        SwrveCacheItem cacheItem = getCacheItem(str, str2);
        if (cacheItem == null || (str4 = cacheItem.rawData) == null) {
            return null;
        }
        SwrveCacheItem cacheItem2 = getCacheItem(str, str2 + LocalStorage.SIGNATURE_SUFFIX);
        if (cacheItem2 == null) {
            return null;
        }
        String str5 = cacheItem2.rawData;
        try {
            String createHMACWithMD5 = SwrveHelper.createHMACWithMD5(str4, str3);
            if (!SwrveHelper.isNullOrEmpty(createHMACWithMD5) && !SwrveHelper.isNullOrEmpty(str5) && str5.equals(createHMACWithMD5)) {
                return str4;
            }
            throw new SecurityException("Signature validation failed");
        } catch (InvalidKeyException | NoSuchAlgorithmException unused) {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.swrve.sdk.SwrveUser} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0061, code lost:
        if (r3 != null) goto L_0x004e;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0068  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.swrve.sdk.SwrveUser getUserByExternalUserId(java.lang.String r13) throws android.database.SQLException {
        /*
            r12 = this;
            r0 = 0
            if (r13 == 0) goto L_0x006c
            boolean r1 = r13.isEmpty()
            if (r1 == 0) goto L_0x000a
            goto L_0x006c
        L_0x000a:
            android.database.sqlite.SQLiteDatabase r1 = r12.database
            boolean r1 = r1.isOpen()
            if (r1 == 0) goto L_0x006c
            r1 = 0
            r2 = 1
            android.database.sqlite.SQLiteDatabase r3 = r12.database     // Catch:{ Exception -> 0x0056, all -> 0x0054 }
            java.lang.String r4 = "users"
            java.lang.String r5 = "swrve_user_id"
            java.lang.String r6 = "verified"
            java.lang.String[] r5 = new java.lang.String[]{r5, r6}     // Catch:{ Exception -> 0x0056, all -> 0x0054 }
            java.lang.String r6 = "external_user_id= ?"
            java.lang.String[] r7 = new java.lang.String[r2]     // Catch:{ Exception -> 0x0056, all -> 0x0054 }
            r7[r1] = r13     // Catch:{ Exception -> 0x0056, all -> 0x0054 }
            r8 = 0
            r9 = 0
            r10 = 0
            java.lang.String r11 = "1"
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x0056, all -> 0x0054 }
            r3.moveToFirst()     // Catch:{ Exception -> 0x0052 }
            boolean r4 = r3.isAfterLast()     // Catch:{ Exception -> 0x0052 }
            if (r4 != 0) goto L_0x004e
            java.lang.String r4 = r3.getString(r1)     // Catch:{ Exception -> 0x0052 }
            int r5 = r3.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r3.moveToNext()     // Catch:{ Exception -> 0x0052 }
            com.swrve.sdk.SwrveUser r6 = new com.swrve.sdk.SwrveUser     // Catch:{ Exception -> 0x0052 }
            if (r5 != r2) goto L_0x0049
            r5 = 1
            goto L_0x004a
        L_0x0049:
            r5 = 0
        L_0x004a:
            r6.<init>(r4, r13, r5)     // Catch:{ Exception -> 0x0052 }
            r0 = r6
        L_0x004e:
            r3.close()
            goto L_0x006c
        L_0x0052:
            r4 = move-exception
            goto L_0x0058
        L_0x0054:
            r13 = move-exception
            goto L_0x0066
        L_0x0056:
            r4 = move-exception
            r3 = r0
        L_0x0058:
            java.lang.String r5 = "Exception occurred getting user: %s"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0064 }
            r2[r1] = r13     // Catch:{ all -> 0x0064 }
            com.swrve.sdk.SwrveLogger.m2753e(r5, r4, r2)     // Catch:{ all -> 0x0064 }
            if (r3 == 0) goto L_0x006c
            goto L_0x004e
        L_0x0064:
            r13 = move-exception
            r0 = r3
        L_0x0066:
            if (r0 == 0) goto L_0x006b
            r0.close()
        L_0x006b:
            throw r13
        L_0x006c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swrve.sdk.localstorage.SQLiteLocalStorage.getUserByExternalUserId(java.lang.String):com.swrve.sdk.SwrveUser");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.swrve.sdk.SwrveUser} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0061, code lost:
        if (r3 != null) goto L_0x004e;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0068  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.swrve.sdk.SwrveUser getUserBySwrveUserId(java.lang.String r13) throws android.database.SQLException {
        /*
            r12 = this;
            r0 = 0
            if (r13 == 0) goto L_0x006c
            boolean r1 = r13.isEmpty()
            if (r1 == 0) goto L_0x000a
            goto L_0x006c
        L_0x000a:
            android.database.sqlite.SQLiteDatabase r1 = r12.database
            boolean r1 = r1.isOpen()
            if (r1 == 0) goto L_0x006c
            r1 = 0
            r2 = 1
            android.database.sqlite.SQLiteDatabase r3 = r12.database     // Catch:{ Exception -> 0x0056, all -> 0x0054 }
            java.lang.String r4 = "users"
            java.lang.String r5 = "external_user_id"
            java.lang.String r6 = "verified"
            java.lang.String[] r5 = new java.lang.String[]{r5, r6}     // Catch:{ Exception -> 0x0056, all -> 0x0054 }
            java.lang.String r6 = "swrve_user_id= ?"
            java.lang.String[] r7 = new java.lang.String[r2]     // Catch:{ Exception -> 0x0056, all -> 0x0054 }
            r7[r1] = r13     // Catch:{ Exception -> 0x0056, all -> 0x0054 }
            r8 = 0
            r9 = 0
            r10 = 0
            java.lang.String r11 = "1"
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x0056, all -> 0x0054 }
            r3.moveToFirst()     // Catch:{ Exception -> 0x0052 }
            boolean r4 = r3.isAfterLast()     // Catch:{ Exception -> 0x0052 }
            if (r4 != 0) goto L_0x004e
            java.lang.String r4 = r3.getString(r1)     // Catch:{ Exception -> 0x0052 }
            int r5 = r3.getInt(r2)     // Catch:{ Exception -> 0x0052 }
            r3.moveToNext()     // Catch:{ Exception -> 0x0052 }
            com.swrve.sdk.SwrveUser r6 = new com.swrve.sdk.SwrveUser     // Catch:{ Exception -> 0x0052 }
            if (r5 != r2) goto L_0x0049
            r5 = 1
            goto L_0x004a
        L_0x0049:
            r5 = 0
        L_0x004a:
            r6.<init>(r13, r4, r5)     // Catch:{ Exception -> 0x0052 }
            r0 = r6
        L_0x004e:
            r3.close()
            goto L_0x006c
        L_0x0052:
            r4 = move-exception
            goto L_0x0058
        L_0x0054:
            r13 = move-exception
            goto L_0x0066
        L_0x0056:
            r4 = move-exception
            r3 = r0
        L_0x0058:
            java.lang.String r5 = "Exception occurred getting user: %s"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0064 }
            r2[r1] = r13     // Catch:{ all -> 0x0064 }
            com.swrve.sdk.SwrveLogger.m2753e(r5, r4, r2)     // Catch:{ all -> 0x0064 }
            if (r3 == 0) goto L_0x006c
            goto L_0x004e
        L_0x0064:
            r13 = move-exception
            r0 = r3
        L_0x0066:
            if (r0 == 0) goto L_0x006b
            r0.close()
        L_0x006b:
            throw r13
        L_0x006c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swrve.sdk.localstorage.SQLiteLocalStorage.getUserBySwrveUserId(java.lang.String):com.swrve.sdk.SwrveUser");
    }

    public synchronized void removeEvents(String str, Collection<Long> collection) {
        try {
            if (this.database.isOpen()) {
                ArrayList arrayList = new ArrayList(collection.size());
                for (Long longValue : collection) {
                    arrayList.add(Long.toString(longValue.longValue()));
                }
                SQLiteDatabase sQLiteDatabase = this.database;
                sQLiteDatabase.delete("events", "_id IN (" + TextUtils.join(",  ", arrayList) + ")", (String[]) null);
            }
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception deleting events for userId:" + str + " id's:[" + collection + "]", e, new Object[0]);
        }
        return;
    }

    public void saveMultipleCacheItems(Map<String, SwrveCacheItem> map) throws SQLException {
        if (this.database.isOpen()) {
            this.database.beginTransaction();
            try {
                ContentValues contentValues = new ContentValues();
                for (Map.Entry next : map.entrySet()) {
                    String str = ((SwrveCacheItem) next.getValue()).userId;
                    String str2 = ((SwrveCacheItem) next.getValue()).category;
                    String str3 = ((SwrveCacheItem) next.getValue()).rawData;
                    contentValues.put("user_id", str);
                    contentValues.put("category", str2);
                    contentValues.put(SwrveSQLiteOpenHelper.CACHE_COLUMN_RAW_DATA, str3);
                    insertOrUpdate(SwrveSQLiteOpenHelper.CACHE_TABLE_NAME, contentValues, "user_id= ? AND category= ?", new String[]{str, str2});
                }
                this.database.setTransactionSuccessful();
            } finally {
                this.database.endTransaction();
            }
        }
    }

    public void saveMultipleEventItems(List<SwrveEventItem> list) throws SQLException {
        if (this.database.isOpen()) {
            this.database.beginTransaction();
            SQLiteStatement sQLiteStatement = null;
            try {
                sQLiteStatement = this.database.compileStatement("INSERT INTO events (event, user_id) VALUES (?, ?)");
                for (SwrveEventItem next : list) {
                    sQLiteStatement.bindString(1, next.event);
                    sQLiteStatement.bindString(2, next.userId);
                    sQLiteStatement.execute();
                    sQLiteStatement.clearBindings();
                }
                this.database.setTransactionSuccessful();
            } finally {
                if (sQLiteStatement != null) {
                    sQLiteStatement.close();
                }
                this.database.endTransaction();
            }
        }
    }

    public void saveNotificationAuthenticated(int i, long j) {
        if (this.database.isOpen()) {
            this.database.beginTransaction();
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("notification_id", Integer.valueOf(i));
                contentValues.put("time", Long.valueOf(j));
                insertOrUpdate(SwrveSQLiteOpenHelper.NOTIFICATIONS_AUTHENTICATED_TABLE_NAME, contentValues, "notification_id= ?", new String[]{String.valueOf(i)});
                this.database.setTransactionSuccessful();
            } finally {
                this.database.endTransaction();
            }
        }
    }

    public void saveOfflineCampaign(String str, String str2, String str3) {
        if (str == null || str2 == null || str3 == null) {
            SwrveLogger.m2754e("Cannot set null value in saveOfflineCampaign for userId:%s category:%s rawData:%s.", str, str2, str3);
            return;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("user_id", str);
            contentValues.put(SwrveSQLiteOpenHelper.OFFLINE_CAMPAIGNS_COLUMN_CAMPAIGN_ID, str2);
            contentValues.put(SwrveSQLiteOpenHelper.OFFLINE_CAMPAIGNS_COLUMN_JSON, str3);
            insertOrUpdate(SwrveSQLiteOpenHelper.OFFLINE_CAMPAIGNS_TABLE_NAME, contentValues, "user_id= ? AND campaign_id= ?", new String[]{str, str2});
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception setting cache for userId:" + str + " campaignId:" + str2 + " campaignData:" + str3, e, new Object[0]);
        }
    }

    public void saveUser(SwrveUser swrveUser) throws SQLException {
        if (this.database.isOpen()) {
            this.database.beginTransaction();
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(SwrveSQLiteOpenHelper.USER_COLUMN_SWRVE_USER_ID, swrveUser.getSwrveUserId());
                contentValues.put(SwrveSQLiteOpenHelper.USER_COLUMN_EXTERNAL_USER_ID, swrveUser.getExternalUserId());
                contentValues.put(SwrveSQLiteOpenHelper.USER_COLUMN_VERFIED, Boolean.valueOf(swrveUser.isVerified()));
                insertOrUpdate(SwrveSQLiteOpenHelper.USER_TABLE_NAME, contentValues, "external_user_id= ?", new String[]{swrveUser.getExternalUserId()});
                this.database.setTransactionSuccessful();
            } finally {
                this.database.endTransaction();
            }
        }
    }

    public void setCacheEntry(String str, String str2, String str3) {
        if (str == null || str2 == null || str3 == null) {
            SwrveLogger.m2754e("Cannot set null value in cache entry for userId:%s category:%s rawData:%s.", str, str2, str3);
            return;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("user_id", str);
            contentValues.put("category", str2);
            contentValues.put(SwrveSQLiteOpenHelper.CACHE_COLUMN_RAW_DATA, str3);
            insertOrUpdate(SwrveSQLiteOpenHelper.CACHE_TABLE_NAME, contentValues, "user_id= ? AND category= ?", new String[]{str, str2});
        } catch (Exception e) {
            SwrveLogger.m2753e("Exception setting cache for userId:" + str + " category:" + str2 + " rawData:" + str3, e, new Object[0]);
        }
    }

    public void setSecureCacheEntryForUser(String str, String str2, String str3, String str4) {
        setCacheEntry(str, str2, str3);
        setCacheEntry(str, str2 + LocalStorage.SIGNATURE_SUFFIX, str4);
    }

    public void truncateNotificationsAuthenticated(int i) {
        if (this.database.isOpen()) {
            this.database.beginTransaction();
            try {
                this.database.execSQL("DELETE FROM notifications_authenticated WHERE notification_id IN (" + ("SELECT notification_id FROM notifications_authenticated ORDER BY time DESC LIMIT -1 OFFSET " + i) + ")");
                this.database.setTransactionSuccessful();
            } finally {
                this.database.endTransaction();
            }
        }
    }
}
