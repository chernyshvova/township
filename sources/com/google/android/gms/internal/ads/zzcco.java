package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzcco extends zzhs implements zzccq {
    public zzcco(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
    }

    public final String zze() throws RemoteException {
        Parcel zzbq = zzbq(1, zza());
        String readString = zzbq.readString();
        zzbq.recycle();
        return readString;
    }

    public final int zzf() throws RemoteException {
        Parcel zzbq = zzbq(2, zza());
        int readInt = zzbq.readInt();
        zzbq.recycle();
        return readInt;
    }
}
