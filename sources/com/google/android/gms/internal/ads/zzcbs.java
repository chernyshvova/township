package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.WeakHashMap;
import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcbs {
    public final WeakHashMap<Context, zzcbr> zza = new WeakHashMap<>();

    public final Future<zzcbp> zza(Context context) {
        return zzche.zza.zzb(new zzcbq(this, context));
    }
}
