package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public abstract class zzccz extends zzht implements zzcda {
    public zzccz() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
    }

    public final boolean zzbR(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zze();
        } else if (i == 2) {
            zzf(parcel.readInt());
        } else if (i != 3) {
            return false;
        } else {
            zzg((zzbdd) zzhu.zzc(parcel, zzbdd.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
