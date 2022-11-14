package com.applovin.impl.mediation.p012c;

import com.applovin.impl.mediation.ads.C0836a;
import com.applovin.impl.sdk.utils.C1267j;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;

/* renamed from: com.applovin.impl.mediation.c.a */
public class C0865a implements C0836a.C0837a, MaxAdListener, MaxAdRevenueListener, MaxAdViewAdListener, MaxRewardedAdListener {

    /* renamed from: a */
    public final C0836a.C0837a f776a;

    public C0865a(C0836a.C0837a aVar) {
        this.f776a = aVar;
    }

    public void onAdClicked(MaxAd maxAd) {
        C1267j.m2578d(this.f776a, maxAd);
    }

    public void onAdCollapsed(MaxAd maxAd) {
        C1267j.m2586h(this.f776a, maxAd);
    }

    public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
        C1267j.m2547a((MaxAdListener) this.f776a, maxAd, maxError);
    }

    public void onAdDisplayed(MaxAd maxAd) {
        C1267j.m2570b((MaxAdListener) this.f776a, maxAd);
    }

    public void onAdExpanded(MaxAd maxAd) {
        C1267j.m2584g(this.f776a, maxAd);
    }

    public void onAdHidden(MaxAd maxAd) {
        C1267j.m2575c(this.f776a, maxAd);
    }

    public void onAdLoadFailed(String str, MaxError maxError) {
        C1267j.m2552a((MaxAdListener) this.f776a, str, maxError);
    }

    public void onAdLoaded(MaxAd maxAd) {
        C1267j.m2546a((MaxAdListener) this.f776a, maxAd);
    }

    public void onAdRevenuePaid(MaxAd maxAd) {
        C1267j.m2554a((MaxAdRevenueListener) this.f776a, maxAd);
    }

    public void onRewardedVideoCompleted(MaxAd maxAd) {
        C1267j.m2582f(this.f776a, maxAd);
    }

    public void onRewardedVideoStarted(MaxAd maxAd) {
        C1267j.m2580e(this.f776a, maxAd);
    }

    public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {
        C1267j.m2549a((MaxAdListener) this.f776a, maxAd, maxReward);
    }
}
