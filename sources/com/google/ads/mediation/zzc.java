package com.google.ads.mediation;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzc extends InterstitialAdLoadCallback {
    @VisibleForTesting
    public final AbstractAdViewAdapter zza;
    @VisibleForTesting
    public final MediationInterstitialListener zzb;

    public zzc(AbstractAdViewAdapter abstractAdViewAdapter, MediationInterstitialListener mediationInterstitialListener) {
        this.zza = abstractAdViewAdapter;
        this.zzb = mediationInterstitialListener;
    }

    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        this.zzb.onAdFailedToLoad((MediationInterstitialAdapter) this.zza, (AdError) loadAdError);
    }

    public final /* bridge */ /* synthetic */ void onAdLoaded(Object obj) {
        InterstitialAd interstitialAd = (InterstitialAd) obj;
        AbstractAdViewAdapter abstractAdViewAdapter = this.zza;
        abstractAdViewAdapter.mInterstitialAd = interstitialAd;
        interstitialAd.setFullScreenContentCallback(new zzd(abstractAdViewAdapter, this.zzb));
        this.zzb.onAdLoaded(this.zza);
    }
}
