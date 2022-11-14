package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzegm extends zzbxh {
    public final /* synthetic */ zzegn zza;
    public final zzedq<zzbxo, zzefj> zzb;

    public /* synthetic */ zzegm(zzegn zzegn, zzedq zzedq, zzegl zzegl) {
        this.zza = zzegn;
        this.zzb = zzedq;
    }

    public final void zze(zzbvw zzbvw) throws RemoteException {
        zzbvw unused = this.zza.zzc = zzbvw;
        ((zzefj) this.zzb.zzc).zzj();
    }

    public final void zzf(String str) throws RemoteException {
        ((zzefj) this.zzb.zzc).zzw(0, str);
    }

    public final void zzg(zzbdd zzbdd) throws RemoteException {
        ((zzefj) this.zzb.zzc).zzx(zzbdd);
    }
}
