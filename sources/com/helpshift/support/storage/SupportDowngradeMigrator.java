package com.helpshift.support.storage;

import com.helpshift.common.platform.KVStore;
import com.helpshift.util.HelpshiftContext;
import com.helpshift.util.StringUtils;
import com.helpshift.util.VersionName;

public class SupportDowngradeMigrator implements SDKMigrator {
    public String deviceId;
    public KVStore kvStore = HelpshiftContext.getPlatform().getKVStore();

    public void backup(VersionName versionName) {
        this.deviceId = this.kvStore.getString("key_support_device_id");
    }

    public void restore() {
        if (!StringUtils.isEmpty(this.deviceId)) {
            this.kvStore.setString("key_support_device_id", this.deviceId);
        }
    }
}
