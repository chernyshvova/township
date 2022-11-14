package com.appsflyer;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.annotation.NonNull;
import com.appsflyer.internal.C1387af;
import com.appsflyer.internal.C1414am;
import com.appsflyer.internal.C1431ax;

public final class AFLogger {
    public static final long AFInAppEventType = System.currentTimeMillis();

    public enum LogLevel {
        NONE(0),
        ERROR(1),
        WARNING(2),
        INFO(3),
        DEBUG(4),
        VERBOSE(5);
        
        public int valueOf;

        /* access modifiers changed from: public */
        LogLevel(int i) {
            this.valueOf = i;
        }

        public final int getLevel() {
            return this.valueOf;
        }
    }

    public static void AFInAppEventParameterName(String str, boolean z) {
        if (valueOf(LogLevel.INFO)) {
            Log.i("AppsFlyer_6.3.0", valueOf(str, false));
        }
        if (z) {
            C1414am.AFKeystoreWrapper().valueOf((String) null, "I", valueOf(str, true));
        }
    }

    public static void AFInAppEventType(Throwable th) {
        valueOf((String) null, th, false, false);
    }

    public static void AFKeystoreWrapper(String str) {
        if (valueOf(LogLevel.VERBOSE)) {
            Log.v("AppsFlyer_6.3.0", valueOf(str, false));
        }
        C1414am.AFKeystoreWrapper().valueOf((String) null, "V", valueOf(str, true));
    }

    public static void AFVersionDeclaration(String str) {
        valueOf(str);
    }

    @NonNull
    public static String valueOf(String str, boolean z) {
        if (str == null) {
            str = "null";
        }
        if (!z && LogLevel.VERBOSE.getLevel() > AppsFlyerProperties.getInstance().getInt("logLevel", LogLevel.NONE.getLevel())) {
            return str;
        }
        StringBuilder sb = new StringBuilder("(");
        sb.append(System.currentTimeMillis() - AFInAppEventType);
        sb.append(") [");
        sb.append(Thread.currentThread().getName());
        sb.append("] ");
        sb.append(str);
        return sb.toString();
    }

    public static void values(String str) {
        if (!values()) {
            Log.d("AppsFlyer_6.3.0", valueOf(str, false));
        }
        C1414am.AFKeystoreWrapper().valueOf((String) null, "F", str);
    }

    public static void AFInAppEventType(String str) {
        if (valueOf(LogLevel.DEBUG)) {
            Log.d("AppsFlyer_6.3.0", valueOf(str, false));
        }
        C1414am.AFKeystoreWrapper().valueOf((String) null, "D", valueOf(str, true));
    }

    public static void valueOf(String str, Throwable th, boolean z, boolean z2) {
        long j;
        if (valueOf(LogLevel.ERROR)) {
            if (str == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(th.getClass().getSimpleName());
                sb.append(" at ");
                sb.append(th.getStackTrace()[0].toString());
                str = sb.toString();
            }
            String valueOf = valueOf(str, false);
            if (z2) {
                Log.e("AppsFlyer_6.3.0", valueOf, th);
            } else if (z) {
                Log.d("AppsFlyer_6.3.0", valueOf);
            }
        }
        C1414am AFKeystoreWrapper = C1414am.AFKeystoreWrapper();
        Throwable cause = th.getCause();
        AFKeystoreWrapper.valueOf("exception", th.getClass().getSimpleName(), C1414am.AFInAppEventParameterName(cause == null ? th.getMessage() : cause.getMessage(), cause == null ? th.getStackTrace() : cause.getStackTrace()));
        Application application = C1431ax.AFInAppEventParameterName;
        if (application != null) {
            SharedPreferences.Editor edit = C1387af.AFInAppEventType((Context) application).edit();
            Application application2 = C1431ax.AFInAppEventParameterName;
            if (application2 == null) {
                j = -1;
            } else {
                j = C1387af.AFInAppEventType((Context) application2).getLong("exception_number", 0);
            }
            edit.putLong("exception_number", j + 1).apply();
        }
    }

    public static void AFInAppEventParameterName(String str) {
        AFInAppEventParameterName(str, true);
    }

    public static boolean values() {
        return AppsFlyerProperties.getInstance().isLogsDisabledCompletely();
    }

    public static void AFInAppEventParameterName(String str, Throwable th) {
        valueOf(str, th, true, true);
    }

    public static void values(String str, Throwable th) {
        valueOf(str, th, true, false);
    }

    public static void valueOf(String str) {
        if (valueOf(LogLevel.WARNING)) {
            Log.w("AppsFlyer_6.3.0", valueOf(str, false));
        }
        C1414am.AFKeystoreWrapper().valueOf((String) null, "W", valueOf(str, true));
    }

    public static boolean valueOf(LogLevel logLevel) {
        return logLevel.getLevel() <= AppsFlyerProperties.getInstance().getInt("logLevel", LogLevel.NONE.getLevel());
    }
}
