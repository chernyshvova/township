package com.google.android.gms.ads;

import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public abstract class AdLoadCallback<AdT> {
    public void onAdFailedToLoad(@RecentlyNonNull LoadAdError loadAdError) {
    }

    public void onAdLoaded(@RecentlyNonNull AdT adt) {
    }
}
