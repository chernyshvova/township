package com.google.android.gms.internal.ads;

import android.util.Log;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.appevents.codeless.CodelessMatcher;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzao {
    public static final String zza = "Volley";
    public static final boolean zzb = Log.isLoggable(zza, 2);
    public static final String zzc = zzao.class.getName();

    public static void zza(String str, Object... objArr) {
        if (zzb) {
            Log.v(zza, zze(str, objArr));
        }
    }

    public static void zzb(String str, Object... objArr) {
        Log.d(zza, zze(str, objArr));
    }

    public static void zzc(String str, Object... objArr) {
        Log.e(zza, zze(str, objArr));
    }

    public static void zzd(Throwable th, String str, Object... objArr) {
        Log.e(zza, zze(str, objArr), th);
    }

    public static String zze(String str, Object... objArr) {
        String str2;
        String format = String.format(Locale.US, str, objArr);
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            } else if (!stackTrace[i].getClassName().equals(zzc)) {
                String className = stackTrace[i].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                String substring2 = substring.substring(substring.lastIndexOf(36) + 1);
                String methodName = stackTrace[i].getMethodName();
                str2 = GeneratedOutlineSupport.outline19(new StringBuilder(String.valueOf(substring2).length() + 1 + String.valueOf(methodName).length()), substring2, CodelessMatcher.CURRENT_CLASS_NAME, methodName);
                break;
            } else {
                i++;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), str2, format});
    }
}
