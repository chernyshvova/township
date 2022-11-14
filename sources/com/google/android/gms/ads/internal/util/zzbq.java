package com.google.android.gms.ads.internal.util;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzhs;
import com.google.android.gms.internal.ads.zzhu;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbq extends zzhs implements zzbs {
    public zzbq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.util.IWorkManagerUtil");
    }

    public final boolean zze(IObjectWrapper iObjectWrapper, String str, String str2) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, iObjectWrapper);
        zza.writeString(str);
        zza.writeString(str2);
        Parcel zzbq = zzbq(1, zza);
        boolean zza2 = zzhu.zza(zzbq);
        zzbq.recycle();
        return zza2;
    }

    public final void zzf(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzhu.zzf(zza, iObjectWrapper);
        zzbr(2, zza);
    }
}
