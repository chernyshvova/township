package com.google.android.gms.internal.ads;

import android.os.Trace;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzauy {
    public static void zza(String str) {
        if (zzava.zza >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void zzb() {
        if (zzava.zza >= 18) {
            Trace.endSection();
        }
    }
}
