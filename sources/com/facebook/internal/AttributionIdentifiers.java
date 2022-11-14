package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.facebook.FacebookSdk;
import com.unity3d.services.core.device.AdvertisingId;
import com.vungle.warren.VungleApiClient;
import com.vungle.warren.log.LogEntry;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AttributionIdentifiers.kt */
public final class AttributionIdentifiers {
    public static final String ANDROID_ID_COLUMN_NAME = "androidid";
    public static final String ATTRIBUTION_ID_COLUMN_NAME = "aid";
    public static final String ATTRIBUTION_ID_CONTENT_PROVIDER = "com.facebook.katana.provider.AttributionIdProvider";
    public static final String ATTRIBUTION_ID_CONTENT_PROVIDER_WAKIZASHI = "com.facebook.wakizashi.provider.AttributionIdProvider";
    public static final int CONNECTION_RESULT_SUCCESS = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long IDENTIFIER_REFRESH_INTERVAL_MILLIS = 3600000;
    public static final String LIMIT_TRACKING_COLUMN_NAME = "limit_tracking";
    public static final String TAG = AttributionIdentifiers.class.getCanonicalName();
    public static AttributionIdentifiers cachedIdentifiers;
    public String androidAdvertiserIdValue;
    public String androidInstallerPackage;
    public String attributionId;
    public long fetchTime;
    public boolean isTrackingLimited;

    /* compiled from: AttributionIdentifiers.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final AttributionIdentifiers cacheAndReturnIdentifiers(AttributionIdentifiers attributionIdentifiers) {
            attributionIdentifiers.fetchTime = System.currentTimeMillis();
            AttributionIdentifiers.cachedIdentifiers = attributionIdentifiers;
            return attributionIdentifiers;
        }

        @VisibleForTesting(otherwise = 2)
        /* renamed from: getATTRIBUTION_ID_CONTENT_PROVIDER$facebook_core_release$annotations */
        public static /* synthetic */ void m2715xdcc20fa1() {
        }

        private final AttributionIdentifiers getAndroidId(Context context) {
            AttributionIdentifiers androidIdViaReflection = getAndroidIdViaReflection(context);
            if (androidIdViaReflection != null) {
                return androidIdViaReflection;
            }
            AttributionIdentifiers androidIdViaService = getAndroidIdViaService(context);
            return androidIdViaService == null ? new AttributionIdentifiers() : androidIdViaService;
        }

        private final AttributionIdentifiers getAndroidIdViaReflection(Context context) {
            try {
                if (!isGooglePlayServicesAvailable(context)) {
                    return null;
                }
                Utility utility = Utility.INSTANCE;
                boolean z = false;
                Method methodQuietly = Utility.getMethodQuietly("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", (Class<?>[]) new Class[]{Context.class});
                if (methodQuietly == null) {
                    return null;
                }
                Utility utility2 = Utility.INSTANCE;
                Object invokeMethodQuietly = Utility.invokeMethodQuietly((Object) null, methodQuietly, context);
                if (invokeMethodQuietly == null) {
                    return null;
                }
                Utility utility3 = Utility.INSTANCE;
                Method methodQuietly2 = Utility.getMethodQuietly(invokeMethodQuietly.getClass(), "getId", (Class<?>[]) new Class[0]);
                Utility utility4 = Utility.INSTANCE;
                Method methodQuietly3 = Utility.getMethodQuietly(invokeMethodQuietly.getClass(), "isLimitAdTrackingEnabled", (Class<?>[]) new Class[0]);
                if (methodQuietly2 != null) {
                    if (methodQuietly3 != null) {
                        AttributionIdentifiers attributionIdentifiers = new AttributionIdentifiers();
                        Utility utility5 = Utility.INSTANCE;
                        attributionIdentifiers.androidAdvertiserIdValue = (String) Utility.invokeMethodQuietly(invokeMethodQuietly, methodQuietly2, new Object[0]);
                        Utility utility6 = Utility.INSTANCE;
                        Boolean bool = (Boolean) Utility.invokeMethodQuietly(invokeMethodQuietly, methodQuietly3, new Object[0]);
                        if (bool != null) {
                            z = bool.booleanValue();
                        }
                        attributionIdentifiers.isTrackingLimited = z;
                        return attributionIdentifiers;
                    }
                }
                return null;
            } catch (Exception e) {
                Utility utility7 = Utility.INSTANCE;
                Utility.logd(VungleApiClient.ANDROID_ID, e);
                return null;
            }
        }

