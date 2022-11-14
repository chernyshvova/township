package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzbv;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzefu implements zzedv<zzdiw, zzezn, zzefj> {
    public final Context zza;
    public final zzdjt zzb;
    public final zzcgy zzc;
    public final Executor zzd;

    public zzefu(Context context, zzcgy zzcgy, zzdjt zzdjt, Executor executor) {
        this.zza = context;
        this.zzc = zzcgy;
        this.zzb = zzdjt;
        this.zzd = executor;
    }

    public final void zza(zzeyq zzeyq, zzeye zzeye, zzedq<zzezn, zzefj> zzedq) throws zzezb {
        ((zzezn) zzedq.zzb).zzh(this.zza, zzeyq.zza.zza.zzd, zzeye.zzv.toString(), zzbv.zzl(zzeye.zzs), (zzbvn) zzedq.zzc);
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzeyq zzeyq, zzeye zzeye, zzedq zzedq) throws zzezb, zzehd {
        zzdix zzc2 = this.zzb.zzc(new zzcxx(zzeyq, zzeye, zzedq.zza), new zzdja(new zzeft(this, zzedq), (zzcmr) null));
        zzc2.zza().zzh(new zzcta((zzezn) zzedq.zzb), this.zzd);
        ((zzefj) zzedq.zzc).zzc(zzc2.zzf());
        return zzc2.zzh();
    }

    public final /* synthetic */ void zzc(zzedq zzedq, boolean z, Context context, zzdbq zzdbq) throws zzdka {
        try {
            ((zzezn) zzedq.zzb).zzs(z);
            if (this.zzc.zzc < ((Integer) zzbex.zzc().zzb(zzbjn.zzau)).intValue()) {
                ((zzezn) zzedq.zzb).zzd();
            } else {
                ((zzezn) zzedq.zzb).zze(context);
            }
        } catch (zzezb e) {
            zzcgs.zzh("Cannot show interstitial.");
            throw new zzdka(e.getCause());
        }
    }
}
