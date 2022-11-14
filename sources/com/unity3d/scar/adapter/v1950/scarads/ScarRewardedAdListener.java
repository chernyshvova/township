package com.unity3d.scar.adapter.v1950.scarads;

import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.unity3d.scar.adapter.common.IScarRewardedAdListenerWrapper;

public class ScarRewardedAdListener {
    public RewardedAdLoadCallback _rewardedAdLoadCallback = new RewardedAdLoadCallback(this) {
    };
    public RewardedAdCallback rewardedAdCallback = new RewardedAdCallback(this) {
    };

    public ScarRewardedAdListener(RewardedAd rewardedAd, IScarRewardedAdListenerWrapper iScarRewardedAdListenerWrapper) {
    }
}
