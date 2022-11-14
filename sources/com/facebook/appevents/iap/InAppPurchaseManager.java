package com.facebook.appevents.iap;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.appevents.codeless.CodelessMatcher;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.text.CharsKt__CharKt;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* compiled from: InAppPurchaseManager.kt */
public final class InAppPurchaseManager {
    public static final String GOOGLE_BILLINGCLIENT_VERSION = "com.google.android.play.billingclient.version";
    public static final InAppPurchaseManager INSTANCE = new InAppPurchaseManager();
    public static final AtomicBoolean enabled = new AtomicBoolean(false);

    public static final void enableAutoLogging() {
        Class<InAppPurchaseManager> cls = InAppPurchaseManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                enabled.set(true);
                startTracking();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static final void startTracking() {
        Class<InAppPurchaseManager> cls = InAppPurchaseManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                if (enabled.get()) {
                    if (INSTANCE.usingBillingLib2Plus()) {
                        FeatureManager featureManager = FeatureManager.INSTANCE;
                        if (FeatureManager.isEnabled(FeatureManager.Feature.IapLoggingLib2)) {
                            InAppPurchaseAutoLogger inAppPurchaseAutoLogger = InAppPurchaseAutoLogger.INSTANCE;
                            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                            InAppPurchaseAutoLogger.startIapLogging(FacebookSdk.getApplicationContext());
                            return;
                        }
                    }
                    InAppPurchaseActivityLifecycleTracker inAppPurchaseActivityLifecycleTracker = InAppPurchaseActivityLifecycleTracker.INSTANCE;
                    InAppPurchaseActivityLifecycleTracker.startIapLogging();
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private final boolean usingBillingLib2Plus() {
        String string;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            Context applicationContext = FacebookSdk.getApplicationContext();
            ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
            if (applicationInfo == null || (string = applicationInfo.metaData.getString(GOOGLE_BILLINGCLIENT_VERSION)) == null || Integer.parseInt((String) CharsKt__CharKt.split$default(string, new String[]{CodelessMatcher.CURRENT_CLASS_NAME}, false, 3, 2).get(0)) < 2) {
                return false;
            }
            return true;
        } catch (Exception unused) {
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
        return false;
    }
}
