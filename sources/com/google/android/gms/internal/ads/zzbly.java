package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbly extends zzhs implements zzbma {
    public zzbly(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
    }

    public final String zzb() throws RemoteException {
        Parcel zzbq = zzbq(2, zza());
        String readString = zzbq.readString();
        zzbq.recycle();
        return readString;
    }

    public final List<zzbmi> zzc() throws RemoteException {
        Parcel zzbq = zzbq(3, zza());
        ArrayList zzg = zzhu.zzg(zzbq);
        zzbq.recycle();
        return zzg;
    }
}
