package com.google.android.gms.cloudmessaging;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
public interface IMessengerCompat extends IInterface {
    public static final String DESCRIPTOR = "com.google.android.gms.iid.IMessengerCompat";
    public static final int TRANSACTION_SEND = 1;

    /* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
    public static class Impl extends Binder implements IMessengerCompat {
        @NonNull
        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, @NonNull Parcel parcel, @Nullable Parcel parcel2, int i2) throws RemoteException {
            parcel.enforceInterface(getInterfaceDescriptor());
            if (i != 1) {
                return false;
            }
            send(parcel.readInt() != 0 ? (Message) Message.CREATOR.createFromParcel(parcel) : null);
            return true;
        }

        public void send(@NonNull Message message) throws RemoteException {
            message.arg2 = Binder.getCallingUid();
            throw null;
        }
    }

    /* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
    public static class Proxy implements IMessengerCompat {
        public final IBinder zza;

        public Proxy(@NonNull IBinder iBinder) {
            this.zza = iBinder;
        }

        @NonNull
        public IBinder asBinder() {
            return this.zza;
        }

        public void send(@NonNull Message message) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            obtain.writeInterfaceToken(IMessengerCompat.DESCRIPTOR);
            obtain.writeInt(1);
            message.writeToParcel(obtain, 0);
            try {
                this.zza.transact(1, obtain, (Parcel) null, 1);
            } finally {
                obtain.recycle();
            }
        }
    }

    void send(@NonNull Message message) throws RemoteException;
}
