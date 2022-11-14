package com.google.ads.mediation.customevent;

import android.app.Activity;
import androidx.annotation.RecentlyNonNull;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public interface CustomEventBanner {
    /* synthetic */ void destroy();

    void requestBannerAd(@RecentlyNonNull CustomEventBannerListener customEventBannerListener, @RecentlyNonNull Activity activity, @RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull AdSize adSize, @RecentlyNonNull MediationAdRequest mediationAdRequest, @RecentlyNonNull Object obj);
}
