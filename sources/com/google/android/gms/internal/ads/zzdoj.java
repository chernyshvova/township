package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzbp;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdoj implements zzgjg<zzdoi> {
    public final zzgju<zzbp> zza;
    public final zzgju<Clock> zzb;
    public final zzgju<Executor> zzc;

    public zzdoj(zzgju<zzbp> zzgju, zzgju<Clock> zzgju2, zzgju<Executor> zzgju3) {
        this.zza = zzgju;
        this.zzb = zzgju2;
        this.zzc = zzgju3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfqo zzfqo = zzche.zza;
        zzgjp.zzb(zzfqo);
        return new zzdoi(this.zza.zzb(), this.zzb.zzb(), zzfqo);
    }
}
