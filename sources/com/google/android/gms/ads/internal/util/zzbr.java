package com.google.android.gms.ads.internal.util;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzht;
import com.google.android.gms.internal.ads.zzhu;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public abstract class zzbr extends zzht implements zzbs {
    public zzbr() {
        super("com.google.android.gms.ads.internal.util.IWorkManagerUtil");
    }

    public final boolean zzbR(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            boolean zze = zze(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            zzhu.zzb(parcel2, zze);
        } else if (i != 2) {
            return false;
        } else {
            zzf(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
            parcel2.writeNoException();
        }
        return true;
    }
}
