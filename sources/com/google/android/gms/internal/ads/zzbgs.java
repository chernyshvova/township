package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbgs extends zzhs implements zzbgu {
    public zzbgs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IOnAdInspectorClosedListener");
    }

    public final void zze(zzbdd zzbdd) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzd(zza, zzbdd);
        zzbr(1, zza);
    }
}
