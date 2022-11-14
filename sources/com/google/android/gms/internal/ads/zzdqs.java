package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdqs implements Callable<zzdqu> {
    public final zza zza;
    public final zzcnd zzb;
    public final Context zzc;
    public final zzduu zzd;
    public final zzfdh zze;
    public final zzedb zzf;
    public final Executor zzg;
    public final zzfb zzh;
    public final zzcgy zzi;
    public final zzfdz zzj;

    public zzdqs(Context context, Executor executor, zzfb zzfb, zzcgy zzcgy, zza zza2, zzcnd zzcnd, zzedb zzedb, zzfdz zzfdz, zzduu zzduu, zzfdh zzfdh) {
        this.zzc = context;
        this.zzg = executor;
        this.zzh = zzfb;
        this.zzi = zzcgy;
        this.zza = zza2;
        this.zzb = zzcnd;
        this.zzf = zzedb;
        this.zzj = zzfdz;
        this.zzd = zzduu;
        this.zze = zzfdh;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzdqu zzdqu = new zzdqu(this);
        zzdqu.zza();
        return zzdqu;
    }
}
