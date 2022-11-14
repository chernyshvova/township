package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzbb;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzcbf extends zzht implements zzcbg {
    public zzcbf() {
        super("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
    }

    public final boolean zzbR(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zze((ParcelFileDescriptor) zzhu.zzc(parcel, ParcelFileDescriptor.CREATOR));
        } else if (i != 2) {
            return false;
        } else {
            zzf((zzbb) zzhu.zzc(parcel, zzbb.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
