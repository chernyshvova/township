package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import java.net.UnknownHostException;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaka {
    @Pure
    public static void zza(String str, String str2, @Nullable Throwable th) {
        Log.w(str, zzc(str2, th));
    }

    @Pure
    public static void zzb(String str, String str2, @Nullable Throwable th) {
        Log.e(str, zzc(str2, th));
    }

    @Pure
    public static String zzc(String str, @Nullable Throwable th) {
        String str2;
        if (th != null) {
            Throwable th2 = th;
            while (true) {
                if (th2 == null) {
                    str2 = Log.getStackTraceString(th).trim().replace("\t", "    ");
                    break;
                } else if (th2 instanceof UnknownHostException) {
                    str2 = "UnknownHostException (no network)";
                    break;
                } else {
                    th2 = th2.getCause();
                }
            }
        } else {
            str2 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        String valueOf = String.valueOf(str);
        String replace = str2.replace("\n", "\n  ");
        StringBuilder sb = new StringBuilder(valueOf.length() + 4 + String.valueOf(replace).length());
        sb.append(valueOf);
        sb.append("\n  ");
        sb.append(replace);
        sb.append(10);
        return sb.toString();
    }
}
