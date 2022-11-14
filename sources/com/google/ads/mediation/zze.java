package com.google.ads.mediation;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zze extends AdListener implements UnifiedNativeAd.OnUnifiedNativeAdLoadedListener, NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener {
    @VisibleForTesting
    public final AbstractAdViewAdapter zza;
    @VisibleForTesting
    public final MediationNativeListener zzb;

    public zze(AbstractAdViewAdapter abstractAdViewAdapter, MediationNativeListener mediationNativeListener) {
        this.zza = abstractAdViewAdapter;
        this.zzb = mediationNativeListener;
    }

    public final void onAdClicked() {
        this.zzb.onAdClicked(this.zza);
    }

    public final void onAdClosed() {
        this.zzb.onAdClosed(this.zza);
    }

    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        this.zzb.onAdFailedToLoad((MediationNativeAdapter) this.zza, (AdError) loadAdError);
    }

    public final void onAdImpression() {
        this.zzb.onAdImpression(this.zza);
    }

    public final void onAdLoaded() {
    }

    public final void onAdOpened() {
        this.zzb.onAdOpened(this.zza);
    }

    public final void onCustomClick(NativeCustomTemplateAd nativeCustomTemplateAd, String str) {
        this.zzb.zzc(this.zza, nativeCustomTemplateAd, str);
    }

    public final void onCustomTemplateAdLoaded(NativeCustomTemplateAd nativeCustomTemplateAd) {
        this.zzb.zzb(this.zza, nativeCustomTemplateAd);
    }

    public final void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
        this.zzb.onAdLoaded(this.zza, new zza(unifiedNativeAd));
    }
}
