package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public interface CustomEventNative extends CustomEvent {
    void requestNativeAd(@RecentlyNonNull Context context, @RecentlyNonNull CustomEventNativeListener customEventNativeListener, @Nullable String str, @RecentlyNonNull NativeMediationAdRequest nativeMediationAdRequest, @Nullable Bundle bundle);
}
