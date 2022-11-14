package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeex extends zzbxb {
    public final /* synthetic */ zzeey zza;
    public final zzedq<zzbxo, zzefj> zzb;

    public /* synthetic */ zzeex(zzeey zzeey, zzedq zzedq, zzeew zzeew) {
        this.zza = zzeey;
        this.zzb = zzedq;
    }

    public final void zze(IObjectWrapper iObjectWrapper) throws RemoteException {
        View unused = this.zza.zzc = (View) ObjectWrapper.unwrap(iObjectWrapper);
        ((zzefj) this.zzb.zzc).zzj();
    }

    public final void zzf(String str) throws RemoteException {
        ((zzefj) this.zzb.zzc).zzw(0, str);
    }

    public final void zzg(zzbdd zzbdd) throws RemoteException {
        ((zzefj) this.zzb.zzc).zzx(zzbdd);
    }

    public final void zzh(zzbvq zzbvq) throws RemoteException {
        zzbvq unused = this.zza.zzd = zzbvq;
        ((zzefj) this.zzb.zzc).zzj();
    }
}
