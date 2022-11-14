package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.ads.AdSize;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public interface MediationBannerAdapter extends MediationAdapter {
    @RecentlyNonNull
    View getBannerView();

    void requestBannerAd(@RecentlyNonNull Context context, @RecentlyNonNull MediationBannerListener mediationBannerListener, @RecentlyNonNull Bundle bundle, @RecentlyNonNull AdSize adSize, @RecentlyNonNull MediationAdRequest mediationAdRequest, @Nullable Bundle bundle2);
}
