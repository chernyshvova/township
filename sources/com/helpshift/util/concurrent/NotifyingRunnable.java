package com.helpshift.util.concurrent;

import com.helpshift.util.HSLogger;
import java.util.concurrent.atomic.AtomicBoolean;

public class NotifyingRunnable implements Runnable {
    public static final String TAG = "Helpshift_NotiRunnable";
    public AtomicBoolean isFinished = new AtomicBoolean(false);
    public final Runnable runnable;
    public final Object syncLock = new Object();

    public NotifyingRunnable(Runnable runnable2) {
        this.runnable = runnable2;
    }

    public void run() {
        synchronized (this.syncLock) {
            try {
                this.runnable.run();
                this.isFinished.set(true);
                this.syncLock.notifyAll();
            } catch (Throwable th) {
                this.isFinished.set(true);
                this.syncLock.notifyAll();
                throw th;
            }
        }
    }

    public void waitForCompletion() {
        synchronized (this.syncLock) {
            while (!this.isFinished.get()) {
                try {
                    this.syncLock.wait();
                } catch (InterruptedException e) {
                    HSLogger.m3238d(TAG, "Exception in NotifyingRunnable", (Throwable) e);
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
