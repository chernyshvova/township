package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfqt extends zzfqq implements ScheduledExecutorService, zzfqo {
    public final ScheduledExecutorService zza;

    public zzfqt(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        if (scheduledExecutorService != null) {
            this.zza = scheduledExecutorService;
            return;
        }
        throw null;
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        zzfrc zza2 = zzfrc.zza(runnable, null);
        return new zzfqr(zza2, this.zza.schedule(zza2, j, timeUnit));
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        zzfqs zzfqs = new zzfqs(runnable);
        return new zzfqr(zzfqs, this.zza.scheduleAtFixedRate(zzfqs, j, j2, timeUnit));
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        zzfqs zzfqs = new zzfqs(runnable);
        return new zzfqr(zzfqs, this.zza.scheduleWithFixedDelay(zzfqs, j, j2, timeUnit));
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture schedule(Callable callable, long j, TimeUnit timeUnit) {
        zzfrc zzfrc = new zzfrc(callable);
        return new zzfqr(zzfrc, this.zza.schedule(zzfrc, j, timeUnit));
    }
}
