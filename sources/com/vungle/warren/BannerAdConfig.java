package com.vungle.warren;

import androidx.annotation.RestrictTo;
import com.vungle.warren.AdConfig;

public class BannerAdConfig extends BaseAdConfig {
    public BannerAdConfig() {
    }

    public /* bridge */ /* synthetic */ AdConfig.AdSize getAdSize() {
        return super.getAdSize();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public /* bridge */ /* synthetic */ int getSettings() {
        return super.getSettings();
    }

    public /* bridge */ /* synthetic */ void setAdSize(AdConfig.AdSize adSize) {
        super.setAdSize(adSize);
    }

    public /* bridge */ /* synthetic */ void setMuted(boolean z) {
        super.setMuted(z);
    }

    public BannerAdConfig(AdConfig.AdSize adSize) {
        super(adSize);
    }

    public BannerAdConfig(BaseAdConfig baseAdConfig) {
        super(baseAdConfig);
    }
}
