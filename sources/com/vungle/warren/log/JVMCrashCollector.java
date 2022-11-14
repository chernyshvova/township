package com.vungle.warren.log;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.measurement.AppMeasurement;
import com.vungle.warren.VungleLogger;
import com.vungle.warren.log.LogManager;
import java.lang.Thread;

public class JVMCrashCollector implements Thread.UncaughtExceptionHandler {
    public String collectFilter = LogManager.sDefaultCollectFilter;
    public final Thread.UncaughtExceptionHandler defaultExceptionHandler;
    public LogManager.SdkLoggingEventListener sdkLoggingEventListener;

    public JVMCrashCollector(@NonNull LogManager.SdkLoggingEventListener sdkLoggingEventListener2) {
        this.sdkLoggingEventListener = sdkLoggingEventListener2;
        this.defaultExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (!(!this.sdkLoggingEventListener.isCrashReportEnabled() || thread == null || th == null)) {
            boolean z = false;
            for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
                StackTraceElement[] stackTrace = th2.getStackTrace();
                int length = stackTrace.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if (stackTrace[i].getClassName().startsWith(this.collectFilter)) {
                        z = true;
                        break;
                    } else {
                        i++;
                    }
                }
            }
            if (z) {
                this.sdkLoggingEventListener.saveLog(VungleLogger.LoggerLevel.CRASH, AppMeasurement.CRASH_ORIGIN, Log.getStackTraceString(th), th.getClass().toString(), String.valueOf(thread.getId()));
            }
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.defaultExceptionHandler;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    public void updateConfig(@NonNull String str) {
        this.collectFilter = str;
    }
}
