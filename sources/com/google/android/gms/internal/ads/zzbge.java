package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public abstract class zzbge extends zzht implements zzbgf {
    public zzbge() {
        super("com.google.android.gms.ads.internal.client.IFullScreenContentCallback");
    }

    public final boolean zzbR(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzb((zzbdd) zzhu.zzc(parcel, zzbdd.CREATOR));
        } else if (i == 2) {
            zzc();
        } else if (i == 3) {
            zzd();
        } else if (i != 4) {
            return false;
        } else {
            zze();
        }
        parcel2.writeNoException();
        return true;
    }
}
