package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzcdm extends zzccz {
    public final RewardedInterstitialAdLoadCallback zza;
    public final zzcdn zzb;

    public zzcdm(RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback, zzcdn zzcdn) {
        this.zza = rewardedInterstitialAdLoadCallback;
        this.zzb = zzcdn;
    }

    public final void zze() {
        zzcdn zzcdn;
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zza;
        if (rewardedInterstitialAdLoadCallback != null && (zzcdn = this.zzb) != null) {
            rewardedInterstitialAdLoadCallback.onAdLoaded(zzcdn);
        }
    }

    public final void zzf(int i) {
    }

    public final void zzg(zzbdd zzbdd) {
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zza;
        if (rewardedInterstitialAdLoadCallback != null) {
            rewardedInterstitialAdLoadCallback.onAdFailedToLoad(zzbdd.zzb());
        }
    }
}
