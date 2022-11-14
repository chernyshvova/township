package com.google.android.gms.internal.ads;

import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public class zzcgs {
    public static void zzd(String str) {
        if (zzm(3)) {
            Log.d("Ads", str);
        }
    }

    public static void zze(String str, Throwable th) {
        if (zzm(3)) {
            Log.d("Ads", str, th);
        }
    }

    public static void zzf(String str) {
        if (zzm(6)) {
            Log.e("Ads", str);
        }
    }

    public static void zzg(String str, Throwable th) {
        if (zzm(6)) {
            Log.e("Ads", str, th);
        }
    }

    public static void zzh(String str) {
        if (zzm(4)) {
            Log.i("Ads", str);
        }
    }

    public static void zzi(String str) {
        if (zzm(5)) {
            Log.w("Ads", str);
        }
    }

    public static void zzj(String str, Throwable th) {
        if (zzm(5)) {
            Log.w("Ads", str, th);
        }
    }

    @VisibleForTesting
    public static String zzk(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length < 4) {
            return str;
        }
        int lineNumber = stackTrace[3].getLineNumber();
        StringBuilder sb = new StringBuilder(str.length() + 13);
        sb.append(str);
        sb.append(" @");
        sb.append(lineNumber);
        return sb.toString();
    }

    public static void zzl(String str, @Nullable Throwable th) {
        if (!zzm(5)) {
            return;
        }
        if (th != null) {
            zzj(zzk(str), th);
        } else {
            zzi(zzk(str));
        }
    }

    public static boolean zzm(int i) {
        return i >= 5 || Log.isLoggable("Ads", i);
    }
}
