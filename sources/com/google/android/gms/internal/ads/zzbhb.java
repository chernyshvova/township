package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbhb extends zzhs implements zzbhd {
    public zzbhb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IResponseInfo");
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

    public final List<zzbdt> zzg() throws RemoteException {
        Parcel zzbq = zzbq(3, zza());
        ArrayList<zzbdt> createTypedArrayList = zzbq.createTypedArrayList(zzbdt.CREATOR);
        zzbq.recycle();
        return createTypedArrayList;
    }
}
