package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzcjx implements Runnable {
    public final zzciz zza;
    public final Map zzb;

    public zzcjx(zzciz zzciz, Map map) {
        this.zza = zzciz;
        this.zzb = map;
    }

    public final void run() {
        zzciz zzciz = this.zza;
        Map map = this.zzb;
        int i = zzckg.zzc;
        zzciz.zze("onGcacheInfoEvent", map);
    }
}
