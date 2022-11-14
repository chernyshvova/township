package com.facebook.appevents.internal;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper;
import com.facebook.appevents.iap.InAppPurchaseEventManager;
import com.facebook.appevents.iap.InAppPurchaseLoggerManager;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* compiled from: AutomaticAnalyticsLogger.kt */
public final class AutomaticAnalyticsLogger {
    public static final String APP_EVENTS_IF_AUTO_LOG_SUBS = "app_events_if_auto_log_subs";
    public static final AutomaticAnalyticsLogger INSTANCE = new AutomaticAnalyticsLogger();
    public static final String TAG = AutomaticAnalyticsLogger.class.getCanonicalName();
    public static final InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(FacebookSdk.getApplicationContext());

    /* compiled from: AutomaticAnalyticsLogger.kt */
    public static final class PurchaseLoggingParameters {
        public Currency currency;
        public Bundle param;
        public BigDecimal purchaseAmount;

        public PurchaseLoggingParameters(BigDecimal bigDecimal, Currency currency2, Bundle bundle) {
            Intrinsics.checkNotNullParameter(bigDecimal, "purchaseAmount");
            Intrinsics.checkNotNullParameter(currency2, "currency");
            Intrinsics.checkNotNullParameter(bundle, "param");
            this.purchaseAmount = bigDecimal;
            this.currency = currency2;
            this.param = bundle;
        }

        public final Currency getCurrency() {
            return this.currency;
        }

        public final Bundle getParam() {
            return this.param;
        }

        public final BigDecimal getPurchaseAmount() {
            return this.purchaseAmount;
        }

        public final void setCurrency(Currency currency2) {
            Intrinsics.checkNotNullParameter(currency2, "<set-?>");
            this.currency = currency2;
        }

        public final void setParam(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "<set-?>");
            this.param = bundle;
        }

