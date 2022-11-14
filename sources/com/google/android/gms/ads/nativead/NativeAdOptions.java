package com.google.android.gms.ads.nativead;

import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.ads.VideoOptions;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class NativeAdOptions {
    public static final int ADCHOICES_BOTTOM_LEFT = 3;
    public static final int ADCHOICES_BOTTOM_RIGHT = 2;
    public static final int ADCHOICES_TOP_LEFT = 0;
    public static final int ADCHOICES_TOP_RIGHT = 1;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_ANY = 1;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_LANDSCAPE = 2;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_PORTRAIT = 3;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_SQUARE = 4;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_UNKNOWN = 0;
    public final boolean zza;
    public final int zzb;
    public final boolean zzc;
    public final int zzd;
    public final VideoOptions zze;
    public final boolean zzf;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
    public @interface AdChoicesPlacement {
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
    public static final class Builder {
        public boolean zza = false;
        public int zzb = 0;
        public boolean zzc = false;
        public VideoOptions zzd;
        public int zze = 1;
        public boolean zzf = false;

        @RecentlyNonNull
        public NativeAdOptions build() {
            return new NativeAdOptions(this, (zza) null);
        }

        @RecentlyNonNull
        public Builder setAdChoicesPlacement(@AdChoicesPlacement int i) {
            this.zze = i;
            return this;
        }

        @RecentlyNonNull
        public Builder setMediaAspectRatio(@NativeMediaAspectRatio int i) {
            this.zzb = i;
            return this;
        }

        @RecentlyNonNull
        public Builder setRequestCustomMuteThisAd(boolean z) {
            this.zzf = z;
            return this;
        }

        @RecentlyNonNull
        public Builder setRequestMultipleImages(boolean z) {
            this.zzc = z;
            return this;
        }

        @RecentlyNonNull
        public Builder setReturnUrlsForImageAssets(boolean z) {
            this.zza = z;
            return this;
        }

        @RecentlyNonNull
        public Builder setVideoOptions(@RecentlyNonNull VideoOptions videoOptions) {
            this.zzd = videoOptions;
            return this;
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
    public @interface NativeMediaAspectRatio {
    }

    public /* synthetic */ NativeAdOptions(Builder builder, zza zza2) {
        this.zza = builder.zza;
        this.zzb = builder.zzb;
        this.zzc = builder.zzc;
        this.zzd = builder.zze;
        this.zze = builder.zzd;
        this.zzf = builder.zzf;
    }

    public int getAdChoicesPlacement() {
        return this.zzd;
    }

    public int getMediaAspectRatio() {
        return this.zzb;
    }

    @RecentlyNullable
    public VideoOptions getVideoOptions() {
        return this.zze;
    }

    public boolean shouldRequestMultipleImages() {
        return this.zzc;
    }

    public boolean shouldReturnUrlsForImageAssets() {
        return this.zza;
    }

    public final boolean zza() {
        return this.zzf;
    }
}
