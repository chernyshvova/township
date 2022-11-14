package com.google.android.gms.internal.ads;

import com.vungle.warren.VungleApiClient;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzsk {
    public static final boolean zza;

    static {
        boolean z = true;
        if (!VungleApiClient.MANUFACTURER_AMAZON.equals(zzalh.zzc) || (!"AFTM".equals(zzalh.zzd) && !"AFTB".equals(zzalh.zzd))) {
            z = false;
        }
        zza = z;
    }
}
