package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzayl extends zzhs implements IInterface {
    public zzayl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.cache.ICacheService");
    }

    public final zzayg zze(zzayj zzayj) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzd(zza, zzayj);
        Parcel zzbq = zzbq(1, zza);
        zzayg zzayg = (zzayg) zzhu.zzc(zzbq, zzayg.CREATOR);
        zzbq.recycle();
        return zzayg;
    }

    public final zzayg zzf(zzayj zzayj) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzd(zza, zzayj);
        Parcel zzbq = zzbq(2, zza);
        zzayg zzayg = (zzayg) zzhu.zzc(zzbq, zzayg.CREATOR);
        zzbq.recycle();
        return zzayg;
    }

    public final long zzg(zzayj zzayj) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzd(zza, zzayj);
        Parcel zzbq = zzbq(3, zza);
        long readLong = zzbq.readLong();
        zzbq.recycle();
        return readLong;
    }
}
