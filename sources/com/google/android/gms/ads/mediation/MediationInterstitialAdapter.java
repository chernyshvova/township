package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public interface MediationInterstitialAdapter extends MediationAdapter {
    void requestInterstitialAd(@RecentlyNonNull Context context, @RecentlyNonNull MediationInterstitialListener mediationInterstitialListener, @RecentlyNonNull Bundle bundle, @RecentlyNonNull MediationAdRequest mediationAdRequest, @Nullable Bundle bundle2);

    void showInterstitial();
}
