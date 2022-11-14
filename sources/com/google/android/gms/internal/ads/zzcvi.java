package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcvi implements zzgjg<zzdds> {
    public final zzgju<ScheduledExecutorService> zza;
    public final zzgju<Clock> zzb;

    public zzcvi(zzgju<ScheduledExecutorService> zzgju, zzgju<Clock> zzgju2) {
        this.zza = zzgju;
        this.zzb = zzgju2;
    }

    /* renamed from: zza */
    public final zzdds zzb() {
        return new zzdds(this.zza.zzb(), this.zzb.zzb());
    }
}
