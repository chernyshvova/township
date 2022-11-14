package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public abstract class zzbhi extends zzht implements zzbhj {
    public zzbhi() {
        super("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
    }

    public final boolean zzbR(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zze();
        } else if (i == 2) {
            zzf();
        } else if (i == 3) {
            zzg();
        } else if (i == 4) {
            zzh();
        } else if (i != 5) {
            return false;
        } else {
            zzi(zzhu.zza(parcel));
        }
        parcel2.writeNoException();
        return true;
    }
}
