package com.helpshift.p042db.user;

import com.helpshift.p042db.base.DatabaseContract;
import com.helpshift.p042db.base.IMigrator;
import com.helpshift.p042db.user.migration.UserDbMigration_1_to_2;
import com.helpshift.p042db.user.tables.ClearedUserTable;
import com.helpshift.p042db.user.tables.LegacyAnalyticsEventIDTable;
import com.helpshift.p042db.user.tables.LegacyProfileTable;
import com.helpshift.p042db.user.tables.RedactionInfoTable;
import com.helpshift.p042db.user.tables.UserTable;
import com.helpshift.support.p043db.SupportDBNameRepo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.helpshift.db.user.UserDatabaseContract */
public class UserDatabaseContract implements DatabaseContract {
    public static final String TAG = "Helpshift_UserDB";
    public final String CREATE_CLEARED_USER_TABLE = "CREATE TABLE cleared_user_table ( _id INTEGER PRIMARY KEY AUTOINCREMENT, identifier TEXT, name TEXT, email TEXT, deviceid TEXT, auth_token TEXT, sync_state INTEGER );";
    public final String CREATE_LEGACY_ANALYTICS_EVENT_IDS_TABLE = "CREATE TABLE legacy_analytics_event_id_table ( identifier TEXT, analytics_event_id TEXT );";
    public final String CREATE_LEGACY_PROFILE_TABLE = "CREATE TABLE legacy_profile_table ( identifier TEXT PRIMARY KEY, name TEXT, email TEXT, serverid TEXT, migration_state INTEGER );";
    public final String CREATE_REDACTION_INFO_TABLE = "CREATE TABLE redaction_info_table ( user_local_id INTEGER PRIMARY KEY, redaction_state INTEGER , redaction_type INTEGER );";
    public final String CREATE_USER_TABLE = "CREATE TABLE user_table(_id INTEGER PRIMARY KEY AUTOINCREMENT, identifier TEXT, name TEXT, email TEXT, deviceid TEXT, auth_token TEXT, active INTEGER DEFAULT 0, anonymous INTEGER DEFAULT 0, issue_exists INTEGER DEFAULT 1, initial_state_synced INTEGER DEFAULT 0, push_token_synced INTEGER DEFAULT 0 );";

    public List<String> getCreateTableQueries() {
        return Arrays.asList(new String[]{"CREATE TABLE cleared_user_table ( _id INTEGER PRIMARY KEY AUTOINCREMENT, identifier TEXT, name TEXT, email TEXT, deviceid TEXT, auth_token TEXT, sync_state INTEGER );", "CREATE TABLE user_table(_id INTEGER PRIMARY KEY AUTOINCREMENT, identifier TEXT, name TEXT, email TEXT, deviceid TEXT, auth_token TEXT, active INTEGER DEFAULT 0, anonymous INTEGER DEFAULT 0, issue_exists INTEGER DEFAULT 1, initial_state_synced INTEGER DEFAULT 0, push_token_synced INTEGER DEFAULT 0 );", "CREATE TABLE legacy_analytics_event_id_table ( identifier TEXT, analytics_event_id TEXT );", "CREATE TABLE legacy_profile_table ( identifier TEXT PRIMARY KEY, name TEXT, email TEXT, serverid TEXT, migration_state INTEGER );", "CREATE TABLE redaction_info_table ( user_local_id INTEGER PRIMARY KEY, redaction_state INTEGER , redaction_type INTEGER );"});
    }

    public String getDatabaseName() {
        return SupportDBNameRepo.getUserDbName();
    }

    public int getDatabaseVersion() {
        return 2;
    }

    public List<IMigrator> getMigratorsForUpgrade(int i) {
        ArrayList arrayList = new ArrayList();
        if (i == 1) {
            arrayList.add(new UserDbMigration_1_to_2(this));
        }
        return arrayList;
    }

    public List<String> getTableNames() {
        return Arrays.asList(new String[]{UserTable.TABLE_NAME, RedactionInfoTable.TABLE_NAME, LegacyAnalyticsEventIDTable.TABLE_NAME, LegacyProfileTable.TABLE_NAME, ClearedUserTable.TABLE_NAME});
    }

    public String getTag() {
        return "Helpshift_UserDB";
    }
}
