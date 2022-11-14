package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public abstract class zzcfk extends zzht implements zzcfl {
    public zzcfk() {
        super("com.google.android.gms.ads.internal.signals.ISignalCallback");
    }

    public final boolean zzbR(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            parcel.readString();
            parcel.readString();
        } else if (i == 2) {
            zzb(parcel.readString());
        } else if (i != 3) {
            return false;
        } else {
            zzc(parcel.readString(), parcel.readString(), (Bundle) zzhu.zzc(parcel, Bundle.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
