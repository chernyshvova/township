package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public abstract class zzbxe extends zzht implements zzbxf {
    public zzbxe() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback");
    }

    public final boolean zzbR(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 2) {
            zze();
        } else if (i == 3) {
            zzf(parcel.readString());
        } else if (i != 4) {
            return false;
        } else {
            zzg((zzbdd) zzhu.zzc(parcel, zzbdd.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
