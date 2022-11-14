package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzehm implements zzedv<zzdrj, zzbxo, zzefj> {
    public final Context zza;
    public final zzdro zzb;

    public zzehm(Context context, zzdro zzdro) {
        this.zza = context;
        this.zzb = zzdro;
    }

    public final void zza(zzeyq zzeyq, zzeye zzeye, zzedq<zzbxo, zzefj> zzedq) throws zzezb {
        try {
            ((zzbxo) zzedq.zzb).zzo(zzeye.zzU);
            if (zzeyq.zza.zza.zzo.zza == 3) {
                ((zzbxo) zzedq.zzb).zzp(zzeye.zzP, zzeye.zzv.toString(), zzeyq.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzehl(this, zzedq, (zzehk) null), (zzbvn) zzedq.zzc);
            } else {
                ((zzbxo) zzedq.zzb).zzl(zzeye.zzP, zzeye.zzv.toString(), zzeyq.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzehl(this, zzedq, (zzehk) null), (zzbvn) zzedq.zzc);
            }
        } catch (RemoteException e) {
            zze.zzb("Remote exception loading a rewarded RTB ad", e);
        }
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzeyq zzeyq, zzeye zzeye, zzedq zzedq) throws zzezb, zzehd {
        zzefs zzefs = new zzefs(zzeye, (zzbxo) zzedq.zzb, true);
        zzdrk zze = this.zzb.zze(new zzcxx(zzeyq, zzeye, zzedq.zza), new zzdrl(zzefs));
        zzefs.zzb(zze.zzd());
        ((zzefj) zzedq.zzc).zzc(zze.zzn());
        return zze.zzh();
    }
}
