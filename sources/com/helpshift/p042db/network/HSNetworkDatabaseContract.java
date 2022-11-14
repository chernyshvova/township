package com.helpshift.p042db.network;

import com.helpshift.p042db.base.DatabaseContract;
import com.helpshift.p042db.base.IMigrator;
import com.helpshift.p042db.network.tables.UrlMetadataTable;
import com.helpshift.support.p043db.SupportDBNameRepo;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* renamed from: com.helpshift.db.network.HSNetworkDatabaseContract */
public class HSNetworkDatabaseContract implements DatabaseContract {
    public static final String TAG = "HelpshiftNetworkDB";
    public final String CREATE_URL_METADATA_TABLE = "CREATE TABLE hs_url_metadata_table ( url TEXT PRIMARY KEY NOT NULL, last_fetch_ts INTEGER, etag TEXT, is_last_fetch_success INTEGER  );";

    public List<String> getCreateTableQueries() {
        return Arrays.asList(new String[]{"CREATE TABLE hs_url_metadata_table ( url TEXT PRIMARY KEY NOT NULL, last_fetch_ts INTEGER, etag TEXT, is_last_fetch_success INTEGER  );"});
    }

    public String getDatabaseName() {
        return SupportDBNameRepo.getNetworkDbName();
    }

    public int getDatabaseVersion() {
        return 1;
    }

    public List<IMigrator> getMigratorsForUpgrade(int i) {
        return Collections.emptyList();
    }

    public List<String> getTableNames() {
        return Arrays.asList(new String[]{UrlMetadataTable.TABLE_NAME});
    }

    public String getTag() {
        return TAG;
    }
}
