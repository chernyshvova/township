package com.helpshift.support.storage;

import com.helpshift.util.VersionName;

public interface SDKMigrator {
    void backup(VersionName versionName);

    void restore();
}
