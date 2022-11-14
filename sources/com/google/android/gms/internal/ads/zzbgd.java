package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbgd extends zzhs implements zzbgf {
    public zzbgd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IFullScreenContentCallback");
    }

    public final void zzb(zzbdd zzbdd) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzd(zza, zzbdd);
        zzbr(1, zza);
    }

    public final void zzc() throws RemoteException {
        zzbr(2, zza());
    }

    public final void zzd() throws RemoteException {
        zzbr(3, zza());
    }

    public final void zze() throws RemoteException {
        zzbr(4, zza());
    }
}
