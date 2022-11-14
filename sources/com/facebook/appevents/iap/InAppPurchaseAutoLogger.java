package com.facebook.appevents.iap;

import android.content.Context;
import androidx.annotation.RestrictTo;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.vungle.warren.log.LogEntry;
import kotlin.jvm.internal.Intrinsics;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* compiled from: InAppPurchaseAutoLogger.kt */
public final class InAppPurchaseAutoLogger {
    public static final String BILLING_CLIENT_PURCHASE_NAME = "com.android.billingclient.api.Purchase";
    public static final InAppPurchaseAutoLogger INSTANCE = new InAppPurchaseAutoLogger();

    private final void logPurchase() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                InAppPurchaseLoggerManager inAppPurchaseLoggerManager = InAppPurchaseLoggerManager.INSTANCE;
                InAppPurchaseLoggerManager.filterPurchaseLogging(InAppPurchaseBillingClientWrapper.Companion.getPurchaseDetailsMap(), InAppPurchaseBillingClientWrapper.Companion.getSkuDetailsMap());
                InAppPurchaseBillingClientWrapper.Companion.getPurchaseDetailsMap().clear();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public static final void startIapLogging(Context context) {
        InAppPurchaseBillingClientWrapper orCreateInstance;
        Class<InAppPurchaseAutoLogger> cls = InAppPurchaseAutoLogger.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(context, LogEntry.LOG_ITEM_CONTEXT);
                InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
                if (InAppPurchaseUtils.getClass("com.android.billingclient.api.Purchase") != null && (orCreateInstance = InAppPurchaseBillingClientWrapper.Companion.getOrCreateInstance(context)) != null && InAppPurchaseBillingClientWrapper.Companion.isServiceConnected().get()) {
                    InAppPurchaseLoggerManager inAppPurchaseLoggerManager = InAppPurchaseLoggerManager.INSTANCE;
                    if (InAppPurchaseLoggerManager.eligibleQueryPurchaseHistory()) {
                        orCreateInstance.queryPurchaseHistory("inapp", $$Lambda$687IX7AaP5K7d5ER9XfsPCHYVU.INSTANCE);
                    } else {
                        orCreateInstance.queryPurchase("inapp", $$Lambda$Wwi5DeOus3p2VMp5XwmTDyqKUU8.INSTANCE);
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    /* renamed from: startIapLogging$lambda-0  reason: not valid java name */
    public static final void m3578startIapLogging$lambda0() {
        Class<InAppPurchaseAutoLogger> cls = InAppPurchaseAutoLogger.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                INSTANCE.logPurchase();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    /* renamed from: startIapLogging$lambda-1  reason: not valid java name */
    public static final void m3579startIapLogging$lambda1() {
        Class<InAppPurchaseAutoLogger> cls = InAppPurchaseAutoLogger.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                INSTANCE.logPurchase();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }
}
