package com.google.android.gms.signin.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.internal.base.zab;
import com.google.android.gms.internal.base.zad;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
public final class zaf extends zab implements zag {
    public zaf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    public final void zaa(int i) throws RemoteException {
        Parcel zaa = zaa();
        zaa.writeInt(i);
        zab(7, zaa);
    }

    public final void zaa(IAccountAccessor iAccountAccessor, int i, boolean z) throws RemoteException {
        Parcel zaa = zaa();
        zad.zaa(zaa, (IInterface) iAccountAccessor);
        zaa.writeInt(i);
        zad.zaa(zaa, z);
        zab(9, zaa);
    }

    public final void zaa(zaj zaj, zae zae) throws RemoteException {
        Parcel zaa = zaa();
        zad.zaa(zaa, (Parcelable) zaj);
        zad.zaa(zaa, (IInterface) zae);
        zab(12, zaa);
    }
}
