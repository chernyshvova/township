package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzehg<AdT> implements zzgjg<zzehf<AdT>> {
    public final zzgju<zzfcx> zza;
    public final zzgju<zzeha> zzb;
    public final zzgju<zzdbf> zzc;
    public final zzgju<zzfdw> zzd;
    public final zzgju<zzfdz> zze;
    public final zzgju<zzcxl<AdT>> zzf;
    public final zzgju<Executor> zzg;
    public final zzgju<ScheduledExecutorService> zzh;
    public final zzgju<zzeds> zzi;

    public zzehg(zzgju<zzfcx> zzgju, zzgju<zzeha> zzgju2, zzgju<zzdbf> zzgju3, zzgju<zzfdw> zzgju4, zzgju<zzfdz> zzgju5, zzgju<zzcxl<AdT>> zzgju6, zzgju<Executor> zzgju7, zzgju<ScheduledExecutorService> zzgju8, zzgju<zzeds> zzgju9) {
        this.zza = zzgju;
        this.zzb = zzgju2;
        this.zzc = zzgju3;
        this.zzd = zzgju4;
        this.zze = zzgju5;
        this.zzf = zzgju6;
        this.zzg = zzgju7;
        this.zzh = zzgju8;
        this.zzi = zzgju9;
    }

    /* renamed from: zza */
    public final zzehf<AdT> zzb() {
        zzfqo zzfqo = zzche.zza;
        zzgjp.zzb(zzfqo);
        return new zzehf(this.zza.zzb(), this.zzb.zzb(), this.zzc.zzb(), this.zzd.zzb(), this.zze.zzb(), this.zzf.zzb(), zzfqo, this.zzh.zzb(), this.zzi.zzb());
    }
}
