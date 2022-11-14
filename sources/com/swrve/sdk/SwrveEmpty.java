package com.swrve.sdk;

import android.content.Context;
import com.swrve.sdk.config.SwrveConfig;

public class SwrveEmpty extends SwrveBaseEmpty<ISwrve, SwrveConfig> implements ISwrve {
    public SwrveEmpty(Context context, String str) {
        super(context, str);
    }

    public void iapPlay(String str, double d, String str2, SwrveIAPRewards swrveIAPRewards, String str3, String str4) {
    }

    public void iapPlay(String str, double d, String str2, String str3, String str4) {
    }

    public void onTokenRefresh() {
    }

    public void setRegistrationId(String str) {
    }
}
