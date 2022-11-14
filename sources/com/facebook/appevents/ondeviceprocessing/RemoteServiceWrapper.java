package com.facebook.appevents.ondeviceprocessing;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.FacebookSignatureValidator;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.ppml.receiver.IReceiverService;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* compiled from: RemoteServiceWrapper.kt */
public final class RemoteServiceWrapper {
    public static final RemoteServiceWrapper INSTANCE = new RemoteServiceWrapper();
    public static final String RECEIVER_SERVICE_ACTION = "ReceiverService";
    public static final String RECEIVER_SERVICE_PACKAGE = "com.facebook.katana";
    public static final String RECEIVER_SERVICE_PACKAGE_WAKIZASHI = "com.facebook.wakizashi";
    public static final String TAG;
    public static Boolean isServiceAvailable;

    /* compiled from: RemoteServiceWrapper.kt */
    public enum EventType {
        MOBILE_APP_INSTALL("MOBILE_APP_INSTALL"),
        CUSTOM_APP_EVENTS("CUSTOM_APP_EVENTS");
        
        public final String eventType;

        /* access modifiers changed from: public */
        EventType(String str) {
            this.eventType = str;
        }

        public String toString() {
            return this.eventType;
        }
    }

    /* compiled from: RemoteServiceWrapper.kt */
    public static final class RemoteServiceConnection implements ServiceConnection {
        public IBinder binder;
        public final CountDownLatch latch = new CountDownLatch(1);

        public final IBinder getBinder() throws InterruptedException {
            this.latch.await(5, TimeUnit.SECONDS);
            return this.binder;
        }

        public void onNullBinding(ComponentName componentName) {
            Intrinsics.checkNotNullParameter(componentName, "name");
            this.latch.countDown();
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Intrinsics.checkNotNullParameter(componentName, "name");
            Intrinsics.checkNotNullParameter(iBinder, "serviceBinder");
            this.binder = iBinder;
            this.latch.countDown();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            Intrinsics.checkNotNullParameter(componentName, "name");
        }
    }

    /* compiled from: RemoteServiceWrapper.kt */
    public enum ServiceResult {
        OPERATION_SUCCESS,
        SERVICE_NOT_AVAILABLE,
        SERVICE_ERROR
    }

    static {
        String simpleName = RemoteServiceWrapper.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "RemoteServiceWrapper::class.java.simpleName");
        TAG = simpleName;
    }

    private final Intent getVerifiedServiceIntent(Context context) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                Intent intent = new Intent(RECEIVER_SERVICE_ACTION);
                intent.setPackage("com.facebook.katana");
                if (packageManager.resolveService(intent, 0) != null) {
                    FacebookSignatureValidator facebookSignatureValidator = FacebookSignatureValidator.INSTANCE;
                    if (FacebookSignatureValidator.validateSignature(context, "com.facebook.katana")) {
                        return intent;
                    }
                }
                Intent intent2 = new Intent(RECEIVER_SERVICE_ACTION);
                intent2.setPackage(RECEIVER_SERVICE_PACKAGE_WAKIZASHI);
                if (packageManager.resolveService(intent2, 0) != null) {
                    FacebookSignatureValidator facebookSignatureValidator2 = FacebookSignatureValidator.INSTANCE;
                    if (FacebookSignatureValidator.validateSignature(context, RECEIVER_SERVICE_PACKAGE_WAKIZASHI)) {
                        return intent2;
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public static final boolean isServiceAvailable() {
        Class<RemoteServiceWrapper> cls = RemoteServiceWrapper.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            if (isServiceAvailable == null) {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                isServiceAvailable = Boolean.valueOf(INSTANCE.getVerifiedServiceIntent(FacebookSdk.getApplicationContext()) != null);
            }
            Boolean bool = isServiceAvailable;
            if (bool == null) {
                return false;
            }
            return bool.booleanValue();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    public static final ServiceResult sendCustomEvents(String str, List<AppEvent> list) {
        Class<RemoteServiceWrapper> cls = RemoteServiceWrapper.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(str, "applicationId");
            Intrinsics.checkNotNullParameter(list, "appEvents");
            return INSTANCE.sendEvents(EventType.CUSTOM_APP_EVENTS, str, list);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    private final ServiceResult sendEvents(EventType eventType, String str, List<AppEvent> list) {
        Context applicationContext;
        RemoteServiceConnection remoteServiceConnection;
        ServiceResult serviceResult;
        String str2;
        ServiceResult serviceResult2;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            ServiceResult serviceResult3 = ServiceResult.SERVICE_NOT_AVAILABLE;
            AppEventUtility appEventUtility = AppEventUtility.INSTANCE;
            AppEventUtility.assertIsNotMainThread();
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            applicationContext = FacebookSdk.getApplicationContext();
            Intent verifiedServiceIntent = getVerifiedServiceIntent(applicationContext);
            if (verifiedServiceIntent == null) {
                return serviceResult3;
            }
            remoteServiceConnection = new RemoteServiceConnection();
            if (!applicationContext.bindService(verifiedServiceIntent, remoteServiceConnection, 1)) {
                return ServiceResult.SERVICE_ERROR;
            }
            try {
                IBinder binder = remoteServiceConnection.getBinder();
                if (binder != null) {
                    IReceiverService asInterface = IReceiverService.Stub.asInterface(binder);
                    RemoteServiceParametersHelper remoteServiceParametersHelper = RemoteServiceParametersHelper.INSTANCE;
                    Bundle buildEventsBundle = RemoteServiceParametersHelper.buildEventsBundle(eventType, str, list);
                    if (buildEventsBundle != null) {
                        asInterface.sendEvents(buildEventsBundle);
                        Utility utility = Utility.INSTANCE;
                        Utility.logd(TAG, Intrinsics.stringPlus("Successfully sent events to the remote service: ", buildEventsBundle));
                    }
                    serviceResult2 = ServiceResult.OPERATION_SUCCESS;
                } else {
                    serviceResult2 = ServiceResult.SERVICE_NOT_AVAILABLE;
                }
                applicationContext.unbindService(remoteServiceConnection);
                Utility utility2 = Utility.INSTANCE;
                Utility.logd(TAG, "Unbound from the remote service");
                return serviceResult2;
            } catch (InterruptedException e) {
                serviceResult = ServiceResult.SERVICE_ERROR;
                Utility utility3 = Utility.INSTANCE;
                Utility.logd(TAG, (Exception) e);
                applicationContext.unbindService(remoteServiceConnection);
                Utility utility4 = Utility.INSTANCE;
                str2 = TAG;
                Utility.logd(str2, "Unbound from the remote service");
                return serviceResult;
            } catch (RemoteException e2) {
                serviceResult = ServiceResult.SERVICE_ERROR;
                Utility utility5 = Utility.INSTANCE;
                Utility.logd(TAG, (Exception) e2);
                applicationContext.unbindService(remoteServiceConnection);
                Utility utility6 = Utility.INSTANCE;
                str2 = TAG;
                Utility.logd(str2, "Unbound from the remote service");
                return serviceResult;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public static final ServiceResult sendInstallEvent(String str) {
        Class<RemoteServiceWrapper> cls = RemoteServiceWrapper.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(str, "applicationId");
            return INSTANCE.sendEvents(EventType.MOBILE_APP_INSTALL, str, EmptyList.INSTANCE);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }
}
