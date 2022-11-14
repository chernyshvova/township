package com.google.ads.mediation;

import androidx.annotation.RecentlyNonNull;
import com.google.ads.AdRequest$ErrorCode;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public interface MediationInterstitialListener {
    void onFailedToReceiveAd(@RecentlyNonNull MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, @RecentlyNonNull AdRequest$ErrorCode adRequest$ErrorCode);
}
