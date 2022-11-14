package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcue implements zzaws {
    public final ScheduledExecutorService zza;
    public final Clock zzb;
    @GuardedBy("this")
    @Nullable
    public ScheduledFuture<?> zzc;
    @GuardedBy("this")
    public long zzd = -1;
    @GuardedBy("this")
    public long zze = -1;
    @GuardedBy("this")
    public Runnable zzf = null;
    @GuardedBy("this")
    public boolean zzg = false;

    public zzcue(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        this.zza = scheduledExecutorService;
        this.zzb = clock;
        zzs.zzf().zzb(this);
    }

    public final void zza(boolean z) {
        if (z) {
            zzd();
        } else {
            zzc();
        }
    }

    public final synchronized void zzb(int i, Runnable runnable) {
        this.zzf = runnable;
        long j = (long) i;
        this.zzd = this.zzb.elapsedRealtime() + j;
        this.zzc = this.zza.schedule(runnable, j, TimeUnit.MILLISECONDS);
    }

    @VisibleForTesting
    public final synchronized void zzc() {
        if (!this.zzg) {
            ScheduledFuture<?> scheduledFuture = this.zzc;
            if (scheduledFuture == null || scheduledFuture.isDone()) {
                this.zze = -1;
            } else {
                this.zzc.cancel(true);
                this.zze = this.zzd - this.zzb.elapsedRealtime();
            }
            this.zzg = true;
        }
    }

    @VisibleForTesting
    public final synchronized void zzd() {
        ScheduledFuture<?> scheduledFuture;
        if (this.zzg) {
            if (this.zze > 0 && (scheduledFuture = this.zzc) != null && scheduledFuture.isCancelled()) {
                this.zzc = this.zza.schedule(this.zzf, this.zze, TimeUnit.MILLISECONDS);
            }
            this.zzg = false;
        }
    }
}
