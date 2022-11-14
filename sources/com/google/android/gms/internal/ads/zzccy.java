package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzccy extends zzhs implements zzcda {
    public zzccy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
    }

    public final void zze() throws RemoteException {
        zzbr(1, zza());
    }

    public final void zzf(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzbr(2, zza);
    }

    public final void zzg(zzbdd zzbdd) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzd(zza, zzbdd);
        zzbr(3, zza);
    }
}
