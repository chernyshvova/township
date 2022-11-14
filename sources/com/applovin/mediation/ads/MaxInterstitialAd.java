package com.applovin.mediation.ads;

import android.app.Activity;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.mediation.ads.C0836a;
import com.applovin.impl.mediation.ads.MaxFullscreenAdImpl;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.WeakReference;

public class MaxInterstitialAd implements MaxFullscreenAdImpl.C0826a {

    /* renamed from: a */
    public static WeakReference<Activity> f2659a = new WeakReference<>((Object) null);

    /* renamed from: b */
    public final MaxFullscreenAdImpl f2660b;

    public MaxInterstitialAd(String str, Activity activity) {
        this(str, AppLovinSdk.getInstance(activity), activity);
    }

    public MaxInterstitialAd(String str, AppLovinSdk appLovinSdk, Activity activity) {
        C0836a.logApiCall("MaxInterstitialAd", "MaxInterstitialAd(adUnitId=" + str + ", sdk=" + appLovinSdk + ", activity=" + activity + ")");
        if (str == null) {
            throw new IllegalArgumentException("No ad unit ID specified");
        } else if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Empty ad unit ID specified");
        } else if (activity == null) {
            throw new IllegalArgumentException("No activity specified");
        } else if (appLovinSdk != null) {
            f2659a = new WeakReference<>(activity);
            this.f2660b = new MaxFullscreenAdImpl(str.trim(), MaxAdFormat.INTERSTITIAL, this, "MaxInterstitialAd", appLovinSdk.coreSdk);
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    public void destroy() {
        this.f2660b.logApiCall("destroy()");
        this.f2660b.destroy();
    }

    public Activity getActivity() {
        this.f2660b.logApiCall("getActivity()");
        return (Activity) f2659a.get();
    }

    public String getAdUnitId() {
        return this.f2660b.getAdUnitId();
    }

    public boolean isReady() {
        boolean isReady = this.f2660b.isReady();
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f2660b;
        maxFullscreenAdImpl.logApiCall("isReady() " + isReady + " for ad unit id " + this.f2660b.getAdUnitId());
        return isReady;
    }

    public void loadAd() {
        this.f2660b.logApiCall("loadAd()");
        this.f2660b.loadAd(getActivity());
    }

    public void setCustomPostbackData(String str) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f2660b;
        maxFullscreenAdImpl.logApiCall("setCustomPostbackData(value=" + str + ")");
        this.f2660b.setCustomPostbackData(str);
    }

    public void setExtraParameter(String str, String str2) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f2660b;
        maxFullscreenAdImpl.logApiCall("setExtraParameter(key=" + str + ", value=" + str2 + ")");
        this.f2660b.setExtraParameter(str, str2);
    }

    public void setListener(MaxAdListener maxAdListener) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f2660b;
        maxFullscreenAdImpl.logApiCall("setListener(listener=" + maxAdListener + ")");
        this.f2660b.setListener(maxAdListener);
    }

    public void setLocalExtraParameter(String str, Object obj) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f2660b;
        maxFullscreenAdImpl.logApiCall("setLocalExtraParameter(key=" + str + ", value=" + obj + ")");
        this.f2660b.setLocalExtraParameter(str, obj);
    }

    public void setRevenueListener(MaxAdRevenueListener maxAdRevenueListener) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f2660b;
        maxFullscreenAdImpl.logApiCall("setRevenueListener(listener=" + maxAdRevenueListener + ")");
        this.f2660b.setRevenueListener(maxAdRevenueListener);
    }

    public void showAd() {
        showAd((String) null);
    }

    public void showAd(ViewGroup viewGroup, Lifecycle lifecycle) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f2660b;
        maxFullscreenAdImpl.logApiCall("showAd(containerView=" + viewGroup + ", lifecycle=" + lifecycle + ")");
        this.f2660b.showAd(viewGroup, lifecycle, getActivity());
    }

    public void showAd(String str) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f2660b;
        maxFullscreenAdImpl.logApiCall("showAd(placement=" + str + ")");
        this.f2660b.showAd(str, getActivity());
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("");
        outline24.append(this.f2660b);
        return outline24.toString();
    }
}