        public final void setPurchaseAmount(BigDecimal bigDecimal) {
            Intrinsics.checkNotNullParameter(bigDecimal, "<set-?>");
            this.purchaseAmount = bigDecimal;
        }
    }

    static {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
    }

    private final PurchaseLoggingParameters getPurchaseLoggingParameters(String str, String str2) {
        return getPurchaseLoggingParameters(str, str2, new HashMap());
    }

    public static final boolean isImplicitPurchaseLoggingEnabled() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        String applicationId = FacebookSdk.getApplicationId();
        FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(applicationId);
        if (appSettingsWithoutQuery != null) {
            FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
            return FacebookSdk.getAutoLogAppEventsEnabled() && appSettingsWithoutQuery.getIAPAutomaticLoggingEnabled();
        }
    }

    public static final void logActivateAppEvent() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        Context applicationContext = FacebookSdk.getApplicationContext();
        FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
        String applicationId = FacebookSdk.getApplicationId();
        FacebookSdk facebookSdk3 = FacebookSdk.INSTANCE;
        if (!FacebookSdk.getAutoLogAppEventsEnabled()) {
            return;
        }
        if (applicationContext instanceof Application) {
            AppEventsLogger.Companion.activateApp((Application) applicationContext, applicationId);
        } else {
            Log.w(TAG, "Automatic logging of basic events will not happen, because FacebookSdk.getApplicationContext() returns object that is not instance of android.app.Application. Make sure you call FacebookSdk.sdkInitialize() from Application class and pass application context.");
        }
    }

    public static final void logActivityTimeSpentEvent(String str, long j) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        Context applicationContext = FacebookSdk.getApplicationContext();
        FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
        String applicationId = FacebookSdk.getApplicationId();
        FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
        FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(applicationId, false);
        if (queryAppSettings != null && queryAppSettings.getAutomaticLoggingEnabled() && j > 0) {
            InternalAppEventsLogger internalAppEventsLogger2 = new InternalAppEventsLogger(applicationContext);
            Bundle bundle = new Bundle(1);
            bundle.putCharSequence(Constants.AA_TIME_SPENT_SCREEN_PARAMETER_NAME, str);
            internalAppEventsLogger2.logEvent(Constants.AA_TIME_SPENT_EVENT_NAME, (double) j, bundle);
        }
    }

    public static final void logPurchase(String str, String str2, boolean z) {
        PurchaseLoggingParameters purchaseLoggingParameters;
        Intrinsics.checkNotNullParameter(str, FirebaseAnalytics.Event.PURCHASE);
        Intrinsics.checkNotNullParameter(str2, "skuDetails");
        if (isImplicitPurchaseLoggingEnabled() && (purchaseLoggingParameters = INSTANCE.getPurchaseLoggingParameters(str, str2)) != null) {
            boolean z2 = false;
            if (z) {
                FetchedAppGateKeepersManager fetchedAppGateKeepersManager = FetchedAppGateKeepersManager.INSTANCE;
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                if (FetchedAppGateKeepersManager.getGateKeeperForKey(APP_EVENTS_IF_AUTO_LOG_SUBS, FacebookSdk.getApplicationId(), false)) {
                    z2 = true;
                }
            }
            if (z2) {
                internalAppEventsLogger.logEventImplicitly(InAppPurchaseEventManager.INSTANCE.hasFreeTrialPeirod(str2) ? AppEventsConstants.EVENT_NAME_START_TRIAL : AppEventsConstants.EVENT_NAME_SUBSCRIBE, purchaseLoggingParameters.getPurchaseAmount(), purchaseLoggingParameters.getCurrency(), purchaseLoggingParameters.getParam());
            } else {
                internalAppEventsLogger.logPurchaseImplicitly(purchaseLoggingParameters.getPurchaseAmount(), purchaseLoggingParameters.getCurrency(), purchaseLoggingParameters.getParam());
            }
        }
    }

    private final PurchaseLoggingParameters getPurchaseLoggingParameters(String str, String str2, Map<String, String> map) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject(str2);
            boolean z = true;
            Bundle bundle = new Bundle(1);
            bundle.putCharSequence(Constants.IAP_PRODUCT_ID, jSONObject.getString("productId"));
            bundle.putCharSequence(Constants.IAP_PURCHASE_TIME, jSONObject.getString(InAppPurchaseLoggerManager.PURCHASE_TIME));
            bundle.putCharSequence(Constants.IAP_PURCHASE_TOKEN, jSONObject.getString("purchaseToken"));
            bundle.putCharSequence(Constants.IAP_PACKAGE_NAME, jSONObject.optString(InAppPurchaseBillingClientWrapper.PACKAGE_NAME));
            bundle.putCharSequence(Constants.IAP_PRODUCT_TITLE, jSONObject2.optString("title"));
            bundle.putCharSequence(Constants.IAP_PRODUCT_DESCRIPTION, jSONObject2.optString("description"));
            String optString = jSONObject2.optString("type");
            bundle.putCharSequence(Constants.IAP_PRODUCT_TYPE, optString);
            if (Intrinsics.areEqual(optString, InAppPurchaseEventManager.SUBSCRIPTION)) {
                bundle.putCharSequence(Constants.IAP_SUBSCRIPTION_AUTORENEWING, Boolean.toString(jSONObject.optBoolean("autoRenewing", false)));
                bundle.putCharSequence(Constants.IAP_SUBSCRIPTION_PERIOD, jSONObject2.optString("subscriptionPeriod"));
                bundle.putCharSequence(Constants.IAP_FREE_TRIAL_PERIOD, jSONObject2.optString("freeTrialPeriod"));
                String optString2 = jSONObject2.optString("introductoryPriceCycles");
                Intrinsics.checkNotNullExpressionValue(optString2, "introductoryPriceCycles");
                if (optString2.length() != 0) {
                    z = false;
                }
                if (!z) {
                    bundle.putCharSequence(Constants.IAP_INTRO_PRICE_AMOUNT_MICROS, jSONObject2.optString("introductoryPriceAmountMicros"));
                    bundle.putCharSequence(Constants.IAP_INTRO_PRICE_CYCLES, optString2);
                }
            }
            for (Map.Entry next : map.entrySet()) {
                bundle.putCharSequence((String) next.getKey(), (String) next.getValue());
            }
            double d = (double) jSONObject2.getLong("price_amount_micros");
            Double.isNaN(d);
            BigDecimal bigDecimal = new BigDecimal(d / 1000000.0d);
            Currency instance = Currency.getInstance(jSONObject2.getString("price_currency_code"));
            Intrinsics.checkNotNullExpressionValue(instance, "getInstance(skuDetailsJSON.getString(\"price_currency_code\"))");
            return new PurchaseLoggingParameters(bigDecimal, instance, bundle);
        } catch (JSONException e) {
            Log.e(TAG, "Error parsing in-app subscription data.", e);
            return null;
        }
    }
}
