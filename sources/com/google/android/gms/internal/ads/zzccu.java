package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzccu extends zzhs implements zzccw {
    public zzccu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
    }

    public final void zze() throws RemoteException {
        zzbr(1, zza());
    }

    public final void zzf() throws RemoteException {
        zzbr(2, zza());
    }

    public final void zzg(zzccq zzccq) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, zzccq);
        zzbr(3, zza);
    }

    public final void zzh(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzbr(4, zza);
    }

    public final void zzi(zzbdd zzbdd) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzd(zza, zzbdd);
        zzbr(5, zza);
    }

    public final void zzj() throws RemoteException {
        zzbr(6, zza());
    }
}
