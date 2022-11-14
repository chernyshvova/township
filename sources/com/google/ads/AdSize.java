package com.google.ads;

import androidx.annotation.RecentlyNonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import com.unity3d.services.banners.UnityBannerSize;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class AdSize {
    @RecentlyNonNull
    public static final AdSize BANNER = new AdSize(UnityBannerSize.BannerSize.STANDARD_WIDTH, 50, "mb");
    @RecentlyNonNull
    public static final AdSize IAB_BANNER = new AdSize(UnityBannerSize.BannerSize.IAB_STANDARD_WIDTH, 60, "as");
    @RecentlyNonNull
    public static final AdSize IAB_LEADERBOARD = new AdSize(UnityBannerSize.BannerSize.LEADERBOARD_WIDTH, 90, "as");
    @RecentlyNonNull
    public static final AdSize IAB_MRECT = new AdSize(300, 250, "as");
    @RecentlyNonNull
    public static final AdSize IAB_WIDE_SKYSCRAPER = new AdSize(DrawerLayout.PEEK_DELAY, 600, "as");
    @RecentlyNonNull
    public static final AdSize SMART_BANNER = new AdSize(-1, -2, "mb");
    public final com.google.android.gms.ads.AdSize zza;

    public AdSize(int i, int i2, String str) {
        this.zza = new com.google.android.gms.ads.AdSize(i, i2);
    }

    public AdSize(@RecentlyNonNull com.google.android.gms.ads.AdSize adSize) {
        this.zza = adSize;
    }

    public boolean equals(@RecentlyNonNull Object obj) {
        if (!(obj instanceof AdSize)) {
            return false;
        }
        return this.zza.equals(((AdSize) obj).zza);
    }

    public int hashCode() {
        return this.zza.hashCode();
    }

    @RecentlyNonNull
    public String toString() {
        return this.zza.toString();
    }
}
