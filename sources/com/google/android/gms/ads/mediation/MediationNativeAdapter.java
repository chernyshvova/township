package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public interface MediationNativeAdapter extends MediationAdapter {
    void requestNativeAd(@RecentlyNonNull Context context, @RecentlyNonNull MediationNativeListener mediationNativeListener, @RecentlyNonNull Bundle bundle, @RecentlyNonNull NativeMediationAdRequest nativeMediationAdRequest, @Nullable Bundle bundle2);
}
