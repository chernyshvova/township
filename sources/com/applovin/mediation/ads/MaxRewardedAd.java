package com.applovin.mediation.ads;

import android.app.Activity;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.mediation.ads.C0836a;
import com.applovin.impl.mediation.ads.MaxFullscreenAdImpl;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class MaxRewardedAd implements MaxFullscreenAdImpl.C0826a {

    /* renamed from: a */
    public static final Map<String, MaxRewardedAd> f2661a = new HashMap();

    /* renamed from: b */
    public static final Object f2662b = new Object();

    /* renamed from: c */
    public static WeakReference<Activity> f2663c = new WeakReference<>((Object) null);

    /* renamed from: d */
    public final MaxFullscreenAdImpl f2664d;

    public MaxRewardedAd(String str, AppLovinSdk appLovinSdk) {
        this.f2664d = new MaxFullscreenAdImpl(str.trim(), MaxAdFormat.REWARDED, this, "MaxRewardedAd", appLovinSdk.coreSdk);
    }

    public static MaxRewardedAd getInstance(String str, Activity activity) {
        return getInstance(str, AppLovinSdk.getInstance(activity), activity);
    }

    public static MaxRewardedAd getInstance(String str, AppLovinSdk appLovinSdk, Activity activity) {
        C0836a.logApiCall("MaxRewardedAd", "getInstance(adUnitId=" + str + ", sdk=" + appLovinSdk + ", activity=" + activity + ")");
        if (str == null) {
            throw new IllegalArgumentException("No ad unit ID specified");
        } else if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Empty ad unit ID specified");
        } else if (activity == null) {
            throw new IllegalArgumentException("No activity specified");
        } else if (appLovinSdk != null) {
            updateActivity(activity);
            synchronized (f2662b) {
                MaxRewardedAd maxRewardedAd = f2661a.get(str);
                if (maxRewardedAd != null) {
                    return maxRewardedAd;
                }
                MaxRewardedAd maxRewardedAd2 = new MaxRewardedAd(str, appLovinSdk);
                f2661a.put(str, maxRewardedAd2);
                return maxRewardedAd2;
            }
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    public static void updateActivity(Activity activity) {
        C0836a.logApiCall("MaxRewardedAd", "updateActivity(activity=" + activity + ")");
        if (activity != null) {
            f2663c = new WeakReference<>(activity);
        }
    }

    public void destroy() {
        this.f2664d.logApiCall("destroy()");
        synchronized (f2662b) {
            f2661a.remove(this.f2664d.getAdUnitId());
        }
        this.f2664d.destroy();
    }

    public Activity getActivity() {
        this.f2664d.logApiCall("getActivity()");
        return (Activity) f2663c.get();
    }

    public String getAdUnitId() {
        return this.f2664d.getAdUnitId();
    }

    public boolean isReady() {
        boolean isReady = this.f2664d.isReady();
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f2664d;
        maxFullscreenAdImpl.logApiCall("isReady() " + isReady + " for ad unit id " + this.f2664d.getAdUnitId());
        return isReady;
    }

    public void loadAd() {
        this.f2664d.logApiCall("loadAd()");
        this.f2664d.loadAd(getActivity());
    }

    public void setCustomPostbackData(String str) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f2664d;
        maxFullscreenAdImpl.logApiCall("setCustomPostbackData(value=" + str + ")");
        this.f2664d.setCustomPostbackData(str);
    }

    public void setExtraParameter(String str, String str2) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f2664d;
        maxFullscreenAdImpl.logApiCall("setExtraParameter(key=" + str + ", value=" + str2 + ")");
        this.f2664d.setExtraParameter(str, str2);
    }

    public void setListener(MaxRewardedAdListener maxRewardedAdListener) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f2664d;
        maxFullscreenAdImpl.logApiCall("setListener(listener=" + maxRewardedAdListener + ")");
        this.f2664d.setListener(maxRewardedAdListener);
    }

    public void setLocalExtraParameter(String str, Object obj) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f2664d;
        maxFullscreenAdImpl.logApiCall("setLocalExtraParameter(key=" + str + ", value=" + obj + ")");
        this.f2664d.setLocalExtraParameter(str, obj);
    }

    public void setRevenueListener(MaxAdRevenueListener maxAdRevenueListener) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f2664d;
        maxFullscreenAdImpl.logApiCall("setRevenueListener(listener=" + maxAdRevenueListener + ")");
        this.f2664d.setRevenueListener(maxAdRevenueListener);
    }

    public void showAd() {
        showAd((String) null);
    }

    public void showAd(ViewGroup viewGroup, Lifecycle lifecycle) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f2664d;
        maxFullscreenAdImpl.logApiCall("showAd(containerView=" + viewGroup + ", lifecycle=" + lifecycle + ")");
        this.f2664d.showAd(viewGroup, lifecycle, getActivity());
    }

    public void showAd(String str) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.f2664d;
        maxFullscreenAdImpl.logApiCall("showAd(placement=" + str + ")");
        this.f2664d.showAd(str, getActivity());
    }

    public String toString() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("");
        outline24.append(this.f2664d);
        return outline24.toString();
    }
}
