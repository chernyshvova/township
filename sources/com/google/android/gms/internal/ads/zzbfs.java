package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbfs extends zzhs implements IInterface {
    public zzbfs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManagerCreator");
    }

    public final IBinder zze(IObjectWrapper iObjectWrapper, zzbdp zzbdp, String str, zzbvh zzbvh, int i, int i2) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, iObjectWrapper);
        zzhu.zzd(zza, zzbdp);
        zza.writeString(str);
        zzhu.zzf(zza, zzbvh);
        zza.writeInt(212104000);
        zza.writeInt(i2);
        Parcel zzbq = zzbq(2, zza);
        IBinder readStrongBinder = zzbq.readStrongBinder();
        zzbq.recycle();
        return readStrongBinder;
    }
}
