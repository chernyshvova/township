package com.microsoft.appcenter.utils;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.VisibleForTesting;

public class HandlerUtils {
    @VisibleForTesting
    public static final Handler sMainHandler = new Handler(Looper.getMainLooper());

    public static void runOnUiThread(Runnable runnable) {
        if (Thread.currentThread() == sMainHandler.getLooper().getThread()) {
            runnable.run();
        } else {
            sMainHandler.post(runnable);
        }
    }
}
