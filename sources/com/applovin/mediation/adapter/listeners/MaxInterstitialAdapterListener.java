package com.applovin.mediation.adapter.listeners;

import android.os.Bundle;
import com.applovin.mediation.adapter.MaxAdapterError;

public interface MaxInterstitialAdapterListener extends MaxAdapterListener {
    void onInterstitialAdClicked();

    void onInterstitialAdDisplayFailed(MaxAdapterError maxAdapterError);

    void onInterstitialAdDisplayed();

    void onInterstitialAdDisplayed(Bundle bundle);

    void onInterstitialAdHidden();

    void onInterstitialAdLoadFailed(MaxAdapterError maxAdapterError);

    void onInterstitialAdLoaded();

    void onInterstitialAdLoaded(Bundle bundle);
}
