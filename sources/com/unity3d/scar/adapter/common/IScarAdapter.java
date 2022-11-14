package com.unity3d.scar.adapter.common;

import android.content.Context;
import com.unity3d.scar.adapter.common.scarads.ScarAdMetadata;

public interface IScarAdapter {
    void loadInterstitialAd(Context context, ScarAdMetadata scarAdMetadata, IScarInterstitialAdListenerWrapper iScarInterstitialAdListenerWrapper);

    void loadRewardedAd(Context context, ScarAdMetadata scarAdMetadata, IScarRewardedAdListenerWrapper iScarRewardedAdListenerWrapper);
}
