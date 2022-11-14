package com.google.ads.mediation;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbcz;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzb extends AdListener implements AppEventListener, zzbcz {
    @VisibleForTesting
    public final AbstractAdViewAdapter zza;
    @VisibleForTesting
    public final MediationBannerListener zzb;

    public zzb(AbstractAdViewAdapter abstractAdViewAdapter, MediationBannerListener mediationBannerListener) {
        this.zza = abstractAdViewAdapter;
        this.zzb = mediationBannerListener;
    }

    public final void onAdClicked() {
        this.zzb.onAdClicked(this.zza);
    }

    public final void onAdClosed() {
        this.zzb.onAdClosed(this.zza);
    }

    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        this.zzb.onAdFailedToLoad((MediationBannerAdapter) this.zza, (AdError) loadAdError);
    }

    public final void onAdLoaded() {
        this.zzb.onAdLoaded(this.zza);
    }

    public final void onAdOpened() {
        this.zzb.onAdOpened(this.zza);
    }

    public final void onAppEvent(String str, String str2) {
        this.zzb.zza(this.zza, str, str2);
    }
}
