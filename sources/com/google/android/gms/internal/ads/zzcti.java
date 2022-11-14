package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcti implements zzgjg<zzcth> {
    public final zzgju<Context> zza;
    public final zzgju<Executor> zzb;
    public final zzgju<Executor> zzc;
    public final zzgju<ScheduledExecutorService> zzd;
    public final zzgju<zzeyq> zze;
    public final zzgju<zzeye> zzf;
    public final zzgju<zzfdw> zzg;
    public final zzgju<zzezg> zzh;
    public final zzgju<View> zzi;
    public final zzgju<zzfb> zzj;
    public final zzgju<zzbkm> zzk;
    public final zzgju<zzbko> zzl;

    public zzcti(zzgju<Context> zzgju, zzgju<Executor> zzgju2, zzgju<Executor> zzgju3, zzgju<ScheduledExecutorService> zzgju4, zzgju<zzeyq> zzgju5, zzgju<zzeye> zzgju6, zzgju<zzfdw> zzgju7, zzgju<zzezg> zzgju8, zzgju<View> zzgju9, zzgju<zzfb> zzgju10, zzgju<zzbkm> zzgju11, zzgju<zzbko> zzgju12) {
        this.zza = zzgju;
        this.zzb = zzgju2;
        this.zzc = zzgju3;
        this.zzd = zzgju4;
        this.zze = zzgju5;
        this.zzf = zzgju6;
        this.zzg = zzgju7;
        this.zzh = zzgju8;
        this.zzi = zzgju9;
        this.zzj = zzgju10;
        this.zzk = zzgju11;
        this.zzl = zzgju12;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Context zza2 = ((zzfaa) this.zza).zza();
        zzfqo zzfqo = zzche.zza;
        zzgjp.zzb(zzfqo);
        return new zzcth(zza2, zzfqo, this.zzc.zzb(), this.zzd.zzb(), ((zzcyb) this.zze).zza(), ((zzcxy) this.zzf).zza(), this.zzg.zzb(), this.zzh.zzb(), this.zzi.zzb(), this.zzj.zzb(), this.zzk.zzb(), new zzbko(), (byte[]) null);
    }
}
