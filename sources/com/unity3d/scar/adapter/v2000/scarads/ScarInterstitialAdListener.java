package com.unity3d.scar.adapter.v2000.scarads;

import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.unity3d.scar.adapter.common.IScarInterstitialAdListenerWrapper;
import com.unity3d.scar.adapter.common.scarads.IScarLoadListener;

public class ScarInterstitialAdListener extends ScarAdListener {
    public final IScarInterstitialAdListenerWrapper _adListenerWrapper;
    public final InterstitialAdLoadCallback _adLoadCallback = new InterstitialAdLoadCallback() {
        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
            super.onAdFailedToLoad(loadAdError);
            ScarInterstitialAdListener.this._adListenerWrapper.onAdFailedToLoad(loadAdError.getCode(), loadAdError.toString());
        }

        public void onAdLoaded(@NonNull Object obj) {
            T t = (InterstitialAd) obj;
            super.onAdLoaded(t);
            ScarInterstitialAdListener.this._adListenerWrapper.onAdLoaded();
            t.setFullScreenContentCallback(ScarInterstitialAdListener.this._fullScreenContentCallback);
            ScarInterstitialAdListener scarInterstitialAdListener = ScarInterstitialAdListener.this;
            scarInterstitialAdListener._scarInterstitialAd._adObj = t;
            IScarLoadListener iScarLoadListener = scarInterstitialAdListener._loadListener;
            if (iScarLoadListener != null) {
                iScarLoadListener.onAdLoaded();
            }
        }
    };
    public final FullScreenContentCallback _fullScreenContentCallback = new FullScreenContentCallback() {
        public void onAdDismissedFullScreenContent() {
            super.onAdDismissedFullScreenContent();
            ScarInterstitialAdListener.this._adListenerWrapper.onAdClosed();
        }

        public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
            super.onAdFailedToShowFullScreenContent(adError);
            ScarInterstitialAdListener.this._adListenerWrapper.onAdFailedToShow(adError.getCode(), adError.toString());
        }

        public void onAdImpression() {
            super.onAdImpression();
            ScarInterstitialAdListener.this._adListenerWrapper.onAdImpression();
        }

        public void onAdShowedFullScreenContent() {
            super.onAdShowedFullScreenContent();
            ScarInterstitialAdListener.this._adListenerWrapper.onAdOpened();
        }
    };
    public final ScarInterstitialAd _scarInterstitialAd;

    public ScarInterstitialAdListener(IScarInterstitialAdListenerWrapper iScarInterstitialAdListenerWrapper, ScarInterstitialAd scarInterstitialAd) {
        this._adListenerWrapper = iScarInterstitialAdListenerWrapper;
        this._scarInterstitialAd = scarInterstitialAd;
    }
}
