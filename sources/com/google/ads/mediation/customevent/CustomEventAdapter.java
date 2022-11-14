package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import androidx.annotation.RecentlyNonNull;
import com.google.ads.AdRequest$ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzcgs;

@KeepName
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters> {
    @VisibleForTesting
    public CustomEventBanner zza;
    @VisibleForTesting
    public CustomEventInterstitial zzb;

    public static <T> T zzb(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            String message = th.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 46 + String.valueOf(message).length());
            sb.append("Could not instantiate custom event adapter: ");
            sb.append(str);
            sb.append(". ");
            sb.append(message);
            zzcgs.zzi(sb.toString());
            return null;
        }
    }

    public void destroy() {
        CustomEventBanner customEventBanner = this.zza;
        if (customEventBanner != null) {
            customEventBanner.destroy();
        }
        CustomEventInterstitial customEventInterstitial = this.zzb;
        if (customEventInterstitial != null) {
            customEventInterstitial.destroy();
        }
    }

    @RecentlyNonNull
    public Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    @RecentlyNonNull
    public View getBannerView() {
        return null;
    }

    @RecentlyNonNull
    public Class<CustomEventServerParameters> getServerParametersType() {
        return CustomEventServerParameters.class;
    }

    public void showInterstitial() {
        this.zzb.showInterstitial();
    }

    public void requestBannerAd(@RecentlyNonNull MediationBannerListener mediationBannerListener, @RecentlyNonNull Activity activity, @RecentlyNonNull CustomEventServerParameters customEventServerParameters, @RecentlyNonNull AdSize adSize, @RecentlyNonNull MediationAdRequest mediationAdRequest, @RecentlyNonNull CustomEventExtras customEventExtras) {
        Object obj;
        CustomEventBanner customEventBanner = (CustomEventBanner) zzb(customEventServerParameters.className);
        this.zza = customEventBanner;
        if (customEventBanner == null) {
            mediationBannerListener.onFailedToReceiveAd(this, AdRequest$ErrorCode.INTERNAL_ERROR);
            return;
        }
        if (customEventExtras == null) {
            obj = null;
        } else {
            obj = customEventExtras.getExtra(customEventServerParameters.label);
        }
        Activity activity2 = activity;
        this.zza.requestBannerAd(new zza(this, mediationBannerListener), activity2, customEventServerParameters.label, customEventServerParameters.parameter, adSize, mediationAdRequest, obj);
    }

    public void requestInterstitialAd(@RecentlyNonNull MediationInterstitialListener mediationInterstitialListener, @RecentlyNonNull Activity activity, @RecentlyNonNull CustomEventServerParameters customEventServerParameters, @RecentlyNonNull MediationAdRequest mediationAdRequest, @RecentlyNonNull CustomEventExtras customEventExtras) {
        Object obj;
        CustomEventInterstitial customEventInterstitial = (CustomEventInterstitial) zzb(customEventServerParameters.className);
        this.zzb = customEventInterstitial;
        if (customEventInterstitial == null) {
            mediationInterstitialListener.onFailedToReceiveAd(this, AdRequest$ErrorCode.INTERNAL_ERROR);
            return;
        }
        if (customEventExtras == null) {
            obj = null;
        } else {
            obj = customEventExtras.getExtra(customEventServerParameters.label);
        }
        Activity activity2 = activity;
        this.zzb.requestInterstitialAd(new zzb(this, this, mediationInterstitialListener), activity2, customEventServerParameters.label, customEventServerParameters.parameter, mediationAdRequest, obj);
    }
}
