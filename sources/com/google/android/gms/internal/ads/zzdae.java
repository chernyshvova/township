package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdae implements zzgjg<zzdad> {
    public final zzgju<zzdbv> zza;
    public final zzgju<zzeye> zzb;
    public final zzgju<ScheduledExecutorService> zzc;
    public final zzgju<Executor> zzd;

    public zzdae(zzgju<zzdbv> zzgju, zzgju<zzeye> zzgju2, zzgju<ScheduledExecutorService> zzgju3, zzgju<Executor> zzgju4) {
        this.zza = zzgju;
        this.zzb = zzgju2;
        this.zzc = zzgju3;
        this.zzd = zzgju4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfqo zzfqo = zzche.zza;
        zzgjp.zzb(zzfqo);
        return new zzdad(this.zza.zzb(), ((zzcxy) this.zzb).zza(), this.zzc.zzb(), zzfqo);
    }
}
