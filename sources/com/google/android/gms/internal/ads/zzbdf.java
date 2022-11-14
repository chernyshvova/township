package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbdf extends zzbfd {
    public final AdListener zza;

    public zzbdf(AdListener adListener) {
        this.zza = adListener;
    }

    public final void zzb() {
        AdListener adListener = this.zza;
        if (adListener != null) {
            adListener.onAdClosed();
        }
    }

    public final void zzc(int i) {
    }

    public final void zzd(zzbdd zzbdd) {
        AdListener adListener = this.zza;
        if (adListener != null) {
            adListener.onAdFailedToLoad(zzbdd.zzb());
        }
    }

    public final void zze() {
    }

    public final void zzf() {
        AdListener adListener = this.zza;
        if (adListener != null) {
            adListener.onAdLoaded();
        }
    }

    public final void zzg() {
        AdListener adListener = this.zza;
        if (adListener != null) {
            adListener.onAdOpened();
        }
    }

    public final void zzh() {
        AdListener adListener = this.zza;
        if (adListener != null) {
            adListener.onAdClicked();
        }
    }

    public final void zzi() {
        AdListener adListener = this.zza;
        if (adListener != null) {
            adListener.onAdImpression();
        }
    }

    public final AdListener zzj() {
        return this.zza;
    }
}
