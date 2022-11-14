package com.helpshift.android.commons.downloader.runnable;

import android.content.Context;
import com.helpshift.android.commons.downloader.contracts.DownloadRequestedFileInfo;
import com.helpshift.android.commons.downloader.contracts.NetworkAuthDataFetcher;
import com.helpshift.android.commons.downloader.contracts.OnDownloadFinishListener;
import com.helpshift.android.commons.downloader.contracts.OnProgressChangedListener;
import com.helpshift.android.commons.downloader.storage.DownloadInProgressCacheDbStorage;
import java.io.File;

public class FilteredViewExternalStorageDownloadRunnable extends StorageDownloadRunnable {
    public Context context;

    public FilteredViewExternalStorageDownloadRunnable(Context context2, DownloadRequestedFileInfo downloadRequestedFileInfo, DownloadInProgressCacheDbStorage downloadInProgressCacheDbStorage, NetworkAuthDataFetcher networkAuthDataFetcher, OnProgressChangedListener onProgressChangedListener, OnDownloadFinishListener onDownloadFinishListener) {
        super(downloadRequestedFileInfo, downloadInProgressCacheDbStorage, networkAuthDataFetcher, onProgressChangedListener, onDownloadFinishListener);
        this.context = context2;
    }

    public File getCacheDir() {
        return this.context.getExternalFilesDir((String) null);
    }

    public boolean isNoMediaDir() {
        return false;
    }
}
