package com.google.android.gms.ads.mediation;

import androidx.annotation.NonNull;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.ads.formats.NativeAdOptions;
import java.util.Map;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public interface NativeMediationAdRequest extends MediationAdRequest {
    float getAdVolume();

    @RecentlyNonNull
    @Deprecated
    NativeAdOptions getNativeAdOptions();

    @NonNull
    com.google.android.gms.ads.nativead.NativeAdOptions getNativeAdRequestOptions();

    boolean isAdMuted();

    boolean isUnifiedNativeAdRequested();

    boolean zza();

    @RecentlyNonNull
    Map<String, Boolean> zzb();
}
