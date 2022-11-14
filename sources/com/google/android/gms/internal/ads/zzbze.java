package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public abstract class zzbze extends zzht implements zzbzf {
    public zzbze() {
        super("com.google.android.gms.ads.internal.offline.IOfflineUtils");
    }

    public static zzbzf zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.offline.IOfflineUtils");
        if (queryLocalInterface instanceof zzbzf) {
            return (zzbzf) queryLocalInterface;
        }
        return new zzbzd(iBinder);
    }

    public final boolean zzbR(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zze((Intent) zzhu.zzc(parcel, Intent.CREATOR));
        } else if (i == 2) {
            zzf(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
        } else if (i != 3) {
            return false;
        } else {
            zzg();
        }
        parcel2.writeNoException();
        return true;
    }
}
