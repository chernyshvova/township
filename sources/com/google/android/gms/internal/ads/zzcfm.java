package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzcfm extends zzhs implements zzcfo {
    public zzcfm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.signals.ISignalGenerator");
    }

    public final void zze(IObjectWrapper iObjectWrapper, zzcfs zzcfs, zzcfl zzcfl) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, iObjectWrapper);
        zzhu.zzd(zza, zzcfs);
        zzhu.zzf(zza, zzcfl);
        zzbr(1, zza);
    }

    public final void zzf(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, iObjectWrapper);
        zzbr(2, zza);
    }

    public final void zzg(List<Uri> list, IObjectWrapper iObjectWrapper, zzcag zzcag) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzhu.zzf(zza, iObjectWrapper);
        zzhu.zzf(zza, zzcag);
        zzbr(5, zza);
    }

    public final void zzh(List<Uri> list, IObjectWrapper iObjectWrapper, zzcag zzcag) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzhu.zzf(zza, iObjectWrapper);
        zzhu.zzf(zza, zzcag);
        zzbr(6, zza);
    }

    public final void zzi(zzcan zzcan) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzd(zza, zzcan);
        zzbr(7, zza);
    }

    public final void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, iObjectWrapper);
        zzbr(8, zza);
    }
}
