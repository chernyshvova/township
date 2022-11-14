package com.facebook.ads;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.UiThread;
import com.facebook.ads.C1513Ad;
import com.facebook.ads.FullScreenAd;
import com.facebook.ads.internal.api.RewardedInterstitialAdApi;
import com.facebook.ads.internal.bench.Benchmark;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;

@UiThread
@Keep
public class RewardedInterstitialAd implements FullScreenAd {
    public static final int UNSET_VIDEO_DURATION = -1;
    public final RewardedInterstitialAdApi mRewardedInterstitialAdApi;

    @Keep
    public interface RewardedInterstitialAdLoadConfigBuilder extends C1513Ad.LoadConfigBuilder {
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        RewardedInterstitialLoadAdConfig build();

        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        RewardedInterstitialAdLoadConfigBuilder withAdListener(RewardedInterstitialAdListener rewardedInterstitialAdListener);

        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        RewardedInterstitialAdLoadConfigBuilder withBid(String str);

        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        RewardedInterstitialAdLoadConfigBuilder withFailOnCacheFailureEnabled(boolean z);

        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        RewardedInterstitialAdLoadConfigBuilder withRewardData(RewardData rewardData);
    }

    @Keep
    public interface RewardedInterstitialAdShowConfigBuilder extends FullScreenAd.ShowConfigBuilder {
        RewardedInterstitialShowAdConfig build();

        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        RewardedInterstitialAdShowConfigBuilder withAppOrientation(int i);
    }

    @Keep
    public interface RewardedInterstitialLoadAdConfig extends C1513Ad.LoadAdConfig {
    }

    @Keep
    public interface RewardedInterstitialShowAdConfig extends FullScreenAd.ShowAdConfig {
    }

    @Benchmark
    public RewardedInterstitialAd(Context context, String str) {
        this.mRewardedInterstitialAdApi = DynamicLoaderFactory.makeLoader(context).createRewardedInterstitialAd(context, str, this);
    }

    public void destroy() {
        this.mRewardedInterstitialAdApi.destroy();
    }

    public String getPlacementId() {
        return this.mRewardedInterstitialAdApi.getPlacementId();
    }

    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public int getVideoDuration() {
        return this.mRewardedInterstitialAdApi.getVideoDuration();
    }

    public boolean isAdInvalidated() {
        return this.mRewardedInterstitialAdApi.isAdInvalidated();
    }

    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public boolean isAdLoaded() {
        return this.mRewardedInterstitialAdApi.isAdLoaded();
    }

    public void loadAd() {
        this.mRewardedInterstitialAdApi.loadAd();
    }

    @SuppressLint({"DeprecatedMethod"})
    @Deprecated
    public void setExtraHints(ExtraHints extraHints) {
        this.mRewardedInterstitialAdApi.setExtraHints(extraHints);
    }

    public boolean show() {
        return this.mRewardedInterstitialAdApi.show();
    }

    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public RewardedInterstitialAdLoadConfigBuilder buildLoadAdConfig() {
        return this.mRewardedInterstitialAdApi.buildLoadAdConfig();
    }

    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public RewardedInterstitialAdShowConfigBuilder buildShowAdConfig() {
        return this.mRewardedInterstitialAdApi.buildShowAdConfig();
    }

    @Benchmark
    public void loadAd(RewardedInterstitialLoadAdConfig rewardedInterstitialLoadAdConfig) {
        this.mRewardedInterstitialAdApi.loadAd(rewardedInterstitialLoadAdConfig);
    }

    @Benchmark
    public boolean show(RewardedInterstitialShowAdConfig rewardedInterstitialShowAdConfig) {
        return this.mRewardedInterstitialAdApi.show(rewardedInterstitialShowAdConfig);
    }
}
