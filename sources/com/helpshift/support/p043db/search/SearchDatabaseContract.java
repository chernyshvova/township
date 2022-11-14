package com.helpshift.support.p043db.search;

import com.helpshift.p042db.base.DatabaseContract;
import com.helpshift.p042db.base.IMigrator;
import com.helpshift.support.p043db.SupportDBNameRepo;
import com.helpshift.support.p043db.search.tables.SearchTable;
import java.util.Collections;
import java.util.List;

/* renamed from: com.helpshift.support.db.search.SearchDatabaseContract */
public class SearchDatabaseContract implements DatabaseContract {
    public static final String TAG = "Helpshift_SearchDB";
    public final String CREATE_SEARCH_TABLE = "CREATE TABLE search_token_table (token TEXT PRIMARY KEY , type INTEGER , score TEXT NOT NULL  )";

    public List<String> getCreateTableQueries() {
        return Collections.singletonList("CREATE TABLE search_token_table (token TEXT PRIMARY KEY , type INTEGER , score TEXT NOT NULL  )");
    }

    public String getDatabaseName() {
        return SupportDBNameRepo.getSearchDbName();
    }

    public int getDatabaseVersion() {
        return 1;
    }

    public List<IMigrator> getMigratorsForUpgrade(int i) {
        return Collections.emptyList();
    }

    public List<String> getTableNames() {
        return Collections.singletonList(SearchTable.TABLE_NAME);
    }

    public String getTag() {
        return TAG;
    }
}
