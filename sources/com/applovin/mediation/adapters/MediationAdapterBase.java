package com.applovin.mediation.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.mediation.MaxRewardImpl;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.MaxInterstitialAdViewAdapter;
import com.applovin.mediation.adapter.MaxNativeAdAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdViewAdapter;
import com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.sdk.AppLovinEventParameters;
import com.applovin.sdk.AppLovinSdk;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public abstract class MediationAdapterBase implements MaxAdapter, MaxInterstitialAdViewAdapter, MaxNativeAdAdapter, MaxRewardedAdViewAdapter {
    public boolean alwaysRewardUser;
    public final C1314v mLogger;
    public final C1188m mSdk;
    public final String mTag = getClass().getSimpleName();
    public final AppLovinSdk mWrappingSdk;
    public MaxReward reward;

    public MediationAdapterBase(AppLovinSdk appLovinSdk) {
        this.mWrappingSdk = appLovinSdk;
        C1188m mVar = appLovinSdk.coreSdk;
        this.mSdk = mVar;
        this.mLogger = mVar.mo10922B();
    }

    public static String mediationTag() {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("AppLovinSdk_");
        outline24.append(AppLovinSdk.VERSION);
        return outline24.toString();
    }

    public void checkActivities(Context context, Class<?>... clsArr) {
    }

    public void checkExistence(Class<?>... clsArr) {
        if (clsArr != null && clsArr.length > 0) {
            for (Class<?> name : clsArr) {
                StringBuilder outline24 = GeneratedOutlineSupport.outline24("Found: ");
                outline24.append(name.getName());
                log(outline24.toString());
            }
        }
    }

    public void configureReward(MaxAdapterResponseParameters maxAdapterResponseParameters) {
        Bundle serverParameters = maxAdapterResponseParameters.getServerParameters();
        this.alwaysRewardUser = BundleUtils.getBoolean("always_reward_user", maxAdapterResponseParameters.isTesting(), serverParameters);
        int i = BundleUtils.getInt(AppLovinEventParameters.REVENUE_AMOUNT, 0, serverParameters);
        String string = BundleUtils.getString("currency", "", serverParameters);
        log("Creating reward: " + i + " " + string);
        this.reward = MaxRewardImpl.create(i, string);
    }

    public Future<Drawable> createDrawableFuture(final String str, final Resources resources) {
        return getCachingExecutorService().submit(new Callable<Drawable>() {
            public Drawable call() throws Exception {
                InputStream openStream = new URL(str).openStream();
                BitmapDrawable bitmapDrawable = new BitmapDrawable(resources, BitmapFactory.decodeStream(openStream));
                openStream.close();
                return bitmapDrawable;
            }
        });
    }

    /* renamed from: d */
    public void mo11468d(String str) {
        this.mLogger.mo11372b(this.mTag, str);
    }

    /* renamed from: e */
    public void mo11469e(String str) {
        this.mLogger.mo11376e(this.mTag, str);
    }

    /* renamed from: e */
    public void mo11470e(String str, Throwable th) {
        this.mLogger.mo11373b(this.mTag, str, th);
    }

    public Context getApplicationContext() {
        return this.mSdk.mo10932L();
    }

    public ExecutorService getCachingExecutorService() {
        return this.mSdk.mo10938S().mo10834c();
    }

    public MaxReward getReward() {
        MaxReward maxReward = this.reward;
        return maxReward != null ? maxReward : MaxRewardImpl.createDefault();
    }

    public String getVersionString(Class cls, String str) {
        String string = Utils.getString(cls, str);
        if (string == null) {
            log("Failed to retrieve version string.");
        }
        return string;
    }

    public AppLovinSdk getWrappingSdk() {
        return this.mWrappingSdk;
    }

    /* renamed from: i */
    public void mo11476i(String str) {
        this.mLogger.mo11374c(this.mTag, str);
    }

    public boolean isBeta() {
        return false;
    }

    public void loadNativeAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxNativeAdAdapterListener maxNativeAdAdapterListener) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("This adapter (");
        outline24.append(getAdapterVersion());
        outline24.append(") does not support native ads.");
        mo11468d(outline24.toString());
        maxNativeAdAdapterListener.onNativeAdLoadFailed(MaxAdapterError.INVALID_CONFIGURATION);
    }

    public void log(String str) {
        this.mLogger.mo11374c(this.mTag, str);
    }

    public void log(String str, Throwable th) {
        this.mLogger.mo11373b(this.mTag, str, th);
    }

    public boolean shouldAlwaysRewardUser() {
        return this.alwaysRewardUser;
    }

    public void showInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, ViewGroup viewGroup, Lifecycle lifecycle, Activity activity, MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("This adapter (");
        outline24.append(getAdapterVersion());
        outline24.append(") does not support interstitial ad view ads.");
        mo11468d(outline24.toString());
        maxInterstitialAdapterListener.onInterstitialAdDisplayFailed(MaxAdapterError.INVALID_CONFIGURATION);
    }

    public void showRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, ViewGroup viewGroup, Lifecycle lifecycle, Activity activity, MaxRewardedAdapterListener maxRewardedAdapterListener) {
        StringBuilder outline24 = GeneratedOutlineSupport.outline24("This adapter (");
        outline24.append(getAdapterVersion());
        outline24.append(") does not support rewarded ad view ads.");
        mo11468d(outline24.toString());
        maxRewardedAdapterListener.onRewardedAdDisplayFailed(MaxAdapterError.INVALID_CONFIGURATION);
    }

    public void userError(String str) {
        userError(str, (Throwable) null);
    }

    public void userError(String str, Throwable th) {
        C1314v.m2659c(this.mTag, str, th);
    }

    /* renamed from: w */
    public void mo11482w(String str) {
        this.mLogger.mo11375d(this.mTag, str);
    }
}
