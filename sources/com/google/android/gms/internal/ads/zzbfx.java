package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public abstract class zzbfx extends zzht implements zzbfy {
    public zzbfx() {
        super("com.google.android.gms.ads.internal.client.IAppEventListener");
    }

    public static zzbfy zzd(IBinder iBinder) {
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
        if (queryLocalInterface instanceof zzbfy) {
            return (zzbfy) queryLocalInterface;
        }
        return new zzbfw(iBinder);
    }

    public final boolean zzbR(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zzb(parcel.readString(), parcel.readString());
        parcel2.writeNoException();
        return true;
    }
}
