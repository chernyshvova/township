package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbff extends zzhs implements zzbfh {
    public zzbff(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoadCallback");
    }

    public final void zzb() throws RemoteException {
        zzbr(1, zza());
    }

    public final void zzc(zzbdd zzbdd) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzd(zza, zzbdd);
        zzbr(2, zza);
    }
}
