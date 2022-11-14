package com.helpshift.account.dao.legacy;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.helpshift.account.dao.ProfileDTO;
import com.helpshift.migration.legacyUser.LegacyProfileDAO;
import com.helpshift.p042db.legacy_profile.LegacyProfileDBHelper;
import com.helpshift.p042db.legacy_profile.LegacyProfileDatabaseContract;
import com.helpshift.p042db.legacy_profile.tables.ProfileTable;

public class AndroidLegacyProfileDAO implements LegacyProfileDAO {
    public static final String TAG = "Helpshift_ALProfileDAO";
    public static AndroidLegacyProfileDAO instance;
    public LegacyProfileDBHelper dbHelper;

    public AndroidLegacyProfileDAO(Context context) {
        this.dbHelper = new LegacyProfileDBHelper(context, new LegacyProfileDatabaseContract());
    }

    private ProfileDTO cursorToProfile(Cursor cursor) {
        return new ProfileDTO(Long.valueOf(cursor.getLong(cursor.getColumnIndex("_id"))), cursor.getString(getColumnIndexForIdentifier(cursor)), cursor.getString(cursor.getColumnIndex(ProfileTable.Columns.COLUMN_PROFILE_ID)), cursor.getString(cursor.getColumnIndex("name")), cursor.getString(cursor.getColumnIndex("email")), cursor.getString(cursor.getColumnIndex(ProfileTable.Columns.COLUMN_SALT)), cursor.getString(cursor.getColumnIndex(ProfileTable.Columns.COLUMN_UID)), cursor.getString(cursor.getColumnIndex(ProfileTable.Columns.COLUMN_DID)), cursor.getInt(cursor.getColumnIndex(ProfileTable.Columns.COLUMN_PUSH_TOKEN_SYNC_STATUS)) == 1);
    }

    public static int getColumnIndexForIdentifier(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex(ProfileTable.Columns.COLUMN_IDENTIFIER);
        return columnIndex == -1 ? cursor.getColumnIndex(ProfileTable.Columns.COLUMN_IDENTIFIER.toLowerCase()) : columnIndex;
    }

    public static synchronized AndroidLegacyProfileDAO getInstance(Context context) {
        AndroidLegacyProfileDAO androidLegacyProfileDAO;
        synchronized (AndroidLegacyProfileDAO.class) {
            if (instance == null) {
                instance = new AndroidLegacyProfileDAO(context);
            }
            androidLegacyProfileDAO = instance;
        }
        return androidLegacyProfileDAO;
    }

    public void deleteProfiles() {
        SQLiteDatabase writableDatabase = this.dbHelper.getWritableDatabase();
        if (writableDatabase != null) {
            writableDatabase.execSQL("DROP TABLE IF EXISTS profiles");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.helpshift.account.dao.ProfileDTO> fetchProfiles() {
        /*
            r11 = this;
            r0 = 0
            com.helpshift.db.legacy_profile.LegacyProfileDBHelper r1 = r11.dbHelper     // Catch:{ Exception -> 0x003d, all -> 0x0038 }
            android.database.sqlite.SQLiteDatabase r2 = r1.getReadableDatabase()     // Catch:{ Exception -> 0x003d, all -> 0x0038 }
            java.lang.String r3 = "profiles"
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x003d, all -> 0x0038 }
            boolean r2 = r1.moveToFirst()     // Catch:{ Exception -> 0x0033 }
            if (r2 == 0) goto L_0x002f
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x0033 }
            r2.<init>()     // Catch:{ Exception -> 0x0033 }
        L_0x001e:
            com.helpshift.account.dao.ProfileDTO r0 = r11.cursorToProfile(r1)     // Catch:{ Exception -> 0x002d }
            r2.add(r0)     // Catch:{ Exception -> 0x002d }
            boolean r0 = r1.moveToNext()     // Catch:{ Exception -> 0x002d }
            if (r0 != 0) goto L_0x001e
            r0 = r2
            goto L_0x002f
        L_0x002d:
            r0 = move-exception
            goto L_0x0041
        L_0x002f:
            r1.close()
            goto L_0x004e
        L_0x0033:
            r2 = move-exception
            r10 = r2
            r2 = r0
            r0 = r10
            goto L_0x0041
        L_0x0038:
            r1 = move-exception
            r10 = r1
            r1 = r0
            r0 = r10
            goto L_0x0050
        L_0x003d:
            r1 = move-exception
            r2 = r0
            r0 = r1
            r1 = r2
        L_0x0041:
            java.lang.String r3 = "Helpshift_ALProfileDAO"
            java.lang.String r4 = "Error in fetchProfiles"
            com.helpshift.util.HSLogger.m3242e(r3, r4, r0)     // Catch:{ all -> 0x004f }
            if (r1 == 0) goto L_0x004d
            r1.close()
        L_0x004d:
            r0 = r2
        L_0x004e:
            return r0
        L_0x004f:
            r0 = move-exception
        L_0x0050:
            if (r1 == 0) goto L_0x0055
            r1.close()
        L_0x0055:
            goto L_0x0057
        L_0x0056:
            throw r0
        L_0x0057:
            goto L_0x0056
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.account.dao.legacy.AndroidLegacyProfileDAO.fetchProfiles():java.util.List");
    }
}
