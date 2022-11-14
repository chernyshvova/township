package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfgc {
    public final BlockingQueue<Runnable> zza = new LinkedBlockingQueue();
    public final ThreadPoolExecutor zzb = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, this.zza);
    public final ArrayDeque<zzfgb> zzc = new ArrayDeque<>();
    public zzfgb zzd = null;

    private final void zzc() {
        zzfgb poll = this.zzc.poll();
        this.zzd = poll;
        if (poll != null) {
            poll.executeOnExecutor(this.zzb, new Object[0]);
        }
    }

    public final void zza(zzfgb zzfgb) {
        zzfgb.zzb(this);
        this.zzc.add(zzfgb);
        if (this.zzd == null) {
            zzc();
        }
    }

    public final void zzb(zzfgb zzfgb) {
        this.zzd = null;
        zzc();
    }
}
