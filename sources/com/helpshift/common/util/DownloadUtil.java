package com.helpshift.common.util;

import com.helpshift.common.domain.Domain;
import com.helpshift.common.domain.network.AuthDataProvider;
import com.helpshift.common.platform.Platform;
import com.helpshift.downloader.AdminFileInfo;
import com.helpshift.downloader.SupportDownloadStateChangeListener;
import com.helpshift.downloader.SupportDownloader;
import com.helpshift.util.StringUtils;

public class DownloadUtil {

    public interface OnFileDownloadFinishListener {
        void onFileDownloadFailure(String str, int i, String str2);

        void onFileDownloadSuccess(String str, String str2, String str3, String str4);
    }

    public static void downloadFile(Platform platform, Domain domain, String str, String str2, OnFileDownloadFinishListener onFileDownloadFinishListener) {
        if (!StringUtils.isEmpty(str)) {
            downloadFileInternal(platform, domain, new AdminFileInfo(str, str, (String) null, false), str2, onFileDownloadFinishListener);
        }
    }

    public static void downloadFileInternal(Platform platform, Domain domain, AdminFileInfo adminFileInfo, final String str, final OnFileDownloadFinishListener onFileDownloadFinishListener) {
        platform.getDownloader().startDownload(adminFileInfo, SupportDownloader.StorageDirType.INTERNAL_ONLY, new AuthDataProvider(domain, platform, adminFileInfo.url), new SupportDownloadStateChangeListener() {
            public void onFailure(String str, int i) {
                OnFileDownloadFinishListener onFileDownloadFinishListener = onFileDownloadFinishListener;
                if (onFileDownloadFinishListener != null) {
                    onFileDownloadFinishListener.onFileDownloadFailure(str, i, str);
                }
            }

            public void onProgressChange(String str, int i) {
            }

            public void onSuccess(String str, String str2, String str3) {
                OnFileDownloadFinishListener onFileDownloadFinishListener = onFileDownloadFinishListener;
                if (onFileDownloadFinishListener != null) {
                    onFileDownloadFinishListener.onFileDownloadSuccess(str, str2, str3, str);
                }
            }
        });
    }

    public static void downloadFile(Platform platform, Domain domain, boolean z, String str, String str2, String str3, OnFileDownloadFinishListener onFileDownloadFinishListener) {
        if (!StringUtils.isEmpty(str2)) {
            downloadFileInternal(platform, domain, new AdminFileInfo(str2, str2, (String) null, false, str3, z), str, onFileDownloadFinishListener);
        }
    }
}
