package com.google.android.gms.internal.ads;

import android.os.Trace;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzalf {
    public static void zza(String str) {
        if (zzalh.zza >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void zzb() {
        if (zzalh.zza >= 18) {
            Trace.endSection();
        }
    }
}
