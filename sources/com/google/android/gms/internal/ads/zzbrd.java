package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzbrd extends zzht implements zzbre {
    public zzbrd() {
        super("com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheCallback");
    }

    public final boolean zzbR(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zzb((ParcelFileDescriptor) zzhu.zzc(parcel, ParcelFileDescriptor.CREATOR));
        return true;
    }
}
