package com.vungle.warren;

import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.GraphRequest;
import com.google.android.gms.measurement.AppMeasurement;
import com.vungle.warren.log.LogManager;

public class VungleLogger {
    public static final int LOGGER_MAX_ENTRIES = 100;
    public static final String TAG = "VungleLogger";
    public static final VungleLogger _instance = new VungleLogger();
    public LogManager logManager;
    public LoggerLevel loggingLevel = LoggerLevel.DEBUG;

    @Keep
    public enum LoggerLevel {
        VERBOSE(0, "verbose"),
        DEBUG(1, GraphRequest.DEBUG_PARAM),
        INFO(2, GraphRequest.DEBUG_SEVERITY_INFO),
        WARNING(3, "warn"),
        ERROR(4, "error"),
        CRASH(5, AppMeasurement.CRASH_ORIGIN);
        
        public int level;
        public String levelString;

        /* access modifiers changed from: public */
        LoggerLevel(int i, @NonNull String str) {
            this.level = i;
            this.levelString = str;
        }

        @NonNull
        public String toString() {
            return this.levelString;
        }
    }

    public static void addCustomData(@NonNull String str, @NonNull String str2) {
        LogManager logManager2 = _instance.logManager;
        if (logManager2 == null) {
            Log.d(TAG, "Please setup Logger first.");
        } else {
            logManager2.addCustomData(str, str2);
        }
    }

    public static void debug(@NonNull String str, @NonNull String str2) {
        log(LoggerLevel.DEBUG, str, str2);
    }

    public static void error(@NonNull String str, @NonNull String str2) {
        log(LoggerLevel.ERROR, str, str2);
    }

    public static void info(@NonNull String str, @NonNull String str2) {
        log(LoggerLevel.INFO, str, str2);
    }

    public static boolean isLoggable(@NonNull LoggerLevel loggerLevel) {
        return loggerLevel.level >= _instance.loggingLevel.level;
    }

    public static void log(@NonNull LoggerLevel loggerLevel, @NonNull String str, @NonNull String str2) {
        LogManager logManager2 = _instance.logManager;
        if (logManager2 == null) {
            Log.d(TAG, "Please setup Logger first.");
        } else if (logManager2.isLoggingEnabled() && isLoggable(loggerLevel)) {
            _instance.logManager.saveLog(loggerLevel, str, str2, (String) null, (String) null);
        }
    }

    public static void removeCustomData(@NonNull String str) {
        LogManager logManager2 = _instance.logManager;
        if (logManager2 == null) {
            Log.d(TAG, "Please setup Logger first.");
        } else {
            logManager2.removeCustomData(str);
        }
    }

    public static void setupLoggerWithLogLevel(@NonNull LogManager logManager2, @NonNull LoggerLevel loggerLevel, int i) {
        VungleLogger vungleLogger = _instance;
        vungleLogger.loggingLevel = loggerLevel;
        vungleLogger.logManager = logManager2;
        logManager2.setMaxEntries(i);
    }

    public static void verbose(@NonNull String str, @NonNull String str2) {
        log(LoggerLevel.VERBOSE, str, str2);
    }

    public static void warn(@NonNull String str, @NonNull String str2) {
        log(LoggerLevel.WARNING, str, str2);
    }

    public static void debug(boolean z, @Nullable String str, @NonNull String str2, @NonNull String str3) {
        if (z) {
            Log.d(str, "[" + str2 + "] " + str3);
        }
        debug(str2, str3);
    }

    public static void error(boolean z, @Nullable String str, @NonNull String str2, @NonNull String str3) {
        if (z) {
            Log.e(str, "[" + str2 + "] " + str3);
        }
        error(str2, str3);
    }

    public static void info(boolean z, @Nullable String str, @NonNull String str2, @NonNull String str3) {
        if (z) {
            Log.i(str, "[" + str2 + "] " + str3);
        }
        info(str2, str3);
    }

    public static void verbose(boolean z, @Nullable String str, @NonNull String str2, @NonNull String str3) {
        if (z) {
            Log.v(str, "[" + str2 + "] " + str3);
        }
        verbose(str2, str3);
    }

    public static void warn(boolean z, @Nullable String str, @NonNull String str2, @NonNull String str3) {
        if (z) {
            Log.w(str, "[" + str2 + "] " + str3);
        }
        warn(str2, str3);
    }
}
