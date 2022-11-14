package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzaxt extends zzhs implements zzaxv {
    public zzaxt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenAdLoadCallback");
    }

    public final void zzb(zzaxs zzaxs) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, zzaxs);
        zzbr(1, zza);
    }

    public final void zzc(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzbr(2, zza);
    }

    public final void zzd(zzbdd zzbdd) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzd(zza, zzbdd);
        zzbr(3, zza);
    }
}
