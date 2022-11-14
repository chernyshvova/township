package com.google.android.gms.ads.rewarded;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzcdc;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public abstract class RewardedAd {
    public static void load(@RecentlyNonNull Context context, @RecentlyNonNull String str, @RecentlyNonNull AdRequest adRequest, @RecentlyNonNull RewardedAdLoadCallback rewardedAdLoadCallback) {
        Preconditions.checkNotNull(context, "Context cannot be null.");
        Preconditions.checkNotNull(str, "AdUnitId cannot be null.");
        Preconditions.checkNotNull(adRequest, "AdRequest cannot be null.");
        Preconditions.checkNotNull(rewardedAdLoadCallback, "LoadCallback cannot be null.");
        new zzcdc(context, str).zza(adRequest.zza(), rewardedAdLoadCallback);
    }

    @RecentlyNonNull
    public abstract Bundle getAdMetadata();

    @NonNull
    public abstract String getAdUnitId();

    @RecentlyNullable
    public abstract FullScreenContentCallback getFullScreenContentCallback();

    @RecentlyNullable
    public abstract OnAdMetadataChangedListener getOnAdMetadataChangedListener();

    @RecentlyNullable
    public abstract OnPaidEventListener getOnPaidEventListener();

    @NonNull
    public abstract ResponseInfo getResponseInfo();

    @NonNull
    public abstract RewardItem getRewardItem();

    public abstract void setFullScreenContentCallback(@Nullable FullScreenContentCallback fullScreenContentCallback);

    public abstract void setImmersiveMode(boolean z);

    public abstract void setOnAdMetadataChangedListener(@Nullable OnAdMetadataChangedListener onAdMetadataChangedListener);

    public abstract void setOnPaidEventListener(@Nullable OnPaidEventListener onPaidEventListener);

    public abstract void setServerSideVerificationOptions(@Nullable ServerSideVerificationOptions serverSideVerificationOptions);

    public abstract void show(@RecentlyNonNull Activity activity, @RecentlyNonNull OnUserEarnedRewardListener onUserEarnedRewardListener);

    public static void load(@RecentlyNonNull Context context, @RecentlyNonNull String str, @RecentlyNonNull AdManagerAdRequest adManagerAdRequest, @RecentlyNonNull RewardedAdLoadCallback rewardedAdLoadCallback) {
        Preconditions.checkNotNull(context, "Context cannot be null.");
        Preconditions.checkNotNull(str, "AdUnitId cannot be null.");
        Preconditions.checkNotNull(adManagerAdRequest, "AdManagerAdRequest cannot be null.");
        Preconditions.checkNotNull(rewardedAdLoadCallback, "LoadCallback cannot be null.");
        new zzcdc(context, str).zza(adManagerAdRequest.zza(), rewardedAdLoadCallback);
    }
}
