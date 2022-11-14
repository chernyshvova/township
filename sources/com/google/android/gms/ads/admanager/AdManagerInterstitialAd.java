package com.google.android.gms.ads.admanager;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbsi;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public abstract class AdManagerInterstitialAd extends InterstitialAd {
    public static void load(@RecentlyNonNull Context context, @RecentlyNonNull String str, @RecentlyNonNull AdManagerAdRequest adManagerAdRequest, @RecentlyNonNull AdManagerInterstitialAdLoadCallback adManagerInterstitialAdLoadCallback) {
        Preconditions.checkNotNull(context, "Context cannot be null.");
        Preconditions.checkNotNull(str, "AdUnitId cannot be null.");
        Preconditions.checkNotNull(adManagerAdRequest, "AdManagerAdRequest cannot be null.");
        Preconditions.checkNotNull(adManagerInterstitialAdLoadCallback, "LoadCallback cannot be null.");
        new zzbsi(context, str).zza(adManagerAdRequest.zza(), adManagerInterstitialAdLoadCallback);
    }

    @RecentlyNullable
    public abstract AppEventListener getAppEventListener();

    public abstract void setAppEventListener(@Nullable AppEventListener appEventListener);
}
