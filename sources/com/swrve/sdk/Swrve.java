package com.swrve.sdk;

import android.app.Application;
import android.content.Context;
import com.swrve.sdk.config.SwrveConfig;
import org.json.JSONException;
import org.json.JSONObject;

public class Swrve extends SwrveBase<ISwrve, SwrveConfig> implements ISwrve {
    public static final SwrveFlavour FLAVOUR = SwrveFlavour.FIREBASE;
    public SwrveGoogleUtil googleUtil;

    public Swrve(Application application, int i, String str, SwrveConfig swrveConfig) {
        super(application, i, str, swrveConfig);
        this.googleUtil = new SwrveGoogleUtil(application);
    }

    private void _iapPlay(String str, double d, String str2, SwrveIAPRewards swrveIAPRewards, String str3, String str4) {
        if (isStarted()) {
            try {
                if (checkPlayStoreSpecificArguments(str3, str4)) {
                    _iap(1, str, d, str2, swrveIAPRewards, str3, str4, "Google");
                }
            } catch (Exception e) {
                SwrveLogger.m2753e("IAP Play event failed", e, new Object[0]);
            }
        }
    }

    private boolean checkPlayStoreSpecificArguments(String str, String str2) throws IllegalArgumentException {
        if (SwrveHelper.isNullOrEmpty(str)) {
            SwrveLogger.m2754e("IAP event illegal argument: receipt cannot be empty for Google Play store event", new Object[0]);
            return false;
        } else if (!SwrveHelper.isNullOrEmpty(str2)) {
            return true;
        } else {
            SwrveLogger.m2754e("IAP event illegal argument: receiptSignature cannot be empty for Google Play store event", new Object[0]);
            return false;
        }
    }

    public void beforeSendDeviceInfo(Context context) {
        this.googleUtil.init(this.multiLayerLocalStorage, getUserId(), ((SwrveConfig) this.config).isPushRegistrationAutomatic(), ((SwrveConfig) this.config).isGAIDLoggingEnabled());
    }

    public void extraDeviceInfo(JSONObject jSONObject) throws JSONException {
        this.googleUtil.appendDeviceUpdate(jSONObject);
    }

    public String getPlatformOS(Context context) {
        return SwrveHelper.getPlatformOS(context, FLAVOUR);
    }

    public void iapPlay(String str, double d, String str2, String str3, String str4) {
        iapPlay(str, d, str2, new SwrveIAPRewards(), str3, str4);
    }

    public /* synthetic */ void lambda$setRegistrationId$0$Swrve(String str, String str2) {
        this.googleUtil.lambda$registerForTokenOnSuccessListener$2$SwrveGoogleUtil(this.multiLayerLocalStorage, str, str2);
    }

    public void onTokenRefresh() {
        if (isStarted()) {
            this.googleUtil.registerForTokenInBackground(this.multiLayerLocalStorage, getUserId());
        }
    }

    public void setRegistrationId(String str) {
        storageExecutorExecute(new Runnable(getUserId(), str) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ String f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                Swrve.this.lambda$setRegistrationId$0$Swrve(this.f$1, this.f$2);
            }
        });
    }

    public void iapPlay(String str, double d, String str2, SwrveIAPRewards swrveIAPRewards, String str3, String str4) {
        _iapPlay(str, d, str2, swrveIAPRewards, str3, str4);
    }
}
