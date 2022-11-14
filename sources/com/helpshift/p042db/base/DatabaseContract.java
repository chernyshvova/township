package com.helpshift.p042db.base;

import java.util.List;

/* renamed from: com.helpshift.db.base.DatabaseContract */
public interface DatabaseContract {
    List<String> getCreateTableQueries();

    String getDatabaseName();

    int getDatabaseVersion();

    List<IMigrator> getMigratorsForUpgrade(int i);

    List<String> getTableNames();

    String getTag();
}
