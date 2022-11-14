package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public abstract class zzbvg extends zzht implements zzbvh {
    public zzbvg() {
        super("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    public static zzbvh zzg(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        if (queryLocalInterface instanceof zzbvh) {
            return (zzbvh) queryLocalInterface;
        }
        return new zzbvf(iBinder);
    }

    public final boolean zzbR(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzbvk zzb = zzb(parcel.readString());
            parcel2.writeNoException();
            zzhu.zzf(parcel2, zzb);
        } else if (i == 2) {
            boolean zzc = zzc(parcel.readString());
            parcel2.writeNoException();
            zzhu.zzb(parcel2, zzc);
        } else if (i == 3) {
            zzbxo zzf = zzf(parcel.readString());
            parcel2.writeNoException();
            zzhu.zzf(parcel2, zzf);
        } else if (i != 4) {
            return false;
        } else {
            boolean zzd = zzd(parcel.readString());
            parcel2.writeNoException();
            zzhu.zzb(parcel2, zzd);
        }
        return true;
    }
}
