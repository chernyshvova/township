package com.facebook.ads.internal.api;

import android.content.res.Configuration;
import androidx.annotation.Keep;
import androidx.annotation.UiThread;
import com.facebook.ads.AdView;
import com.facebook.ads.C1513Ad;
import com.facebook.ads.ExtraHints;
import com.facebook.proguard.annotations.DoNotStripAny;

@UiThread
@DoNotStripAny
@Keep
public interface AdViewApi extends AdViewParentApi, C1513Ad {
    AdView.AdViewLoadConfigBuilder buildLoadAdConfig();

    void loadAd(AdView.AdViewLoadConfig adViewLoadConfig);

    void onConfigurationChanged(Configuration configuration);

    @Deprecated
    void setExtraHints(ExtraHints extraHints);
}
