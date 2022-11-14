package com.helpshift.util;

import com.helpshift.logger.ILogger;
import com.helpshift.logger.logmodels.ILogExtrasModel;
import com.helpshift.logger.model.LogModel;
import java.util.List;

public class HSLogger {
    public static final String LOG_STORE_DB_NAME = "__hs_log_store";
    public static final String OLD_ERROR_REPORTING_DATABASE_NAME = "__hs__db_error_reports";
    public static ILogger logger;

    /* renamed from: d */
    public static void m3237d(String str, String str2) {
        m3239d(str, str2, (Throwable) null, (ILogExtrasModel[]) null);
    }

    public static void deleteAll() {
        ILogger iLogger = logger;
        if (iLogger != null) {
            iLogger.deleteAllCachedLogs();
        }
    }

    /* renamed from: e */
    public static void m3241e(String str, String str2) {
        m3244e(str, str2, (Throwable[]) null, (ILogExtrasModel[]) null);
    }

    public static void enableLogging(boolean z, boolean z2) {
        ILogger iLogger = logger;
        if (iLogger != null) {
            iLogger.enableLogging(z, z2);
        }
    }

    /* renamed from: f */
    public static void m3245f(String str, String str2, Throwable th, ILogExtrasModel... iLogExtrasModelArr) {
        logMessage(16, str, str2, new Throwable[]{th}, iLogExtrasModelArr);
    }

    public static List<LogModel> getAll() {
        ILogger iLogger = logger;
        if (iLogger == null) {
            return null;
        }
        return iLogger.getAll();
    }

    public static void initialize(ILogger iLogger, int i, int i2) {
        logger = iLogger;
        iLogger.setConsoleLoggingLevel(i);
        logger.setLogCachingLevel(i2);
    }

    public static void logMessage(int i, String str, String str2, Throwable[] thArr, ILogExtrasModel... iLogExtrasModelArr) {
        ILogger iLogger = logger;
        if (iLogger != null) {
            if (i == 2) {
                iLogger.mo35418d(str, str2, thArr, iLogExtrasModelArr);
            } else if (i == 4) {
                iLogger.mo35434w(str, str2, thArr, iLogExtrasModelArr);
            } else if (i == 8) {
                iLogger.mo35423e(str, str2, thArr, iLogExtrasModelArr);
            } else if (i == 16) {
                iLogger.mo35426f(str, str2, thArr, iLogExtrasModelArr);
            }
        }
    }

    public static void updateTimeStampDelta(float f) {
        logger.setTimestampDelta(((long) f) * 1000);
    }

    /* renamed from: w */
    public static void m3247w(String str, String str2) {
        m3249w(str, str2, (Throwable) null, (ILogExtrasModel[]) null);
    }

    /* renamed from: d */
    public static void m3238d(String str, String str2, Throwable th) {
        m3239d(str, str2, th, (ILogExtrasModel[]) null);
    }

    /* renamed from: e */
    public static void m3242e(String str, String str2, Throwable th) {
        m3244e(str, str2, new Throwable[]{th}, (ILogExtrasModel[]) null);
    }

    /* renamed from: f */
    public static void m3246f(String str, String str2, Throwable[] thArr, ILogExtrasModel... iLogExtrasModelArr) {
        logMessage(16, str, str2, thArr, iLogExtrasModelArr);
    }

    /* renamed from: w */
    public static void m3248w(String str, String str2, Throwable th) {
        m3249w(str, str2, th, (ILogExtrasModel[]) null);
    }

    /* renamed from: d */
    public static void m3240d(String str, String str2, ILogExtrasModel... iLogExtrasModelArr) {
        m3239d(str, str2, (Throwable) null, iLogExtrasModelArr);
    }

    /* renamed from: e */
    public static void m3243e(String str, String str2, Throwable th, ILogExtrasModel... iLogExtrasModelArr) {
        logMessage(8, str, str2, new Throwable[]{th}, iLogExtrasModelArr);
    }

    /* renamed from: w */
    public static void m3249w(String str, String str2, Throwable th, ILogExtrasModel... iLogExtrasModelArr) {
        logMessage(4, str, str2, new Throwable[]{th}, iLogExtrasModelArr);
    }

    /* renamed from: d */
    public static void m3239d(String str, String str2, Throwable th, ILogExtrasModel... iLogExtrasModelArr) {
        logMessage(2, str, str2, new Throwable[]{th}, iLogExtrasModelArr);
    }

    /* renamed from: e */
    public static void m3244e(String str, String str2, Throwable[] thArr, ILogExtrasModel... iLogExtrasModelArr) {
        logMessage(8, str, str2, thArr, iLogExtrasModelArr);
    }
}
