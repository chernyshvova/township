package com.facebook.ads;

import androidx.annotation.Keep;

@Keep
public interface InterstitialAdListener extends AdListener {
    void onInterstitialDismissed(C1513Ad ad);

    void onInterstitialDisplayed(C1513Ad ad);
}
