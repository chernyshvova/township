package com.helpshift.android.commons.downloader;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.helpshift.android.commons.downloader.contracts.DownloadRequestedFileInfo;
import com.helpshift.android.commons.downloader.contracts.DownloaderKeyValueStorage;
import com.helpshift.android.commons.downloader.contracts.NetworkAuthDataFetcher;
import com.helpshift.android.commons.downloader.contracts.OnDownloadFinishListener;
import com.helpshift.android.commons.downloader.contracts.OnProgressChangedListener;
import com.helpshift.android.commons.downloader.runnable.BaseDownloadRunnable;
import com.helpshift.android.commons.downloader.runnable.ExternalStorageDownloadRunnable;
import com.helpshift.android.commons.downloader.runnable.FilteredViewExternalStorageDownloadRunnable;
import com.helpshift.android.commons.downloader.runnable.InternalStorageDownloadRunnable;
import com.helpshift.android.commons.downloader.runnable.MediaStoreDownloadRunnable;
import com.helpshift.android.commons.downloader.runnable.RawResponseDownloadRunnable;
import com.helpshift.android.commons.downloader.storage.DownloadInProgressCacheDbStorage;
import com.helpshift.android.commons.downloader.storage.DownloadManagerCacheDbStorage;
import com.helpshift.util.HSLogger;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadPoolExecutor;

public class DownloadManager {
    public static final String TAG = "Helpshift_DownloadMngr";
    public ConcurrentHashMap<String, ConcurrentLinkedQueue<OnDownloadFinishListener>> activeDownloadFinishListeners = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, ConcurrentLinkedQueue<OnProgressChangedListener>> activeProgressChangeListeners = new ConcurrentHashMap<>();
    public DownloadManagerCacheDbStorage cacheDbStorage;
    public Context context;
    public ThreadPoolExecutor downloadExecutor;
    public DownloaderKeyValueStorage storage;

