package com.applovin.impl.adview;

import android.content.Context;
import com.applovin.adview.AppLovinIncentivizedInterstitial;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;

public class AppLovinRewardedInterstitialAd {

    /* renamed from: a */
    public final AppLovinIncentivizedInterstitial f170a;

    /* renamed from: b */
    public AppLovinAdDisplayListener f171b;

    /* renamed from: c */
    public AppLovinAdClickListener f172c;

    /* renamed from: d */
    public AppLovinAdVideoPlaybackListener f173d;

    public AppLovinRewardedInterstitialAd(AppLovinSdk appLovinSdk) {
        this.f170a = new AppLovinIncentivizedInterstitial(appLovinSdk);
    }

    public void setAdClickListener(AppLovinAdClickListener appLovinAdClickListener) {
        this.f172c = appLovinAdClickListener;
    }

    public void setAdDisplayListener(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.f171b = appLovinAdDisplayListener;
    }

    public void setAdVideoPlaybackListener(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        this.f173d = appLovinAdVideoPlaybackListener;
    }

    public void show(AppLovinAd appLovinAd, Context context, AppLovinAdRewardListener appLovinAdRewardListener) {
        this.f170a.show(appLovinAd, context, appLovinAdRewardListener, this.f173d, this.f171b, this.f172c);
    }

    public String toString() {
        return "AppLovinRewardedInterstitialAd{}";
    }
}
