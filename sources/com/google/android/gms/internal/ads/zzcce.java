package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzcce extends zzhs implements zzccg {
    public zzcce(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
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

    public final void zzi(zzcca zzcca) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, zzcca);
        zzbr(5, zza);
    }

    public final void zzj() throws RemoteException {
        zzbr(6, zza());
    }

    public final void zzk(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzbr(7, zza);
    }

    public final void zzl() throws RemoteException {
        zzbr(8, zza());
    }
}
