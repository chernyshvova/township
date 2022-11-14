package com.playrix.advertising.version1;

import android.app.Activity;
import android.text.TextUtils;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.mediation.ads.MaxRewardedAd;
import com.applovin.sdk.AppLovinMediationProvider;
import com.applovin.sdk.AppLovinPrivacySettings;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.AppLovinSdkSettings;
import com.playrix.advertising.version1.ProviderBase;
import com.swrve.sdk.rest.RESTClient;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class AppLovinProvider extends ProviderBase {
    public final Delegate _delegate = new Delegate();
    public final AtomicBoolean _isClicked = new AtomicBoolean(false);
    public final AtomicBoolean _isRewarded = new AtomicBoolean(false);
    public AppLovinSdk _sdk = null;

    public class Delegate implements MaxRewardedAdListener, MaxAdRevenueListener {
        public Delegate() {
        }

        public void onAdClicked(MaxAd maxAd) {
            AppLovinProvider.this.onAdClicked(maxAd.getAdUnitId());
        }

        public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
            AppLovinProvider.this.onAdDisplayFailed(maxAd.getAdUnitId(), maxError.toString());
        }

        public void onAdDisplayed(MaxAd maxAd) {
            AppLovinProvider.this.onAdDisplayed(maxAd.getAdUnitId());
        }

        public void onAdHidden(MaxAd maxAd) {
            AppLovinProvider.this.onAdHidden(maxAd.getAdUnitId());
        }

        public void onAdLoadFailed(String str, MaxError maxError) {
            AppLovinProvider.this.onAdLoadFailed(str, maxError.getMessage());
        }

        public void onAdLoaded(MaxAd maxAd) {
            AppLovinProvider.this.onAdLoaded(maxAd.getAdUnitId());
        }

        public void onAdRevenuePaid(MaxAd maxAd) {
            AppLovinProvider.this.onImpression(maxAd);
        }

        public void onRewardedVideoCompleted(MaxAd maxAd) {
            AppLovinProvider.this.onRewardedVideoCompleted(maxAd.getAdUnitId());
        }

        public void onRewardedVideoStarted(MaxAd maxAd) {
            AppLovinProvider.this.onRewardedVideoStarted(maxAd.getAdUnitId());
        }

        public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {
            AppLovinProvider.this.onUserRewarded(maxAd.getAdUnitId());
        }
    }

    /* access modifiers changed from: private */
    public void onAdDisplayFailed(String str, String str2) {
        logInfo("location: " + str + ", error: " + str2);
        this._isRewarded.set(false);
        this._isClicked.set(false);
        callOnShowDone(0, str2, false);
    }

    /* access modifiers changed from: private */
    public void onAdDisplayed(String str) {
        logInfo("location: " + str);
        this._isRewarded.set(false);
        this._isClicked.set(false);
        callOnShowStart();
    }

    /* access modifiers changed from: private */
    public void onAdHidden(String str) {
        logInfo("location: " + str);
        if (!this._isRewarded.get()) {
            callOnShowFinishDone(1, "", false);
        } else {
            callOnShowDone(2, "", this._isClicked.get());
        }
        this._isRewarded.set(false);
        this._isClicked.set(false);
    }

    /* access modifiers changed from: private */
    public void onAdLoadFailed(String str, String str2) {
        logInfo("location: " + str + ", error: " + str2);
        callOnLoadFailed(1, str, str2);
    }

    /* access modifiers changed from: private */
    public void onAdLoaded(String str) {
        logInfo("location: " + str);
        callOnLoadSuccess(1, str, "");
    }

    /* access modifiers changed from: private */
    public void onImpression(MaxAd maxAd) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adunit_format", maxAd.getFormat().getLabel());
            jSONObject.put("adunit_id", maxAd.getAdUnitId());
            jSONObject.put("network_name", maxAd.getNetworkName());
            jSONObject.put("network_placement_id", maxAd.getNetworkPlacement());
            jSONObject.put("precision", maxAd.getRevenuePrecision());
            jSONObject.put("publisher_revenue", maxAd.getRevenue());
            String placement = maxAd.getPlacement();
            if (placement != null) {
                jSONObject.put("placement", placement);
            }
            String creativeId = maxAd.getCreativeId();
            if (creativeId != null) {
                jSONObject.put("creative_id", creativeId);
            }
            String jSONObject2 = jSONObject.toString();
            logInfo(jSONObject2);
            callOnTrackMediation(jSONObject2);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public void onRewardedVideoCompleted(String str) {
        logInfo("location: " + str);
    }

    /* access modifiers changed from: private */
    public void onRewardedVideoStarted(String str) {
        logInfo("location: " + str);
    }

    /* access modifiers changed from: private */
    public void onUserRewarded(String str) {
        logInfo("location: " + str);
        this._isRewarded.set(true);
        callOnShowFinish(2);
    }

    public boolean cache(int i, final String str) {
        final Activity activity = getActivity();
        if (!isInitialized() || !isModeAvailable(i) || isReady(i, str) || activity == null) {
            return false;
        }
        activity.runOnUiThread(new Runnable() {
            public void run() {
                MaxRewardedAd instance = MaxRewardedAd.getInstance(str, AppLovinProvider.this._sdk, activity);
                instance.setListener(AppLovinProvider.this._delegate);
                instance.setRevenueListener(AppLovinProvider.this._delegate);
                instance.loadAd();
            }
        });
        return true;
    }

    public boolean doBackPressed(Activity activity) {
        return false;
    }

    public void doCreate(Activity activity, Map<String, String> map) {
        if (!ProvidersConfig.blockAdapterProviders()) {
            logInfo("Already initialized some adapter providers");
            setInitializationState(3);
            return;
        }
        String str = map.get("sdkKey");
        if (TextUtils.isEmpty(str)) {
            logInfo("not found sdkKey setting");
            setInitializationState(3);
            return;
        }
        String[] stringListParameter = ProviderBase.getStringListParameter(map, "locations");
        if (stringListParameter == null || stringListParameter.length == 0) {
            logInfo("not found locations settings");
            setInitializationState(3);
            return;
        }
        boolean booleanParameter = ProviderBase.getBooleanParameter(map, "disableSequentialCaching");
        boolean booleanParameter2 = ProviderBase.getBooleanParameter(map, "verboseLogging");
        final boolean booleanParameter3 = ProviderBase.getBooleanParameter(map, "showMediationDebugger");
        String str2 = map.get("userId");
        AppLovinSdk instance = AppLovinSdk.getInstance(str, new AppLovinSdkSettings(activity), activity);
        this._sdk = instance;
        if (instance == null) {
            logInfo("error creating AppLovinSdk");
            setInitializationState(3);
            return;
        }
        instance.setMediationProvider(AppLovinMediationProvider.MAX);
        this._sdk.getSettings().setVerboseLogging(booleanParameter2);
        if (booleanParameter) {
            this._sdk.getSettings().setExtraParameter("disable_b2b_ad_unit_ids", TextUtils.join(RESTClient.COMMA_SEPARATOR, stringListParameter));
        }
        if (!TextUtils.isEmpty(str2)) {
            this._sdk.setUserIdentifier(str2);
        }
        setInitializationState(2);
        setEnvironment(map);
        final AppLovinSdk appLovinSdk = this._sdk;
        appLovinSdk.initializeSdk((AppLovinSdk.SdkInitializationListener) new AppLovinSdk.SdkInitializationListener() {
            public void onSdkInitialized(AppLovinSdkConfiguration appLovinSdkConfiguration) {
                if (appLovinSdk.isInitialized()) {
                    AppLovinProvider.this.logInfo("success");
                    AppLovinProvider.this.setInitializationState(1);
                    if (booleanParameter3) {
                        appLovinSdk.showMediationDebugger();
                        return;
                    }
                    return;
                }
                AppLovinProvider.this.logInfo("failed");
                AppLovinProvider.this.setInitializationState(3);
            }
        });
    }

    public void doDestroy(Activity activity) {
    }

    public void doPause(Activity activity) {
    }

    public void doResume(Activity activity) {
    }

    public void doStart(Activity activity) {
    }

    public void doStop(Activity activity) {
    }

    public int getCacheMode() {
        return 0;
    }

    public String getName() {
        return "AppLovin";
    }

    public String getVersion() {
        return AppLovinSdk.VERSION;
    }

    public boolean isModeAvailable(int i) {
        return i == 1;
    }

    public boolean isReady(int i, String str) {
        Activity activity = getActivity();
        if (!isInitialized() || !isModeAvailable(i) || isShowing() || activity == null) {
            return false;
        }
        return MaxRewardedAd.getInstance(str, this._sdk, activity).isReady();
    }

    public void onAdClicked(String str) {
        logInfo("location: " + str);
        this._isClicked.set(true);
    }

    public void setEnvironment(Map<String, String> map) {
        Activity activity = getActivity();
        if (activity != null) {
            if (map.containsKey(ProviderBase.ParameterName.HAS_USER_CONSENT)) {
                AppLovinPrivacySettings.setHasUserConsent(ProviderBase.getBooleanParameter(map, ProviderBase.ParameterName.HAS_USER_CONSENT), activity);
            }
            if (map.containsKey(ProviderBase.ParameterName.DO_NOT_SELL)) {
                AppLovinPrivacySettings.setDoNotSell(ProviderBase.getBooleanParameter(map, ProviderBase.ParameterName.DO_NOT_SELL), activity);
            }
        }
    }

    public boolean show(int i, final String str) {
        final Activity activity = getActivity();
        if (!isReady(i, str) || activity == null) {
            return false;
        }
        activity.runOnUiThread(new Runnable() {
            public void run() {
                MaxRewardedAd.getInstance(str, AppLovinProvider.this._sdk, activity).showAd();
            }
        });
        return true;
    }
}
