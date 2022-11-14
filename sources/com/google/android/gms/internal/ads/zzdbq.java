package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdbq extends zzdgf<zzdbh> implements zzdbh {
    public final ScheduledExecutorService zzb;
    public ScheduledFuture<?> zzc;
    public boolean zzd = false;
    public final boolean zze;

    public zzdbq(zzdbp zzdbp, Set<zzdhz<zzdbh>> set, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        super(set);
        this.zzb = scheduledExecutorService;
        this.zze = ((Boolean) zzbex.zzc().zzb(zzbjn.zzgH)).booleanValue();
        zzh(zzdbp, executor);
    }

    public final void zza(zzbdd zzbdd) {
        zzr(new zzdbi(zzbdd));
    }

    public final synchronized void zzb() {
        if (this.zze) {
            ScheduledFuture<?> scheduledFuture = this.zzc;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
        }
    }

    public final void zzc(zzdka zzdka) {
        if (this.zze) {
            if (!this.zzd) {
                ScheduledFuture<?> scheduledFuture = this.zzc;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(true);
                }
            } else {
                return;
            }
        }
        zzr(new zzdbj(zzdka));
    }

    public final void zzd() {
        zzr(zzdbk.zza);
    }

    public final void zze() {
        if (this.zze) {
            this.zzc = this.zzb.schedule(new zzdbl(this), (long) ((Integer) zzbex.zzc().zzb(zzbjn.zzgI)).intValue(), TimeUnit.MILLISECONDS);
        }
    }

    public final /* synthetic */ void zzf() {
        synchronized (this) {
            zzcgs.zzf("Timeout waiting for show call succeed to be called.");
            zzc(new zzdka("Timeout for show call succeed."));
            this.zzd = true;
        }
    }
}
