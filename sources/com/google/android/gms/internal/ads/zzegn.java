package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzegn implements zzedv<zzdlv, zzbxo, zzefj> {
    public final Context zza;
    public final zzdkp zzb;
    public zzbvw zzc;
    public final zzcgy zzd;

    public zzegn(Context context, zzdkp zzdkp, zzcgy zzcgy) {
        this.zza = context;
        this.zzb = zzdkp;
        this.zzd = zzcgy;
    }

    public final void zza(zzeyq zzeyq, zzeye zzeye, zzedq<zzbxo, zzefj> zzedq) throws zzezb {
        try {
            ((zzbxo) zzedq.zzb).zzo(zzeye.zzU);
            if (this.zzd.zzc < ((Integer) zzbex.zzc().zzb(zzbjn.zzbd)).intValue()) {
                ((zzbxo) zzedq.zzb).zzn(zzeye.zzP, zzeye.zzv.toString(), zzeyq.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzegm(this, zzedq, (zzegl) null), (zzbvn) zzedq.zzc);
            } else {
                ((zzbxo) zzedq.zzb).zzr(zzeye.zzP, zzeye.zzv.toString(), zzeyq.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzegm(this, zzedq, (zzegl) null), (zzbvn) zzedq.zzc, zzeyq.zza.zza.zzi);
            }
        } catch (RemoteException e) {
            throw new zzezb(e);
        }
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzeyq zzeyq, zzeye zzeye, zzedq zzedq) throws zzezb, zzehd {
        if (zzeyq.zza.zza.zzg.contains(Integer.toString(6))) {
            zzdma zzaa = zzdma.zzaa(this.zzc);
            if (zzeyq.zza.zza.zzg.contains(Integer.toString(zzaa.zzv()))) {
                zzdmc zzd2 = this.zzb.zzd(new zzcxx(zzeyq, zzeye, zzedq.zza), new zzdmm(zzaa), new zzdnz((zzbvt) null, (zzbvs) null, this.zzc, (byte[]) null));
                ((zzefj) zzedq.zzc).zzc(zzd2.zzg());
                return zzd2.zzh();
            }
            throw new zzehd(1, "No corresponding native ad listener");
        }
        throw new zzehd(2, "Unified must be used for RTB.");
    }
}
