package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdad implements zzdbd, zzdhr, zzdfq, zzdbt {
    public final zzdbv zza;
    public final zzeye zzb;
    public final ScheduledExecutorService zzc;
    public final Executor zzd;
    public final zzfqv<Boolean> zze = zzfqv.zza();
    public ScheduledFuture<?> zzf;

    public zzdad(zzdbv zzdbv, zzeye zzeye, ScheduledExecutorService scheduledExecutorService, Executor executor) {
        this.zza = zzdbv;
        this.zzb = zzeye;
        this.zzc = scheduledExecutorService;
        this.zzd = executor;
    }

    public final void zza() {
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzba)).booleanValue()) {
            zzeye zzeye = this.zzb;
            if (zzeye.zzT != 2) {
                return;
            }
            if (zzeye.zzq == 0) {
                this.zza.zza();
                return;
            }
            zzfqe.zzp(this.zze, new zzdac(this), this.zzd);
            this.zzf = this.zzc.schedule(new zzdab(this), (long) this.zzb.zzq, TimeUnit.MILLISECONDS);
        }
    }

    public final synchronized void zzb() {
        if (!this.zze.isDone()) {
            ScheduledFuture<?> scheduledFuture = this.zzf;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            this.zze.zzh(Boolean.TRUE);
        }
    }

    public final void zzc() {
        int i = this.zzb.zzT;
        if (i == 0 || i == 1) {
            this.zza.zza();
        }
    }

    public final void zzd() {
    }

    public final void zze() {
    }

    public final void zzf(zzcca zzcca, String str, String str2) {
    }

    public final void zzg() {
    }

    public final void zzh() {
    }

    public final synchronized void zzi(zzbdd zzbdd) {
        if (!this.zze.isDone()) {
            ScheduledFuture<?> scheduledFuture = this.zzf;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            this.zze.zzi(new Exception());
        }
    }

    public final void zzj() {
    }

    public final void zzk() {
    }

    public final /* synthetic */ void zzl() {
        synchronized (this) {
            if (!this.zze.isDone()) {
                this.zze.zzh(Boolean.TRUE);
            }
        }
    }
}
