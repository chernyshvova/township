package com.google.android.gms.internal.ads;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfby implements zzgjg<ScheduledExecutorService> {
    public final zzgju<ThreadFactory> zza;

    public zzfby(zzgju<ThreadFactory> zzgju) {
        this.zza = zzgju;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfji.zza();
        ScheduledExecutorService unconfigurableScheduledExecutorService = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, this.zza.zzb()));
        zzgjp.zzb(unconfigurableScheduledExecutorService);
        return unconfigurableScheduledExecutorService;
    }
}
