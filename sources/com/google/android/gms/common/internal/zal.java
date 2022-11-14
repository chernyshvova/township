package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.base.zab;
import com.google.android.gms.internal.base.zad;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zal extends zab implements zam {
    public zal(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ISignInButtonCreator");
    }

    public final IObjectWrapper zaa(IObjectWrapper iObjectWrapper, zaw zaw) throws RemoteException {
        Parcel zaa = zaa();
        zad.zaa(zaa, (IInterface) iObjectWrapper);
        zad.zaa(zaa, (Parcelable) zaw);
        return GeneratedOutlineSupport.outline8(zaa(2, zaa));
    }
}
