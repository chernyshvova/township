package com.google.android.gms.ads.internal.util;

import android.util.Log;
import com.google.android.gms.internal.ads.zzblc;
import com.google.android.gms.internal.ads.zzcgs;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zze extends zzcgs {
    public static void zza(String str) {
        if (zzc()) {
            Log.v("Ads", str);
        }
    }

    public static void zzb(String str, Throwable th) {
        if (zzc()) {
            Log.v("Ads", str, th);
        }
    }

    public static boolean zzc() {
        return zzcgs.zzm(2) && zzblc.zza.zze().booleanValue();
    }
}
