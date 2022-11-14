package com.helpshift.common.platform;

import com.helpshift.android.commons.downloader.contracts.DownloaderKeyValueStorage;
import java.io.Serializable;

public class SupportDownloaderKVStorage implements DownloaderKeyValueStorage {
    public final KVStore kvStore;

    public SupportDownloaderKVStorage(KVStore kVStore) {
        this.kvStore = kVStore;
    }

    public Object get(String str) {
        return this.kvStore.getSerializable(str);
    }

    public boolean set(String str, Serializable serializable) {
        this.kvStore.setSerializable(str, serializable);
        return true;
    }
}
