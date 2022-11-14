package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public abstract class zzbxb extends zzht implements zzbxc {
    public zzbxb() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
    }

    public final boolean zzbR(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zze(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
        } else if (i == 2) {
            zzf(parcel.readString());
        } else if (i == 3) {
            zzg((zzbdd) zzhu.zzc(parcel, zzbdd.CREATOR));
        } else if (i != 4) {
            return false;
        } else {
            zzh(zzbvp.zzb(parcel.readStrongBinder()));
        }
        parcel2.writeNoException();
        return true;
    }
}
