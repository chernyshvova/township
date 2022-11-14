package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public abstract class zzbhc extends zzht implements zzbhd {
    public zzbhc() {
        super("com.google.android.gms.ads.internal.client.IResponseInfo");
    }

    public static zzbhd zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IResponseInfo");
        if (queryLocalInterface instanceof zzbhd) {
            return (zzbhd) queryLocalInterface;
        }
        return new zzbhb(iBinder);
    }

    public final boolean zzbR(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            String zze = zze();
            parcel2.writeNoException();
            parcel2.writeString(zze);
        } else if (i == 2) {
            String zzf = zzf();
            parcel2.writeNoException();
            parcel2.writeString(zzf);
        } else if (i != 3) {
            return false;
        } else {
            List<zzbdt> zzg = zzg();
            parcel2.writeNoException();
            parcel2.writeTypedList(zzg);
        }
        return true;
    }
}
