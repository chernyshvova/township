package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcxw {
    public final Executor zza;
    public final ScheduledExecutorService zzb;
    public final zzfqn<zzcxp> zzc;
    public volatile boolean zzd = true;

    public zzcxw(Executor executor, ScheduledExecutorService scheduledExecutorService, zzfqn<zzcxp> zzfqn) {
        this.zza = executor;
        this.zzb = scheduledExecutorService;
        this.zzc = zzfqn;
    }

    public static /* synthetic */ void zze(zzcxw zzcxw, List list, zzfqa zzfqa) {
        if (list == null || list.isEmpty()) {
            zzcxw.zza.execute(new zzcxq(zzfqa));
            return;
        }
        zzfqn<O> zza2 = zzfqe.zza(null);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zza2 = zzfqe.zzi(zzfqe.zzg(zza2, Throwable.class, new zzcxr(zzfqa), zzcxw.zza), new zzcxs(zzcxw, zzfqa, (zzfqn) it.next()), zzcxw.zza);
        }
        zzfqe.zzp(zza2, new zzcxv(zzcxw, zzfqa), zzcxw.zza);
    }

    public final void zza(zzfqa<zzcxi> zzfqa) {
        zzfqe.zzp(this.zzc, new zzcxu(this, zzfqa), this.zza);
    }

    public final boolean zzb() {
        return this.zzd;
    }

    public final /* synthetic */ void zzc() {
        this.zzd = false;
    }

    public final /* synthetic */ zzfqn zzd(zzfqa zzfqa, zzfqn zzfqn, zzcxi zzcxi) throws Exception {
        if (zzcxi != null) {
            zzfqa.zzb(zzcxi);
        }
        return zzfqe.zzh(zzfqn, zzbll.zzb.zze().longValue(), TimeUnit.MILLISECONDS, this.zzb);
    }
}
