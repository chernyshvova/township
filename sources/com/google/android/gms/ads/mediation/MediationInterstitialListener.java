package com.google.android.gms.ads.mediation;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.ads.AdError;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public interface MediationInterstitialListener {
    void onAdClicked(@RecentlyNonNull MediationInterstitialAdapter mediationInterstitialAdapter);

    void onAdClosed(@RecentlyNonNull MediationInterstitialAdapter mediationInterstitialAdapter);

    @Deprecated
    void onAdFailedToLoad(@RecentlyNonNull MediationInterstitialAdapter mediationInterstitialAdapter, int i);

    void onAdFailedToLoad(@RecentlyNonNull MediationInterstitialAdapter mediationInterstitialAdapter, @RecentlyNonNull AdError adError);

    void onAdLeftApplication(@RecentlyNonNull MediationInterstitialAdapter mediationInterstitialAdapter);

    void onAdLoaded(@RecentlyNonNull MediationInterstitialAdapter mediationInterstitialAdapter);

    void onAdOpened(@RecentlyNonNull MediationInterstitialAdapter mediationInterstitialAdapter);
}
