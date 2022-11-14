package com.helpshift.p042db.key_value;

import com.helpshift.p042db.base.DatabaseContract;
import com.helpshift.p042db.base.IMigrator;
import com.helpshift.p042db.key_value.tables.KeyValueTable;
import com.helpshift.support.p043db.SupportDBNameRepo;
import java.util.Collections;
import java.util.List;

/* renamed from: com.helpshift.db.key_value.KeyValueDatabaseContract */
public class KeyValueDatabaseContract implements DatabaseContract {
    public static final String TAG = "Helpshift_KeyValueDB";
    public final String CREATE_KEY_VALUE_TABLE = "CREATE TABLE key_value_store(key text primary key,value blob not null);";

    public List<String> getCreateTableQueries() {
        return Collections.singletonList("CREATE TABLE key_value_store(key text primary key,value blob not null);");
    }

    public String getDatabaseName() {
        return SupportDBNameRepo.getKeyvalueDbName();
    }

    public int getDatabaseVersion() {
        return 1;
    }

    public List<IMigrator> getMigratorsForUpgrade(int i) {
        return Collections.emptyList();
    }

    public List<String> getTableNames() {
        return Collections.singletonList(KeyValueTable.TABLE_NAME);
    }

    public String getTag() {
        return TAG;
    }
}
