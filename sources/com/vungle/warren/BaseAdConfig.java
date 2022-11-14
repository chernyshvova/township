package com.vungle.warren;

import androidx.annotation.RestrictTo;
import com.google.gson.annotations.SerializedName;
import com.vungle.warren.AdConfig;

public class BaseAdConfig {
    public static final int MUTED = 1;
    @SerializedName("adSize")
    public AdConfig.AdSize adSize;
    @SerializedName("settings")
    public int settings;

    public BaseAdConfig() {
    }

    public AdConfig.AdSize getAdSize() {
        AdConfig.AdSize adSize2 = this.adSize;
        return adSize2 == null ? AdConfig.AdSize.VUNGLE_DEFAULT : adSize2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int getSettings() {
        return this.settings;
    }

    public void setAdSize(AdConfig.AdSize adSize2) {
        this.adSize = adSize2;
    }

    public void setMuted(boolean z) {
        if (z) {
            this.settings |= 1;
        } else {
            this.settings &= -2;
        }
    }

    public BaseAdConfig(AdConfig.AdSize adSize2) {
        this.adSize = adSize2;
    }

    public BaseAdConfig(BaseAdConfig baseAdConfig) {
        this(baseAdConfig.getAdSize());
        this.settings = baseAdConfig.getSettings();
    }
}
