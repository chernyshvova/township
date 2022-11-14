package com.google.android.gms.ads.rewarded;

import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public interface RewardItem {
    @RecentlyNonNull
    public static final RewardItem DEFAULT_REWARD = new zza();

    int getAmount();

    @RecentlyNonNull
    String getType();
}
