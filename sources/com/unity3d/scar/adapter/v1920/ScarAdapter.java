package com.unity3d.scar.adapter.v1920;

import android.content.Context;
import com.android.billingclient.api.zzam;
import com.unity3d.scar.adapter.common.IAdsErrorHandler;
import com.unity3d.scar.adapter.common.IScarAdapter;
import com.unity3d.scar.adapter.common.IScarInterstitialAdListenerWrapper;
import com.unity3d.scar.adapter.common.IScarRewardedAdListenerWrapper;
import com.unity3d.scar.adapter.common.ScarAdapterBase;
import com.unity3d.scar.adapter.common.scarads.IScarLoadListener;
import com.unity3d.scar.adapter.common.scarads.ScarAdMetadata;
import com.unity3d.scar.adapter.v1920.scarads.ScarInterstitialAd;
import com.unity3d.scar.adapter.v1920.scarads.ScarRewardedAd;
import com.unity3d.scar.adapter.v1920.signals.SignalsReader;
import com.unity3d.scar.adapter.v1920.signals.SignalsStorage;

public class ScarAdapter extends ScarAdapterBase implements IScarAdapter {
    public SignalsStorage _scarSignalStorage;

    public ScarAdapter(IAdsErrorHandler iAdsErrorHandler) {
        super(iAdsErrorHandler);
        SignalsStorage signalsStorage = new SignalsStorage();
        this._scarSignalStorage = signalsStorage;
        this._scarSignalReader = new SignalsReader(signalsStorage);
    }

    public void loadInterstitialAd(Context context, final ScarAdMetadata scarAdMetadata, IScarInterstitialAdListenerWrapper iScarInterstitialAdListenerWrapper) {
        SignalsStorage signalsStorage = this._scarSignalStorage;
        Context context2 = context;
        ScarAdMetadata scarAdMetadata2 = scarAdMetadata;
        final ScarInterstitialAd scarInterstitialAd = new ScarInterstitialAd(context2, signalsStorage._placementQueryInfoMap.get(scarAdMetadata._placementId), scarAdMetadata2, this._adsErrorHandler, iScarInterstitialAdListenerWrapper);
        zzam.runOnUiThread(new Runnable() {
            public void run() {
                scarInterstitialAd.loadAd(new IScarLoadListener() {
                    public void onAdLoaded() {
                        C17171 r0 = C17171.this;
                        ScarAdapter.this._loadedAds.put(scarAdMetadata._placementId, scarInterstitialAd);
                    }
                });
            }
        });
    }

    public void loadRewardedAd(Context context, final ScarAdMetadata scarAdMetadata, IScarRewardedAdListenerWrapper iScarRewardedAdListenerWrapper) {
        SignalsStorage signalsStorage = this._scarSignalStorage;
        Context context2 = context;
        ScarAdMetadata scarAdMetadata2 = scarAdMetadata;
        final ScarRewardedAd scarRewardedAd = new ScarRewardedAd(context2, signalsStorage._placementQueryInfoMap.get(scarAdMetadata._placementId), scarAdMetadata2, this._adsErrorHandler, iScarRewardedAdListenerWrapper);
        zzam.runOnUiThread(new Runnable() {
            public void run() {
                scarRewardedAd.loadAd(new IScarLoadListener() {
                    public void onAdLoaded() {
                        C17192 r0 = C17192.this;
                        ScarAdapter.this._loadedAds.put(scarAdMetadata._placementId, scarRewardedAd);
                    }
                });
            }
        });
    }
}
