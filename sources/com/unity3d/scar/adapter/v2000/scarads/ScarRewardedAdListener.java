package com.unity3d.scar.adapter.v2000.scarads;

import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.unity3d.scar.adapter.common.IScarRewardedAdListenerWrapper;
import com.unity3d.scar.adapter.common.scarads.IScarLoadListener;

public class ScarRewardedAdListener extends ScarAdListener {
    public final IScarRewardedAdListenerWrapper _adListenerWrapper;
    public final RewardedAdLoadCallback _adLoadCallback = new RewardedAdLoadCallback() {
        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
            super.onAdFailedToLoad(loadAdError);
            ScarRewardedAdListener.this._adListenerWrapper.onRewardedAdFailedToLoad(loadAdError.getCode(), loadAdError.toString());
        }

        public void onAdLoaded(@NonNull Object obj) {
            T t = (RewardedAd) obj;
            super.onAdLoaded(t);
            ScarRewardedAdListener.this._adListenerWrapper.onRewardedAdLoaded();
            t.setFullScreenContentCallback(ScarRewardedAdListener.this._fullScreenContentCallback);
            ScarRewardedAdListener scarRewardedAdListener = ScarRewardedAdListener.this;
            scarRewardedAdListener._scarRewardedAd._adObj = t;
            IScarLoadListener iScarLoadListener = scarRewardedAdListener._loadListener;
            if (iScarLoadListener != null) {
                iScarLoadListener.onAdLoaded();
            }
        }
    };
    public final FullScreenContentCallback _fullScreenContentCallback = new FullScreenContentCallback() {
        public void onAdDismissedFullScreenContent() {
            super.onAdDismissedFullScreenContent();
            ScarRewardedAdListener.this._adListenerWrapper.onRewardedAdClosed();
        }

        public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
            super.onAdFailedToShowFullScreenContent(adError);
            ScarRewardedAdListener.this._adListenerWrapper.onRewardedAdFailedToShow(adError.getCode(), adError.toString());
        }

        public void onAdImpression() {
            super.onAdImpression();
            ScarRewardedAdListener.this._adListenerWrapper.onAdImpression();
        }

        public void onAdShowedFullScreenContent() {
            super.onAdShowedFullScreenContent();
            ScarRewardedAdListener.this._adListenerWrapper.onRewardedAdOpened();
        }
    };
    public final OnUserEarnedRewardListener _onUserEarnedRewardListener = new OnUserEarnedRewardListener() {
        public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
            ScarRewardedAdListener.this._adListenerWrapper.onUserEarnedReward();
        }
    };
    public final ScarRewardedAd _scarRewardedAd;

    public ScarRewardedAdListener(IScarRewardedAdListenerWrapper iScarRewardedAdListenerWrapper, ScarRewardedAd scarRewardedAd) {
        this._adListenerWrapper = iScarRewardedAdListenerWrapper;
        this._scarRewardedAd = scarRewardedAd;
    }
}
