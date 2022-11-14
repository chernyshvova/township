package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.play.core.internal.j */
public class C2319j implements IInterface {

    /* renamed from: a */
    public final IBinder f3264a;

    /* renamed from: b */
    public final String f3265b;

    public C2319j(IBinder iBinder, String str) {
        this.f3264a = iBinder;
        this.f3265b = str;
    }

    /* renamed from: a */
    public final Parcel mo33294a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f3265b);
        return obtain;
    }

    /* renamed from: a */
    public final void mo33295a(int i, Parcel parcel) throws RemoteException {
        try {
            this.f3264a.transact(i, parcel, (Parcel) null, 1);
        } finally {
            parcel.recycle();
        }
    }

    public final IBinder asBinder() {
        return this.f3264a;
    }
}
