package com.helpshift.util.concurrent;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public class HandlerThreadExecutor implements ApiExecutor {
    public Handler handler;
    public final Object syncLock = new Object();
    public Handler uiHandler;

    public HandlerThreadExecutor(String str) {
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        this.handler = new Handler(handlerThread.getLooper());
        this.uiHandler = new Handler(Looper.getMainLooper());
    }

    public void awaitForSyncExecution() {
        runSync(new Runnable() {
            public void run() {
            }
        });
    }

    public void runAsync(Runnable runnable) {
        this.handler.post(runnable);
    }

    public void runOnUiThread(final Runnable runnable) {
        runAsync(new Runnable() {
            public void run() {
                HandlerThreadExecutor.this.uiHandler.post(runnable);
            }
        });
    }

    public void runSync(Runnable runnable) {
        NotifyingRunnable notifyingRunnable = new NotifyingRunnable(runnable);
        synchronized (this.syncLock) {
            this.handler.post(notifyingRunnable);
            notifyingRunnable.waitForCompletion();
        }
    }
}
