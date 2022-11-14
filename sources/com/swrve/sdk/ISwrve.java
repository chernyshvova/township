package com.swrve.sdk;

import com.swrve.sdk.config.SwrveConfig;

public interface ISwrve extends ISwrveBase<ISwrve, SwrveConfig> {
    void iapPlay(String str, double d, String str2, SwrveIAPRewards swrveIAPRewards, String str3, String str4);

    void iapPlay(String str, double d, String str2, String str3, String str4);

    void onTokenRefresh();

    void setRegistrationId(String str);
}
