package com.facebook.appevents.iap;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import com.applovin.sdk.AppLovinEventParameters;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: InAppPurchaseActivityLifecycleTracker.kt */
public final class InAppPurchaseActivityLifecycleTracker {
    public static final String BILLING_ACTIVITY_NAME = "com.android.billingclient.api.ProxyBillingActivity";
    public static final InAppPurchaseActivityLifecycleTracker INSTANCE = new InAppPurchaseActivityLifecycleTracker();
    public static final String SERVICE_INTERFACE_NAME = "com.android.vending.billing.IInAppBillingService$Stub";
    public static final String TAG = InAppPurchaseActivityLifecycleTracker.class.getCanonicalName();
    public static Application.ActivityLifecycleCallbacks callbacks;
    public static Boolean hasBillingActivity;
    public static Boolean hasBillingService;
    public static Object inAppBillingObj;
    public static Intent intent;
    public static final AtomicBoolean isTracking = new AtomicBoolean(false);
    public static ServiceConnection serviceConnection;

    private final void initializeIfNotInitialized() {
        if (hasBillingService == null) {
            InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
            boolean z = true;
            Boolean valueOf = Boolean.valueOf(InAppPurchaseUtils.getClass("com.android.vending.billing.IInAppBillingService$Stub") != null);
            hasBillingService = valueOf;
            if (!Intrinsics.areEqual(valueOf, Boolean.FALSE)) {
                InAppPurchaseUtils inAppPurchaseUtils2 = InAppPurchaseUtils.INSTANCE;
                if (InAppPurchaseUtils.getClass(BILLING_ACTIVITY_NAME) == null) {
                    z = false;
                }
                hasBillingActivity = Boolean.valueOf(z);
                InAppPurchaseEventManager inAppPurchaseEventManager = InAppPurchaseEventManager.INSTANCE;
                InAppPurchaseEventManager.clearSkuDetailsCache();
                Intent intent2 = new Intent("com.android.vending.billing.InAppBillingService.BIND").setPackage("com.android.vending");
                Intrinsics.checkNotNullExpressionValue(intent2, "Intent(\"com.android.vending.billing.InAppBillingService.BIND\")\n            .setPackage(\"com.android.vending\")");
                intent = intent2;
                serviceConnection = new C1530x362beb25();
                callbacks = new C1531x362beb26();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void logPurchase(Context context, ArrayList<String> arrayList, boolean z) {
        if (!arrayList.isEmpty()) {
            HashMap hashMap = new HashMap();
            ArrayList arrayList2 = new ArrayList();
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                try {
                    String string = new JSONObject(next).getString("productId");
                    Intrinsics.checkNotNullExpressionValue(string, AppLovinEventParameters.PRODUCT_IDENTIFIER);
                    Intrinsics.checkNotNullExpressionValue(next, FirebaseAnalytics.Event.PURCHASE);
                    hashMap.put(string, next);
                    arrayList2.add(string);
                } catch (JSONException e) {
                    Log.e(TAG, "Error parsing in-app purchase data.", e);
                }
            }
            InAppPurchaseEventManager inAppPurchaseEventManager = InAppPurchaseEventManager.INSTANCE;
            for (Map.Entry next2 : InAppPurchaseEventManager.getSkuDetails(context, arrayList2, inAppBillingObj, z).entrySet()) {
                String str = (String) next2.getValue();
                String str2 = (String) hashMap.get((String) next2.getKey());
                if (str2 != null) {
                    AutomaticAnalyticsLogger automaticAnalyticsLogger = AutomaticAnalyticsLogger.INSTANCE;
                    AutomaticAnalyticsLogger.logPurchase(str2, str, z);
                }
            }
        }
    }

    public static final void startIapLogging() {
        INSTANCE.initializeIfNotInitialized();
        if (!Intrinsics.areEqual(hasBillingService, Boolean.FALSE)) {
            AutomaticAnalyticsLogger automaticAnalyticsLogger = AutomaticAnalyticsLogger.INSTANCE;
            if (AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled()) {
                INSTANCE.startTracking();
            }
        }
    }

    private final void startTracking() {
        if (isTracking.compareAndSet(false, true)) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            Context applicationContext = FacebookSdk.getApplicationContext();
            if (applicationContext instanceof Application) {
                Application application = (Application) applicationContext;
                Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = callbacks;
                if (activityLifecycleCallbacks != null) {
                    application.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
                    Intent intent2 = intent;
                    if (intent2 != null) {
                        ServiceConnection serviceConnection2 = serviceConnection;
                        if (serviceConnection2 != null) {
                            applicationContext.bindService(intent2, serviceConnection2, 1);
                        } else {
                            Intrinsics.throwUninitializedPropertyAccessException("serviceConnection");
                            throw null;
                        }
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("intent");
                        throw null;
                    }
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("callbacks");
                    throw null;
                }
            }
        }
    }
}