    /* renamed from: com.helpshift.android.commons.downloader.DownloadManager$3 */
    public static /* synthetic */ class C24813 {

        /* renamed from: $SwitchMap$com$helpshift$android$commons$downloader$contracts$DownloadDirType */
        public static final /* synthetic */ int[] f3327xecde4a84;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|(2:1|2)|3|5|6|7|8|10) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
        static {
            /*
                com.helpshift.android.commons.downloader.contracts.DownloadDirType[] r0 = com.helpshift.android.commons.downloader.contracts.DownloadDirType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3327xecde4a84 = r0
                r1 = 1
                com.helpshift.android.commons.downloader.contracts.DownloadDirType r2 = com.helpshift.android.commons.downloader.contracts.DownloadDirType.INTERNAL_ONLY     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = f3327xecde4a84     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.helpshift.android.commons.downloader.contracts.DownloadDirType r3 = com.helpshift.android.commons.downloader.contracts.DownloadDirType.EXTERNAL_ONLY     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r1 = f3327xecde4a84     // Catch:{ NoSuchFieldError -> 0x001d }
                com.helpshift.android.commons.downloader.contracts.DownloadDirType r2 = com.helpshift.android.commons.downloader.contracts.DownloadDirType.EXTERNAL_OR_INTERNAL     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 3
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.helpshift.android.commons.downloader.DownloadManager.C24813.<clinit>():void");
        }
    }

    public DownloadManager(Context context2, DownloaderKeyValueStorage downloaderKeyValueStorage, ThreadPoolExecutor threadPoolExecutor) {
        this.context = context2;
        this.storage = downloaderKeyValueStorage;
        this.downloadExecutor = threadPoolExecutor;
        this.cacheDbStorage = new DownloadManagerCacheDbStorage(downloaderKeyValueStorage);
    }

    private BaseDownloadRunnable buildDownloadRunnable(DownloadRequestedFileInfo downloadRequestedFileInfo, DownloadConfig downloadConfig, NetworkAuthDataFetcher networkAuthDataFetcher) {
        OnProgressChangedListener onProgressChangedListener = getOnProgressChangedListener();
        OnDownloadFinishListener onDownloadFinishListener = getOnDownloadFinishListener(downloadConfig);
        if (!downloadConfig.writeToFile) {
            return new RawResponseDownloadRunnable(downloadRequestedFileInfo, networkAuthDataFetcher, onProgressChangedListener, onDownloadFinishListener);
        }
        DownloadInProgressCacheDbStorage downloadInProgressCacheDbStorage = new DownloadInProgressCacheDbStorage(downloadRequestedFileInfo, this.storage);
        int ordinal = downloadConfig.downloadDirType.ordinal();
        if (ordinal == 0) {
            return new InternalStorageDownloadRunnable(this.context, downloadRequestedFileInfo, downloadInProgressCacheDbStorage, networkAuthDataFetcher, onProgressChangedListener, onDownloadFinishListener);
        }
        if (ordinal != 1) {
            if (ordinal != 2) {
                throw new IllegalStateException("Unsupported download Dir type");
            } else if (isScopedStorageEnabled()) {
                return new FilteredViewExternalStorageDownloadRunnable(this.context, downloadRequestedFileInfo, downloadInProgressCacheDbStorage, networkAuthDataFetcher, onProgressChangedListener, onDownloadFinishListener);
            } else {
                if (!isExternalStoragePermissionGranted()) {
                    return new InternalStorageDownloadRunnable(this.context, downloadRequestedFileInfo, downloadInProgressCacheDbStorage, networkAuthDataFetcher, onProgressChangedListener, onDownloadFinishListener);
                }
                return new ExternalStorageDownloadRunnable(this.context, downloadRequestedFileInfo, downloadConfig.externalStorageDirectoryPath, downloadConfig.isNoMedia, downloadInProgressCacheDbStorage, networkAuthDataFetcher, onProgressChangedListener, onDownloadFinishListener);
            }
        } else if (isScopedStorageEnabled()) {
            return new MediaStoreDownloadRunnable(this.context, downloadRequestedFileInfo, downloadInProgressCacheDbStorage, networkAuthDataFetcher, onProgressChangedListener, onDownloadFinishListener);
        } else {
            if (isExternalStoragePermissionGranted()) {
                return new ExternalStorageDownloadRunnable(this.context, downloadRequestedFileInfo, downloadConfig.externalStorageDirectoryPath, downloadConfig.isNoMedia, downloadInProgressCacheDbStorage, networkAuthDataFetcher, onProgressChangedListener, onDownloadFinishListener);
            }
            throw new IllegalStateException("External storage permission is not granted on below Android-Q device");
        }
    }

    private String getAvailableCacheFile(String str) {
        String filePath = this.cacheDbStorage.getFilePath(str);
        if (TextUtils.isEmpty(filePath)) {
            return null;
        }
        if (!HsUriUtils.isValidUriPath(filePath)) {
            File file = new File(filePath);
            if (file.exists() && file.canRead()) {
                return filePath;
            }
            this.cacheDbStorage.removeFilePath(str);
        } else if (HsUriUtils.canReadFileAtUri(this.context, filePath)) {
            return filePath;
        } else {
            this.cacheDbStorage.removeFilePath(str);
        }
        return null;
    }

    private OnDownloadFinishListener getOnDownloadFinishListener(final DownloadConfig downloadConfig) {
        return new OnDownloadFinishListener() {
            public void onDownloadFinish(boolean z, String str, Object obj, int i, String str2) {
                if (z && downloadConfig.writeToFile) {
                    DownloadManager.this.cacheDbStorage.insertFilePath(str, obj.toString());
                }
                ConcurrentLinkedQueue remove = DownloadManager.this.activeDownloadFinishListeners.remove(str);
                DownloadManager.this.activeProgressChangeListeners.remove(str);
                if (remove != null) {
                    Iterator it = remove.iterator();
                    while (it.hasNext()) {
                        OnDownloadFinishListener onDownloadFinishListener = (OnDownloadFinishListener) it.next();
                        if (onDownloadFinishListener != null) {
                            onDownloadFinishListener.onDownloadFinish(z, str, obj, i, str2);
                        }
                    }
                }
            }
        };
    }

    private OnProgressChangedListener getOnProgressChangedListener() {
        return new OnProgressChangedListener() {
            public void onProgressChanged(String str, int i) {
                ConcurrentLinkedQueue concurrentLinkedQueue = DownloadManager.this.activeProgressChangeListeners.get(str);
                if (concurrentLinkedQueue != null) {
                    Iterator it = concurrentLinkedQueue.iterator();
                    while (it.hasNext()) {
                        OnProgressChangedListener onProgressChangedListener = (OnProgressChangedListener) it.next();
                        if (onProgressChangedListener != null) {
                            onProgressChangedListener.onProgressChanged(str, i);
                        }
                    }
                }
            }
        };
    }

    private boolean isExternalStoragePermissionGranted() {
        try {
            if (this.context.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", this.context.getPackageName()) == 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            HSLogger.m3238d(TAG, "Error checking for permission : " + "android.permission.WRITE_EXTERNAL_STORAGE", (Throwable) e);
            return false;
        }
    }

    private boolean isScopedStorageEnabled() {
        if (Build.VERSION.SDK_INT >= 29) {
            return !Environment.isExternalStorageLegacy();
        }
        return false;
    }

    public void startDownload(DownloadRequestedFileInfo downloadRequestedFileInfo, DownloadConfig downloadConfig, NetworkAuthDataFetcher networkAuthDataFetcher, OnProgressChangedListener onProgressChangedListener, OnDownloadFinishListener onDownloadFinishListener) {
        if (downloadConfig.useCache) {
            String availableCacheFile = getAvailableCacheFile(downloadRequestedFileInfo.url);
            if (!TextUtils.isEmpty(availableCacheFile)) {
                onDownloadFinishListener.onDownloadFinish(true, downloadRequestedFileInfo.url, availableCacheFile, 200, "");
                return;
            }
        }
        ConcurrentLinkedQueue concurrentLinkedQueue = this.activeDownloadFinishListeners.get(downloadRequestedFileInfo.url);
        ConcurrentLinkedQueue concurrentLinkedQueue2 = this.activeProgressChangeListeners.get(downloadRequestedFileInfo.url);
        if (concurrentLinkedQueue == null || concurrentLinkedQueue2 == null) {
            ConcurrentLinkedQueue concurrentLinkedQueue3 = new ConcurrentLinkedQueue();
            ConcurrentLinkedQueue concurrentLinkedQueue4 = new ConcurrentLinkedQueue();
            if (onDownloadFinishListener != null) {
                concurrentLinkedQueue3.add(onDownloadFinishListener);
            }
            if (onProgressChangedListener != null) {
                concurrentLinkedQueue4.add(onProgressChangedListener);
            }
            this.activeDownloadFinishListeners.put(downloadRequestedFileInfo.url, concurrentLinkedQueue3);
            this.activeProgressChangeListeners.put(downloadRequestedFileInfo.url, concurrentLinkedQueue4);
            this.downloadExecutor.execute(buildDownloadRunnable(downloadRequestedFileInfo, downloadConfig, networkAuthDataFetcher));
            return;
        }
        if (onDownloadFinishListener != null) {
            concurrentLinkedQueue.add(onDownloadFinishListener);
        }
        if (onProgressChangedListener != null) {
            concurrentLinkedQueue2.add(onProgressChangedListener);
        }
    }
}
