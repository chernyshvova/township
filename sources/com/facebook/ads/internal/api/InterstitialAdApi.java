package com.facebook.ads.internal.api;

import androidx.annotation.Keep;
import androidx.annotation.UiThread;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.FullScreenAd;
import com.facebook.ads.InterstitialAd;
import com.facebook.proguard.annotations.DoNotStripAny;

@UiThread
@DoNotStripAny
@Keep
public interface InterstitialAdApi extends FullScreenAd {
    InterstitialAd.InterstitialAdLoadConfigBuilder buildLoadAdConfig();

    InterstitialAd.InterstitialAdShowConfigBuilder buildShowAdConfig();

    boolean isAdLoaded();

    void loadAd(InterstitialAd.InterstitialLoadAdConfig interstitialLoadAdConfig);

    void registerAdCompanionView(AdCompanionView adCompanionView);

    @Deprecated
    void setExtraHints(ExtraHints extraHints);

    boolean show();

    boolean show(InterstitialAd.InterstitialShowAdConfig interstitialShowAdConfig);

    void unregisterAdCompanionView();
}
