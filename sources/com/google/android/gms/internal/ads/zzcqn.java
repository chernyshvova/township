package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcqn implements zzdwd {
    public final /* synthetic */ zzcra zza;
    public final Context zzb;
    public final zzbqn zzc;
    public final zzgju<zzdwd> zzd = zzgjh.zza(this);
    public final zzgju<zzbqn> zze;
    public final zzgju<zzdvy> zzf;
    public final zzgju<zzdwa> zzg;

    public /* synthetic */ zzcqn(zzcra zzcra, Context context, zzbqn zzbqn, zzcpp zzcpp) {
        this.zza = zzcra;
        this.zzb = context;
        this.zzc = zzbqn;
        zzgjg zza2 = zzgjh.zza(zzbqn);
        this.zze = zza2;
        zzdvz zzdvz = new zzdvz(zza2);
        this.zzf = zzdvz;
        this.zzg = zzgjf.zza(new zzdwb(this.zzd, zzdvz));
    }

    public final zzdwa zza() {
        return this.zzg.zzb();
    }

    public final zzdvu zzb() {
        return new zzcql(this, (zzcpp) null);
    }
}
