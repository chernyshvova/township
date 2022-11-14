package com.facebook.ads;

import androidx.annotation.Keep;
import com.facebook.ads.C1513Ad;

public interface FullScreenAd extends C1513Ad {

    @Keep
    public interface ShowAdConfig {
    }

    @Keep
    public interface ShowConfigBuilder {
        ShowAdConfig build();
    }

    C1513Ad.LoadConfigBuilder buildLoadAdConfig();

    ShowConfigBuilder buildShowAdConfig();

    boolean show();
}
