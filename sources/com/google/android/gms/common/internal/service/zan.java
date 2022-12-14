package com.google.android.gms.common.internal.service;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.base.zab;
import com.google.android.gms.internal.base.zad;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zan extends zab implements zao {
    public zan(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.service.ICommonService");
    }

    public final void zaa(zam zam) throws RemoteException {
        Parcel zaa = zaa();
        zad.zaa(zaa, (IInterface) zam);
        zac(1, zaa);
    }
}
