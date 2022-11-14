package com.android.vending.licensing;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ILicensingService extends IInterface {

    public static abstract class Stub extends Binder implements ILicensingService {

        public static class Proxy implements ILicensingService {
            public IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void checkLicense(long j, String str, ILicenseResultListener iLicenseResultListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.vending.licensing.ILicensingService");
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iLicenseResultListener.asBinder());
                    this.mRemote.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static ILicensingService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.android.vending.licensing.ILicensingService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ILicensingService)) {
                return new Proxy(iBinder);
            }
            return (ILicensingService) queryLocalInterface;
        }
    }

    void checkLicense(long j, String str, ILicenseResultListener iLicenseResultListener) throws RemoteException;
}
