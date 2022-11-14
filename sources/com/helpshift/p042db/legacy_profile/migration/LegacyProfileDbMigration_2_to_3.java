package com.helpshift.p042db.legacy_profile.migration;

import android.database.sqlite.SQLiteDatabase;
import com.helpshift.p042db.base.IMigrator;

/* renamed from: com.helpshift.db.legacy_profile.migration.LegacyProfileDbMigration_2_to_3 */
public class LegacyProfileDbMigration_2_to_3 implements IMigrator {
    public static final String ALTER_PROFILES_TABLE_ADD_PUSH_TOKEN_SYNC_STATUS = "ALTER TABLE profiles ADD push_token_sync INTEGER";

    public void migrate(SQLiteDatabase sQLiteDatabase) throws Exception {
        sQLiteDatabase.execSQL(ALTER_PROFILES_TABLE_ADD_PUSH_TOKEN_SYNC_STATUS);
    }
}
