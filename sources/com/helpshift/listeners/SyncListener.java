package com.helpshift.listeners;

import java.util.Set;

public abstract class SyncListener {
    public String dataType;

    public SyncListener(String str) {
        this.dataType = str;
    }

    public void fullSync() {
    }

    public String getDataType() {
        return this.dataType;
    }

    public Set<String> getDependentChildDataTypes() {
        return null;
    }

    public abstract boolean isFullSyncEnabled();

    public abstract void sync();
}
