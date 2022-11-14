package com.microsoft.appcenter.utils;

import android.util.Log;
import androidx.annotation.NonNull;

public class AppCenterLog {
    public static int sLogLevel = 7;

    public static void debug(@NonNull String str, @NonNull String str2) {
        if (sLogLevel <= 3) {
            Log.d(str, str2);
        }
    }

    public static void error(@NonNull String str, @NonNull String str2) {
        if (sLogLevel <= 6) {
            Log.e(str, str2);
        }
    }

    public static void info(@NonNull String str, @NonNull String str2) {
        if (sLogLevel <= 4) {
            Log.i(str, str2);
        }
    }

    public static void verbose(@NonNull String str, @NonNull String str2) {
        if (sLogLevel <= 2) {
            Log.v(str, str2);
        }
    }

    public static void warn(@NonNull String str, @NonNull String str2) {
        if (sLogLevel <= 5) {
            Log.w(str, str2);
        }
    }

    public static void error(@NonNull String str, @NonNull String str2, Throwable th) {
        if (sLogLevel <= 6) {
            Log.e(str, str2, th);
        }
    }

    public static void warn(@NonNull String str, @NonNull String str2, Throwable th) {
        if (sLogLevel <= 5) {
            Log.w(str, str2, th);
        }
    }
}
