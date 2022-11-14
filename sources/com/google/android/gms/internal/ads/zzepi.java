package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeqo;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzepi<S extends zzeqo> implements zzeqp<S> {
    public final zzeqp<S> zza;
    public final long zzb;
    public final ScheduledExecutorService zzc;

    public zzepi(zzeqp<S> zzeqp, long j, ScheduledExecutorService scheduledExecutorService) {
        this.zza = zzeqp;
        this.zzb = j;
        this.zzc = scheduledExecutorService;
    }

    public final zzfqn<S> zza() {
        zzfqn<S> zza2 = this.zza.zza();
        long j = this.zzb;
        if (j > 0) {
            zza2 = zzfqe.zzh(zza2, j, TimeUnit.MILLISECONDS, this.zzc);
        }
        return zzfqe.zzg(zza2, Throwable.class, zzeph.zza, zzche.zzf);
    }
}
