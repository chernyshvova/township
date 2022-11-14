package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzccx extends zzhs implements IInterface {
    public zzccx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCreator");
    }

    public final IBinder zze(IObjectWrapper iObjectWrapper, String str, zzbvh zzbvh, int i) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, iObjectWrapper);
        zza.writeString(str);
        zzhu.zzf(zza, zzbvh);
        zza.writeInt(212104000);
        Parcel zzbq = zzbq(1, zza);
        IBinder readStrongBinder = zzbq.readStrongBinder();
        zzbq.recycle();
        return readStrongBinder;
    }
}
