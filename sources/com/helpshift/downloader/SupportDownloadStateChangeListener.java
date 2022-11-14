package com.helpshift.downloader;

public interface SupportDownloadStateChangeListener {
    void onFailure(String str, int i);

    void onProgressChange(String str, int i);

    void onSuccess(String str, String str2, String str3);
}
