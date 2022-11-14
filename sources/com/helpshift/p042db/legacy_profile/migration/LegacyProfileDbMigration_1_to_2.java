package com.helpshift.p042db.legacy_profile.migration;

import android.database.sqlite.SQLiteDatabase;
import com.helpshift.p042db.base.IMigrator;

/* renamed from: com.helpshift.db.legacy_profile.migration.LegacyProfileDbMigration_1_to_2 */
public class LegacyProfileDbMigration_1_to_2 implements IMigrator {
    public final String ALTER_PROFILES_TABLE_ADD_DEVICE_ID = "ALTER TABLE profiles ADD did TEXT";
    public final String ALTER_PROFILES_TABLE_ADD_USER_ID = "ALTER TABLE profiles ADD uid TEXT";

    public void migrate(SQLiteDatabase sQLiteDatabase) throws Exception {
        sQLiteDatabase.execSQL("ALTER TABLE profiles ADD uid TEXT");
        sQLiteDatabase.execSQL("ALTER TABLE profiles ADD did TEXT");
    }
}
