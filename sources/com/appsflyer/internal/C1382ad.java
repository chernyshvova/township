package com.appsflyer.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import com.unity3d.services.core.device.AdvertisingId;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Deprecated
/* renamed from: com.appsflyer.internal.ad */
public final class C1382ad {

    /* renamed from: com.appsflyer.internal.ad$a */
    public static final class C1383a implements IInterface {
        public final IBinder values;

        public C1383a(IBinder iBinder) {
            this.values = iBinder;
        }

        public final boolean AFInAppEventParameterName() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(AdvertisingId.ADVERTISING_ID_SERVICE_NAME);
                boolean z = true;
                obtain.writeInt(1);
                this.values.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z = false;
                }
                return z;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final IBinder asBinder() {
            return this.values;
        }

        public final String valueOf() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(AdvertisingId.ADVERTISING_ID_SERVICE_NAME);
                this.values.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    /* renamed from: com.appsflyer.internal.ad$e */
    public static final class C1385e {
        public final String AFInAppEventParameterName;
        public final boolean AFKeystoreWrapper;

        public C1385e(String str, boolean z) {
            this.AFInAppEventParameterName = str;
            this.AFKeystoreWrapper = z;
        }

        public final boolean values() {
            return this.AFKeystoreWrapper;
        }
    }

    public static C1385e AFKeystoreWrapper(Context context) throws Exception {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            C1384b bVar = new C1384b((byte) 0);
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (!context.bindService(intent, bVar, 1)) {
                    context.unbindService(bVar);
                    throw new IOException("Google Play connection failed");
                } else if (!bVar.AFInAppEventType) {
                    bVar.AFInAppEventType = true;
                    IBinder poll = bVar.values.poll(10, TimeUnit.SECONDS);
                    if (poll != null) {
                        C1383a aVar = new C1383a(poll);
                        return new C1385e(aVar.valueOf(), aVar.AFInAppEventParameterName());
                    }
                    throw new TimeoutException("Timed out waiting for the service connection");
                } else {
                    throw new IllegalStateException("Cannot call get on this connection more than once");
                }
            } finally {
                context.unbindService(bVar);
            }
        } else {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
    }

    /* renamed from: com.appsflyer.internal.ad$b */
    public static final class C1384b implements ServiceConnection {
        public boolean AFInAppEventType;
        public final LinkedBlockingQueue<IBinder> values;

        public C1384b() {
            this.values = new LinkedBlockingQueue<>(1);
            this.AFInAppEventType = false;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.values.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
        }

        public /* synthetic */ C1384b(byte b) {
            this();
        }
    }
}
