package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbzp extends zzhs implements zzbzr {
    public zzbzp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
    }

    public final void zze() throws RemoteException {
        zzbr(10, zza());
    }

    public final void zzf() throws RemoteException {
        zzbr(14, zza());
    }

    public final boolean zzg() throws RemoteException {
        Parcel zzbq = zzbq(11, zza());
        boolean zza = zzhu.zza(zzbq);
        zzbq.recycle();
        return zza;
    }

    public final void zzh(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzd(zza, bundle);
        zzbr(1, zza);
    }

    public final void zzi() throws RemoteException {
        zzbr(2, zza());
    }

    public final void zzj() throws RemoteException {
        zzbr(3, zza());
    }

    public final void zzk() throws RemoteException {
        zzbr(4, zza());
    }

    public final void zzl() throws RemoteException {
        zzbr(5, zza());
    }

    public final void zzm(int i, int i2, Intent intent) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zza.writeInt(i2);
        zzhu.zzd(zza, intent);
        zzbr(12, zza);
    }

    public final void zzn(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, iObjectWrapper);
        zzbr(13, zza);
    }

    public final void zzo(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzd(zza, bundle);
        Parcel zzbq = zzbq(6, zza);
        if (zzbq.readInt() != 0) {
            bundle.readFromParcel(zzbq);
        }
        zzbq.recycle();
    }

    public final void zzp() throws RemoteException {
        zzbr(7, zza());
    }

    public final void zzq() throws RemoteException {
        zzbr(8, zza());
    }

    public final void zzs() throws RemoteException {
        zzbr(9, zza());
    }
}
