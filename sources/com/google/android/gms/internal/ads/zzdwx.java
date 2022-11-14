package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdwx implements zzgjg<zzdww> {
    public final zzgju<Executor> zza;
    public final zzgju<Context> zzb;
    public final zzgju<WeakReference<Context>> zzc;
    public final zzgju<Executor> zzd;
    public final zzgju<zzdss> zze;
    public final zzgju<ScheduledExecutorService> zzf;
    public final zzgju<zzdvd> zzg;
    public final zzgju<zzcgy> zzh;
    public final zzgju<zzdhl> zzi;

    public zzdwx(zzgju<Executor> zzgju, zzgju<Context> zzgju2, zzgju<WeakReference<Context>> zzgju3, zzgju<Executor> zzgju4, zzgju<zzdss> zzgju5, zzgju<ScheduledExecutorService> zzgju6, zzgju<zzdvd> zzgju7, zzgju<zzcgy> zzgju8, zzgju<zzdhl> zzgju9) {
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

    public final /* bridge */ /* synthetic */ Object zzb() {
        Context zza2 = ((zzcou) this.zzb).zza();
        WeakReference<Context> zza3 = ((zzcov) this.zzc).zza();
        zzfqo zzfqo = zzche.zza;
        zzgjp.zzb(zzfqo);
        return new zzdww(this.zza.zzb(), zza2, zza3, zzfqo, this.zze.zzb(), this.zzf.zzb(), this.zzg.zzb(), ((zzcpd) this.zzh).zza(), ((zzdhm) this.zzi).zzb());
    }
}
