package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.appopen.AppOpenAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzaxn extends zzaxu {
    @Nullable
    public final AppOpenAd.AppOpenAdLoadCallback zza;
    public final String zzb;

    public zzaxn(AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback, String str) {
        this.zza = appOpenAdLoadCallback;
        this.zzb = str;
    }

    public final void zzb(zzaxs zzaxs) {
        if (this.zza != null) {
            this.zza.onAdLoaded(new zzaxo(zzaxs, this.zzb));
        }
    }

    public final void zzc(int i) {
    }

    public final void zzd(zzbdd zzbdd) {
        if (this.zza != null) {
            this.zza.onAdFailedToLoad(zzbdd.zzb());
        }
    }
}
