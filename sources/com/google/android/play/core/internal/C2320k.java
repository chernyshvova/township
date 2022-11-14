package com.google.android.play.core.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.play.core.internal.k */
public class C2320k extends Binder implements IInterface {
    public C2320k(String str) {
        attachInterface(this, str);
    }

    /* renamed from: a */
    public boolean mo33277a(int i, Parcel parcel) throws RemoteException {
        throw null;
    }

    public final IBinder asBinder() {
        return this;
    }

    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i <= 16777215) {
            parcel.enforceInterface(getInterfaceDescriptor());
        } else if (super.onTransact(i, parcel, parcel2, i2)) {
            return true;
        }
        return mo33277a(i, parcel);
    }
}
