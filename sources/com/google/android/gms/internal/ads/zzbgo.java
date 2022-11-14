package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbgo extends zzhs implements zzbgq {
    public zzbgo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMuteThisAdReason");
    }

    public final String zze() throws RemoteException {
        Parcel zzbq = zzbq(1, zza());
        String readString = zzbq.readString();
        zzbq.recycle();
        return readString;
    }

    public final String zzf() throws RemoteException {
        Parcel zzbq = zzbq(2, zza());
        String readString = zzbq.readString();
        zzbq.recycle();
        return readString;
    }
}
