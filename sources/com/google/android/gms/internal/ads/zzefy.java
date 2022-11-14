package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzefy implements zzedv<zzdiw, zzbxo, zzefj> {
    public final Context zza;
    public final zzdjt zzb;

    public zzefy(Context context, zzdjt zzdjt) {
        this.zza = context;
        this.zzb = zzdjt;
    }

    public final void zza(zzeyq zzeyq, zzeye zzeye, zzedq<zzbxo, zzefj> zzedq) throws zzezb {
        try {
            ((zzbxo) zzedq.zzb).zzo(zzeye.zzU);
            ((zzbxo) zzedq.zzb).zzj(zzeye.zzP, zzeye.zzv.toString(), zzeyq.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzefx(this, zzedq, (zzefw) null), (zzbvn) zzedq.zzc);
        } catch (RemoteException e) {
            throw new zzezb(e);
        }
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzeyq zzeyq, zzeye zzeye, zzedq zzedq) throws zzezb, zzehd {
        zzefs zzefs = new zzefs(zzeye, (zzbxo) zzedq.zzb, false);
        zzdix zzc = this.zzb.zzc(new zzcxx(zzeyq, zzeye, zzedq.zza), new zzdja(zzefs, (zzcmr) null));
        zzefs.zzb(zzc.zzd());
        ((zzefj) zzedq.zzc).zzc(zzc.zzg());
        return zzc.zzh();
    }
}
