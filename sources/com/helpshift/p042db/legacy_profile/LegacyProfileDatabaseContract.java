package com.helpshift.p042db.legacy_profile;

import com.helpshift.p042db.base.DatabaseContract;
import com.helpshift.p042db.base.IMigrator;
import com.helpshift.p042db.legacy_profile.migration.LegacyProfileDbMigration_1_to_2;
import com.helpshift.p042db.legacy_profile.migration.LegacyProfileDbMigration_2_to_3;
import com.helpshift.p042db.user.tables.LegacyProfileTable;
import com.helpshift.support.p043db.SupportDBNameRepo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.helpshift.db.legacy_profile.LegacyProfileDatabaseContract */
public class LegacyProfileDatabaseContract implements DatabaseContract {
    public static final String TAG = "Helpshift_LProfileDB";
    public final String CREATE_PROFILE_TABLE = "CREATE TABLE profiles(_id INTEGER PRIMARY KEY AUTOINCREMENT, IDENTIFIER TEXT NOT NULL UNIQUE, profile_id TEXT UNIQUE, name TEXT, email TEXT, salt TEXT, uid TEXT, did TEXT, push_token_sync INTEGER );";

    public List<String> getCreateTableQueries() {
        return Collections.singletonList("CREATE TABLE profiles(_id INTEGER PRIMARY KEY AUTOINCREMENT, IDENTIFIER TEXT NOT NULL UNIQUE, profile_id TEXT UNIQUE, name TEXT, email TEXT, salt TEXT, uid TEXT, did TEXT, push_token_sync INTEGER );");
    }

    public String getDatabaseName() {
        return SupportDBNameRepo.getLegacyProfileDbName();
    }

    public int getDatabaseVersion() {
        return 3;
    }

    public List<IMigrator> getMigratorsForUpgrade(int i) {
        ArrayList arrayList = new ArrayList();
        if (i < 2) {
            arrayList.add(new LegacyProfileDbMigration_1_to_2());
        }
        if (i < 3) {
            arrayList.add(new LegacyProfileDbMigration_2_to_3());
        }
        return arrayList;
    }

    public List<String> getTableNames() {
        return Collections.singletonList(LegacyProfileTable.TABLE_NAME);
    }

    public String getTag() {
        return TAG;
    }
}
