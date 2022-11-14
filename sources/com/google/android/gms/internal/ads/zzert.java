package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzert implements zzeqp<zzeru> {
    public final Context zza;
    public final zzcgd zzb;
    public final ScheduledExecutorService zzc;
    public final Executor zzd;
    public final zzcfw zze;

    public zzert(zzcfw zzcfw, int i, Context context, zzcgd zzcgd, ScheduledExecutorService scheduledExecutorService, Executor executor, byte[] bArr) {
        this.zze = zzcfw;
        this.zza = context;
        this.zzb = zzcgd;
        this.zzc = scheduledExecutorService;
        this.zzd = executor;
    }

    public final zzfqn<zzeru> zza() {
        return zzfqe.zzf((zzfpv) zzfqe.zzh(zzfqe.zzj(zzfpv.zzw(zzfqe.zze(new zzerq(this), this.zzd)), zzerr.zza, this.zzd), ((Long) zzbex.zzc().zzb(zzbjn.zzaG)).longValue(), TimeUnit.MILLISECONDS, this.zzc), Exception.class, new zzers(this), zzfqu.zza());
    }

    public final /* synthetic */ zzeru zzb(Exception exc) {
        this.zzb.zzg(exc, "AttestationTokenSignal");
        return null;
    }
}
