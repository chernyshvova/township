package com.google.android.gms.ads;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.internal.ads.zzbiv;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class VideoOptions {
    public final boolean zza;
    public final boolean zzb;
    public final boolean zzc;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
    public static final class Builder {
        public boolean zza = true;
        public boolean zzb = false;
        public boolean zzc = false;

        @RecentlyNonNull
        public VideoOptions build() {
            return new VideoOptions(this, (zzd) null);
        }

        @RecentlyNonNull
        public Builder setClickToExpandRequested(boolean z) {
            this.zzc = z;
            return this;
        }

        @RecentlyNonNull
        public Builder setCustomControlsRequested(boolean z) {
            this.zzb = z;
            return this;
        }

        @RecentlyNonNull
        public Builder setStartMuted(boolean z) {
            this.zza = z;
            return this;
        }
    }

    public /* synthetic */ VideoOptions(Builder builder, zzd zzd) {
        this.zza = builder.zza;
        this.zzb = builder.zzb;
        this.zzc = builder.zzc;
    }

    public VideoOptions(zzbiv zzbiv) {
        this.zza = zzbiv.zza;
        this.zzb = zzbiv.zzb;
        this.zzc = zzbiv.zzc;
    }

    public boolean getClickToExpandRequested() {
        return this.zzc;
    }

    public boolean getCustomControlsRequested() {
        return this.zzb;
    }

    public boolean getStartMuted() {
        return this.zza;
    }
}
