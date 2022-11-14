package com.helpshift.android.commons.downloader.runnable;

import android.text.TextUtils;
import android.util.Log;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.helpshift.android.commons.downloader.contracts.DownloadRequestedFileInfo;
import com.helpshift.android.commons.downloader.contracts.NetworkAuthDataFetcher;
import com.helpshift.android.commons.downloader.contracts.OnDownloadFinishListener;
import com.helpshift.android.commons.downloader.contracts.OnProgressChangedListener;
import com.helpshift.android.commons.downloader.storage.DownloadInProgressCacheDbStorage;
import com.helpshift.util.HSLogger;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public abstract class StorageDownloadRunnable extends BaseDownloadRunnable {
    public static final String TAG = "Helpshift_InterDownRun";
    public DownloadInProgressCacheDbStorage downloadInProgressCacheDbStorage;

    public StorageDownloadRunnable(DownloadRequestedFileInfo downloadRequestedFileInfo, DownloadInProgressCacheDbStorage downloadInProgressCacheDbStorage2, NetworkAuthDataFetcher networkAuthDataFetcher, OnProgressChangedListener onProgressChangedListener, OnDownloadFinishListener onDownloadFinishListener) {
        super(downloadRequestedFileInfo, networkAuthDataFetcher, onProgressChangedListener, onDownloadFinishListener);
        this.downloadInProgressCacheDbStorage = downloadInProgressCacheDbStorage2;
    }

    private void checkAndCreateNoMediaFile(File file) {
        try {
            File file2 = new File(file, ".nomedia");
            if (!file2.exists()) {
                file2.createNewFile();
            }
        } catch (IOException e) {
            Log.d(TAG, "Exception while creating no media file", e);
        }
    }

    private void deleteFile(File file) {
        if (file != null) {
            try {
                file.delete();
            } catch (Exception e) {
                HSLogger.m3242e(TAG, "Exception in deleting file ", e);
            }
        }
    }

    private String generateFileName() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("Support_");
        outline24.append(System.currentTimeMillis());
        String str = this.requestInfo.url;
        outline24.append(str.substring(str.lastIndexOf("/") + 1));
        return outline24.toString();
    }

    private File getFileToWriteResponseData() {
        File cachedFile = getCachedFile();
        if (cachedFile != null) {
            return cachedFile;
        }
        File cacheDir = getCacheDir();
        if (!cacheDir.exists()) {
            cacheDir.mkdirs();
        }
        if (isNoMediaDir()) {
            checkAndCreateNoMediaFile(cacheDir);
        }
        File file = new File(cacheDir, generateFileName());
        this.downloadInProgressCacheDbStorage.insertFilePath(file.getAbsolutePath());
        return file;
    }

    public void clearCache() {
        File cachedFile = getCachedFile();
        this.downloadInProgressCacheDbStorage.removeFilePath();
        deleteFile(cachedFile);
    }

    public long getAlreadyDownloadedBytes() {
        File cachedFile = getCachedFile();
        if (cachedFile != null) {
            return cachedFile.length();
        }
        return 0;
    }

    public abstract File getCacheDir();

    public File getCachedFile() {
        String filePath = this.downloadInProgressCacheDbStorage.getFilePath();
        if (TextUtils.isEmpty(filePath)) {
            return null;
        }
        File file = new File(filePath);
        if (file.exists() && file.canWrite()) {
            return file;
        }
        this.downloadInProgressCacheDbStorage.removeFilePath();
        return null;
    }

    public boolean isGzipSupported() {
        return false;
    }

    public abstract boolean isNoMediaDir();

    public void processHttpResponse(InputStream inputStream, int i, int i2, String str) throws IOException {
        long alreadyDownloadedBytes = getAlreadyDownloadedBytes();
        File fileToWriteResponseData = getFileToWriteResponseData();
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(fileToWriteResponseData, true);
            try {
                byte[] bArr = new byte[8192];
                long j = 0;
                while (true) {
                    int read = inputStream.read(bArr, 0, 8192);
                    if (read == -1) {
                        this.downloadInProgressCacheDbStorage.removeFilePath();
                        String absolutePath = fileToWriteResponseData.getAbsolutePath();
                        HSLogger.m3237d(TAG, "Download finished : " + this.requestInfo.url);
                        notifyDownloadFinish(true, absolutePath, i2, str);
                        closeFileStream(fileOutputStream2);
                        return;
                    } else if (read >= 0) {
                        fileOutputStream2.write(bArr, 0, read);
                        long length = (long) ((((float) fileToWriteResponseData.length()) / ((float) (((long) i) + alreadyDownloadedBytes))) * 100.0f);
                        if (length != j) {
                            notifyProgressChange((int) length);
                            j = length;
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                closeFileStream(fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            closeFileStream(fileOutputStream);
            throw th;
        }
    }
}
