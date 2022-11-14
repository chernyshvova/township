package com.unity3d.scar.adapter.v1920.scarads;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.unity3d.scar.adapter.common.GMAAdsError;
import com.unity3d.scar.adapter.common.IAdsErrorHandler;
import com.unity3d.scar.adapter.common.IScarRewardedAdListenerWrapper;
import com.unity3d.scar.adapter.common.scarads.IScarLoadListener;
import com.unity3d.scar.adapter.common.scarads.ScarAdMetadata;
import com.unity3d.scar.adapter.v1920.signals.QueryInfoMetadata;

public class ScarRewardedAd extends ScarAdBase {
    public RewardedAd _rewardedAd;
    public ScarRewardedAdListener _rewardedAdDelegate;

    public ScarRewardedAd(Context context, QueryInfoMetadata queryInfoMetadata, ScarAdMetadata scarAdMetadata, IAdsErrorHandler iAdsErrorHandler, IScarRewardedAdListenerWrapper iScarRewardedAdListenerWrapper) {
        super(context, scarAdMetadata, queryInfoMetadata, iAdsErrorHandler);
        RewardedAd rewardedAd = new RewardedAd(this._context, this._scarAdMetadata._adUnitId);
        this._rewardedAd = rewardedAd;
        this._rewardedAdDelegate = new ScarRewardedAdListener(rewardedAd, iScarRewardedAdListenerWrapper);
    }

    public void loadAdInternal(IScarLoadListener iScarLoadListener, AdRequest adRequest) {
        ScarRewardedAdListener scarRewardedAdListener = this._rewardedAdDelegate;
        if (scarRewardedAdListener != null) {
            this._rewardedAd.loadAd(adRequest, scarRewardedAdListener._rewardedAdLoadCallback);
            return;
        }
        throw null;
    }

    public void show(Activity activity) {
        if (this._rewardedAd.isLoaded()) {
            this._rewardedAd.show(activity, this._rewardedAdDelegate.rewardedAdCallback);
        } else {
            this._adsErrorHandler.handleError(GMAAdsError.InternalShowError(this._scarAdMetadata));
        }
    }
}
