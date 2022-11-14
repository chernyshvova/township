package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzczv implements zzddy {
    public final Context zza;
    public final zzeyw zzb;
    public final zzcgy zzc;
    public final zzg zzd;
    public final zzdww zze;

    public zzczv(Context context, zzeyw zzeyw, zzcgy zzcgy, zzg zzg, zzdww zzdww) {
        this.zza = context;
        this.zzb = zzeyw;
        this.zzc = zzcgy;
        this.zzd = zzg;
        this.zze = zzdww;
    }

    public final void zzj(zzcbk zzcbk) {
        if (((Boolean) zzbex.zzc().zzb(zzbjn.zzco)).booleanValue()) {
            zzs.zzk().zzb(this.zza, this.zzc, this.zzb.zzf, this.zzd.zzn());
        }
        this.zze.zzc();
    }

    public final void zzq(zzeyq zzeyq) {
    }
}
