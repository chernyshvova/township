package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;

@TargetApi(17)
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcf {
    public static zzcf zzb;
    public String zza;

    public static zzcf zza() {
        if (zzb == null) {
            zzb = new zzcf();
        }
        return zzb;
    }
}
