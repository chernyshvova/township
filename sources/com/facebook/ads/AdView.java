package com.facebook.ads;

import android.content.Context;
import android.content.res.Configuration;
import android.widget.RelativeLayout;
import androidx.annotation.Keep;
import com.facebook.ads.C1513Ad;
import com.facebook.ads.internal.api.AdViewApi;
import com.facebook.ads.internal.api.AdViewParentApi;
import com.facebook.ads.internal.bench.Benchmark;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;

@Keep
public class AdView extends RelativeLayout implements C1513Ad {
    public final AdViewApi mAdViewApi;
    public final AdViewParentApi mAdViewParentApi = new AdViewParentApi() {
        @Benchmark
        public void onConfigurationChanged(Configuration configuration) {
            AdView.super.onConfigurationChanged(configuration);
        }
    };

    @Keep
    public interface AdViewLoadConfig extends C1513Ad.LoadAdConfig {
    }

    @Keep
    public interface AdViewLoadConfigBuilder extends C1513Ad.LoadConfigBuilder {
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        AdViewLoadConfig build();

        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        AdViewLoadConfigBuilder withAdListener(AdListener adListener);

        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        AdViewLoadConfigBuilder withBid(String str);
    }

    @Benchmark
    public AdView(Context context, String str, AdSize adSize) {
        super(context);
        this.mAdViewApi = DynamicLoaderFactory.makeLoader(context).createAdViewApi(context, str, adSize, this.mAdViewParentApi, this);
    }

    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public AdViewLoadConfigBuilder buildLoadAdConfig() {
        return this.mAdViewApi.buildLoadAdConfig();
    }

    public void destroy() {
        this.mAdViewApi.destroy();
    }

    public String getPlacementId() {
        return this.mAdViewApi.getPlacementId();
    }

    public boolean isAdInvalidated() {
        return this.mAdViewApi.isAdInvalidated();
    }

    @Benchmark
    public void loadAd() {
        this.mAdViewApi.loadAd();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.mAdViewApi.onConfigurationChanged(configuration);
    }

    @Deprecated
    public void setExtraHints(ExtraHints extraHints) {
        this.mAdViewApi.setExtraHints(extraHints);
    }

    @Benchmark
    public void loadAd(AdViewLoadConfig adViewLoadConfig) {
        this.mAdViewApi.loadAd(adViewLoadConfig);
    }

    @Benchmark
    public AdView(Context context, String str, String str2) throws Exception {
        super(context);
        this.mAdViewApi = DynamicLoaderFactory.makeLoader(context).createAdViewApi(context, str, str2, this.mAdViewParentApi, this);
    }
}
