package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzadm {
    public static final AtomicLong zzd = new AtomicLong();
    public final zzahx zza;
    public final Uri zzb;
    public final Map<String, List<String>> zzc;

    public zzadm(long j, zzahx zzahx, Uri uri, Map<String, List<String>> map, long j2, long j3, long j4) {
        this.zza = zzahx;
        this.zzb = uri;
        this.zzc = map;
    }

    public static long zza() {
        return zzd.getAndIncrement();
    }
}
