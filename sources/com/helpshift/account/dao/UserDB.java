package com.helpshift.account.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.helpshift.account.domainmodel.ClearedUserDM;
import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.account.domainmodel.UserSyncStatus;
import com.helpshift.common.platform.network.KeyValuePair;
import com.helpshift.migration.MigrationState;
import com.helpshift.migration.legacyUser.LegacyProfile;
import com.helpshift.p042db.user.UserDBHelper;
import com.helpshift.p042db.user.UserDatabaseContract;
import com.helpshift.p042db.user.tables.ClearedUserTable;
import com.helpshift.p042db.user.tables.LegacyAnalyticsEventIDTable;
import com.helpshift.p042db.user.tables.LegacyProfileTable;
import com.helpshift.p042db.user.tables.RedactionInfoTable;
import com.helpshift.p042db.user.tables.UserTable;
import com.helpshift.redaction.RedactionDetail;
import com.helpshift.redaction.RedactionState;
import com.helpshift.redaction.RedactionType;
import com.helpshift.util.HSLogger;

public class UserDB {
    public static final Integer INT_TRUE = 1;
    public static final String TAG = "Helpshift_UserDB";
    public static final String WHERE_LOCAL_ID_IS = "_id = ?";
    public static UserDB instance;
    public final UserDBHelper userDBHelper;

    public UserDB(Context context) {
        this.userDBHelper = new UserDBHelper(context, new UserDatabaseContract());
    }

