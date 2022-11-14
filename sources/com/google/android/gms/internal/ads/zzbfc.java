package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbfc extends zzhs implements zzbfe {
    public zzbfc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdListener");
    }

    public final void zzb() throws RemoteException {
        zzbr(1, zza());
    }

    public final void zzc(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzbr(2, zza);
    }

    public final void zzd(zzbdd zzbdd) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzd(zza, zzbdd);
        zzbr(8, zza);
    }

    public final void zze() throws RemoteException {
        zzbr(3, zza());
    }

    public final void zzf() throws RemoteException {
        zzbr(4, zza());
    }

    public final void zzg() throws RemoteException {
        zzbr(5, zza());
    }

    public final void zzh() throws RemoteException {
        zzbr(6, zza());
    }

    public final void zzi() throws RemoteException {
        zzbr(7, zza());
    }
}
