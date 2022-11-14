package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public abstract class zzbfd extends zzht implements zzbfe {
    public zzbfd() {
        super("com.google.android.gms.ads.internal.client.IAdListener");
    }

    public final boolean zzbR(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzb();
                break;
            case 2:
                zzc(parcel.readInt());
                break;
            case 3:
                break;
            case 4:
                zzf();
                break;
            case 5:
                zzg();
                break;
            case 6:
                zzh();
                break;
            case 7:
                zzi();
                break;
            case 8:
                zzd((zzbdd) zzhu.zzc(parcel, zzbdd.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
