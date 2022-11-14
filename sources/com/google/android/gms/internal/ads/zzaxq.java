package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzaxq extends zzhs implements zzaxs {
    public zzaxq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
    }

    public final zzbfr zze() throws RemoteException {
        throw null;
    }

    public final void zzf(IObjectWrapper iObjectWrapper, zzaxz zzaxz) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, iObjectWrapper);
        zzhu.zzf(zza, zzaxz);
        zzbr(4, zza);
    }

    public final zzbhd zzg() throws RemoteException {
        Parcel zzbq = zzbq(5, zza());
        zzbhd zzb = zzbhc.zzb(zzbq.readStrongBinder());
        zzbq.recycle();
        return zzb;
    }

    public final void zzh(boolean z) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzb(zza, z);
        zzbr(6, zza);
    }

    public final void zzi(zzbha zzbha) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, zzbha);
        zzbr(7, zza);
    }

    public final void zzj(zzaxw zzaxw) throws RemoteException {
        throw null;
    }
}
