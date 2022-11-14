package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.overlay.zzv;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeec implements zzdkb {
    public final zzcgy zza;
    public final zzfqn<zzcuu> zzb;
    public final zzeye zzc;
    public final zzcmr zzd;
    public final zzeyw zze;
    public final zzbpv zzf;
    public final boolean zzg;

    public zzeec(zzcgy zzcgy, zzfqn<zzcuu> zzfqn, zzeye zzeye, zzcmr zzcmr, zzeyw zzeyw, boolean z, zzbpv zzbpv) {
        this.zza = zzcgy;
        this.zzb = zzfqn;
        this.zzc = zzeye;
        this.zzd = zzcmr;
        this.zze = zzeyw;
        this.zzg = z;
        this.zzf = zzbpv;
    }

    public final void zza(boolean z, Context context, zzdbq zzdbq) {
        int i;
        zzcuu zzcuu = (zzcuu) zzfqe.zzr(this.zzb);
        this.zzd.zzag(true);
        zzj zzj = new zzj(this.zzg ? this.zzf.zzc(true) : true, true, this.zzg ? this.zzf.zzd() : false, this.zzg ? this.zzf.zze() : 0.0f, -1, z, this.zzc.zzK, false);
        zzs.zzb();
        zzdjq zzj2 = zzcuu.zzj();
        zzcmr zzcmr = this.zzd;
        int i2 = this.zzc.zzM;
        if (i2 == -1) {
            zzbdv zzbdv = this.zze.zzj;
            if (zzbdv != null) {
                int i3 = zzbdv.zza;
                if (i3 == 1) {
                    i = 7;
                } else if (i3 == 2) {
                    i = 6;
                }
                zzcgy zzcgy = this.zza;
                zzeye zzeye = this.zzc;
                String str = zzeye.zzB;
                zzeyj zzeyj = zzeye.zzs;
                AdOverlayInfoParcel adOverlayInfoParcel = r4;
                AdOverlayInfoParcel adOverlayInfoParcel2 = new AdOverlayInfoParcel((zzbcz) null, zzj2, (zzv) null, zzcmr, i, zzcgy, str, zzj, zzeyj.zzb, zzeyj.zza, this.zze.zzf, zzdbq);
                zzm.zza(context, adOverlayInfoParcel, true);
            }
            zzcgs.zzd("Error setting app open orientation; no targeting orientation available.");
            i2 = this.zzc.zzM;
        }
        i = i2;
        zzcgy zzcgy2 = this.zza;
        zzeye zzeye2 = this.zzc;
        String str2 = zzeye2.zzB;
        zzeyj zzeyj2 = zzeye2.zzs;
        AdOverlayInfoParcel adOverlayInfoParcel3 = adOverlayInfoParcel2;
        AdOverlayInfoParcel adOverlayInfoParcel22 = new AdOverlayInfoParcel((zzbcz) null, zzj2, (zzv) null, zzcmr, i, zzcgy2, str2, zzj, zzeyj2.zzb, zzeyj2.zza, this.zze.zzf, zzdbq);
        zzm.zza(context, adOverlayInfoParcel3, true);
    }
}
