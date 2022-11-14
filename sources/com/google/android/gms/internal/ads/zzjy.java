package com.google.android.gms.internal.ads;

import android.os.Build;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzjy {
    @Deprecated
    public static final String zza;
    public static final HashSet<String> zzb = new HashSet<>();
    public static final String zzc = "goog.exo.core";

    static {
        String str = Build.VERSION.RELEASE;
        zza = GeneratedOutlineSupport.outline19(new StringBuilder(String.valueOf(str).length() + 57), "ExoPlayerLib/2.14.0 (Linux; Android ", str, ") ExoPlayerLib/2.14.0");
    }

    public static synchronized String zza() {
        String str;
        synchronized (zzjy.class) {
            str = zzc;
        }
        return str;
    }
}
