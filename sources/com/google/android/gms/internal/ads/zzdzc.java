package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdzc implements zzgjg<zzdzb> {
    public final zzgju<zzeyw> zza;
    public final zzgju<zzdyc> zzb;
    public final zzgju<zzfqo> zzc;
    public final zzgju<ScheduledExecutorService> zzd;
    public final zzgju<zzecf> zze;

    public zzdzc(zzgju<zzeyw> zzgju, zzgju<zzdyc> zzgju2, zzgju<zzfqo> zzgju3, zzgju<ScheduledExecutorService> zzgju4, zzgju<zzecf> zzgju5) {
        this.zza = zzgju;
        this.zzb = zzgju2;
        this.zzc = zzgju3;
        this.zzd = zzgju4;
        this.zze = zzgju5;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzeyw zza2 = ((zzdau) this.zza).zza();
        zzdyc zza3 = ((zzdyd) this.zzb).zzb();
        zzfqo zzfqo = zzche.zza;
        zzgjp.zzb(zzfqo);
        return new zzdzb(zza2, zza3, zzfqo, this.zzd.zzb(), this.zze.zzb());
    }
}
