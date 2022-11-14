package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.formats.OnAdManagerAdViewLoadedListener;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbdf;
import com.google.android.gms.internal.ads.zzbdo;
import com.google.android.gms.internal.ads.zzbdp;
import com.google.android.gms.internal.ads.zzbev;
import com.google.android.gms.internal.ads.zzbfk;
import com.google.android.gms.internal.ads.zzbfn;
import com.google.android.gms.internal.ads.zzbhn;
import com.google.android.gms.internal.ads.zzbie;
import com.google.android.gms.internal.ads.zzbiv;
import com.google.android.gms.internal.ads.zzblw;
import com.google.android.gms.internal.ads.zzbom;
import com.google.android.gms.internal.ads.zzboo;
import com.google.android.gms.internal.ads.zzbop;
import com.google.android.gms.internal.ads.zzbve;
import com.google.android.gms.internal.ads.zzbyz;
import com.google.android.gms.internal.ads.zzbzb;
import com.google.android.gms.internal.ads.zzcgs;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public class AdLoader {
    public final zzbdo zza;
    public final Context zzb;
    public final zzbfk zzc;

    public AdLoader(Context context, zzbfk zzbfk, zzbdo zzbdo) {
        this.zzb = context;
        this.zzc = zzbfk;
        this.zza = zzbdo;
    }

    private final void zza(zzbhn zzbhn) {
        try {
            this.zzc.zze(this.zza.zza(this.zzb, zzbhn));
        } catch (RemoteException e) {
            zzcgs.zzg("Failed to load ad.", e);
        }
    }

    public boolean isLoading() {
        try {
            return this.zzc.zzg();
        } catch (RemoteException e) {
            zzcgs.zzj("Failed to check if ad is loading.", e);
            return false;
        }
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(@RecentlyNonNull AdRequest adRequest) {
        zza(adRequest.zza());
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAds(@RecentlyNonNull AdRequest adRequest, int i) {
        try {
            this.zzc.zzi(this.zza.zza(this.zzb, adRequest.zza()), i);
        } catch (RemoteException e) {
            zzcgs.zzg("Failed to load ads.", e);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
    public static class Builder {
        public final Context zza;
        public final zzbfn zzb;

        public Builder(@RecentlyNonNull Context context, @RecentlyNonNull String str) {
            zzbfn zzc = zzbev.zzb().zzc(context, str, new zzbve());
            this.zza = (Context) Preconditions.checkNotNull(context, "context cannot be null");
            this.zzb = zzc;
        }

        @RecentlyNonNull
        public AdLoader build() {
            try {
                return new AdLoader(this.zza, this.zzb.zze(), zzbdo.zza);
            } catch (RemoteException e) {
                zzcgs.zzg("Failed to build AdLoader.", e);
                return new AdLoader(this.zza, new zzbie().zzb(), zzbdo.zza);
            }
        }

        @RecentlyNonNull
        public Builder forAdManagerAdView(@RecentlyNonNull OnAdManagerAdViewLoadedListener onAdManagerAdViewLoadedListener, @RecentlyNonNull AdSize... adSizeArr) {
            if (adSizeArr == null || adSizeArr.length <= 0) {
                throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
            }
            try {
                this.zzb.zzk(new zzboo(onAdManagerAdViewLoadedListener), new zzbdp(this.zza, adSizeArr));
            } catch (RemoteException e) {
                zzcgs.zzj("Failed to add Google Ad Manager banner ad listener", e);
            }
            return this;
        }

        @RecentlyNonNull
        public Builder forCustomFormatAd(@RecentlyNonNull String str, @RecentlyNonNull NativeCustomFormatAd.OnCustomFormatAdLoadedListener onCustomFormatAdLoadedListener, @Nullable NativeCustomFormatAd.OnCustomClickListener onCustomClickListener) {
            zzbyz zzbyz = new zzbyz(onCustomFormatAdLoadedListener, onCustomClickListener);
            try {
                this.zzb.zzi(str, zzbyz.zza(), zzbyz.zzb());
            } catch (RemoteException e) {
                zzcgs.zzj("Failed to add custom format ad listener", e);
            }
            return this;
        }

        @RecentlyNonNull
        @Deprecated
        public Builder forCustomTemplateAd(@RecentlyNonNull String str, @RecentlyNonNull NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, @Nullable NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
            zzbom zzbom = new zzbom(onCustomTemplateAdLoadedListener, onCustomClickListener);
            try {
                this.zzb.zzi(str, zzbom.zza(), zzbom.zzb());
            } catch (RemoteException e) {
                zzcgs.zzj("Failed to add custom template ad listener", e);
            }
            return this;
        }

        @RecentlyNonNull
        public Builder forNativeAd(@RecentlyNonNull NativeAd.OnNativeAdLoadedListener onNativeAdLoadedListener) {
            try {
                this.zzb.zzm(new zzbzb(onNativeAdLoadedListener));
            } catch (RemoteException e) {
                zzcgs.zzj("Failed to add google native ad listener", e);
            }
            return this;
        }

        @RecentlyNonNull
        @Deprecated
        public Builder forUnifiedNativeAd(@RecentlyNonNull UnifiedNativeAd.OnUnifiedNativeAdLoadedListener onUnifiedNativeAdLoadedListener) {
            try {
                this.zzb.zzm(new zzbop(onUnifiedNativeAdLoadedListener));
            } catch (RemoteException e) {
                zzcgs.zzj("Failed to add google native ad listener", e);
            }
            return this;
        }

        @RecentlyNonNull
        public Builder withAdListener(@RecentlyNonNull AdListener adListener) {
            try {
                this.zzb.zzf(new zzbdf(adListener));
            } catch (RemoteException e) {
                zzcgs.zzj("Failed to set AdListener.", e);
            }
            return this;
        }

        @RecentlyNonNull
        public Builder withAdManagerAdViewOptions(@RecentlyNonNull AdManagerAdViewOptions adManagerAdViewOptions) {
            try {
                this.zzb.zzp(adManagerAdViewOptions);
            } catch (RemoteException e) {
                zzcgs.zzj("Failed to specify Ad Manager banner ad options", e);
            }
            return this;
        }

        @RecentlyNonNull
        @Deprecated
        public Builder withNativeAdOptions(@RecentlyNonNull NativeAdOptions nativeAdOptions) {
            try {
                this.zzb.zzj(new zzblw(nativeAdOptions));
            } catch (RemoteException e) {
                zzcgs.zzj("Failed to specify native ad options", e);
            }
            return this;
        }

        @RecentlyNonNull
        public Builder withNativeAdOptions(@RecentlyNonNull com.google.android.gms.ads.nativead.NativeAdOptions nativeAdOptions) {
            try {
                this.zzb.zzj(new zzblw(4, nativeAdOptions.shouldReturnUrlsForImageAssets(), -1, nativeAdOptions.shouldRequestMultipleImages(), nativeAdOptions.getAdChoicesPlacement(), nativeAdOptions.getVideoOptions() != null ? new zzbiv(nativeAdOptions.getVideoOptions()) : null, nativeAdOptions.zza(), nativeAdOptions.getMediaAspectRatio()));
            } catch (RemoteException e) {
                zzcgs.zzj("Failed to specify native ad options", e);
            }
            return this;
        }
    }

    public void loadAd(@RecentlyNonNull AdManagerAdRequest adManagerAdRequest) {
        zza(adManagerAdRequest.zza);
    }
}
