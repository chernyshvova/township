package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcqs implements zzewm {
    public final /* synthetic */ zzcra zza;
    public final zzgju<Context> zzb;
    public final zzgju<zzbdp> zzc;
    public final zzgju<String> zzd;
    public final zzgju<zzekq> zze = zzgjf.zza(new zzekr(this.zza.zzn));
    public final zzgju<zzexi> zzf = zzgjf.zza(new zzexj(this.zza.zzar));
    public final zzgju<zzewj> zzg;
    public final zzgju<zzeky> zzh;

    public /* synthetic */ zzcqs(zzcra zzcra, Context context, String str, zzbdp zzbdp, zzcpp zzcpp) {
        this.zza = zzcra;
        this.zzb = zzgjh.zza(context);
        this.zzc = zzgjh.zza(zzbdp);
        this.zzd = zzgjh.zza(str);
        zzgju<zzewj> zza2 = zzgjf.zza(new zzewk(this.zzb, this.zza.zzo, this.zza.zzM, this.zze, this.zzf, zzeyy.zza()));
        this.zzg = zza2;
        this.zzh = zzgjf.zza(new zzekz(this.zzb, this.zzc, this.zzd, zza2, this.zze, this.zzf));
    }

    public final zzeky zza() {
        return this.zzh.zzb();
    }
}
