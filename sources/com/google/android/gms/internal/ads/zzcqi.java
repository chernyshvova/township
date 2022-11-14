package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcqi implements zzeuu {
    public final /* synthetic */ zzcra zza;
    public final Context zzb;
    public final zzbdp zzc;
    public final String zzd;
    public final zzgju<Context> zze;
    public final zzgju<zzbdp> zzf;
    public final zzgju<zzekq> zzg = zzgjf.zza(new zzekr(this.zza.zzn));
    public final zzgju<zzeku> zzh = zzgjf.zza(zzekw.zza());
    public final zzgju<zzeur> zzi = zzgjf.zza(new zzeus(this.zze, this.zza.zzo, this.zzf, this.zza.zzM, this.zzg, this.zzh, zzeyy.zza()));

    public /* synthetic */ zzcqi(zzcra zzcra, Context context, String str, zzbdp zzbdp, zzcpp zzcpp) {
        this.zza = zzcra;
        this.zzb = context;
        this.zzc = zzbdp;
        this.zzd = str;
        this.zze = zzgjh.zza(context);
        this.zzf = zzgjh.zza(zzbdp);
    }

    public final zzejy zza() {
        return new zzejy(this.zzb, this.zzc, this.zzd, this.zzi.zzb(), this.zzg.zzb());
    }
}