        private final AttributionIdentifiers getAndroidIdViaService(Context context) {
            GoogleAdServiceConnection googleAdServiceConnection = new GoogleAdServiceConnection();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (context.bindService(intent, googleAdServiceConnection, 1)) {
                    try {
                        GoogleAdInfo googleAdInfo = new GoogleAdInfo(googleAdServiceConnection.getBinder());
                        AttributionIdentifiers attributionIdentifiers = new AttributionIdentifiers();
                        attributionIdentifiers.androidAdvertiserIdValue = googleAdInfo.getAdvertiserId();
                        attributionIdentifiers.isTrackingLimited = googleAdInfo.isTrackingLimited();
                        return attributionIdentifiers;
                    } catch (Exception e) {
                        Utility utility = Utility.INSTANCE;
                        Utility.logd(VungleApiClient.ANDROID_ID, e);
                    } finally {
                        context.unbindService(googleAdServiceConnection);
                    }
                }
            } catch (SecurityException unused) {
            }
            return null;
        }

        @VisibleForTesting(otherwise = 2)
        public static /* synthetic */ void getCachedIdentifiers$facebook_core_release$annotations() {
        }

        private final String getInstallerPackageName(Context context) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return packageManager.getInstallerPackageName(context.getPackageName());
        }

        private final boolean isGooglePlayServicesAvailable(Context context) {
            Utility utility = Utility.INSTANCE;
            Method methodQuietly = Utility.getMethodQuietly("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", (Class<?>[]) new Class[]{Context.class});
            if (methodQuietly == null) {
                return false;
            }
            Utility utility2 = Utility.INSTANCE;
            Object invokeMethodQuietly = Utility.invokeMethodQuietly((Object) null, methodQuietly, context);
            if (!(invokeMethodQuietly instanceof Integer) || !Intrinsics.areEqual(invokeMethodQuietly, 0)) {
                return false;
            }
            return true;
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x0085 A[Catch:{ Exception -> 0x00f8, all -> 0x00f6 }] */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x008a A[Catch:{ Exception -> 0x00f8, all -> 0x00f6 }] */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x008f A[Catch:{ Exception -> 0x00f8, all -> 0x00f6 }] */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x010c  */
        /* JADX WARNING: Removed duplicated region for block: B:63:0x0115  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.facebook.internal.AttributionIdentifiers getAttributionIdentifiers(android.content.Context r13) {
            /*
                r12 = this;
                java.lang.String r0 = "limit_tracking"
                java.lang.String r1 = "androidid"
                java.lang.String r2 = "aid"
                java.lang.String r3 = "context"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r3)
                com.facebook.internal.AttributionIdentifiers r3 = r12.getAndroidId(r13)
                r4 = 0
                android.os.Looper r5 = android.os.Looper.myLooper()     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                android.os.Looper r6 = android.os.Looper.getMainLooper()     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r6)     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                if (r5 != 0) goto L_0x00ee
                com.facebook.internal.AttributionIdentifiers r5 = com.facebook.internal.AttributionIdentifiers.cachedIdentifiers     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                if (r5 == 0) goto L_0x0033
                long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                long r8 = r5.fetchTime     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                long r6 = r6 - r8
                r8 = 3600000(0x36ee80, double:1.7786363E-317)
                int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r10 >= 0) goto L_0x0033
                return r5
            L_0x0033:
                java.lang.String[] r7 = new java.lang.String[]{r2, r1, r0}     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                android.content.pm.PackageManager r5 = r13.getPackageManager()     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                java.lang.String r6 = "com.facebook.katana.provider.AttributionIdProvider"
                r8 = 0
                android.content.pm.ProviderInfo r5 = r5.resolveContentProvider(r6, r8)     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                android.content.pm.PackageManager r6 = r13.getPackageManager()     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                java.lang.String r9 = "com.facebook.wakizashi.provider.AttributionIdProvider"
                android.content.pm.ProviderInfo r6 = r6.resolveContentProvider(r9, r8)     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                if (r5 == 0) goto L_0x0065
                com.facebook.internal.FacebookSignatureValidator r8 = com.facebook.internal.FacebookSignatureValidator.INSTANCE     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                java.lang.String r5 = r5.packageName     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                java.lang.String r8 = "contentProviderInfo.packageName"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r8)     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                boolean r5 = com.facebook.internal.FacebookSignatureValidator.validateSignature(r13, r5)     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                if (r5 == 0) goto L_0x0065
                java.lang.String r5 = "content://com.facebook.katana.provider.AttributionIdProvider"
                android.net.Uri r5 = android.net.Uri.parse(r5)     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
            L_0x0063:
                r6 = r5
                goto L_0x007f
            L_0x0065:
                if (r6 == 0) goto L_0x007e
                com.facebook.internal.FacebookSignatureValidator r5 = com.facebook.internal.FacebookSignatureValidator.INSTANCE     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                java.lang.String r5 = r6.packageName     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                java.lang.String r6 = "wakizashiProviderInfo.packageName"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                boolean r5 = com.facebook.internal.FacebookSignatureValidator.validateSignature(r13, r5)     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                if (r5 == 0) goto L_0x007e
                java.lang.String r5 = "content://com.facebook.wakizashi.provider.AttributionIdProvider"
                android.net.Uri r5 = android.net.Uri.parse(r5)     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                goto L_0x0063
            L_0x007e:
                r6 = r4
            L_0x007f:
                java.lang.String r5 = r12.getInstallerPackageName(r13)     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                if (r5 == 0) goto L_0x0088
                r3.androidInstallerPackage = r5     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
            L_0x0088:
                if (r6 != 0) goto L_0x008f
                com.facebook.internal.AttributionIdentifiers r13 = r12.cacheAndReturnIdentifiers(r3)     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                return r13
            L_0x008f:
                android.content.ContentResolver r5 = r13.getContentResolver()     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                r8 = 0
                r9 = 0
                r10 = 0
                android.database.Cursor r13 = r5.query(r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                if (r13 == 0) goto L_0x00da
                boolean r5 = r13.moveToFirst()     // Catch:{ Exception -> 0x00e9, all -> 0x00e5 }
                if (r5 != 0) goto L_0x00a3
                goto L_0x00da
            L_0x00a3:
                int r2 = r13.getColumnIndex(r2)     // Catch:{ Exception -> 0x00e9, all -> 0x00e5 }
                int r1 = r13.getColumnIndex(r1)     // Catch:{ Exception -> 0x00e9, all -> 0x00e5 }
                int r0 = r13.getColumnIndex(r0)     // Catch:{ Exception -> 0x00e9, all -> 0x00e5 }
                java.lang.String r2 = r13.getString(r2)     // Catch:{ Exception -> 0x00e9, all -> 0x00e5 }
                r3.attributionId = r2     // Catch:{ Exception -> 0x00e9, all -> 0x00e5 }
                if (r1 <= 0) goto L_0x00d2
                if (r0 <= 0) goto L_0x00d2
                java.lang.String r2 = r3.getAndroidAdvertiserId()     // Catch:{ Exception -> 0x00e9, all -> 0x00e5 }
                if (r2 != 0) goto L_0x00d2
                java.lang.String r1 = r13.getString(r1)     // Catch:{ Exception -> 0x00e9, all -> 0x00e5 }
                r3.androidAdvertiserIdValue = r1     // Catch:{ Exception -> 0x00e9, all -> 0x00e5 }
                java.lang.String r0 = r13.getString(r0)     // Catch:{ Exception -> 0x00e9, all -> 0x00e5 }
                boolean r0 = java.lang.Boolean.parseBoolean(r0)     // Catch:{ Exception -> 0x00e9, all -> 0x00e5 }
                r3.isTrackingLimited = r0     // Catch:{ Exception -> 0x00e9, all -> 0x00e5 }
            L_0x00d2:
                r13.close()
                com.facebook.internal.AttributionIdentifiers r13 = r12.cacheAndReturnIdentifiers(r3)
                return r13
            L_0x00da:
                com.facebook.internal.AttributionIdentifiers r0 = r12.cacheAndReturnIdentifiers(r3)     // Catch:{ Exception -> 0x00e9, all -> 0x00e5 }
                if (r13 != 0) goto L_0x00e1
                goto L_0x00e4
            L_0x00e1:
                r13.close()
            L_0x00e4:
                return r0
            L_0x00e5:
                r0 = move-exception
                r4 = r13
                r13 = r0
                goto L_0x0112
            L_0x00e9:
                r0 = move-exception
                r11 = r0
                r0 = r13
                r13 = r11
                goto L_0x00fa
            L_0x00ee:
                com.facebook.FacebookException r13 = new com.facebook.FacebookException     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                java.lang.String r0 = "getAttributionIdentifiers cannot be called on the main thread."
                r13.<init>((java.lang.String) r0)     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                throw r13     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
            L_0x00f6:
                r13 = move-exception
                goto L_0x0112
            L_0x00f8:
                r13 = move-exception
                r0 = r4
            L_0x00fa:
                com.facebook.internal.Utility r1 = com.facebook.internal.Utility.INSTANCE     // Catch:{ all -> 0x0110 }
                java.lang.String r1 = com.facebook.internal.AttributionIdentifiers.TAG     // Catch:{ all -> 0x0110 }
                java.lang.String r2 = "Caught unexpected exception in getAttributionId(): "
                java.lang.String r13 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r13)     // Catch:{ all -> 0x0110 }
                com.facebook.internal.Utility.logd((java.lang.String) r1, (java.lang.String) r13)     // Catch:{ all -> 0x0110 }
                if (r0 != 0) goto L_0x010c
                goto L_0x010f
            L_0x010c:
                r0.close()
            L_0x010f:
                return r4
            L_0x0110:
                r13 = move-exception
                r4 = r0
            L_0x0112:
                if (r4 != 0) goto L_0x0115
                goto L_0x0118
            L_0x0115:
                r4.close()
            L_0x0118:
                goto L_0x011a
            L_0x0119:
                throw r13
            L_0x011a:
                goto L_0x0119
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.AttributionIdentifiers.Companion.getAttributionIdentifiers(android.content.Context):com.facebook.internal.AttributionIdentifiers");
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final boolean isTrackingLimited(Context context) {
            Intrinsics.checkNotNullParameter(context, LogEntry.LOG_ITEM_CONTEXT);
            AttributionIdentifiers attributionIdentifiers = getAttributionIdentifiers(context);
            return attributionIdentifiers != null && attributionIdentifiers.isTrackingLimited();
        }
    }

    /* compiled from: AttributionIdentifiers.kt */
    public static final class GoogleAdInfo implements IInterface {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final int FIRST_TRANSACTION_CODE = 1;
        public static final int SECOND_TRANSACTION_CODE = 2;
        public final IBinder binder;

        /* compiled from: AttributionIdentifiers.kt */
        public static final class Companion {
            public Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public GoogleAdInfo(IBinder iBinder) {
            Intrinsics.checkNotNullParameter(iBinder, "binder");
            this.binder = iBinder;
        }

        public IBinder asBinder() {
            return this.binder;
        }

        public final String getAdvertiserId() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
            Parcel obtain2 = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(obtain2, "obtain()");
            try {
                obtain.writeInterfaceToken(AdvertisingId.ADVERTISING_ID_SERVICE_NAME);
                this.binder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final boolean isTrackingLimited() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
            Parcel obtain2 = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(obtain2, "obtain()");
            try {
                obtain.writeInterfaceToken(AdvertisingId.ADVERTISING_ID_SERVICE_NAME);
                boolean z = true;
                obtain.writeInt(1);
                this.binder.transact(2, obtain, obtain2, 0);
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
    }

    /* compiled from: AttributionIdentifiers.kt */
    public static final class GoogleAdServiceConnection implements ServiceConnection {
        public final AtomicBoolean consumed = new AtomicBoolean(false);
        public final BlockingQueue<IBinder> queue = new LinkedBlockingDeque();

        public final IBinder getBinder() throws InterruptedException {
            if (!this.consumed.compareAndSet(true, true)) {
                IBinder take = this.queue.take();
                Intrinsics.checkNotNullExpressionValue(take, "queue.take()");
                return take;
            }
            throw new IllegalStateException("Binder already consumed".toString());
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (iBinder != null) {
                try {
                    this.queue.put(iBinder);
                } catch (InterruptedException unused) {
                }
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static final AttributionIdentifiers getAttributionIdentifiers(Context context) {
        return Companion.getAttributionIdentifiers(context);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final boolean isTrackingLimited(Context context) {
        return Companion.isTrackingLimited(context);
    }

    public final String getAndroidAdvertiserId() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (FacebookSdk.isInitialized()) {
            FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
            if (FacebookSdk.getAdvertiserIDCollectionEnabled()) {
                return this.androidAdvertiserIdValue;
            }
        }
        return null;
    }

    public final String getAndroidInstallerPackage() {
        return this.androidInstallerPackage;
    }

    public final String getAttributionId() {
        return this.attributionId;
    }

    public final boolean isTrackingLimited() {
        return this.isTrackingLimited;
    }
}
