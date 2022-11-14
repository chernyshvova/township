package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbhh extends zzhs implements zzbhj {
    public zzbhh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
    }

    public final void zze() throws RemoteException {
        zzbr(1, zza());
    }

    public final void zzf() throws RemoteException {
        zzbr(2, zza());
    }

    public final void zzg() throws RemoteException {
        zzbr(3, zza());
    }

    public final void zzh() throws RemoteException {
        zzbr(4, zza());
    }

    public final void zzi(boolean z) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzb(zza, z);
        zzbr(5, zza);
    }
}
