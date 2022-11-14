package com.helpshift.android.commons.downloader.storage;

import com.helpshift.android.commons.downloader.contracts.DownloaderKeyValueStorage;

public class DownloadManagerCacheDbStorage extends BaseCacheDbStorage {
    public static final String KEY_CACHED_DOWNLOADS = "hs-cached-downloads";

    public DownloadManagerCacheDbStorage(DownloaderKeyValueStorage downloaderKeyValueStorage) {
        super(downloaderKeyValueStorage);
    }

    public String getStorageKey() {
        return KEY_CACHED_DOWNLOADS;
    }
}
