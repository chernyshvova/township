package com.swrve.sdk;

import android.app.Application;
import android.content.Context;
import com.swrve.sdk.config.SwrveConfig;
import java.util.Map;

public class SwrveSDK extends SwrveSDKBase {
    public static synchronized ISwrve createInstance(Application application, int i, String str) {
        ISwrve createInstance;
        synchronized (SwrveSDK.class) {
            createInstance = createInstance(application, i, str, new SwrveConfig());
        }
        return createInstance;
    }

    public static SwrveConfig getConfig() {
        SwrveSDKBase.checkInstanceCreated();
        return (SwrveConfig) SwrveSDKBase.instance.getConfig();
    }

    public static void iapPlay(String str, double d, String str2, String str3, String str4) {
        SwrveSDKBase.checkInstanceCreated();
        ((ISwrve) SwrveSDKBase.instance).iapPlay(str, d, str2, str3, str4);
    }

    public static void sendPushEngagedEvent(Context context, String str) {
        SwrveSDKBase.checkInstanceCreated();
        EventHelper.sendEngagedEvent(context, ISwrveCommon.GENERIC_EVENT_CAMPAIGN_TYPE_PUSH, str, (Map<String, String>) null);
    }

    public static void setRegistrationId(String str) {
        SwrveSDKBase.checkInstanceCreated();
        ((ISwrve) SwrveSDKBase.instance).setRegistrationId(str);
    }

    public static void setSilentPushListener(SwrveSilentPushListener swrveSilentPushListener) {
        SwrveSDKBase.checkInstanceCreated();
        SwrveConfig config = getConfig();
        if (config != null) {
            config.setSilentPushListener(swrveSilentPushListener);
        }
    }

    public static synchronized ISwrve createInstance(Application application, int i, String str, SwrveConfig swrveConfig) {
        ISwrve iSwrve;
        synchronized (SwrveSDK.class) {
            if (application == null) {
                SwrveHelper.logAndThrowException("Application is null");
            } else if (SwrveHelper.isNullOrEmpty(str)) {
                SwrveHelper.logAndThrowException("Api key not specified");
            }
            if (!SwrveHelper.sdkAvailable(swrveConfig.getModelBlackList())) {
                SwrveSDKBase.instance = new SwrveEmpty(application, str);
            }
            if (SwrveSDKBase.instance == null) {
                SwrveSDKBase.instance = new Swrve(application, i, str, swrveConfig);
            }
            iSwrve = (ISwrve) SwrveSDKBase.instance;
        }
        return iSwrve;
    }

    public static void iapPlay(String str, double d, String str2, SwrveIAPRewards swrveIAPRewards, String str3, String str4) {
        SwrveSDKBase.checkInstanceCreated();
        ((ISwrve) SwrveSDKBase.instance).iapPlay(str, d, str2, swrveIAPRewards, str3, str4);
    }
}
