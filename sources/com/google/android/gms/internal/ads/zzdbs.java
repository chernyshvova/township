package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdbs implements zzgjg<zzdbq> {
    public final zzgju<zzdbp> zza;
    public final zzgju<Set<zzdhz<zzdbh>>> zzb;
    public final zzgju<Executor> zzc;
    public final zzgju<ScheduledExecutorService> zzd;

    public zzdbs(zzgju<zzdbp> zzgju, zzgju<Set<zzdhz<zzdbh>>> zzgju2, zzgju<Executor> zzgju3, zzgju<ScheduledExecutorService> zzgju4) {
        this.zza = zzgju;
        this.zzb = zzgju2;
        this.zzc = zzgju3;
        this.zzd = zzgju4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzdbp zza2 = ((zzdbr) this.zza).zzb();
        Set zzc2 = ((zzgjs) this.zzb).zzb();
        zzfqo zzfqo = zzche.zza;
        zzgjp.zzb(zzfqo);
        return new zzdbq(zza2, zzc2, zzfqo, this.zzd.zzb());
    }
}
