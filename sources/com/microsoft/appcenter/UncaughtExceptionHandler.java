package com.microsoft.appcenter;

import android.os.Handler;
import android.os.Process;
import com.microsoft.appcenter.channel.Channel;
import com.microsoft.appcenter.channel.DefaultChannel;
import com.microsoft.appcenter.utils.AppCenterLog;
import java.lang.Thread;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class UncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    public final Channel mChannel;
    public Thread.UncaughtExceptionHandler mDefaultUncaughtExceptionHandler;
    public final Handler mHandler;

    public UncaughtExceptionHandler(Handler handler, Channel channel) {
        this.mHandler = handler;
        this.mChannel = channel;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (AppCenter.getInstance().isInstanceEnabled()) {
            final Semaphore semaphore = new Semaphore(0);
            this.mHandler.post(new Runnable() {
                public void run() {
                    DefaultChannel defaultChannel = (DefaultChannel) UncaughtExceptionHandler.this.mChannel;
                    defaultChannel.mEnabled = false;
                    defaultChannel.suspend(false, new CancellationException());
                    AppCenterLog.debug("AppCenter", "Channel completed shutdown.");
                    semaphore.release();
                }
            });
            try {
                if (!semaphore.tryAcquire(5000, TimeUnit.MILLISECONDS)) {
                    AppCenterLog.error("AppCenter", "Timeout waiting for looper tasks to complete.");
                }
            } catch (InterruptedException e) {
                AppCenterLog.warn("AppCenter", "Interrupted while waiting looper to flush.", e);
            }
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.mDefaultUncaughtExceptionHandler;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
            return;
        }
        Process.killProcess(Process.myPid());
        System.exit(10);
    }
}
