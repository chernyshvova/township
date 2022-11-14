package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public abstract class zzccp extends zzht implements zzccq {
    public zzccp() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
    }

    public static zzccq zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
        if (queryLocalInterface instanceof zzccq) {
            return (zzccq) queryLocalInterface;
        }
        return new zzcco(iBinder);
    }

    public final boolean zzbR(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            String zze = zze();
            parcel2.writeNoException();
            parcel2.writeString(zze);
        } else if (i != 2) {
            return false;
        } else {
            int zzf = zzf();
            parcel2.writeNoException();
            parcel2.writeInt(zzf);
        }
        return true;
    }
}
