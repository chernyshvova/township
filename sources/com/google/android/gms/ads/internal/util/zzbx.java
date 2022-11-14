package com.google.android.gms.ads.internal.util;

import android.graphics.Bitmap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbx {
    public final Map<Integer, Bitmap> zza = new ConcurrentHashMap();
    public final AtomicInteger zzb = new AtomicInteger(0);

    public final Bitmap zza(Integer num) {
        return this.zza.get(num);
    }
}
