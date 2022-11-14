package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcqc implements zzetj {
    public final /* synthetic */ zzcra zza;
    public final zzgju<Context> zzb;
    public final zzgju<String> zzc;
    public final zzgju<zzevv<zzcum, zzcus>> zzd = new zzevz(this.zzb, this.zza.zzar, this.zza.zzas);
    public final zzgju<zzeud> zze = zzgjf.zza(new zzeue(this.zza.zzar));
    public final zzgju<zzeta> zzf = zzgjf.zza(new zzetb(this.zzb, this.zza.zzo, this.zza.zzM, this.zzd, this.zze, zzeyy.zza()));
    public final zzgju<zzetg> zzg = zzgjf.zza(new zzeth(this.zza.zzM, this.zzb, this.zzc, this.zzf, this.zze, this.zza.zzh));
    public final zzgju<zzevv<zzcux, zzcvc>> zzh = new zzevy(this.zzb, this.zza.zzar, this.zza.zzas);
    public final zzgju<zzeuf> zzi = zzgjf.zza(new zzeug(this.zzb, this.zza.zzo, this.zza.zzM, this.zzh, this.zze, zzeyy.zza()));
    public final zzgju<zzeul> zzj = zzgjf.zza(new zzeum(this.zza.zzM, this.zzb, this.zzc, this.zzi, this.zze));

    public /* synthetic */ zzcqc(zzcra zzcra, Context context, String str, zzcpp zzcpp) {
        this.zza = zzcra;
        this.zzb = zzgjh.zza(context);
        this.zzc = zzgjh.zza(str);
    }

    public final zzetg zza() {
        return this.zzg.zzb();
    }

    public final zzeul zzb() {
        return this.zzj.zzb();
    }
}
