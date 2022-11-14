package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public class zzbew extends AdListener {
    public final Object zza = new Object();
    public AdListener zzb;

    public final void onAdClosed() {
        synchronized (this.zza) {
            AdListener adListener = this.zzb;
            if (adListener != null) {
                adListener.onAdClosed();
            }
        }
    }

    public void onAdFailedToLoad(LoadAdError loadAdError) {
        synchronized (this.zza) {
            AdListener adListener = this.zzb;
            if (adListener != null) {
                adListener.onAdFailedToLoad(loadAdError);
            }
        }
    }

    public final void onAdImpression() {
        synchronized (this.zza) {
            AdListener adListener = this.zzb;
            if (adListener != null) {
                adListener.onAdImpression();
            }
        }
    }

    public void onAdLoaded() {
        synchronized (this.zza) {
            AdListener adListener = this.zzb;
            if (adListener != null) {
                adListener.onAdLoaded();
            }
        }
    }

    public final void onAdOpened() {
        synchronized (this.zza) {
            AdListener adListener = this.zzb;
            if (adListener != null) {
                adListener.onAdOpened();
            }
        }
    }

    public final void zza(AdListener adListener) {
        synchronized (this.zza) {
            this.zzb = adListener;
        }
    }
}
