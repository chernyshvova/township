package com.google.android.gms.internal.ads;

import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzayp implements Runnable {
    public final zzchj zza;
    public final Future zzb;

    public zzayp(zzchj zzchj, Future future) {
        this.zza = zzchj;
        this.zzb = future;
    }

    public final void run() {
        zzchj zzchj = this.zza;
        Future future = this.zzb;
        if (zzchj.isCancelled()) {
            future.cancel(true);
        }
    }
}
