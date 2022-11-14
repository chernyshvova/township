package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzeeu implements zzcxg {
    public final zzedq zza;

    public zzeeu(zzedq zzedq) {
        this.zza = zzedq;
    }

    public final zzbhg zza() {
        try {
            return ((zzbxo) this.zza.zzb).zzh();
        } catch (RemoteException e) {
            throw new zzezb(e);
        }
    }
}
