package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfdk implements zzfdh {
    public final zzfdh zza;
    public final Queue<zzfdg> zzb = new LinkedBlockingQueue();
    public final int zzc = ((Integer) zzbex.zzc().zzb(zzbjn.zzfX)).intValue();
    public final AtomicBoolean zzd = new AtomicBoolean(false);

    public zzfdk(zzfdh zzfdh, ScheduledExecutorService scheduledExecutorService) {
        this.zza = zzfdh;
        long intValue = (long) ((Integer) zzbex.zzc().zzb(zzbjn.zzfW)).intValue();
        scheduledExecutorService.scheduleAtFixedRate(new zzfdj(this), intValue, intValue, TimeUnit.MILLISECONDS);
    }

    public final void zza(zzfdg zzfdg) {
        if (this.zzb.size() < this.zzc) {
            this.zzb.offer(zzfdg);
        } else if (!this.zzd.getAndSet(true)) {
            Queue<zzfdg> queue = this.zzb;
            zzfdg zza2 = zzfdg.zza("dropped_event");
            Map<String, String> zzj = zzfdg.zzj();
            if (zzj.containsKey("action")) {
                zza2.zzc("dropped_action", zzj.get("action"));
            }
            queue.offer(zza2);
        }
    }

    public final String zzb(zzfdg zzfdg) {
        return this.zza.zzb(zzfdg);
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        while (!this.zzb.isEmpty()) {
            this.zza.zza(this.zzb.remove());
        }
    }
}
