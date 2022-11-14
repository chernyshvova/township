package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbgy extends zzhs implements zzbha {
    public zzbgy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IOnPaidEventListener");
    }

    public final void zze(zzbdr zzbdr) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzd(zza, zzbdr);
        zzbr(1, zza);
    }
}
