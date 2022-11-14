package com.google.android.gms.internal.ads;

import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfqr<V> extends zzfpy<V> implements ScheduledFuture<V>, zzfqn {
    public final ScheduledFuture<?> zza;

    public zzfqr(zzfqn<V> zzfqn, ScheduledFuture<?> scheduledFuture) {
        super(zzfqn);
        this.zza = scheduledFuture;
    }

    public final boolean cancel(boolean z) {
        boolean cancel = zzb().cancel(z);
        if (cancel) {
            this.zza.cancel(z);
        }
        return cancel;
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.zza.compareTo((Delayed) obj);
    }

    public final long getDelay(TimeUnit timeUnit) {
        return this.zza.getDelay(timeUnit);
    }
}
