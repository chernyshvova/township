package com.helpshift.p042db.user.migration;

import android.database.sqlite.SQLiteDatabase;
import com.helpshift.p042db.base.IMigrator;
import com.helpshift.p042db.user.UserDatabaseContract;

/* renamed from: com.helpshift.db.user.migration.UserDbMigration_1_to_2 */
public class UserDbMigration_1_to_2 implements IMigrator {
    public UserDatabaseContract contract;

    public UserDbMigration_1_to_2(UserDatabaseContract userDatabaseContract) {
        this.contract = userDatabaseContract;
    }

    public void migrate(SQLiteDatabase sQLiteDatabase) throws Exception {
        this.contract.getClass();
        sQLiteDatabase.execSQL("CREATE TABLE redaction_info_table ( user_local_id INTEGER PRIMARY KEY, redaction_state INTEGER , redaction_type INTEGER );");
    }
}
