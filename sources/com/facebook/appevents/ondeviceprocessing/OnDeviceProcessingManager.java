package com.facebook.appevents.ondeviceprocessing;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.RestrictTo;
import com.android.billingclient.api.zzam;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* compiled from: OnDeviceProcessingManager.kt */
public final class OnDeviceProcessingManager {
    public static final Set<String> ALLOWED_IMPLICIT_EVENTS = zzam.setOf((T[]) new String[]{AppEventsConstants.EVENT_NAME_PURCHASED, AppEventsConstants.EVENT_NAME_START_TRIAL, AppEventsConstants.EVENT_NAME_SUBSCRIBE});
    public static final OnDeviceProcessingManager INSTANCE = new OnDeviceProcessingManager();

    private final boolean isEventEligibleForOnDeviceProcessing(AppEvent appEvent) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            boolean z = appEvent.isImplicit() && ALLOWED_IMPLICIT_EVENTS.contains(appEvent.getName());
            if ((!appEvent.isImplicit()) || z) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0026 A[Catch:{ all -> 0x0030 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean isOnDeviceProcessingEnabled() {
        /*
            java.lang.Class<com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager> r0 = com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager.class
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)
            r2 = 0
            if (r1 == 0) goto L_0x000a
            return r2
        L_0x000a:
            com.facebook.FacebookSdk r1 = com.facebook.FacebookSdk.INSTANCE     // Catch:{ all -> 0x0030 }
            android.content.Context r1 = com.facebook.FacebookSdk.getApplicationContext()     // Catch:{ all -> 0x0030 }
            com.facebook.FacebookSdk r3 = com.facebook.FacebookSdk.INSTANCE     // Catch:{ all -> 0x0030 }
            boolean r1 = com.facebook.FacebookSdk.getLimitEventAndDataUsage(r1)     // Catch:{ all -> 0x0030 }
            r3 = 1
            if (r1 != 0) goto L_0x0023
            com.facebook.internal.Utility r1 = com.facebook.internal.Utility.INSTANCE     // Catch:{ all -> 0x0030 }
            boolean r1 = com.facebook.internal.Utility.isDataProcessingRestricted()     // Catch:{ all -> 0x0030 }
            if (r1 != 0) goto L_0x0023
            r1 = 1
            goto L_0x0024
        L_0x0023:
            r1 = 0
        L_0x0024:
            if (r1 == 0) goto L_0x002f
            com.facebook.appevents.ondeviceprocessing.RemoteServiceWrapper r1 = com.facebook.appevents.ondeviceprocessing.RemoteServiceWrapper.INSTANCE     // Catch:{ all -> 0x0030 }
            boolean r0 = com.facebook.appevents.ondeviceprocessing.RemoteServiceWrapper.isServiceAvailable()     // Catch:{ all -> 0x0030 }
            if (r0 == 0) goto L_0x002f
            r2 = 1
        L_0x002f:
            return r2
        L_0x0030:
            r1 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r1, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager.isOnDeviceProcessingEnabled():boolean");
    }

    public static final void sendCustomEventAsync(String str, AppEvent appEvent) {
        Class<OnDeviceProcessingManager> cls = OnDeviceProcessingManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(str, "applicationId");
                Intrinsics.checkNotNullParameter(appEvent, "event");
                if (INSTANCE.isEventEligibleForOnDeviceProcessing(appEvent)) {
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    FacebookSdk.getExecutor().execute(new Runnable(str, appEvent) {
                        public final /* synthetic */ String f$0;
                        public final /* synthetic */ AppEvent f$1;

                        {
                            this.f$0 = r1;
                            this.f$1 = r2;
                        }

                        public final void run() {
                            OnDeviceProcessingManager.m3591sendCustomEventAsync$lambda1(this.f$0, this.f$1);
                        }
                    });
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    /* renamed from: sendCustomEventAsync$lambda-1  reason: not valid java name */
    public static final void m3591sendCustomEventAsync$lambda1(String str, AppEvent appEvent) {
        Class<OnDeviceProcessingManager> cls = OnDeviceProcessingManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(str, "$applicationId");
                Intrinsics.checkNotNullParameter(appEvent, "$event");
                RemoteServiceWrapper remoteServiceWrapper = RemoteServiceWrapper.INSTANCE;
                RemoteServiceWrapper.sendCustomEvents(str, zzam.listOf(appEvent));
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static final void sendInstallEventAsync(String str, String str2) {
        Class<OnDeviceProcessingManager> cls = OnDeviceProcessingManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                Context applicationContext = FacebookSdk.getApplicationContext();
                if (applicationContext != null && str != null && str2 != null) {
                    FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
                    FacebookSdk.getExecutor().execute(new Runnable(applicationContext, str2, str) {
                        public final /* synthetic */ Context f$0;
                        public final /* synthetic */ String f$1;
                        public final /* synthetic */ String f$2;

                        {
                            this.f$0 = r1;
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void run() {
                            OnDeviceProcessingManager.m3592sendInstallEventAsync$lambda0(this.f$0, this.f$1, this.f$2);
                        }
                    });
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    /* renamed from: sendInstallEventAsync$lambda-0  reason: not valid java name */
    public static final void m3592sendInstallEventAsync$lambda0(Context context, String str, String str2) {
        Class<OnDeviceProcessingManager> cls = OnDeviceProcessingManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(context, "$context");
                SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
                String stringPlus = Intrinsics.stringPlus(str2, "pingForOnDevice");
                if (sharedPreferences.getLong(stringPlus, 0) == 0) {
                    RemoteServiceWrapper remoteServiceWrapper = RemoteServiceWrapper.INSTANCE;
                    RemoteServiceWrapper.sendInstallEvent(str2);
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putLong(stringPlus, System.currentTimeMillis());
                    edit.apply();
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }
}
