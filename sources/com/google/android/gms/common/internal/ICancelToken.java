package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.internal.common.zzb;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public interface ICancelToken extends IInterface {

    /* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    public static abstract class Stub extends zzb implements ICancelToken {
        public Stub() {
            super("com.google.android.gms.common.internal.ICancelToken");
        }

        @RecentlyNonNull
        public static ICancelToken asInterface(@RecentlyNonNull IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICancelToken");
            if (queryLocalInterface instanceof ICancelToken) {
                return (ICancelToken) queryLocalInterface;
            }
            return new zzv(iBinder);
        }

        public final boolean zza(int i, @RecentlyNonNull Parcel parcel, @RecentlyNonNull Parcel parcel2, int i2) throws RemoteException {
            if (i != 2) {
                return false;
            }
            cancel();
            return true;
        }
    }

    void cancel() throws RemoteException;
}
