package com.playrix.engine;

import android.util.Log;

public class Logger {
    public static final int LOG_LEVEL_DEBUG = 0;
    public static final int LOG_LEVEL_ERROR = 3;
    public static final int LOG_LEVEL_FATAL = 4;
    public static final int LOG_LEVEL_INFO = 1;
    public static final int LOG_LEVEL_WARN = 2;

    public static void log(final int i, final String str) {
        Engine.runOnGLThread(new Runnable() {
            public void run() {
                Logger.nativeLog(i, str);
            }
        });
    }

    public static void logDebug(String str) {
        log(0, str);
    }

    public static void logError(String str) {
        log(3, str);
    }

    public static void logFatal(String str) {
        log(4, str);
    }

    public static void logInfo(String str) {
        log(1, str);
    }

    public static void logWarning(String str) {
        log(2, str);
    }

    public static native void nativeLog(int i, String str);

    public static void sysDebug(String str) {
        systemLog(0, str);
    }

    public static void sysError(String str) {
        systemLog(3, str);
    }

    public static void sysFatal(String str) {
        systemLog(4, str);
    }

    public static void sysInfo(String str) {
        systemLog(1, str);
    }

    public static void sysWarning(String str) {
        systemLog(2, str);
    }

    public static void systemLog(int i, String str) {
        int i2 = 3;
        if (i != 0) {
            i2 = i != 1 ? i != 2 ? i != 3 ? 7 : 6 : 5 : 4;
        }
        Log.println(i2, EngineActivity.LOG_TAG, str);
    }
}
