package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzcdg extends zzccz {
    public final RewardedAdLoadCallback zza;
    public final RewardedAd zzb;

    public zzcdg(RewardedAdLoadCallback rewardedAdLoadCallback, RewardedAd rewardedAd) {
        this.zza = rewardedAdLoadCallback;
        this.zzb = rewardedAd;
    }

    public final void zze() {
        RewardedAdLoadCallback rewardedAdLoadCallback = this.zza;
        if (rewardedAdLoadCallback != null) {
            rewardedAdLoadCallback.onAdLoaded(this.zzb);
        }
    }

    public final void zzf(int i) {
    }

    public final void zzg(zzbdd zzbdd) {
        if (this.zza != null) {
            this.zza.onAdFailedToLoad(zzbdd.zzb());
        }
    }
}
