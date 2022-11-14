package com.google.android.gms.internal.ads;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfqz<V> extends zzfpu<V> {
    @CheckForNull
    public zzfqn<V> zza;
    @CheckForNull
    public ScheduledFuture<?> zzb;

    public zzfqz(zzfqn<V> zzfqn) {
        if (zzfqn != null) {
            this.zza = zzfqn;
            return;
        }
        throw null;
    }

    public static <V> zzfqn<V> zza(zzfqn<V> zzfqn, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        zzfqz zzfqz = new zzfqz(zzfqn);
        zzfqx zzfqx = new zzfqx(zzfqz);
        zzfqz.zzb = scheduledExecutorService.schedule(zzfqx, j, timeUnit);
        zzfqn.zze(zzfqx, zzfps.INSTANCE);
        return zzfqz;
    }

    @CheckForNull
    public final String zzc() {
        zzfqn<V> zzfqn = this.zza;
        ScheduledFuture<?> scheduledFuture = this.zzb;
        if (zzfqn == null) {
            return null;
        }
        String valueOf = String.valueOf(zzfqn);
        String outline19 = GeneratedOutlineSupport.outline19(new StringBuilder(valueOf.length() + 14), "inputFuture=[", valueOf, "]");
        if (scheduledFuture == null) {
            return outline19;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return outline19;
        }
        String valueOf2 = String.valueOf(outline19);
        StringBuilder sb = new StringBuilder(valueOf2.length() + 43);
        sb.append(valueOf2);
        sb.append(", remaining delay=[");
        sb.append(delay);
        sb.append(" ms]");
        return sb.toString();
    }

    public final void zzd() {
        zzl(this.zza);
        ScheduledFuture<?> scheduledFuture = this.zzb;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.zza = null;
        this.zzb = null;
    }
}
