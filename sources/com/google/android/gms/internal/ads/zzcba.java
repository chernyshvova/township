package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcba extends zzhs implements zzcbc {
    public zzcba(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    public final void zze(zzcbk zzcbk, zzcbg zzcbg) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzd(zza, zzcbk);
        zzhu.zzf(zza, zzcbg);
        zzbr(4, zza);
    }

    public final void zzf(zzcbk zzcbk, zzcbg zzcbg) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzd(zza, zzcbk);
        zzhu.zzf(zza, zzcbg);
        zzbr(5, zza);
    }

    public final void zzg(zzcbk zzcbk, zzcbg zzcbg) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzd(zza, zzcbk);
        zzhu.zzf(zza, zzcbg);
        zzbr(6, zza);
    }

    public final void zzh(String str, zzcbg zzcbg) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzhu.zzf(zza, zzcbg);
        zzbr(7, zza);
    }
}
