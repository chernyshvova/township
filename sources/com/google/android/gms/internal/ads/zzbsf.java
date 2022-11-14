package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbsf extends zzhs implements zzbsh {
    public zzbsf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.instream.client.IInstreamAdLoadCallback");
    }

    public final void zze(zzbsb zzbsb) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, zzbsb);
        zzbr(1, zza);
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
