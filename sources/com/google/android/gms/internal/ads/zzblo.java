package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzblo {
    public static final AtomicBoolean zza = new AtomicBoolean();
    public static final AtomicReference<zzbln> zzb = new AtomicReference<>();

    public static zzbln zza() {
        return zzb.get();
    }

    public static void zzb(zzbln zzbln) {
        zzb.set(zzbln);
    }
}
