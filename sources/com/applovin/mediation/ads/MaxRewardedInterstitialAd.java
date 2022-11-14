package com.applovin.mediation.ads;

import android.app.Activity;
import android.text.TextUtils;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.mediation.ads.C0836a;
import com.applovin.impl.mediation.ads.MaxFullscreenAdImpl;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.WeakReference;

public class MaxRewardedInterstitialAd implements MaxFullscreenAdImpl.C0826a {

    /* renamed from: a */
    public static WeakReference<Activity> f2665a = new WeakReference<>((Object) null);

    /* renamed from: b */
    public final MaxFullscreenAdImpl f2666b;

    public MaxRewardedInterstitialAd(String str, Activity activity) {
        this(str, AppLovinSdk.getInstance(activity), activity);
    }

    public MaxRewardedInterstitialAd(String str, AppLovinSdk appLovinSdk, Activity activity) {
        C0836a.logApiCall("MaxRewardedInterstitialAd", "MaxRewardedInterstitialAd(adUnitId=" + str + ", sdk=" + appLovinSdk + ", activity=" + activity + ")");
        if (str == null) {
            throw new IllegalArgumentException("No ad unit ID specified");
        } else if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Empty ad unit ID specified");
        } else if (activity == null) {
            throw new IllegalArgumentException("No activity specified");
        } else if (appLovinSdk != null) {
            f2665a = new WeakReference<>(activity);
            this.f2666b = new MaxFullscreenAdImpl(str, MaxAdFormat.REWARDED_INTERSTITIAL, this, "MaxRewardedInterstitialAd", appLovinSdk.coreSdk);
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    public void destroy() {
        this.f2666b.logApiCall("destroy()");
        this.f2666b.destroy();
    }

    public Activity getActivity() {
        this.f2666b.logApiCall("getActivity()");
        return (Activity) f2665a.get();
    }

    public boolean isReady() {
        boolean isReady = this.f2666b.isReady();
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f2666b;
        maxFullscreenAdImpl.logApiCall("isReady() " + isReady + " for ad unit id " + this.f2666b.getAdUnitId());
        return isReady;
    }

    public void loadAd() {
        this.f2666b.logApiCall("loadAd()");
        this.f2666b.loadAd(getActivity());
    }

    public void setCustomPostbackData(String str) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f2666b;
        maxFullscreenAdImpl.logApiCall("setCustomPostbackData(value=" + str + ")");
        this.f2666b.setCustomPostbackData(str);
    }

    public void setExtraParameter(String str, String str2) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f2666b;
        maxFullscreenAdImpl.logApiCall("setExtraParameter(key=" + str + ", value=" + str2 + ")");
        this.f2666b.setExtraParameter(str, str2);
    }

    public void setListener(MaxRewardedAdListener maxRewardedAdListener) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f2666b;
        maxFullscreenAdImpl.logApiCall("setListener(listener=" + maxRewardedAdListener + ")");
        this.f2666b.setListener(maxRewardedAdListener);
    }

    public void setLocalExtraParameter(String str, Object obj) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f2666b;
        maxFullscreenAdImpl.logApiCall("setLocalExtraParameter(key=" + str + ", value=" + obj + ")");
        this.f2666b.setLocalExtraParameter(str, obj);
    }

    public void setRevenueListener(MaxAdRevenueListener maxAdRevenueListener) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f2666b;
        maxFullscreenAdImpl.logApiCall("setRevenueListener(listener=" + maxAdRevenueListener + ")");
        this.f2666b.setRevenueListener(maxAdRevenueListener);
    }

    public void showAd() {
        showAd((String) null);
    }

    public void showAd(String str) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f2666b;
        maxFullscreenAdImpl.logApiCall("showAd(placement=" + str + ")");
        this.f2666b.showAd(str, getActivity());
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("");
        outline24.append(this.f2666b);
        return outline24.toString();
    }
}
