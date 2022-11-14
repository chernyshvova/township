package com.helpshift.common.platform;

import android.content.Context;
import com.helpshift.android.commons.downloader.DownloadConfig;
import com.helpshift.android.commons.downloader.DownloadManager;
import com.helpshift.android.commons.downloader.contracts.DownloadDirType;
import com.helpshift.android.commons.downloader.contracts.DownloadRequestedFileInfo;
import com.helpshift.android.commons.downloader.contracts.NetworkAuthDataFetcher;
import com.helpshift.android.commons.downloader.contracts.OnDownloadFinishListener;
import com.helpshift.android.commons.downloader.contracts.OnProgressChangedListener;
import com.helpshift.common.domain.HSThreadFactory;
import com.helpshift.common.domain.network.AuthDataProvider;
import com.helpshift.common.platform.network.Method;
import com.helpshift.downloader.AdminFileInfo;
import com.helpshift.downloader.SupportDownloadStateChangeListener;
import com.helpshift.downloader.SupportDownloader;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AndroidSupportDownloader implements SupportDownloader {
    public static final int CORE_POOL_SIZE = 5;
    public static final int KEEP_ALIVE_TIME = 1;
    public static final TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;
    public static final int MAXIMUM_POOL_SIZE = 5;
    public Map<String, Set<SupportDownloadStateChangeListener>> callbackManager = new HashMap();
    public Context context;
    public final DownloadManager downloadManager;

    /* renamed from: com.helpshift.common.platform.AndroidSupportDownloader$4 */
    public static /* synthetic */ class C25124 {

        /* renamed from: $SwitchMap$com$helpshift$downloader$SupportDownloader$StorageDirType */
        public static final /* synthetic */ int[] f3331x3c4e7675;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|(2:1|2)|3|5|6|7|8|10) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
        static {
            /*
                com.helpshift.downloader.SupportDownloader$StorageDirType[] r0 = com.helpshift.downloader.SupportDownloader.StorageDirType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3331x3c4e7675 = r0
                r1 = 1
                com.helpshift.downloader.SupportDownloader$StorageDirType r2 = com.helpshift.downloader.SupportDownloader.StorageDirType.INTERNAL_ONLY     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = f3331x3c4e7675     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.helpshift.downloader.SupportDownloader$StorageDirType r3 = com.helpshift.downloader.SupportDownloader.StorageDirType.EXTERNAL_ONLY     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r1 = f3331x3c4e7675     // Catch:{ NoSuchFieldError -> 0x001d }
                com.helpshift.downloader.SupportDownloader$StorageDirType r2 = com.helpshift.downloader.SupportDownloader.StorageDirType.EXTERNAL_OR_INTERNAL     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 3
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.helpshift.common.platform.AndroidSupportDownloader.C25124.<clinit>():void");
        }
    }

    public AndroidSupportDownloader(Context context2, KVStore kVStore) {
        this.context = context2;
        this.downloadManager = new DownloadManager(context2, new SupportDownloaderKVStorage(kVStore), new ThreadPoolExecutor(5, 5, 1, KEEP_ALIVE_TIME_UNIT, new LinkedBlockingQueue(), new HSThreadFactory("sp-dwnld")));
    }

    private synchronized void addCallback(String str, SupportDownloadStateChangeListener supportDownloadStateChangeListener) {
        if (supportDownloadStateChangeListener != null) {
            Set set = this.callbackManager.get(str);
            if (set == null) {
                set = new HashSet();
            }
            set.add(supportDownloadStateChangeListener);
            this.callbackManager.put(str, set);
        }
    }

    private DownloadConfig buildDownloadConfig(SupportDownloader.StorageDirType storageDirType, boolean z) {
        DownloadDirType downloadDirType;
        int ordinal = storageDirType.ordinal();
        boolean z2 = false;
        if (ordinal == 0) {
            downloadDirType = DownloadDirType.INTERNAL_ONLY;
            z2 = true;
        } else if (ordinal == 1) {
            downloadDirType = DownloadDirType.EXTERNAL_ONLY;
        } else if (ordinal == 2) {
            downloadDirType = DownloadDirType.EXTERNAL_OR_INTERNAL;
        } else {
            throw new IllegalStateException("Unsupported download Dir type");
        }
        return new DownloadConfig.Builder().setUseCache(z).setIsNoMedia(z2).setWriteToFile(true).setDownloadDirType(downloadDirType).create();
    }

    private synchronized Set<SupportDownloadStateChangeListener> getAndRemoveCallbacks(String str) {
        Set<SupportDownloadStateChangeListener> callbacks;
        callbacks = getCallbacks(str);
        removeCallbacks(str);
        return callbacks;
    }

    private synchronized Set<SupportDownloadStateChangeListener> getCallbacks(String str) {
        HashSet hashSet;
        Set set = this.callbackManager.get(str);
        if (set == null) {
            hashSet = new HashSet();
        } else {
            hashSet = new HashSet(set);
        }
        return hashSet;
    }

    private synchronized void removeCallbacks(String str) {
        this.callbackManager.remove(str);
    }

    public void handleDownloadFailure(String str, int i) {
        for (SupportDownloadStateChangeListener onFailure : getAndRemoveCallbacks(str)) {
            onFailure.onFailure(str, i);
        }
    }

    public void handleDownloadSuccess(String str, String str2, String str3) {
        for (SupportDownloadStateChangeListener onSuccess : getAndRemoveCallbacks(str)) {
            onSuccess.onSuccess(str, str2, str3);
        }
    }

    public void handleProgressChange(String str, int i) {
        for (SupportDownloadStateChangeListener onProgressChange : getCallbacks(str)) {
            onProgressChange.onProgressChange(str, i);
        }
    }

    public void startDownload(AdminFileInfo adminFileInfo, SupportDownloader.StorageDirType storageDirType, final AuthDataProvider authDataProvider, SupportDownloadStateChangeListener supportDownloadStateChangeListener) {
        addCallback(adminFileInfo.url, supportDownloadStateChangeListener);
        this.downloadManager.startDownload(new DownloadRequestedFileInfo(adminFileInfo.url, adminFileInfo.isSecureAttachment, adminFileInfo.contentType, adminFileInfo.etag), buildDownloadConfig(storageDirType, !adminFileInfo.skipCaching), new NetworkAuthDataFetcher() {
            public Map<String, String> getAuthData(Map<String, String> map) throws GeneralSecurityException {
                return authDataProvider.getAuthData(Method.GET, map);
            }
        }, new OnProgressChangedListener() {
            public void onProgressChanged(String str, int i) {
                AndroidSupportDownloader.this.handleProgressChange(str, i);
            }
        }, new OnDownloadFinishListener() {
            public void onDownloadFinish(boolean z, String str, Object obj, int i, String str2) {
                if (z) {
                    AndroidSupportDownloader.this.handleDownloadSuccess(str, obj.toString(), str2);
                    return;
                }
                AndroidSupportDownloader.this.handleDownloadFailure(str, i);
            }
        });
    }
}
