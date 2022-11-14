package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzcnl implements Runnable {
    public final zzcnn zza;
    public final Map zzb;

    public zzcnl(zzcnn zzcnn, Map map) {
        this.zza = zzcnn;
        this.zzb = map;
    }

    public final void run() {
        this.zza.zzu(this.zzb);
    }
}
