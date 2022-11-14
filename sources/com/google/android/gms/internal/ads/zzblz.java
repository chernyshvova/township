package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public abstract class zzblz extends zzht implements zzbma {
    public zzblz() {
        super("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
    }

    public static zzbma zzj(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
        if (queryLocalInterface instanceof zzbma) {
            return (zzbma) queryLocalInterface;
        }
        return new zzbly(iBinder);
    }

    public final boolean zzbR(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 2) {
            String zzb = zzb();
            parcel2.writeNoException();
            parcel2.writeString(zzb);
            return true;
        } else if (i != 3) {
            return false;
        } else {
            List<zzbmi> zzc = zzc();
            parcel2.writeNoException();
            parcel2.writeList(zzc);
            return true;
        }
    }
}
