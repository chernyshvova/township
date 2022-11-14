package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdyx implements zzgjg<zzdyw> {
    public final zzgju<ScheduledExecutorService> zza;
    public final zzgju<zzfqo> zzb;
    public final zzgju<zzdzn> zzc;
    public final zzgju<zzebb> zzd;

    public zzdyx(zzgju<ScheduledExecutorService> zzgju, zzgju<zzfqo> zzgju2, zzgju<zzdzn> zzgju3, zzgju<zzebb> zzgju4) {
        this.zza = zzgju;
        this.zzb = zzgju2;
        this.zzc = zzgju3;
        this.zzd = zzgju4;
    }

    /* renamed from: zza */
    public final zzdyw zzb() {
        zzfqo zzfqo = zzche.zza;
        zzgjp.zzb(zzfqo);
        return new zzdyw(this.zza.zzb(), zzfqo, ((zzdzo) this.zzc).zzb(), zzgjf.zzc(this.zzd));
    }
}
