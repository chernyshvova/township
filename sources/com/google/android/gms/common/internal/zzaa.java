package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzc;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public abstract class zzaa extends zzb implements IGmsCallbacks {
    public zzaa() {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
    }

    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            onPostInitComplete(parcel.readInt(), parcel.readStrongBinder(), (Bundle) zzc.zzc(parcel, Bundle.CREATOR));
        } else if (i == 2) {
            zzb(parcel.readInt(), (Bundle) zzc.zzc(parcel, Bundle.CREATOR));
        } else if (i != 3) {
            return false;
        } else {
            zzc(parcel.readInt(), parcel.readStrongBinder(), (zzi) zzc.zzc(parcel, zzi.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
