package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbfi extends zzhs implements zzbfk {
    public zzbfi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoader");
    }

    public final void zze(zzbdk zzbdk) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzd(zza, zzbdk);
        zzbr(1, zza);
    }

    public final String zzf() throws RemoteException {
        throw null;
    }

    public final boolean zzg() throws RemoteException {
        Parcel zzbq = zzbq(3, zza());
        boolean zza = zzhu.zza(zzbq);
        zzbq.recycle();
        return zza;
    }

    public final String zzh() throws RemoteException {
        throw null;
    }

    public final void zzi(zzbdk zzbdk, int i) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzd(zza, zzbdk);
        zza.writeInt(i);
        zzbr(5, zza);
    }
}
