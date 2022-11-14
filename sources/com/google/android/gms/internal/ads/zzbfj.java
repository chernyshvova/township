package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public abstract class zzbfj extends zzht implements zzbfk {
    public zzbfj() {
        super("com.google.android.gms.ads.internal.client.IAdLoader");
    }

    public final boolean zzbR(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zze((zzbdk) zzhu.zzc(parcel, zzbdk.CREATOR));
            parcel2.writeNoException();
        } else if (i == 2) {
            String zzf = zzf();
            parcel2.writeNoException();
            parcel2.writeString(zzf);
        } else if (i == 3) {
            boolean zzg = zzg();
            parcel2.writeNoException();
            zzhu.zzb(parcel2, zzg);
        } else if (i == 4) {
            String zzh = zzh();
            parcel2.writeNoException();
            parcel2.writeString(zzh);
        } else if (i != 5) {
            return false;
        } else {
            zzi((zzbdk) zzhu.zzc(parcel, zzbdk.CREATOR), parcel.readInt());
            parcel2.writeNoException();
        }
        return true;
    }
}
