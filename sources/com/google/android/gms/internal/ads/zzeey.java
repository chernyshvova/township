package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeey implements zzedv<zzcvj, zzbxo, zzefj> {
    public final Context zza;
    public final zzcwg zzb;
    public View zzc;
    public zzbvq zzd;

    public zzeey(Context context, zzcwg zzcwg) {
        this.zza = context;
        this.zzb = zzcwg;
    }

    public final void zza(zzeyq zzeyq, zzeye zzeye, zzedq<zzbxo, zzefj> zzedq) throws zzezb {
        try {
            ((zzbxo) zzedq.zzb).zzo(zzeye.zzU);
            if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzfn)).booleanValue() || !zzeye.zzac) {
                ((zzbxo) zzedq.zzb).zzi(zzeye.zzP, zzeye.zzv.toString(), zzeyq.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzeex(this, zzedq, (zzeew) null), (zzbvn) zzedq.zzc, zzeyq.zza.zza.zze);
            } else {
                ((zzbxo) zzedq.zzb).zzq(zzeye.zzP, zzeye.zzv.toString(), zzeyq.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzeex(this, zzedq, (zzeew) null), (zzbvn) zzedq.zzc, zzeyq.zza.zza.zze);
            }
        } catch (RemoteException e) {
            throw new zzezb(e);
        }
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzeyq zzeyq, zzeye zzeye, zzedq zzedq) throws zzezb, zzehd {
        View view;
        if (!((Boolean) zzbex.zzc().zzb(zzbjn.zzfn)).booleanValue() || !zzeye.zzac) {
            view = this.zzc;
        } else {
            try {
                view = (View) ObjectWrapper.unwrap(this.zzd.zze());
                boolean zzf = this.zzd.zzf();
                if (view == null) {
                    throw new zzezb(new Exception("BannerRtbAdapterWrapper interscrollerView should not be null"));
                } else if (zzf) {
                    try {
                        view = (View) zzfqe.zzi(zzfqe.zza(null), new zzeev(this, view, zzeye), zzche.zze).get();
                    } catch (InterruptedException | ExecutionException e) {
                        throw new zzezb(e);
                    }
                }
            } catch (RemoteException e2) {
                throw new zzezb(e2);
            }
        }
        zzcvk zzd2 = this.zzb.zzd(new zzcxx(zzeyq, zzeye, zzedq.zza), new zzcvq(view, (zzcmr) null, new zzeeu(zzedq), zzeye.zzu.get(0)));
        zzd2.zzj().zza(view);
        ((zzefj) zzedq.zzc).zzc(zzd2.zzg());
        return zzd2.zzh();
    }

    public final /* synthetic */ zzfqn zzc(View view, zzeye zzeye, Object obj) throws Exception {
        return zzfqe.zza(zzcwx.zza(this.zza, view, zzeye));
    }
}
