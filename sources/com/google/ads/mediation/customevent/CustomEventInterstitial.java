package com.google.ads.mediation.customevent;

import android.app.Activity;
import androidx.annotation.RecentlyNonNull;
import com.google.ads.mediation.MediationAdRequest;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public interface CustomEventInterstitial {
    /* synthetic */ void destroy();

    void requestInterstitialAd(@RecentlyNonNull CustomEventInterstitialListener customEventInterstitialListener, @RecentlyNonNull Activity activity, @RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull MediationAdRequest mediationAdRequest, @RecentlyNonNull Object obj);

    void showInterstitial();
}
