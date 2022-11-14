package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbmn extends zzhs implements zzbmp {
    public zzbmn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
    }

    public final IBinder zze(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3, int i) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, iObjectWrapper);
        zzhu.zzf(zza, iObjectWrapper2);
        zzhu.zzf(zza, iObjectWrapper3);
        zza.writeInt(212104000);
        Parcel zzbq = zzbq(1, zza);
        IBinder readStrongBinder = zzbq.readStrongBinder();
        zzbq.recycle();
        return readStrongBinder;
    }
}
