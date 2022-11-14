package com.google.android.finsky.externalreferrer;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.p031a.C1609a;
import com.google.android.p031a.C1610b;
import com.google.android.p031a.C1611c;

public interface IGetInstallReferrerService extends IInterface {

    public static abstract class Stub extends C1610b implements IGetInstallReferrerService {

        public static class Proxy extends C1609a implements IGetInstallReferrerService {
            public Proxy(IBinder iBinder) {
                super(iBinder);
            }

            /* renamed from: c */
            public final Bundle mo14908c(Bundle bundle) throws RemoteException {
                Parcelable parcelable;
                Parcel obtain = Parcel.obtain();
                obtain.writeInterfaceToken(this.f2763b);
                C1611c.m2720b(obtain, bundle);
                obtain = Parcel.obtain();
                try {
                    this.f2762a.transact(1, obtain, obtain, 0);
                    obtain.readException();
                    obtain.recycle();
                    Parcelable.Creator creator = Bundle.CREATOR;
                    if (obtain.readInt() == 0) {
                        parcelable = null;
                    } else {
                        parcelable = (Parcelable) creator.createFromParcel(obtain);
                    }
                    return (Bundle) parcelable;
                } catch (RuntimeException e) {
                    throw e;
                } finally {
                    obtain.recycle();
                }
            }
        }

        /* renamed from: b */
        public static IGetInstallReferrerService m2722b(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            if (queryLocalInterface instanceof IGetInstallReferrerService) {
                return (IGetInstallReferrerService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }
    }

    /* renamed from: c */
    Bundle mo14908c(Bundle bundle) throws RemoteException;
}
