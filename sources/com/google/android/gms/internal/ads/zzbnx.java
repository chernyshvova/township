package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbnx extends zzhs implements zzbnz {
    public zzbnx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IShouldDelayBannerRenderingListener");
    }

    public final boolean zzb(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, iObjectWrapper);
        Parcel zzbq = zzbq(2, zza);
        boolean zza2 = zzhu.zza(zzbq);
        zzbq.recycle();
        return zza2;
    }
}
