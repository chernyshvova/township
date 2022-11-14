package com.helpshift.android.commons.downloader.storage;

import com.helpshift.android.commons.downloader.contracts.DownloadRequestedFileInfo;
import com.helpshift.android.commons.downloader.contracts.DownloaderKeyValueStorage;

public class DownloadInProgressCacheDbStorage extends BaseCacheDbStorage {
    public static final String DOWNLOAD_MANAGER_DB_KEY = "kDownloadManagerCachedFiles";
    public DownloadRequestedFileInfo requestInfo;

    public DownloadInProgressCacheDbStorage(DownloadRequestedFileInfo downloadRequestedFileInfo, DownloaderKeyValueStorage downloaderKeyValueStorage) {
        super(downloaderKeyValueStorage);
        this.requestInfo = downloadRequestedFileInfo;
    }

    public String getFilePath() {
        return getFilePath(this.requestInfo.url);
    }

    public String getStorageKey() {
        return "kDownloadManagerCachedFiles";
    }

    public void insertFilePath(String str) {
        insertFilePath(this.requestInfo.url, str);
    }

    public void removeFilePath() {
        removeFilePath(this.requestInfo.url);
    }
}
