package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public abstract class zzbgz extends zzht implements zzbha {
    public zzbgz() {
        super("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
    }

    public static zzbha zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
        if (queryLocalInterface instanceof zzbha) {
            return (zzbha) queryLocalInterface;
        }
        return new zzbgy(iBinder);
    }

    public final boolean zzbR(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zze((zzbdr) zzhu.zzc(parcel, zzbdr.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
