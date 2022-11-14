package com.helpshift.android.commons.downloader.runnable;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.helpshift.android.commons.downloader.contracts.DownloadRequestedFileInfo;
import com.helpshift.android.commons.downloader.contracts.NetworkAuthDataFetcher;
import com.helpshift.android.commons.downloader.contracts.OnDownloadFinishListener;
import com.helpshift.android.commons.downloader.contracts.OnProgressChangedListener;
import com.helpshift.android.commons.downloader.storage.DownloadInProgressCacheDbStorage;
import java.io.File;

public class ExternalStorageDownloadRunnable extends StorageDownloadRunnable {
    public Context context;
    public boolean isNoMediaDir;
    public String relativePath;

    public ExternalStorageDownloadRunnable(Context context2, DownloadRequestedFileInfo downloadRequestedFileInfo, String str, boolean z, DownloadInProgressCacheDbStorage downloadInProgressCacheDbStorage, NetworkAuthDataFetcher networkAuthDataFetcher, OnProgressChangedListener onProgressChangedListener, OnDownloadFinishListener onDownloadFinishListener) {
        super(downloadRequestedFileInfo, downloadInProgressCacheDbStorage, networkAuthDataFetcher, onProgressChangedListener, onDownloadFinishListener);
        this.context = context2;
        this.relativePath = str;
        this.isNoMediaDir = z;
    }

    public File getCacheDir() {
        if (TextUtils.isEmpty(this.relativePath)) {
            return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        }
        return Environment.getExternalStoragePublicDirectory(this.relativePath);
    }

    public boolean isNoMediaDir() {
        if (this.relativePath != null) {
            return this.isNoMediaDir;
        }
        return false;
    }
}
