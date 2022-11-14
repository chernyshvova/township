package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.ads.mediation.MediationAdRequest;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public interface CustomEventInterstitial extends CustomEvent {
    void requestInterstitialAd(@RecentlyNonNull Context context, @RecentlyNonNull CustomEventInterstitialListener customEventInterstitialListener, @Nullable String str, @RecentlyNonNull MediationAdRequest mediationAdRequest, @Nullable Bundle bundle);

    void showInterstitial();
}
