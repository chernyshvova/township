package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public abstract class zzbgt extends zzht implements zzbgu {
    public zzbgt() {
        super("com.google.android.gms.ads.internal.client.IOnAdInspectorClosedListener");
    }

    public final boolean zzbR(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zze((zzbdd) zzhu.zzc(parcel, zzbdd.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
