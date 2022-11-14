package com.playrix.engine;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.swrve.sdk.ISwrve;
import com.swrve.sdk.ISwrveBase;
import com.swrve.sdk.SwrveHelper;
import com.swrve.sdk.SwrveIAPRewards;
import com.swrve.sdk.SwrveSDK;
import com.swrve.sdk.SwrveSDKBase;
import com.swrve.sdk.config.SwrveConfig;

public class SwrveSDKWrapper extends SwrveSDKWrapperBase {
    public static final String LOG_TAG = "[SwrveSDKWrapperGPlay] ";

    public static void configuration(SwrveConfig swrveConfig) {
        swrveConfig.setPushRegistrationAutomatic(false);
    }

    public static void registerPushToken(String str) {
        ISwrveBase iSwrveBase;
        if (!SwrveHelper.isNullOrEmpty(str) && (iSwrveBase = SwrveSDKBase.instance) != null && (iSwrveBase instanceof ISwrve)) {
            try {
                Logger.logDebug("[SwrveSDKWrapperGPlay] registerPushToken called");
                ((ISwrve) SwrveSDKBase.instance).setRegistrationId(str);
            } catch (Throwable th) {
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("[SwrveSDKWrapperGPlay] Error in processToken ");
                outline24.append(th.toString());
                Logger.logError(outline24.toString());
            }
        }
    }

    public static void trackIap(String str, double d, String str2, SwrveIAPRewards swrveIAPRewards, String str3, String str4) {
        try {
            SwrveSDK.iapPlay(str, d, str2, swrveIAPRewards, str3, str4);
        } catch (Throwable th) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("[SwrveSDKWrapperGPlay] Can't track iap ");
            outline24.append(th.getMessage());
            Logger.logError(outline24.toString());
        }
    }
}