    private ContentValues clearedUserDMtoContentValues(ClearedUserDM clearedUserDM) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", clearedUserDM.localId);
        contentValues.put("identifier", clearedUserDM.identifier);
        contentValues.put("email", clearedUserDM.email);
        contentValues.put("auth_token", clearedUserDM.authToken);
        contentValues.put("deviceid", clearedUserDM.deviceId);
        contentValues.put(ClearedUserTable.Columns.SYNC_STATE, Integer.valueOf(clearedUserDM.syncState.ordinal()));
        return contentValues;
    }

    private ClearedUserDM cursorToClearedUserDM(Cursor cursor) {
        return new ClearedUserDM(Long.valueOf(cursor.getLong(cursor.getColumnIndex("_id"))), cursor.getString(cursor.getColumnIndex("identifier")), cursor.getString(cursor.getColumnIndex("email")), cursor.getString(cursor.getColumnIndex("auth_token")), cursor.getString(cursor.getColumnIndex("deviceid")), intToClearedUserSyncState(cursor.getInt(cursor.getColumnIndex(ClearedUserTable.Columns.SYNC_STATE))));
    }

    private LegacyProfile cursorToLegacyProfile(Cursor cursor) {
        return new LegacyProfile(cursor.getString(cursor.getColumnIndex("identifier")), cursor.getString(cursor.getColumnIndex("email")), cursor.getString(cursor.getColumnIndex("name")), cursor.getString(cursor.getColumnIndex(LegacyProfileTable.Columns.SERVER_ID)), intToMigrationState(cursor.getInt(cursor.getColumnIndex(LegacyProfileTable.Columns.MIGRATION_STATE))));
    }

    private RedactionDetail cursorToRedactionDetail(Cursor cursor) {
        return new RedactionDetail(cursor.getLong(cursor.getColumnIndex("user_local_id")), intToRedactionState(cursor.getInt(cursor.getColumnIndex(RedactionInfoTable.Columns.REDACTION_STATE))), intToRedactionType(cursor.getInt(cursor.getColumnIndex(RedactionInfoTable.Columns.REDACTION_TYPE))));
    }

    private UserDM cursorToUserDM(Cursor cursor) {
        Long valueOf = Long.valueOf(cursor.getLong(cursor.getColumnIndex("_id")));
        String string = cursor.getString(cursor.getColumnIndex("identifier"));
        String string2 = cursor.getString(cursor.getColumnIndex("name"));
        String string3 = cursor.getString(cursor.getColumnIndex("email"));
        String string4 = cursor.getString(cursor.getColumnIndex("deviceid"));
        String string5 = cursor.getString(cursor.getColumnIndex("auth_token"));
        return new UserDM(valueOf, string, string3, string2, string4, cursor.getInt(cursor.getColumnIndex("active")) == INT_TRUE.intValue(), cursor.getInt(cursor.getColumnIndex(UserTable.Columns.ANONOYMOUS)) == INT_TRUE.intValue(), cursor.getInt(cursor.getColumnIndex(UserTable.Columns.PUSH_TOKEN_SYNCED)) == INT_TRUE.intValue(), string5, cursor.getInt(cursor.getColumnIndex(UserTable.Columns.ISSUE_EXISTS)) == INT_TRUE.intValue(), intToUserSyncStatus(cursor.getInt(cursor.getColumnIndex(UserTable.Columns.INITIAL_STATE_SYNCED))));
    }

    private ClearedUserDM getClearUserDMWithLocalId(ClearedUserDM clearedUserDM, long j) {
        return new ClearedUserDM(Long.valueOf(j), clearedUserDM.identifier, clearedUserDM.email, clearedUserDM.authToken, clearedUserDM.deviceId, clearedUserDM.syncState);
    }

    public static synchronized UserDB getInstance(Context context) {
        UserDB userDB;
        synchronized (UserDB.class) {
            if (instance == null) {
                instance = new UserDB(context);
            }
            userDB = instance;
        }
        return userDB;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: com.helpshift.account.domainmodel.UserDM} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0042, code lost:
        if (r1 != null) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0046, code lost:
        return r0;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0031 A[Catch:{ all -> 0x0047 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x004b A[SYNTHETIC, Splitter:B:30:0x004b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized com.helpshift.account.domainmodel.UserDM getUser(java.lang.String r11, java.lang.String[] r12, boolean r13) {
        /*
            r10 = this;
            monitor-enter(r10)
            r0 = 0
            com.helpshift.db.user.UserDBHelper r1 = r10.userDBHelper     // Catch:{ Exception -> 0x0026, all -> 0x0024 }
            android.database.sqlite.SQLiteDatabase r2 = r1.getReadableDatabase()     // Catch:{ Exception -> 0x0026, all -> 0x0024 }
            java.lang.String r3 = "user_table"
            r4 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r5 = r11
            r6 = r12
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0026, all -> 0x0024 }
            boolean r2 = r1.moveToFirst()     // Catch:{ Exception -> 0x0022 }
            if (r2 == 0) goto L_0x001e
            com.helpshift.account.domainmodel.UserDM r0 = r10.cursorToUserDM(r1)     // Catch:{ Exception -> 0x0022 }
        L_0x001e:
            r1.close()     // Catch:{ all -> 0x004f }
            goto L_0x0045
        L_0x0022:
            r2 = move-exception
            goto L_0x0028
        L_0x0024:
            r11 = move-exception
            goto L_0x0049
        L_0x0026:
            r2 = move-exception
            r1 = r0
        L_0x0028:
            java.lang.String r3 = "Helpshift_UserDB"
            java.lang.String r4 = "Error in reading user"
            com.helpshift.util.HSLogger.m3242e(r3, r4, r2)     // Catch:{ all -> 0x0047 }
            if (r13 == 0) goto L_0x0042
            com.helpshift.db.user.UserDBHelper r13 = r10.userDBHelper     // Catch:{ all -> 0x0047 }
            r13.close()     // Catch:{ all -> 0x0047 }
            r13 = 0
            com.helpshift.account.domainmodel.UserDM r11 = r10.getUser(r11, r12, r13)     // Catch:{ all -> 0x0047 }
            if (r1 == 0) goto L_0x0040
            r1.close()     // Catch:{ all -> 0x004f }
        L_0x0040:
            monitor-exit(r10)
            return r11
        L_0x0042:
            if (r1 == 0) goto L_0x0045
            goto L_0x001e
        L_0x0045:
            monitor-exit(r10)
            return r0
        L_0x0047:
            r11 = move-exception
            r0 = r1
        L_0x0049:
            if (r0 == 0) goto L_0x004e
            r0.close()     // Catch:{ all -> 0x004f }
        L_0x004e:
            throw r11     // Catch:{ all -> 0x004f }
        L_0x004f:
            r11 = move-exception
            monitor-exit(r10)
            goto L_0x0053
        L_0x0052:
            throw r11
        L_0x0053:
            goto L_0x0052
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.account.dao.UserDB.getUser(java.lang.String, java.lang.String[], boolean):com.helpshift.account.domainmodel.UserDM");
    }

    private UserDM getUserDMWithLocalId(UserDM userDM, long j) {
        return new UserDM(Long.valueOf(j), userDM.getIdentifier(), userDM.getEmail(), userDM.getName(), userDM.getDeviceId(), userDM.isActiveUser(), userDM.isAnonymousUser(), userDM.isPushTokenSynced(), userDM.getAuthToken(), userDM.issueExists(), userDM.getSyncState());
    }

    private ClearedUserSyncState intToClearedUserSyncState(int i) {
        if (i < 0 || i > 3) {
            i = 0;
        }
        return ClearedUserSyncState.values()[i];
    }

    private MigrationState intToMigrationState(int i) {
        if (i < 0 || i > 3) {
            i = 0;
        }
        return MigrationState.values()[i];
    }

    private RedactionState intToRedactionState(int i) {
        RedactionState[] values = RedactionState.values();
        if (i < 0 || i > values.length) {
            i = 0;
        }
        return values[i];
    }

    private RedactionType intToRedactionType(int i) {
        RedactionType[] values = RedactionType.values();
        if (i < 0 || i > values.length) {
            i = 0;
        }
        return values[i];
    }

    private UserSyncStatus intToUserSyncStatus(int i) {
        if (i < 0 || i > 3) {
            i = 0;
        }
        return UserSyncStatus.values()[i];
    }

    private ContentValues legacyAnalyticsIDPairToContentValues(KeyValuePair keyValuePair) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("identifier", keyValuePair.key);
        contentValues.put(LegacyAnalyticsEventIDTable.Columns.ANALYTICS_EVENT_ID, keyValuePair.value);
        return contentValues;
    }

    private ContentValues legacyProfileToContentValues(LegacyProfile legacyProfile) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("identifier", legacyProfile.identifier);
        contentValues.put("name", legacyProfile.name);
        contentValues.put("email", legacyProfile.email);
        contentValues.put(LegacyProfileTable.Columns.SERVER_ID, legacyProfile.serverId);
        contentValues.put(LegacyProfileTable.Columns.MIGRATION_STATE, Integer.valueOf(legacyProfile.migrationState.ordinal()));
        return contentValues;
    }

    private ContentValues redactionDetailToContentValues(RedactionDetail redactionDetail) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("user_local_id", Long.valueOf(redactionDetail.userLocalId));
        contentValues.put(RedactionInfoTable.Columns.REDACTION_STATE, Integer.valueOf(redactionDetail.redactionState.ordinal()));
        contentValues.put(RedactionInfoTable.Columns.REDACTION_TYPE, Integer.valueOf(redactionDetail.redactionType.ordinal()));
        return contentValues;
    }

    private ContentValues userDMToContentValues(UserDM userDM) {
        ContentValues contentValues = new ContentValues();
        if (userDM.getLocalId() != null) {
            contentValues.put("_id", userDM.getLocalId());
        }
        if (userDM.getIdentifier() != null) {
            contentValues.put("identifier", userDM.getIdentifier());
        } else {
            contentValues.put("identifier", "");
        }
        if (userDM.getName() != null) {
            contentValues.put("name", userDM.getName());
        } else {
            contentValues.put("name", "");
        }
        if (userDM.getEmail() != null) {
            contentValues.put("email", userDM.getEmail());
        } else {
            contentValues.put("email", "");
        }
        if (userDM.getDeviceId() != null) {
            contentValues.put("deviceid", userDM.getDeviceId());
        } else {
            contentValues.put("deviceid", "");
        }
        if (userDM.getAuthToken() != null) {
            contentValues.put("auth_token", userDM.getAuthToken());
        } else {
            contentValues.put("auth_token", "");
        }
        contentValues.put("active", Boolean.valueOf(userDM.isActiveUser()));
        contentValues.put(UserTable.Columns.ANONOYMOUS, Boolean.valueOf(userDM.isAnonymousUser()));
        contentValues.put(UserTable.Columns.ISSUE_EXISTS, Boolean.valueOf(userDM.issueExists()));
        contentValues.put(UserTable.Columns.PUSH_TOKEN_SYNCED, Boolean.valueOf(userDM.isPushTokenSynced()));
        contentValues.put(UserTable.Columns.INITIAL_STATE_SYNCED, Integer.valueOf(userDM.getSyncState().ordinal()));
        return contentValues;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0051, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        com.helpshift.util.HSLogger.m3242e("Helpshift_UserDB", "Error in activating user in finally block", r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005b, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0075, code lost:
        if (r1 != null) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        r1.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x007d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        com.helpshift.util.HSLogger.m3242e("Helpshift_UserDB", "Error in activating user in finally block", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0085, code lost:
        throw r10;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:11:0x004d, B:21:0x0062] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean activateUser(java.lang.Long r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            r0 = 0
            if (r10 != 0) goto L_0x0006
            monitor-exit(r9)
            return r0
        L_0x0006:
            r1 = 0
            r2 = 1
            com.helpshift.db.user.UserDBHelper r3 = r9.userDBHelper     // Catch:{ Exception -> 0x005d }
            android.database.sqlite.SQLiteDatabase r1 = r3.getWritableDatabase()     // Catch:{ Exception -> 0x005d }
            android.content.ContentValues r3 = new android.content.ContentValues     // Catch:{ Exception -> 0x005d }
            r3.<init>()     // Catch:{ Exception -> 0x005d }
            java.lang.String r4 = "active"
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x005d }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x005d }
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch:{ Exception -> 0x005d }
            r4.<init>()     // Catch:{ Exception -> 0x005d }
            java.lang.String r5 = "active"
            java.lang.Boolean r6 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x005d }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x005d }
            r1.beginTransaction()     // Catch:{ Exception -> 0x005d }
            java.lang.String r5 = "user_table"
            java.lang.String r6 = "_id = ?"
            java.lang.String[] r7 = new java.lang.String[r2]     // Catch:{ Exception -> 0x005d }
            java.lang.String r8 = r10.toString()     // Catch:{ Exception -> 0x005d }
            r7[r0] = r8     // Catch:{ Exception -> 0x005d }
            int r3 = r1.update(r5, r3, r6, r7)     // Catch:{ Exception -> 0x005d }
            if (r3 <= 0) goto L_0x004a
            java.lang.String r3 = "user_table"
            java.lang.String r5 = "_id != ?"
            java.lang.String[] r6 = new java.lang.String[r2]     // Catch:{ Exception -> 0x005d }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x005d }
            r6[r0] = r10     // Catch:{ Exception -> 0x005d }
            r1.update(r3, r4, r5, r6)     // Catch:{ Exception -> 0x005d }
        L_0x004a:
            r1.setTransactionSuccessful()     // Catch:{ Exception -> 0x005d }
            r1.endTransaction()     // Catch:{ Exception -> 0x0051 }
            goto L_0x0059
        L_0x0051:
            r10 = move-exception
            java.lang.String r0 = "Helpshift_UserDB"
            java.lang.String r1 = "Error in activating user in finally block"
            com.helpshift.util.HSLogger.m3242e(r0, r1, r10)     // Catch:{ all -> 0x007b }
        L_0x0059:
            r0 = 1
            goto L_0x0073
        L_0x005b:
            r10 = move-exception
            goto L_0x0075
        L_0x005d:
            r10 = move-exception
            java.lang.String r2 = "Helpshift_UserDB"
            java.lang.String r3 = "Error in activating user"
            com.helpshift.util.HSLogger.m3242e(r2, r3, r10)     // Catch:{ all -> 0x005b }
            if (r1 == 0) goto L_0x0073
            r1.endTransaction()     // Catch:{ Exception -> 0x006b }
            goto L_0x0073
        L_0x006b:
            r10 = move-exception
            java.lang.String r1 = "Helpshift_UserDB"
            java.lang.String r2 = "Error in activating user in finally block"
            com.helpshift.util.HSLogger.m3242e(r1, r2, r10)     // Catch:{ all -> 0x007b }
        L_0x0073:
            monitor-exit(r9)
            return r0
        L_0x0075:
            if (r1 == 0) goto L_0x0085
            r1.endTransaction()     // Catch:{ Exception -> 0x007d }
            goto L_0x0085
        L_0x007b:
            r10 = move-exception
            goto L_0x0086
        L_0x007d:
            r0 = move-exception
            java.lang.String r1 = "Helpshift_UserDB"
            java.lang.String r2 = "Error in activating user in finally block"
            com.helpshift.util.HSLogger.m3242e(r1, r2, r0)     // Catch:{ all -> 0x007b }
        L_0x0085:
            throw r10     // Catch:{ all -> 0x007b }
        L_0x0086:
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.account.dao.UserDB.activateUser(java.lang.Long):boolean");
    }

    public UserDM createUser(UserDM userDM) {
        return createUser(userDM, true);
    }

    public synchronized boolean deleteClearedUser(Long l) {
        boolean z;
        long j;
        z = false;
        try {
            j = (long) this.userDBHelper.getWritableDatabase().delete(UserTable.TABLE_NAME, WHERE_LOCAL_ID_IS, new String[]{String.valueOf(l)});
        } catch (Exception e) {
            HSLogger.m3242e("Helpshift_UserDB", "Error in deleting cleared user", e);
            j = 0;
        }
        if (j > 0) {
            z = true;
        }
        return z;
    }

    public synchronized void deleteLegacyProfile(String str) {
        try {
            this.userDBHelper.getWritableDatabase().delete(LegacyProfileTable.TABLE_NAME, "identifier = ?", new String[]{str});
        } catch (Exception e) {
            HSLogger.m3242e("Helpshift_UserDB", "Error in deleting legacy profile", e);
        }
        return;
    }

    public synchronized void deleteRedactionDetail(long j) {
        try {
            this.userDBHelper.getWritableDatabase().delete(RedactionInfoTable.TABLE_NAME, "user_local_id = ?", new String[]{String.valueOf(j)});
        } catch (Exception e) {
            HSLogger.m3242e("Helpshift_UserDB", "Error in deleting redaction detail", e);
        }
        return;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0032, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean deleteUser(java.lang.Long r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            r0 = 0
            if (r9 != 0) goto L_0x0006
            monitor-exit(r8)
            return r0
        L_0x0006:
            r1 = 1
            r2 = 0
            com.helpshift.db.user.UserDBHelper r4 = r8.userDBHelper     // Catch:{ Exception -> 0x0023 }
            android.database.sqlite.SQLiteDatabase r4 = r4.getWritableDatabase()     // Catch:{ Exception -> 0x0023 }
            java.lang.String r5 = "user_table"
            java.lang.String r6 = "_id = ?"
            java.lang.String[] r7 = new java.lang.String[r1]     // Catch:{ Exception -> 0x0023 }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ Exception -> 0x0023 }
            r7[r0] = r9     // Catch:{ Exception -> 0x0023 }
            int r9 = r4.delete(r5, r6, r7)     // Catch:{ Exception -> 0x0023 }
            long r4 = (long) r9
            goto L_0x002c
        L_0x0021:
            r9 = move-exception
            goto L_0x0033
        L_0x0023:
            r9 = move-exception
            java.lang.String r4 = "Helpshift_UserDB"
            java.lang.String r5 = "Error in deleting user"
            com.helpshift.util.HSLogger.m3242e(r4, r5, r9)     // Catch:{ all -> 0x0021 }
            r4 = r2
        L_0x002c:
            int r9 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r9 <= 0) goto L_0x0031
            r0 = 1
        L_0x0031:
            monitor-exit(r8)
            return r0
        L_0x0033:
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.account.dao.UserDB.deleteUser(java.lang.Long):boolean");
    }

    public void dropAndCreateDatabase() {
        UserDBHelper userDBHelper2 = this.userDBHelper;
        userDBHelper2.dropAndCreateAllTables(userDBHelper2.getWritableDatabase());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003a, code lost:
        if (r1 == null) goto L_0x003d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.util.List<com.helpshift.account.domainmodel.ClearedUserDM> fetchClearedUsers() {
        /*
            r11 = this;
            monitor-enter(r11)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0045 }
            r0.<init>()     // Catch:{ all -> 0x0045 }
            r1 = 0
            com.helpshift.db.user.UserDBHelper r2 = r11.userDBHelper     // Catch:{ Exception -> 0x0032 }
            android.database.sqlite.SQLiteDatabase r3 = r2.getReadableDatabase()     // Catch:{ Exception -> 0x0032 }
            java.lang.String r4 = "cleared_user_table"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            android.database.Cursor r1 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0032 }
            boolean r2 = r1.moveToFirst()     // Catch:{ Exception -> 0x0032 }
            if (r2 == 0) goto L_0x002c
        L_0x001f:
            com.helpshift.account.domainmodel.ClearedUserDM r2 = r11.cursorToClearedUserDM(r1)     // Catch:{ Exception -> 0x0032 }
            r0.add(r2)     // Catch:{ Exception -> 0x0032 }
            boolean r2 = r1.moveToNext()     // Catch:{ Exception -> 0x0032 }
            if (r2 != 0) goto L_0x001f
        L_0x002c:
            r1.close()     // Catch:{ all -> 0x0045 }
            goto L_0x003d
        L_0x0030:
            r0 = move-exception
            goto L_0x003f
        L_0x0032:
            r2 = move-exception
            java.lang.String r3 = "Helpshift_UserDB"
            java.lang.String r4 = "Error in reading all cleared users"
            com.helpshift.util.HSLogger.m3242e(r3, r4, r2)     // Catch:{ all -> 0x0030 }
            if (r1 == 0) goto L_0x003d
            goto L_0x002c
        L_0x003d:
            monitor-exit(r11)
            return r0
        L_0x003f:
            if (r1 == 0) goto L_0x0044
            r1.close()     // Catch:{ all -> 0x0045 }
        L_0x0044:
            throw r0     // Catch:{ all -> 0x0045 }
        L_0x0045:
            r0 = move-exception
            monitor-exit(r11)
            goto L_0x0049
        L_0x0048:
            throw r0
        L_0x0049:
            goto L_0x0048
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.account.dao.UserDB.fetchClearedUsers():java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003e, code lost:
        if (r0 != null) goto L_0x002a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0046 A[SYNTHETIC, Splitter:B:26:0x0046] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.String fetchLegacyAnalyticsEventId(java.lang.String r11) {
        /*
            r10 = this;
            monitor-enter(r10)
            r0 = 1
            java.lang.String[] r5 = new java.lang.String[r0]     // Catch:{ all -> 0x004a }
            r0 = 0
            r5[r0] = r11     // Catch:{ all -> 0x004a }
            r11 = 0
            com.helpshift.db.user.UserDBHelper r0 = r10.userDBHelper     // Catch:{ Exception -> 0x0035, all -> 0x0030 }
            android.database.sqlite.SQLiteDatabase r1 = r0.getReadableDatabase()     // Catch:{ Exception -> 0x0035, all -> 0x0030 }
            java.lang.String r2 = "legacy_analytics_event_id_table"
            r3 = 0
            java.lang.String r4 = "identifier = ?"
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r0 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0035, all -> 0x0030 }
            boolean r1 = r0.moveToFirst()     // Catch:{ Exception -> 0x002e }
            if (r1 == 0) goto L_0x002a
            java.lang.String r1 = "analytics_event_id"
            int r1 = r0.getColumnIndex(r1)     // Catch:{ Exception -> 0x002e }
            java.lang.String r11 = r0.getString(r1)     // Catch:{ Exception -> 0x002e }
        L_0x002a:
            r0.close()     // Catch:{ all -> 0x004a }
            goto L_0x0041
        L_0x002e:
            r1 = move-exception
            goto L_0x0037
        L_0x0030:
            r0 = move-exception
            r9 = r0
            r0 = r11
            r11 = r9
            goto L_0x0044
        L_0x0035:
            r1 = move-exception
            r0 = r11
        L_0x0037:
            java.lang.String r2 = "Helpshift_UserDB"
            java.lang.String r3 = "Error in reading legacy analytics eventID with identifier"
            com.helpshift.util.HSLogger.m3242e(r2, r3, r1)     // Catch:{ all -> 0x0043 }
            if (r0 == 0) goto L_0x0041
            goto L_0x002a
        L_0x0041:
            monitor-exit(r10)
            return r11
        L_0x0043:
            r11 = move-exception
        L_0x0044:
            if (r0 == 0) goto L_0x0049
            r0.close()     // Catch:{ all -> 0x004a }
        L_0x0049:
            throw r11     // Catch:{ all -> 0x004a }
        L_0x004a:
            r11 = move-exception
            monitor-exit(r10)
            goto L_0x004e
        L_0x004d:
            throw r11
        L_0x004e:
            goto L_0x004d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.account.dao.UserDB.fetchLegacyAnalyticsEventId(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0038, code lost:
        if (r0 != null) goto L_0x0024;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0040 A[SYNTHETIC, Splitter:B:26:0x0040] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.helpshift.migration.legacyUser.LegacyProfile fetchLegacyProfile(java.lang.String r11) {
        /*
            r10 = this;
            monitor-enter(r10)
            r0 = 1
            java.lang.String[] r5 = new java.lang.String[r0]     // Catch:{ all -> 0x0044 }
            r0 = 0
            r5[r0] = r11     // Catch:{ all -> 0x0044 }
            r11 = 0
            com.helpshift.db.user.UserDBHelper r0 = r10.userDBHelper     // Catch:{ Exception -> 0x002f, all -> 0x002a }
            android.database.sqlite.SQLiteDatabase r1 = r0.getReadableDatabase()     // Catch:{ Exception -> 0x002f, all -> 0x002a }
            java.lang.String r2 = "legacy_profile_table"
            r3 = 0
            java.lang.String r4 = "identifier = ?"
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r0 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x002f, all -> 0x002a }
            boolean r1 = r0.moveToFirst()     // Catch:{ Exception -> 0x0028 }
            if (r1 == 0) goto L_0x0024
            com.helpshift.migration.legacyUser.LegacyProfile r11 = r10.cursorToLegacyProfile(r0)     // Catch:{ Exception -> 0x0028 }
        L_0x0024:
            r0.close()     // Catch:{ all -> 0x0044 }
            goto L_0x003b
        L_0x0028:
            r1 = move-exception
            goto L_0x0031
        L_0x002a:
            r0 = move-exception
            r9 = r0
            r0 = r11
            r11 = r9
            goto L_0x003e
        L_0x002f:
            r1 = move-exception
            r0 = r11
        L_0x0031:
            java.lang.String r2 = "Helpshift_UserDB"
            java.lang.String r3 = "Error in reading legacy profile with identifier"
            com.helpshift.util.HSLogger.m3242e(r2, r3, r1)     // Catch:{ all -> 0x003d }
            if (r0 == 0) goto L_0x003b
            goto L_0x0024
        L_0x003b:
            monitor-exit(r10)
            return r11
        L_0x003d:
            r11 = move-exception
        L_0x003e:
            if (r0 == 0) goto L_0x0043
            r0.close()     // Catch:{ all -> 0x0044 }
        L_0x0043:
            throw r11     // Catch:{ all -> 0x0044 }
        L_0x0044:
            r11 = move-exception
            monitor-exit(r10)
            goto L_0x0048
        L_0x0047:
            throw r11
        L_0x0048:
            goto L_0x0047
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.account.dao.UserDB.fetchLegacyProfile(java.lang.String):com.helpshift.migration.legacyUser.LegacyProfile");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003c, code lost:
        if (r12 != null) goto L_0x0028;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0044 A[SYNTHETIC, Splitter:B:26:0x0044] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.helpshift.redaction.RedactionDetail fetchRedactionDetail(long r11) {
        /*
            r10 = this;
            monitor-enter(r10)
            r0 = 1
            java.lang.String[] r5 = new java.lang.String[r0]     // Catch:{ all -> 0x0048 }
            r0 = 0
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ all -> 0x0048 }
            r5[r0] = r11     // Catch:{ all -> 0x0048 }
            r11 = 0
            com.helpshift.db.user.UserDBHelper r12 = r10.userDBHelper     // Catch:{ Exception -> 0x0033, all -> 0x002e }
            android.database.sqlite.SQLiteDatabase r1 = r12.getReadableDatabase()     // Catch:{ Exception -> 0x0033, all -> 0x002e }
            java.lang.String r2 = "redaction_info_table"
            r3 = 0
            java.lang.String r4 = "user_local_id = ?"
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r12 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0033, all -> 0x002e }
            boolean r0 = r12.moveToFirst()     // Catch:{ Exception -> 0x002c }
            if (r0 == 0) goto L_0x0028
            com.helpshift.redaction.RedactionDetail r11 = r10.cursorToRedactionDetail(r12)     // Catch:{ Exception -> 0x002c }
        L_0x0028:
            r12.close()     // Catch:{ all -> 0x0048 }
            goto L_0x003f
        L_0x002c:
            r0 = move-exception
            goto L_0x0035
        L_0x002e:
            r12 = move-exception
            r9 = r12
            r12 = r11
            r11 = r9
            goto L_0x0042
        L_0x0033:
            r0 = move-exception
            r12 = r11
        L_0x0035:
            java.lang.String r1 = "Helpshift_UserDB"
            java.lang.String r2 = "Error in reading redaction detail of the user"
            com.helpshift.util.HSLogger.m3242e(r1, r2, r0)     // Catch:{ all -> 0x0041 }
            if (r12 == 0) goto L_0x003f
            goto L_0x0028
        L_0x003f:
            monitor-exit(r10)
            return r11
        L_0x0041:
            r11 = move-exception
        L_0x0042:
            if (r12 == 0) goto L_0x0047
            r12.close()     // Catch:{ all -> 0x0048 }
        L_0x0047:
            throw r11     // Catch:{ all -> 0x0048 }
        L_0x0048:
            r11 = move-exception
            monitor-exit(r10)
            goto L_0x004c
        L_0x004b:
            throw r11
        L_0x004c:
            goto L_0x004b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.account.dao.UserDB.fetchRedactionDetail(long):com.helpshift.redaction.RedactionDetail");
    }

    public synchronized UserDM fetchUser(Long l) {
        if (l == null) {
            return null;
        }
        return getUser(WHERE_LOCAL_ID_IS, new String[]{l.toString()}, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003a, code lost:
        if (r1 == null) goto L_0x003d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.util.List<com.helpshift.account.domainmodel.UserDM> fetchUsers() {
        /*
            r11 = this;
            monitor-enter(r11)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0045 }
            r0.<init>()     // Catch:{ all -> 0x0045 }
            r1 = 0
            com.helpshift.db.user.UserDBHelper r2 = r11.userDBHelper     // Catch:{ Exception -> 0x0032 }
            android.database.sqlite.SQLiteDatabase r3 = r2.getReadableDatabase()     // Catch:{ Exception -> 0x0032 }
            java.lang.String r4 = "user_table"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            android.database.Cursor r1 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0032 }
            boolean r2 = r1.moveToFirst()     // Catch:{ Exception -> 0x0032 }
            if (r2 == 0) goto L_0x002c
        L_0x001f:
            com.helpshift.account.domainmodel.UserDM r2 = r11.cursorToUserDM(r1)     // Catch:{ Exception -> 0x0032 }
            r0.add(r2)     // Catch:{ Exception -> 0x0032 }
            boolean r2 = r1.moveToNext()     // Catch:{ Exception -> 0x0032 }
            if (r2 != 0) goto L_0x001f
        L_0x002c:
            r1.close()     // Catch:{ all -> 0x0045 }
            goto L_0x003d
        L_0x0030:
            r0 = move-exception
            goto L_0x003f
        L_0x0032:
            r2 = move-exception
            java.lang.String r3 = "Helpshift_UserDB"
            java.lang.String r4 = "Error in reading all users"
            com.helpshift.util.HSLogger.m3242e(r3, r4, r2)     // Catch:{ all -> 0x0030 }
            if (r1 == 0) goto L_0x003d
            goto L_0x002c
        L_0x003d:
            monitor-exit(r11)
            return r0
        L_0x003f:
            if (r1 == 0) goto L_0x0044
            r1.close()     // Catch:{ all -> 0x0045 }
        L_0x0044:
            throw r0     // Catch:{ all -> 0x0045 }
        L_0x0045:
            r0 = move-exception
            monitor-exit(r11)
            goto L_0x0049
        L_0x0048:
            throw r0
        L_0x0049:
            goto L_0x0048
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.account.dao.UserDB.fetchUsers():java.util.List");
    }

    public synchronized UserDM getActiveUser() {
        return getUser("active = ?", new String[]{INT_TRUE.toString()}, true);
    }

    public synchronized UserDM getAnonymousUser() {
        return getUser("anonymous = ?", new String[]{INT_TRUE.toString()}, true);
    }

    public synchronized ClearedUserDM insertClearedUser(ClearedUserDM clearedUserDM) {
        Long l;
        try {
            l = Long.valueOf(this.userDBHelper.getWritableDatabase().insert(ClearedUserTable.TABLE_NAME, (String) null, clearedUserDMtoContentValues(clearedUserDM)));
        } catch (Exception e) {
            HSLogger.m3242e("Helpshift_UserDB", "Error in creating cleared user", e);
            l = null;
        }
        if (l == null) {
            return null;
        }
        return getClearUserDMWithLocalId(clearedUserDM, l.longValue());
    }

    public synchronized void insertRedactionDetail(RedactionDetail redactionDetail) {
        try {
            this.userDBHelper.getWritableDatabase().insert(RedactionInfoTable.TABLE_NAME, (String) null, redactionDetailToContentValues(redactionDetail));
        } catch (Exception e) {
            HSLogger.m3242e("Helpshift_UserDB", "Error in inserting redaction info of the user", e);
        }
        return;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0047 A[SYNTHETIC, Splitter:B:26:0x0047] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0055 A[SYNTHETIC, Splitter:B:33:0x0055] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void storeLegacyAnalyticsEventIds(java.util.List<com.helpshift.common.platform.network.KeyValuePair> r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            com.helpshift.db.user.UserDBHelper r1 = r4.userDBHelper     // Catch:{ Exception -> 0x003d }
            android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch:{ Exception -> 0x003d }
            r1.beginTransaction()     // Catch:{ Exception -> 0x0038, all -> 0x0035 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ Exception -> 0x0038, all -> 0x0035 }
        L_0x000f:
            boolean r2 = r5.hasNext()     // Catch:{ Exception -> 0x0038, all -> 0x0035 }
            if (r2 == 0) goto L_0x0025
            java.lang.Object r2 = r5.next()     // Catch:{ Exception -> 0x0038, all -> 0x0035 }
            com.helpshift.common.platform.network.KeyValuePair r2 = (com.helpshift.common.platform.network.KeyValuePair) r2     // Catch:{ Exception -> 0x0038, all -> 0x0035 }
            android.content.ContentValues r2 = r4.legacyAnalyticsIDPairToContentValues(r2)     // Catch:{ Exception -> 0x0038, all -> 0x0035 }
            java.lang.String r3 = "legacy_analytics_event_id_table"
            r1.insert(r3, r0, r2)     // Catch:{ Exception -> 0x0038, all -> 0x0035 }
            goto L_0x000f
        L_0x0025:
            r1.setTransactionSuccessful()     // Catch:{ Exception -> 0x0038, all -> 0x0035 }
            r1.endTransaction()     // Catch:{ Exception -> 0x002c }
            goto L_0x0051
        L_0x002c:
            r5 = move-exception
            java.lang.String r0 = "Helpshift_UserDB"
            java.lang.String r1 = "Error in storing legacy analytics events in finally block"
        L_0x0031:
            com.helpshift.util.HSLogger.m3242e(r0, r1, r5)     // Catch:{ all -> 0x0059 }
            goto L_0x0051
        L_0x0035:
            r5 = move-exception
            r0 = r1
            goto L_0x0053
        L_0x0038:
            r5 = move-exception
            r0 = r1
            goto L_0x003e
        L_0x003b:
            r5 = move-exception
            goto L_0x0053
        L_0x003d:
            r5 = move-exception
        L_0x003e:
            java.lang.String r1 = "Helpshift_UserDB"
            java.lang.String r2 = "Error in storing legacy analytics events"
            com.helpshift.util.HSLogger.m3242e(r1, r2, r5)     // Catch:{ all -> 0x003b }
            if (r0 == 0) goto L_0x0051
            r0.endTransaction()     // Catch:{ Exception -> 0x004b }
            goto L_0x0051
        L_0x004b:
            r5 = move-exception
            java.lang.String r0 = "Helpshift_UserDB"
            java.lang.String r1 = "Error in storing legacy analytics events in finally block"
            goto L_0x0031
        L_0x0051:
            monitor-exit(r4)
            return
        L_0x0053:
            if (r0 == 0) goto L_0x0063
            r0.endTransaction()     // Catch:{ Exception -> 0x005b }
            goto L_0x0063
        L_0x0059:
            r5 = move-exception
            goto L_0x0064
        L_0x005b:
            r0 = move-exception
            java.lang.String r1 = "Helpshift_UserDB"
            java.lang.String r2 = "Error in storing legacy analytics events in finally block"
            com.helpshift.util.HSLogger.m3242e(r1, r2, r0)     // Catch:{ all -> 0x0059 }
        L_0x0063:
            throw r5     // Catch:{ all -> 0x0059 }
        L_0x0064:
            monitor-exit(r4)
            goto L_0x0067
        L_0x0066:
            throw r5
        L_0x0067:
            goto L_0x0066
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.account.dao.UserDB.storeLegacyAnalyticsEventIds(java.util.List):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0047 A[SYNTHETIC, Splitter:B:26:0x0047] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0055 A[SYNTHETIC, Splitter:B:33:0x0055] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void storeLegacyProfiles(java.util.List<com.helpshift.migration.legacyUser.LegacyProfile> r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            com.helpshift.db.user.UserDBHelper r1 = r4.userDBHelper     // Catch:{ Exception -> 0x003d }
            android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch:{ Exception -> 0x003d }
            r1.beginTransaction()     // Catch:{ Exception -> 0x0038, all -> 0x0035 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ Exception -> 0x0038, all -> 0x0035 }
        L_0x000f:
            boolean r2 = r5.hasNext()     // Catch:{ Exception -> 0x0038, all -> 0x0035 }
            if (r2 == 0) goto L_0x0025
            java.lang.Object r2 = r5.next()     // Catch:{ Exception -> 0x0038, all -> 0x0035 }
            com.helpshift.migration.legacyUser.LegacyProfile r2 = (com.helpshift.migration.legacyUser.LegacyProfile) r2     // Catch:{ Exception -> 0x0038, all -> 0x0035 }
            android.content.ContentValues r2 = r4.legacyProfileToContentValues(r2)     // Catch:{ Exception -> 0x0038, all -> 0x0035 }
            java.lang.String r3 = "legacy_profile_table"
            r1.insert(r3, r0, r2)     // Catch:{ Exception -> 0x0038, all -> 0x0035 }
            goto L_0x000f
        L_0x0025:
            r1.setTransactionSuccessful()     // Catch:{ Exception -> 0x0038, all -> 0x0035 }
            r1.endTransaction()     // Catch:{ Exception -> 0x002c }
            goto L_0x0051
        L_0x002c:
            r5 = move-exception
            java.lang.String r0 = "Helpshift_UserDB"
            java.lang.String r1 = "Error in storing legacy profiles in finally block"
        L_0x0031:
            com.helpshift.util.HSLogger.m3242e(r0, r1, r5)     // Catch:{ all -> 0x0059 }
            goto L_0x0051
        L_0x0035:
            r5 = move-exception
            r0 = r1
            goto L_0x0053
        L_0x0038:
            r5 = move-exception
            r0 = r1
            goto L_0x003e
        L_0x003b:
            r5 = move-exception
            goto L_0x0053
        L_0x003d:
            r5 = move-exception
        L_0x003e:
            java.lang.String r1 = "Helpshift_UserDB"
            java.lang.String r2 = "Error in storing legacy profiles"
            com.helpshift.util.HSLogger.m3242e(r1, r2, r5)     // Catch:{ all -> 0x003b }
            if (r0 == 0) goto L_0x0051
            r0.endTransaction()     // Catch:{ Exception -> 0x004b }
            goto L_0x0051
        L_0x004b:
            r5 = move-exception
            java.lang.String r0 = "Helpshift_UserDB"
            java.lang.String r1 = "Error in storing legacy profiles in finally block"
            goto L_0x0031
        L_0x0051:
            monitor-exit(r4)
            return
        L_0x0053:
            if (r0 == 0) goto L_0x0063
            r0.endTransaction()     // Catch:{ Exception -> 0x005b }
            goto L_0x0063
        L_0x0059:
            r5 = move-exception
            goto L_0x0064
        L_0x005b:
            r0 = move-exception
            java.lang.String r1 = "Helpshift_UserDB"
            java.lang.String r2 = "Error in storing legacy profiles in finally block"
            com.helpshift.util.HSLogger.m3242e(r1, r2, r0)     // Catch:{ all -> 0x0059 }
        L_0x0063:
            throw r5     // Catch:{ all -> 0x0059 }
        L_0x0064:
            monitor-exit(r4)
            goto L_0x0067
        L_0x0066:
            throw r5
        L_0x0067:
            goto L_0x0066
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.account.dao.UserDB.storeLegacyProfiles(java.util.List):void");
    }

    public synchronized boolean updateClearedUserSyncState(Long l, ClearedUserSyncState clearedUserSyncState) {
        boolean z;
        z = true;
        try {
            SQLiteDatabase writableDatabase = this.userDBHelper.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(ClearedUserTable.Columns.SYNC_STATE, Integer.valueOf(clearedUserSyncState.ordinal()));
            writableDatabase.update(ClearedUserTable.TABLE_NAME, contentValues, WHERE_LOCAL_ID_IS, new String[]{l.toString()});
        } catch (Exception e) {
            HSLogger.m3242e("Helpshift_UserDB", "Error in updating cleared user sync status", e);
            z = false;
        }
        return z;
    }

    public synchronized void updateRedactionDetail(RedactionDetail redactionDetail) {
        try {
            this.userDBHelper.getWritableDatabase().update(RedactionInfoTable.TABLE_NAME, redactionDetailToContentValues(redactionDetail), "user_local_id = ?", new String[]{String.valueOf(redactionDetail.userLocalId)});
        } catch (Exception e) {
            HSLogger.m3242e("Helpshift_UserDB", "Error in updating redaction detail", e);
        }
        return;
    }

    public synchronized void updateRedactionState(long j, RedactionState redactionState) {
        try {
            SQLiteDatabase writableDatabase = this.userDBHelper.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(RedactionInfoTable.Columns.REDACTION_STATE, Integer.valueOf(redactionState.ordinal()));
            writableDatabase.update(RedactionInfoTable.TABLE_NAME, contentValues, "user_local_id = ?", new String[]{String.valueOf(j)});
        } catch (Exception e) {
            HSLogger.m3242e("Helpshift_UserDB", "Error in updating redaction status", e);
        }
        return;
    }

    public synchronized boolean updateUser(UserDM userDM) {
        return updateUser(userDM, true);
    }

    public synchronized boolean updateUserMigrationState(String str, MigrationState migrationState) {
        boolean z;
        z = true;
        try {
            SQLiteDatabase writableDatabase = this.userDBHelper.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(LegacyProfileTable.Columns.MIGRATION_STATE, Integer.valueOf(migrationState.ordinal()));
            writableDatabase.update(LegacyProfileTable.TABLE_NAME, contentValues, "identifier = ?", new String[]{str});
        } catch (Exception e) {
            HSLogger.m3242e("Helpshift_UserDB", "Error in updating user migration sync status", e);
            z = false;
        }
        return z;
    }

    private synchronized UserDM createUser(UserDM userDM, boolean z) {
        Long l;
        try {
            l = Long.valueOf(this.userDBHelper.getWritableDatabase().insert(UserTable.TABLE_NAME, (String) null, userDMToContentValues(userDM)));
        } catch (Exception e) {
            HSLogger.m3242e("Helpshift_UserDB", "Error in creating user", e);
            if (z) {
                this.userDBHelper.close();
                return createUser(userDM, false);
            }
            l = null;
        }
        if (l == null) {
            return null;
        }
        return getUserDMWithLocalId(userDM, l.longValue());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0040, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean updateUser(com.helpshift.account.domainmodel.UserDM r9, boolean r10) {
        /*
            r8 = this;
            monitor-enter(r8)
            java.lang.Long r0 = r9.getLocalId()     // Catch:{ all -> 0x0041 }
            r1 = 0
            if (r0 != 0) goto L_0x000a
            monitor-exit(r8)
            return r1
        L_0x000a:
            r0 = 1
            com.helpshift.db.user.UserDBHelper r2 = r8.userDBHelper     // Catch:{ Exception -> 0x002a }
            android.database.sqlite.SQLiteDatabase r2 = r2.getWritableDatabase()     // Catch:{ Exception -> 0x002a }
            android.content.ContentValues r3 = r8.userDMToContentValues(r9)     // Catch:{ Exception -> 0x002a }
            java.lang.String r4 = "user_table"
            java.lang.String r5 = "_id = ?"
            java.lang.String[] r6 = new java.lang.String[r0]     // Catch:{ Exception -> 0x002a }
            java.lang.Long r7 = r9.getLocalId()     // Catch:{ Exception -> 0x002a }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x002a }
            r6[r1] = r7     // Catch:{ Exception -> 0x002a }
            r2.update(r4, r3, r5, r6)     // Catch:{ Exception -> 0x002a }
            r1 = 1
            goto L_0x003f
        L_0x002a:
            r0 = move-exception
            java.lang.String r2 = "Helpshift_UserDB"
            java.lang.String r3 = "Error in updating user"
            com.helpshift.util.HSLogger.m3242e(r2, r3, r0)     // Catch:{ all -> 0x0041 }
            if (r10 == 0) goto L_0x003f
            com.helpshift.db.user.UserDBHelper r10 = r8.userDBHelper     // Catch:{ all -> 0x0041 }
            r10.close()     // Catch:{ all -> 0x0041 }
            boolean r9 = r8.updateUser(r9, r1)     // Catch:{ all -> 0x0041 }
            monitor-exit(r8)
            return r9
        L_0x003f:
            monitor-exit(r8)
            return r1
        L_0x0041:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.account.dao.UserDB.updateUser(com.helpshift.account.domainmodel.UserDM, boolean):boolean");
    }

    public synchronized UserDM fetchUser(String str, String str2) {
        if (str == null && str2 == null) {
            return null;
        }
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        return getUser("identifier = ? AND email = ?", new String[]{str, str2}, true);
    }
}
