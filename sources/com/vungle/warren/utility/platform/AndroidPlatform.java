package com.vungle.warren.utility.platform;

import android.os.Build;

public class AndroidPlatform implements Platform {
    public boolean isAtLeastMinimumSDK() {
        return Build.VERSION.SDK_INT >= 21;
    }
}
