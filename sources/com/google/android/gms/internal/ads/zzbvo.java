package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbvo extends zzhs implements zzbvq {
    public zzbvo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationInterscrollerAd");
    }

    public final IObjectWrapper zze() throws RemoteException {
        return GeneratedOutlineSupport.outline8(zzbq(1, zza()));
    }

    public final boolean zzf() throws RemoteException {
        Parcel zzbq = zzbq(2, zza());
        boolean zza = zzhu.zza(zzbq);
        zzbq.recycle();
        return zza;
    }
}
