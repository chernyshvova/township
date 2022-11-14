package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcqu implements zzexy {
    public final /* synthetic */ zzcra zza;
    public final zzgju<Context> zzb;
    public final zzgju<zzevv<zzdro, zzdrj>> zzc;
    public final zzgju<zzexi> zzd = zzgjf.zza(new zzexj(this.zza.zzar));
    public final zzgju<zzeyr> zze = zzgjf.zza(zzeyt.zza());
    public final zzgju<zzexr> zzf;
    public final zzgju<zzeyb> zzg;
    public final zzgju<String> zzh;
    public final zzgju<zzexv> zzi;

    public /* synthetic */ zzcqu(zzcra zzcra, Context context, String str, zzcpp zzcpp) {
        this.zza = zzcra;
        zzgjg zza2 = zzgjh.zza(context);
        this.zzb = zza2;
        this.zzc = new zzewa(zza2, this.zza.zzar, this.zza.zzas);
        zzgju<zzexr> zza3 = zzgjf.zza(new zzexs(this.zzb, this.zza.zzo, this.zza.zzM, this.zzc, this.zzd, zzeyy.zza(), this.zze));
        this.zzf = zza3;
        this.zzg = zzgjf.zza(new zzeyc(zza3, this.zzd, this.zze));
        zzgjg zzc2 = zzgjh.zzc(str);
        this.zzh = zzc2;
        this.zzi = zzgjf.zza(new zzexw(zzc2, this.zzf, this.zzb, this.zzd, this.zze));
    }

    public final zzeyb zza() {
        return this.zzg.zzb();
    }

    public final zzexv zzb() {
        return this.zzi.zzb();
    }
}
