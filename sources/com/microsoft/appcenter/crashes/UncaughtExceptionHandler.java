package com.microsoft.appcenter.crashes;

import android.os.Process;
import com.microsoft.appcenter.crashes.utils.ErrorLogHelper;
import com.microsoft.appcenter.utils.AppCenterLog;
import java.io.IOException;
import java.lang.Thread;
import org.json.JSONException;

public class UncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    public Thread.UncaughtExceptionHandler mDefaultUncaughtExceptionHandler;
    public boolean mIgnoreDefaultExceptionHandler = false;

    public void uncaughtException(Thread thread, Throwable th) {
        Crashes instance = Crashes.getInstance();
        if (instance != null) {
            try {
                instance.saveUncaughtException(thread, th, ErrorLogHelper.getModelExceptionFromThrowable(th));
            } catch (JSONException e) {
                AppCenterLog.error("AppCenterCrashes", "Error serializing error log to JSON", e);
            } catch (IOException e2) {
                AppCenterLog.error("AppCenterCrashes", "Error writing error log to file", e2);
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.mDefaultUncaughtExceptionHandler;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
                return;
            }
            Process.killProcess(Process.myPid());
            System.exit(10);
            return;
        }
        throw null;
    }
}
