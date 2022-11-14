package com.google.android.gms.ads.formats;

import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.ads.VideoOptions;

@Deprecated
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
    @Deprecated
    public static final int ORIENTATION_ANY = 0;
    @Deprecated
    public static final int ORIENTATION_LANDSCAPE = 2;
    @Deprecated
    public static final int ORIENTATION_PORTRAIT = 1;
    public final boolean zza;
    public final int zzb;
    public final int zzc;
    public final boolean zzd;
    public final int zze;
    public final VideoOptions zzf;
    public final boolean zzg;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
    public @interface AdChoicesPlacement {
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
    public static final class Builder {
        public boolean zza = false;
        public int zzb = -1;
        public int zzc = 0;
        public boolean zzd = false;
        public VideoOptions zze;
        public int zzf = 1;
        public boolean zzg = false;

        @RecentlyNonNull
        public NativeAdOptions build() {
            return new NativeAdOptions(this, (zzd) null);
        }

        @RecentlyNonNull
        public Builder setAdChoicesPlacement(@AdChoicesPlacement int i) {
            this.zzf = i;
            return this;
        }

        @RecentlyNonNull
        @Deprecated
        public Builder setImageOrientation(int i) {
            this.zzb = i;
            return this;
        }

        @RecentlyNonNull
        public Builder setMediaAspectRatio(@NativeMediaAspectRatio int i) {
            this.zzc = i;
            return this;
        }

        @RecentlyNonNull
        public Builder setRequestCustomMuteThisAd(boolean z) {
            this.zzg = z;
            return this;
        }

        @RecentlyNonNull
        public Builder setRequestMultipleImages(boolean z) {
            this.zzd = z;
            return this;
        }

        @RecentlyNonNull
        public Builder setReturnUrlsForImageAssets(boolean z) {
            this.zza = z;
            return this;
        }

        @RecentlyNonNull
        public Builder setVideoOptions(@RecentlyNonNull VideoOptions videoOptions) {
            this.zze = videoOptions;
            return this;
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
    public @interface NativeMediaAspectRatio {
    }

    public /* synthetic */ NativeAdOptions(Builder builder, zzd zzd2) {
        this.zza = builder.zza;
        this.zzb = builder.zzb;
        this.zzc = builder.zzc;
        this.zzd = builder.zzd;
        this.zze = builder.zzf;
        this.zzf = builder.zze;
        this.zzg = builder.zzg;
    }

    public int getAdChoicesPlacement() {
        return this.zze;
    }

    @Deprecated
    public int getImageOrientation() {
        return this.zzb;
    }

    public int getMediaAspectRatio() {
        return this.zzc;
    }

    @RecentlyNullable
    public VideoOptions getVideoOptions() {
        return this.zzf;
    }

    public boolean shouldRequestMultipleImages() {
        return this.zzd;
    }

    public boolean shouldReturnUrlsForImageAssets() {
        return this.zza;
    }

    public final boolean zza() {
        return this.zzg;
    }
}
