package com.vungle.warren;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.vungle.warren.AdLoader;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.model.Placement;
import java.util.concurrent.ExecutorService;

public class DownloadCallbackWrapper implements AdLoader.DownloadCallback {
    public final AdLoader.DownloadCallback downloadCallback;
    public final ExecutorService executorService;

    public DownloadCallbackWrapper(ExecutorService executorService2, AdLoader.DownloadCallback downloadCallback2) {
        this.downloadCallback = downloadCallback2;
        this.executorService = executorService2;
    }

    public void onDownloadCompleted(@NonNull final AdRequest adRequest, @NonNull final String str) {
        if (this.downloadCallback != null) {
            this.executorService.execute(new Runnable() {
                public void run() {
                    DownloadCallbackWrapper.this.downloadCallback.onDownloadCompleted(adRequest, str);
                }
            });
        }
    }

    public void onDownloadFailed(@NonNull final VungleException vungleException, @NonNull final AdRequest adRequest, @Nullable final String str) {
        if (this.downloadCallback != null) {
            this.executorService.execute(new Runnable() {
                public void run() {
                    DownloadCallbackWrapper.this.downloadCallback.onDownloadFailed(vungleException, adRequest, str);
                }
            });
        }
    }

    public void onReady(@NonNull final AdRequest adRequest, @NonNull final Placement placement, @Nullable final Advertisement advertisement) {
        if (this.downloadCallback != null) {
            this.executorService.execute(new Runnable() {
                public void run() {
                    DownloadCallbackWrapper.this.downloadCallback.onReady(adRequest, placement, advertisement);
                }
            });
        }
    }
}
