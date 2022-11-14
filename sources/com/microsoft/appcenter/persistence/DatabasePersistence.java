package com.microsoft.appcenter.persistence;

import android.content.ContentValues;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.microsoft.appcenter.Constants;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.storage.DatabaseManager;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DatabasePersistence extends Persistence {
    @VisibleForTesting
    public static final ContentValues SCHEMA = getContentValues("", "", "", "", "", 0);
    public final Context mContext;
    @VisibleForTesting
    public final DatabaseManager mDatabaseManager;
    public final File mLargePayloadDirectory;
    @VisibleForTesting
    public final Set<Long> mPendingDbIdentifiers = new HashSet();
    @VisibleForTesting
    public final Map<String, List<Long>> mPendingDbIdentifiersGroups = new HashMap();

    public DatabasePersistence(Context context) {
        ContentValues contentValues = SCHEMA;
        this.mContext = context;
        this.mDatabaseManager = new DatabaseManager(context, "com.microsoft.appcenter.persistence", "logs", 6, contentValues, "CREATE TABLE IF NOT EXISTS `logs`(`oid` INTEGER PRIMARY KEY AUTOINCREMENT,`target_token` TEXT,`type` TEXT,`priority` INTEGER,`log` TEXT,`persistence_group` TEXT,`target_key` TEXT);", new DatabaseManager.Listener() {
        });
        File file = new File(GeneratedOutlineSupport.outline18(new StringBuilder(), Constants.FILES_PATH, "/appcenter/database_large_payloads"));
        this.mLargePayloadDirectory = file;
        file.mkdirs();
    }

    public static ContentValues getContentValues(@Nullable String str, @Nullable String str2, String str3, String str4, String str5, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("persistence_group", str);
        contentValues.put("log", str2);
        contentValues.put("target_token", str3);
        contentValues.put("type", str4);
        contentValues.put("target_key", str5);
        contentValues.put("priority", Integer.valueOf(i));
        return contentValues;
    }

    public void close() {
        this.mDatabaseManager.close();
    }

    public final void deleteLog(File file, long j) {
        getLargePayloadFile(file, j).delete();
        DatabaseManager databaseManager = this.mDatabaseManager;
        databaseManager.delete(databaseManager.mDefaultTable, "oid", Long.valueOf(j));
    }

    public void deleteLogs(String str) {
        AppCenterLog.debug("AppCenter", "Deleting all logs from the Persistence database for " + str);
        File largePayloadGroupDirectory = getLargePayloadGroupDirectory(str);
        File[] listFiles = largePayloadGroupDirectory.listFiles();
        if (listFiles != null) {
            for (File delete : listFiles) {
                delete.delete();
            }
        }
        largePayloadGroupDirectory.delete();
        DatabaseManager databaseManager = this.mDatabaseManager;
        AppCenterLog.debug("AppCenter", "Deleted " + databaseManager.delete(databaseManager.mDefaultTable, "persistence_group", str) + " logs.");
        Iterator<String> it = this.mPendingDbIdentifiersGroups.keySet().iterator();
        while (it.hasNext()) {
            if (it.next().startsWith(str)) {
                it.remove();
            }
        }
    }

    @VisibleForTesting
    @NonNull
    public File getLargePayloadFile(File file, long j) {
        return new File(file, j + ".json");
    }

    @VisibleForTesting
    @NonNull
    public File getLargePayloadGroupDirectory(String str) {
        return new File(this.mLargePayloadDirectory, str);
    }

    /* JADX WARNING: type inference failed for: r12v1, types: [java.lang.Throwable, java.lang.String] */
    /* JADX WARNING: type inference failed for: r12v20 */
    /* JADX WARNING: type inference failed for: r12v23 */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x013f  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getLogs(@androidx.annotation.NonNull java.lang.String r17, @androidx.annotation.NonNull java.util.Collection<java.lang.String> r18, @androidx.annotation.IntRange(from = 0) int r19, @androidx.annotation.NonNull java.util.List<com.microsoft.appcenter.ingestion.models.Log> r20) {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            r3 = r19
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "Trying to get "
            r0.append(r4)
            r0.append(r3)
            java.lang.String r4 = " logs from the Persistence database for "
            r0.append(r4)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r4 = "AppCenter"
            com.microsoft.appcenter.utils.AppCenterLog.debug(r4, r0)
            android.database.sqlite.SQLiteQueryBuilder r5 = new android.database.sqlite.SQLiteQueryBuilder
            r5.<init>()
            java.lang.String r0 = "persistence_group = ?"
            r5.appendWhere(r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r0.add(r2)
            boolean r6 = r18.isEmpty()
            r7 = 0
            if (r6 != 0) goto L_0x0081
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r8 = 0
        L_0x0043:
            int r9 = r18.size()
            if (r8 >= r9) goto L_0x0051
            java.lang.String r9 = "?,"
            r6.append(r9)
            int r8 = r8 + 1
            goto L_0x0043
        L_0x0051:
            int r8 = r6.length()
            int r8 = r8 + -1
            r6.deleteCharAt(r8)
            java.lang.String r8 = " AND "
            r5.appendWhere(r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "target_key NOT IN ("
            r8.append(r9)
            java.lang.String r6 = r6.toString()
            r8.append(r6)
            java.lang.String r6 = ")"
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            r5.appendWhere(r6)
            r6 = r18
            r0.addAll(r6)
        L_0x0081:
            java.util.LinkedHashMap r6 = new java.util.LinkedHashMap
            r6.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.io.File r9 = r16.getLargePayloadGroupDirectory(r17)
            java.lang.String[] r10 = new java.lang.String[r7]
            java.lang.Object[] r0 = r0.toArray(r10)
            r10 = r0
            java.lang.String[] r10 = (java.lang.String[]) r10
            r11 = 0
            com.microsoft.appcenter.utils.storage.DatabaseManager r0 = r1.mDatabaseManager     // Catch:{ RuntimeException -> 0x00a4 }
            java.lang.String r12 = "priority DESC, oid"
            android.database.Cursor r0 = r0.getCursor(r5, r11, r10, r12)     // Catch:{ RuntimeException -> 0x00a4 }
            r12 = r11
            r11 = r0
            goto L_0x00ab
        L_0x00a4:
            r0 = move-exception
            java.lang.String r12 = "Failed to get logs: "
            com.microsoft.appcenter.utils.AppCenterLog.error(r4, r12, r0)
            r12 = r11
        L_0x00ab:
            if (r11 == 0) goto L_0x01c3
            com.microsoft.appcenter.utils.storage.DatabaseManager r0 = r1.mDatabaseManager
            if (r0 == 0) goto L_0x01c2
            boolean r13 = r11.moveToNext()     // Catch:{ RuntimeException -> 0x00bc }
            if (r13 == 0) goto L_0x00c2
            android.content.ContentValues r0 = r0.buildValues(r11)     // Catch:{ RuntimeException -> 0x00bc }
            goto L_0x00c3
        L_0x00bc:
            r0 = move-exception
            java.lang.String r13 = "Failed to get next cursor value: "
            com.microsoft.appcenter.utils.AppCenterLog.error(r4, r13, r0)
        L_0x00c2:
            r0 = r12
        L_0x00c3:
            if (r0 == 0) goto L_0x01c3
            if (r7 >= r3) goto L_0x01c3
            java.lang.String r13 = "oid"
            java.lang.Long r14 = r0.getAsLong(r13)
            if (r14 != 0) goto L_0x013f
            java.lang.String r0 = "Empty database record, probably content was larger than 2MB, need to delete as it's now corrupted."
            com.microsoft.appcenter.utils.AppCenterLog.error(r4, r0)
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            com.microsoft.appcenter.utils.storage.DatabaseManager r0 = r1.mDatabaseManager     // Catch:{ RuntimeException -> 0x00fe }
            java.lang.String[] r15 = com.microsoft.appcenter.utils.storage.DatabaseManager.SELECT_PRIMARY_KEY     // Catch:{ RuntimeException -> 0x00fe }
            android.database.Cursor r15 = r0.getCursor(r5, r15, r10, r12)     // Catch:{ RuntimeException -> 0x00fe }
        L_0x00e1:
            boolean r0 = r15.moveToNext()     // Catch:{ all -> 0x00f9 }
            if (r0 == 0) goto L_0x00f5
            com.microsoft.appcenter.utils.storage.DatabaseManager r0 = r1.mDatabaseManager     // Catch:{ all -> 0x00f9 }
            android.content.ContentValues r0 = r0.buildValues(r15)     // Catch:{ all -> 0x00f9 }
            java.lang.Long r0 = r0.getAsLong(r13)     // Catch:{ all -> 0x00f9 }
            r14.add(r0)     // Catch:{ all -> 0x00f9 }
            goto L_0x00e1
        L_0x00f5:
            r15.close()     // Catch:{ RuntimeException -> 0x00fe }
            goto L_0x0104
        L_0x00f9:
            r0 = move-exception
            r15.close()     // Catch:{ RuntimeException -> 0x00fe }
            throw r0     // Catch:{ RuntimeException -> 0x00fe }
        L_0x00fe:
            r0 = move-exception
            java.lang.String r13 = "Failed to get corrupted ids: "
            com.microsoft.appcenter.utils.AppCenterLog.error(r4, r13, r0)
        L_0x0104:
            java.util.Iterator r0 = r14.iterator()
        L_0x0108:
            boolean r13 = r0.hasNext()
            if (r13 == 0) goto L_0x00ab
            java.lang.Object r13 = r0.next()
            java.lang.Long r13 = (java.lang.Long) r13
            java.util.Set<java.lang.Long> r14 = r1.mPendingDbIdentifiers
            boolean r14 = r14.contains(r13)
            if (r14 != 0) goto L_0x0108
            boolean r14 = r6.containsKey(r13)
            if (r14 != 0) goto L_0x0108
            long r14 = r13.longValue()
            r1.deleteLog(r9, r14)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r14 = "Empty database corrupted empty record deleted, id="
            r0.append(r14)
            r0.append(r13)
            java.lang.String r0 = r0.toString()
            com.microsoft.appcenter.utils.AppCenterLog.error(r4, r0)
            goto L_0x00ab
        L_0x013f:
            java.util.Set<java.lang.Long> r12 = r1.mPendingDbIdentifiers
            boolean r12 = r12.contains(r14)
            if (r12 != 0) goto L_0x01bf
            java.lang.String r12 = "log"
            java.lang.String r12 = r0.getAsString(r12)     // Catch:{ JSONException -> 0x01b6 }
            if (r12 != 0) goto L_0x017a
            long r12 = r14.longValue()     // Catch:{ JSONException -> 0x01b6 }
            java.io.File r12 = r1.getLargePayloadFile(r9, r12)     // Catch:{ JSONException -> 0x01b6 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01b6 }
            r13.<init>()     // Catch:{ JSONException -> 0x01b6 }
            java.lang.String r15 = "Read payload file "
            r13.append(r15)     // Catch:{ JSONException -> 0x01b6 }
            r13.append(r12)     // Catch:{ JSONException -> 0x01b6 }
            java.lang.String r13 = r13.toString()     // Catch:{ JSONException -> 0x01b6 }
            com.microsoft.appcenter.utils.AppCenterLog.debug(r4, r13)     // Catch:{ JSONException -> 0x01b6 }
            java.lang.String r12 = com.microsoft.appcenter.utils.storage.FileManager.read(r12)     // Catch:{ JSONException -> 0x01b6 }
            if (r12 == 0) goto L_0x0172
            goto L_0x017a
        L_0x0172:
            org.json.JSONException r0 = new org.json.JSONException     // Catch:{ JSONException -> 0x01b6 }
            java.lang.String r12 = "Log payload is null and not stored as a file."
            r0.<init>(r12)     // Catch:{ JSONException -> 0x01b6 }
            throw r0     // Catch:{ JSONException -> 0x01b6 }
        L_0x017a:
            java.lang.String r13 = "type"
            java.lang.String r13 = r0.getAsString(r13)     // Catch:{ JSONException -> 0x01b6 }
            com.microsoft.appcenter.ingestion.models.json.DefaultLogSerializer r15 = r1.mLogSerializer     // Catch:{ JSONException -> 0x01b6 }
            if (r15 == 0) goto L_0x01ae
            com.microsoft.appcenter.ingestion.models.Log r12 = r15.deserializeLog(r12, r13)     // Catch:{ JSONException -> 0x01b6 }
            java.lang.String r13 = "target_token"
            java.lang.String r0 = r0.getAsString(r13)     // Catch:{ JSONException -> 0x01b6 }
            if (r0 == 0) goto L_0x01a8
            android.content.Context r13 = r1.mContext     // Catch:{ JSONException -> 0x01b6 }
            com.microsoft.appcenter.utils.crypto.CryptoUtils r15 = com.microsoft.appcenter.utils.crypto.CryptoUtils.sInstance     // Catch:{ JSONException -> 0x01b6 }
            if (r15 != 0) goto L_0x019d
            com.microsoft.appcenter.utils.crypto.CryptoUtils r15 = new com.microsoft.appcenter.utils.crypto.CryptoUtils     // Catch:{ JSONException -> 0x01b6 }
            r15.<init>(r13)     // Catch:{ JSONException -> 0x01b6 }
            com.microsoft.appcenter.utils.crypto.CryptoUtils.sInstance = r15     // Catch:{ JSONException -> 0x01b6 }
        L_0x019d:
            com.microsoft.appcenter.utils.crypto.CryptoUtils r13 = com.microsoft.appcenter.utils.crypto.CryptoUtils.sInstance     // Catch:{ JSONException -> 0x01b6 }
            com.microsoft.appcenter.utils.crypto.CryptoUtils$DecryptedData r0 = r13.decrypt(r0)     // Catch:{ JSONException -> 0x01b6 }
            java.lang.String r0 = r0.mDecryptedData     // Catch:{ JSONException -> 0x01b6 }
            r12.addTransmissionTarget(r0)     // Catch:{ JSONException -> 0x01b6 }
        L_0x01a8:
            r6.put(r14, r12)     // Catch:{ JSONException -> 0x01b6 }
            int r7 = r7 + 1
            goto L_0x01bf
        L_0x01ae:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ JSONException -> 0x01b6 }
            java.lang.String r12 = "logSerializer not configured"
            r0.<init>(r12)     // Catch:{ JSONException -> 0x01b6 }
            throw r0     // Catch:{ JSONException -> 0x01b6 }
        L_0x01b6:
            r0 = move-exception
            java.lang.String r12 = "Cannot deserialize a log in the database"
            com.microsoft.appcenter.utils.AppCenterLog.error(r4, r12, r0)
            r8.add(r14)
        L_0x01bf:
            r12 = 0
            goto L_0x00ab
        L_0x01c2:
            throw r12
        L_0x01c3:
            if (r11 == 0) goto L_0x01ca
            r11.close()     // Catch:{ RuntimeException -> 0x01c9 }
            goto L_0x01ca
        L_0x01c9:
        L_0x01ca:
            int r0 = r8.size()
            if (r0 <= 0) goto L_0x01ed
            java.util.Iterator r0 = r8.iterator()
        L_0x01d4:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x01e8
            java.lang.Object r3 = r0.next()
            java.lang.Long r3 = (java.lang.Long) r3
            long r7 = r3.longValue()
            r1.deleteLog(r9, r7)
            goto L_0x01d4
        L_0x01e8:
            java.lang.String r0 = "Deleted logs that cannot be deserialized"
            com.microsoft.appcenter.utils.AppCenterLog.warn(r4, r0)
        L_0x01ed:
            int r0 = r6.size()
            if (r0 > 0) goto L_0x01fa
            java.lang.String r0 = "No logs found in the Persistence database at the moment"
            com.microsoft.appcenter.utils.AppCenterLog.debug(r4, r0)
            r0 = 0
            return r0
        L_0x01fa:
            java.util.UUID r0 = java.util.UUID.randomUUID()
            java.lang.String r0 = r0.toString()
            java.lang.String r3 = "Returning "
            java.lang.StringBuilder r3 = com.android.tools.p006r8.GeneratedOutlineSupport.outline24(r3)
            int r5 = r6.size()
            r3.append(r5)
            java.lang.String r5 = " log(s) with an ID, "
            r3.append(r5)
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            com.microsoft.appcenter.utils.AppCenterLog.debug(r4, r3)
            java.lang.String r3 = "The SID/ID pairs for returning log(s) is/are:"
            com.microsoft.appcenter.utils.AppCenterLog.debug(r4, r3)
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Set r5 = r6.entrySet()
            java.util.Iterator r5 = r5.iterator()
        L_0x0230:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x027a
            java.lang.Object r6 = r5.next()
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6
            java.lang.Object r7 = r6.getKey()
            java.lang.Long r7 = (java.lang.Long) r7
            java.util.Set<java.lang.Long> r8 = r1.mPendingDbIdentifiers
            r8.add(r7)
            r3.add(r7)
            java.lang.Object r8 = r6.getValue()
            r9 = r20
            r9.add(r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r10 = "\t"
            r8.append(r10)
            java.lang.Object r6 = r6.getValue()
            com.microsoft.appcenter.ingestion.models.Log r6 = (com.microsoft.appcenter.ingestion.models.Log) r6
            java.util.UUID r6 = r6.getSid()
            r8.append(r6)
            java.lang.String r6 = " / "
            r8.append(r6)
            r8.append(r7)
            java.lang.String r6 = r8.toString()
            com.microsoft.appcenter.utils.AppCenterLog.debug(r4, r6)
            goto L_0x0230
        L_0x027a:
            java.util.Map<java.lang.String, java.util.List<java.lang.Long>> r4 = r1.mPendingDbIdentifiersGroups
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r2)
            r5.append(r0)
            java.lang.String r2 = r5.toString()
            r4.put(r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.appcenter.persistence.DatabasePersistence.getLogs(java.lang.String, java.util.Collection, int, java.util.List):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0173, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x017b, code lost:
        throw new com.microsoft.appcenter.persistence.Persistence.PersistenceException("Cannot convert to JSON string.", r0);
     */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0173 A[ExcHandler: JSONException (r0v0 'e' org.json.JSONException A[CUSTOM_DECLARE]), Splitter:B:1:0x0008] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long putLog(@androidx.annotation.NonNull com.microsoft.appcenter.ingestion.models.Log r20, @androidx.annotation.NonNull java.lang.String r21, @androidx.annotation.IntRange(from = 1, mo281to = 2) int r22) throws com.microsoft.appcenter.persistence.Persistence.PersistenceException {
        /*
            r19 = this;
            r1 = r19
            r2 = r20
            r3 = r22
            java.lang.String r4 = "AppCenter"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            r0.<init>()     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            java.lang.String r5 = "Storing a log to the Persistence database for log type "
            r0.append(r5)     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            java.lang.String r5 = r20.getType()     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            r0.append(r5)     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            java.lang.String r5 = " with flags="
            r0.append(r5)     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            r0.append(r3)     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            com.microsoft.appcenter.utils.AppCenterLog.debug(r4, r0)     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            com.microsoft.appcenter.ingestion.models.json.DefaultLogSerializer r0 = r1.mLogSerializer     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            if (r0 == 0) goto L_0x0162
            java.lang.String r5 = r0.serializeLog(r2)     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            java.lang.String r0 = "UTF-8"
            byte[] r0 = r5.getBytes(r0)     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            int r6 = r0.length     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            r0 = 1992294(0x1e6666, float:2.791799E-39)
            r7 = 0
            if (r6 < r0) goto L_0x0040
            r0 = 1
            r8 = 1
            goto L_0x0041
        L_0x0040:
            r8 = 0
        L_0x0041:
            boolean r0 = r2 instanceof com.microsoft.appcenter.ingestion.models.one.CommonSchemaLog     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            if (r0 == 0) goto L_0x0077
            if (r8 != 0) goto L_0x006f
            java.util.Set r0 = r20.getTransmissionTargetTokens()     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            java.lang.Object r0 = r0.next()     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            java.lang.String r10 = com.microsoft.appcenter.ingestion.models.one.PartAUtils.getTargetKey(r0)     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            android.content.Context r11 = r1.mContext     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            com.microsoft.appcenter.utils.crypto.CryptoUtils r12 = com.microsoft.appcenter.utils.crypto.CryptoUtils.sInstance     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            if (r12 != 0) goto L_0x0066
            com.microsoft.appcenter.utils.crypto.CryptoUtils r12 = new com.microsoft.appcenter.utils.crypto.CryptoUtils     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            r12.<init>(r11)     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            com.microsoft.appcenter.utils.crypto.CryptoUtils.sInstance = r12     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
        L_0x0066:
            com.microsoft.appcenter.utils.crypto.CryptoUtils r11 = com.microsoft.appcenter.utils.crypto.CryptoUtils.sInstance     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            java.lang.String r0 = r11.encrypt(r0)     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            r11 = r0
            r13 = r10
            goto L_0x0079
        L_0x006f:
            com.microsoft.appcenter.persistence.Persistence$PersistenceException r0 = new com.microsoft.appcenter.persistence.Persistence$PersistenceException     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            java.lang.String r2 = "Log is larger than 1992294 bytes, cannot send to OneCollector."
            r0.<init>(r2)     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            throw r0     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
        L_0x0077:
            r11 = 0
            r13 = 0
        L_0x0079:
            com.microsoft.appcenter.utils.storage.DatabaseManager r0 = r1.mDatabaseManager     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            if (r0 == 0) goto L_0x0160
            r15 = -1
            android.database.sqlite.SQLiteDatabase r0 = r0.getDatabase()     // Catch:{ RuntimeException -> 0x008a }
            long r17 = r0.getMaximumSize()     // Catch:{ RuntimeException -> 0x008a }
            r9 = r17
            goto L_0x0091
        L_0x008a:
            r0 = move-exception
            java.lang.String r10 = "Could not get maximum database size."
            com.microsoft.appcenter.utils.AppCenterLog.error(r4, r10, r0)     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            r9 = r15
        L_0x0091:
            int r0 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r0 == 0) goto L_0x0158
            r14 = r13
            if (r8 != 0) goto L_0x00c2
            long r12 = (long) r6     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            int r0 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r0 <= 0) goto L_0x009e
            goto L_0x00c2
        L_0x009e:
            com.microsoft.appcenter.persistence.Persistence$PersistenceException r0 = new com.microsoft.appcenter.persistence.Persistence$PersistenceException     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            r2.<init>()     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            java.lang.String r3 = "Log is too large ("
            r2.append(r3)     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            r2.append(r6)     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            java.lang.String r3 = " bytes) to store in database. Current maximum database size is "
            r2.append(r3)     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            r2.append(r9)     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            java.lang.String r3 = " bytes."
            r2.append(r3)     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            java.lang.String r2 = r2.toString()     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            r0.<init>(r2)     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            throw r0     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
        L_0x00c2:
            if (r8 == 0) goto L_0x00c6
            r10 = 0
            goto L_0x00c7
        L_0x00c6:
            r10 = r5
        L_0x00c7:
            java.lang.String r12 = r20.getType()     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            int r0 = com.android.billingclient.api.zzam.getPersistenceFlag(r3, r7)     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            r9 = r21
            r13 = r14
            r14 = r0
            android.content.ContentValues r0 = getContentValues(r9, r10, r11, r12, r13, r14)     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            com.microsoft.appcenter.utils.storage.DatabaseManager r3 = r1.mDatabaseManager     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            java.lang.String r6 = "priority"
            long r6 = r3.put(r0, r6)     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            int r0 = (r6 > r15 ? 1 : (r6 == r15 ? 0 : -1))
            if (r0 == 0) goto L_0x0138
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            r0.<init>()     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            java.lang.String r3 = "Stored a log to the Persistence database for log type "
            r0.append(r3)     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            java.lang.String r2 = r20.getType()     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            r0.append(r2)     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            java.lang.String r2 = " with databaseId="
            r0.append(r2)     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            r0.append(r6)     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            com.microsoft.appcenter.utils.AppCenterLog.debug(r4, r0)     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            if (r8 == 0) goto L_0x0137
            java.lang.String r0 = "Payload is larger than what SQLite supports, storing payload in a separate file."
            com.microsoft.appcenter.utils.AppCenterLog.debug(r4, r0)     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            r2 = r21
            java.io.File r0 = r1.getLargePayloadGroupDirectory(r2)     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            r0.mkdir()     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            java.io.File r0 = r1.getLargePayloadFile(r0, r6)     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            com.microsoft.appcenter.utils.storage.FileManager.write(r0, r5)     // Catch:{ IOException -> 0x012f, JSONException -> 0x0173 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            r2.<init>()     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            java.lang.String r3 = "Payload written to "
            r2.append(r3)     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            r2.append(r0)     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            java.lang.String r0 = r2.toString()     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            com.microsoft.appcenter.utils.AppCenterLog.debug(r4, r0)     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            goto L_0x0137
        L_0x012f:
            r0 = move-exception
            r2 = r0
            com.microsoft.appcenter.utils.storage.DatabaseManager r0 = r1.mDatabaseManager     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            r0.delete(r6)     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            throw r2     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
        L_0x0137:
            return r6
        L_0x0138:
            com.microsoft.appcenter.persistence.Persistence$PersistenceException r0 = new com.microsoft.appcenter.persistence.Persistence$PersistenceException     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            r3.<init>()     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            java.lang.String r4 = "Failed to store a log to the Persistence database for log type "
            r3.append(r4)     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            java.lang.String r2 = r20.getType()     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            r3.append(r2)     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            java.lang.String r2 = "."
            r3.append(r2)     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            java.lang.String r2 = r3.toString()     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            r0.<init>(r2)     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            throw r0     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
        L_0x0158:
            com.microsoft.appcenter.persistence.Persistence$PersistenceException r0 = new com.microsoft.appcenter.persistence.Persistence$PersistenceException     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            java.lang.String r2 = "Failed to store a log to the Persistence database."
            r0.<init>(r2)     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            throw r0     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
        L_0x0160:
            r2 = 0
            throw r2     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
        L_0x0162:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            java.lang.String r2 = "logSerializer not configured"
            r0.<init>(r2)     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
            throw r0     // Catch:{ JSONException -> 0x0173, IOException -> 0x016a }
        L_0x016a:
            r0 = move-exception
            com.microsoft.appcenter.persistence.Persistence$PersistenceException r2 = new com.microsoft.appcenter.persistence.Persistence$PersistenceException
            java.lang.String r3 = "Cannot save large payload in a file."
            r2.<init>(r3, r0)
            throw r2
        L_0x0173:
            r0 = move-exception
            com.microsoft.appcenter.persistence.Persistence$PersistenceException r2 = new com.microsoft.appcenter.persistence.Persistence$PersistenceException
            java.lang.String r3 = "Cannot convert to JSON string."
            r2.<init>(r3, r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.appcenter.persistence.DatabasePersistence.putLog(com.microsoft.appcenter.ingestion.models.Log, java.lang.String, int):long");
    }
}
