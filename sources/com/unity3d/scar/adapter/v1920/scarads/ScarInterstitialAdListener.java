package com.unity3d.scar.adapter.v1920.scarads;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.InterstitialAd;
import com.unity3d.scar.adapter.common.IScarInterstitialAdListenerWrapper;
import com.unity3d.scar.adapter.common.scarads.IScarLoadListener;

public class ScarInterstitialAdListener {
    public AdListener _adListener = new AdListener() {
        public void onAdClicked() {
            ScarInterstitialAdListener.this._adListenerWrapper.onAdClicked();
        }

        public void onAdClosed() {
            ScarInterstitialAdListener.this._adListenerWrapper.onAdClosed();
        }

        public void onAdLoaded() {
            ScarInterstitialAdListener.this._adListenerWrapper.onAdLoaded();
            IScarLoadListener iScarLoadListener = ScarInterstitialAdListener.this._loadListener;
            if (iScarLoadListener != null) {
                iScarLoadListener.onAdLoaded();
            }
        }

        public void onAdOpened() {
            ScarInterstitialAdListener.this._adListenerWrapper.onAdOpened();
        }
    };
    public IScarInterstitialAdListenerWrapper _adListenerWrapper;
    public IScarLoadListener _loadListener;

    public ScarInterstitialAdListener(InterstitialAd interstitialAd, IScarInterstitialAdListenerWrapper iScarInterstitialAdListenerWrapper) {
        this._adListenerWrapper = iScarInterstitialAdListenerWrapper;
    }
}
