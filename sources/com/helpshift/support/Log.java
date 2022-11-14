package com.helpshift.support;

import com.helpshift.common.domain.HSThreadFactory;
import com.helpshift.meta.dto.DebugLogDTO;
import com.helpshift.util.HSLogger;
import com.helpshift.util.HelpshiftContext;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

public final class Log {
    public static final String TAG = "Helpshift_Log";
    public static final ExecutorService executor = Executors.newSingleThreadExecutor(new HSThreadFactory("sup-log"));

    public static void appendLog(Integer num, String str, String str2) {
        appendLog(num, str, str2, (Throwable) null);
    }

    /* renamed from: d */
    public static int m3224d(String str, String str2) {
        return m3225d(str, str2, (Throwable) null);
    }

    /* renamed from: e */
    public static int m3226e(String str, String str2) {
        return m3227e(str, str2, (Throwable) null);
    }

    public static String getStackTraceString(Throwable th) {
        return android.util.Log.getStackTraceString(th);
    }

    /* renamed from: i */
    public static int m3228i(String str, String str2) {
        return m3229i(str, str2, (Throwable) null);
    }

    public static boolean isLoggable(String str, int i) {
        return android.util.Log.isLoggable(str, i);
    }

    public static int println(int i, String str, String str2) {
        return android.util.Log.println(i, str, str2);
    }

    /* renamed from: v */
    public static int m3230v(String str, String str2) {
        return m3231v(str, str2, (Throwable) null);
    }

    /* renamed from: w */
    public static int m3232w(String str, String str2) {
        return m3233w(str, str2, (Throwable) null);
    }

    public static int wtf(String str, String str2) {
        return wtf(str, str2, (Throwable) null);
    }

    public static void appendLog(Integer num, String str, Throwable th) {
        appendLog(num, str, (String) null, th);
    }

    /* renamed from: d */
    public static int m3225d(String str, String str2, Throwable th) {
        int d = android.util.Log.d(str, str2, th);
        appendLog(3, str, str2, th);
        return d;
    }

    /* renamed from: e */
    public static int m3227e(String str, String str2, Throwable th) {
        int e = android.util.Log.e(str, str2, th);
        appendLog(6, str, str2, th);
        return e;
    }

    /* renamed from: i */
    public static int m3229i(String str, String str2, Throwable th) {
        int i = android.util.Log.i(str, str2, th);
        appendLog(4, str, str2, th);
        return i;
    }

    /* renamed from: v */
    public static int m3231v(String str, String str2, Throwable th) {
        int v = android.util.Log.v(str, str2, th);
        appendLog(2, str, str2, th);
        return v;
    }

    /* renamed from: w */
    public static int m3233w(String str, String str2, Throwable th) {
        int e = android.util.Log.e(str, str2, th);
        appendLog(5, str, str2, th);
        return e;
    }

    public static int wtf(String str, Throwable th) {
        return wtf(str, "", th);
    }

    public static void appendLog(Integer num, String str, String str2, Throwable th) {
        final DebugLogDTO debugLogDTO = new DebugLogDTO(num, str, str2, getStackTraceString(th));
        try {
            executor.submit(new Runnable() {
                public void run() {
                    try {
                        HelpshiftContext.getCoreApi().getMetaDataDM().addDebugLog(debugLogDTO);
                    } catch (Exception unused) {
                    }
                }
            });
        } catch (RejectedExecutionException e) {
            HSLogger.m3242e(TAG, "Error executing support logs update", e);
        }
    }

    public static int wtf(String str, String str2, Throwable th) {
        int wtf = android.util.Log.wtf(str, str2, th);
        appendLog(-1, str, str2, th);
        return wtf;
    }

    /* renamed from: w */
    public static int m3234w(String str, Throwable th) {
        return m3233w(str, "", th);
    }
}
