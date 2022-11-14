package com.google.android.gms.ads.formats;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepName;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public interface ShouldDelayBannerRenderingListener {
    @KeepName
    boolean shouldDelayBannerRendering(@RecentlyNonNull Runnable runnable);
}
