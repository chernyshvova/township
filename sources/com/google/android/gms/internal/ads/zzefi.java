package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzefi implements zzgjg<zzefh> {
    public final zzgju<zzcwg> zza;
    public final zzgju<zzeeo> zzb;
    public final zzgju<zzdbf> zzc;
    public final zzgju<ScheduledExecutorService> zzd;
    public final zzgju<zzfqo> zze;

    public zzefi(zzgju<zzcwg> zzgju, zzgju<zzeeo> zzgju2, zzgju<zzdbf> zzgju3, zzgju<ScheduledExecutorService> zzgju4, zzgju<zzfqo> zzgju5) {
        this.zza = zzgju;
        this.zzb = zzgju2;
        this.zzc = zzgju3;
        this.zzd = zzgju4;
        this.zze = zzgju5;
    }

    /* renamed from: zza */
    public final zzefh zzb() {
        zzfqo zzfqo = zzche.zza;
        zzgjp.zzb(zzfqo);
        return new zzefh(this.zza.zzb(), ((zzeep) this.zzb).zzb(), this.zzc.zzb(), this.zzd.zzb(), zzfqo);
    }
}
