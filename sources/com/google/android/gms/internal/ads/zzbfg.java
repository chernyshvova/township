package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public abstract class zzbfg extends zzht implements zzbfh {
    public zzbfg() {
        super("com.google.android.gms.ads.internal.client.IAdLoadCallback");
    }

    public final boolean zzbR(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzb();
        } else if (i != 2) {
            return false;
        } else {
            zzc((zzbdd) zzhu.zzc(parcel, zzbdd.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
