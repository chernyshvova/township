package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.os.StrictMode;
import com.google.android.gms.internal.ads.zzcas;
import com.google.android.gms.internal.ads.zzcgs;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzcc {
    @Deprecated
    public static <T> T zza(Context context, Callable<T> callable) {
        StrictMode.ThreadPolicy threadPolicy;
        try {
            threadPolicy = StrictMode.getThreadPolicy();
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
            T call = callable.call();
            StrictMode.setThreadPolicy(threadPolicy);
            return call;
        } catch (Throwable th) {
            zzcgs.zzg("Unexpected exception.", th);
            zzcas.zza(context).zzd(th, "StrictModeUtil.runWithLaxStrictMode");
            return null;
        }
    }
}
