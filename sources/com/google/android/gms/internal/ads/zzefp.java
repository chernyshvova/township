package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.overlay.zzv;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzefp implements zzdkb {
    public final Context zza;
    public final zzcgy zzb;
    public final zzfqn<zzdix> zzc;
    public final zzeye zzd;
    public final zzcmr zze;
    public final zzeyw zzf;
    public final zzbpv zzg;
    public final boolean zzh;

    public zzefp(Context context, zzcgy zzcgy, zzfqn<zzdix> zzfqn, zzeye zzeye, zzcmr zzcmr, zzeyw zzeyw, boolean z, zzbpv zzbpv) {
        this.zza = context;
        this.zzb = zzcgy;
        this.zzc = zzfqn;
        this.zzd = zzeye;
        this.zze = zzcmr;
        this.zzf = zzeyw;
        this.zzg = zzbpv;
        this.zzh = z;
    }

    public final void zza(boolean z, Context context, zzdbq zzdbq) {
        zzdix zzdix = (zzdix) zzfqe.zzr(this.zzc);
        this.zze.zzag(true);
        boolean zzc2 = this.zzh ? this.zzg.zzc(false) : false;
        zzs.zzc();
        zzj zzj = new zzj(zzc2, zzr.zzL(this.zza), this.zzh ? this.zzg.zzd() : false, this.zzh ? this.zzg.zze() : 0.0f, -1, z, this.zzd.zzK, false);
        if (zzdbq != null) {
            zzdbq.zze();
        }
        zzs.zzb();
        zzdjq zzj2 = zzdix.zzj();
        zzcmr zzcmr = this.zze;
        zzeye zzeye = this.zzd;
        int i = zzeye.zzM;
        zzcgy zzcgy = this.zzb;
        String str = zzeye.zzB;
        zzeyj zzeyj = zzeye.zzs;
        AdOverlayInfoParcel adOverlayInfoParcel = r4;
        AdOverlayInfoParcel adOverlayInfoParcel2 = new AdOverlayInfoParcel((zzbcz) null, zzj2, (zzv) null, zzcmr, i, zzcgy, str, zzj, zzeyj.zzb, zzeyj.zza, this.zzf.zzf, zzdbq);
        zzm.zza(context, adOverlayInfoParcel, true);
    }
}
