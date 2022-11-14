package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcvn implements zzgjg<zzcvm> {
    public final zzgju<zzcxh> zza;
    public final zzgju<Context> zzb;
    public final zzgju<zzeyf> zzc;
    public final zzgju<View> zzd;
    public final zzgju<zzcmr> zze;
    public final zzgju<zzcxg> zzf;
    public final zzgju<zzdml> zzg;
    public final zzgju<zzdie> zzh;
    public final zzgju<zzejt> zzi;
    public final zzgju<Executor> zzj;

    public zzcvn(zzgju<zzcxh> zzgju, zzgju<Context> zzgju2, zzgju<zzeyf> zzgju3, zzgju<View> zzgju4, zzgju<zzcmr> zzgju5, zzgju<zzcxg> zzgju6, zzgju<zzdml> zzgju7, zzgju<zzdie> zzgju8, zzgju<zzejt> zzgju9, zzgju<Executor> zzgju10) {
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
    }

    public static zzcvm zzc(zzcxh zzcxh, Context context, zzeyf zzeyf, View view, zzcmr zzcmr, zzcxg zzcxg, zzdml zzdml, zzdie zzdie, zzgja<zzejt> zzgja, Executor executor) {
        return new zzcvm(zzcxh, context, zzeyf, view, zzcmr, zzcxg, zzdml, zzdie, zzgja, executor);
    }

    /* renamed from: zza */
    public final zzcvm zzb() {
        return new zzcvm(((zzczd) this.zza).zzb(), this.zzb.zzb(), ((zzcvt) this.zzc).zza(), ((zzcvs) this.zzd).zza(), ((zzcwe) this.zze).zza(), ((zzcvu) this.zzf).zza(), ((zzdkn) this.zzg).zza(), this.zzh.zzb(), zzgjf.zzc(this.zzi), this.zzj.zzb());
    }
}
