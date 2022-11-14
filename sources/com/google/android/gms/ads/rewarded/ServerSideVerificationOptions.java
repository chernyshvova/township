package com.google.android.gms.ads.rewarded;

import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public class ServerSideVerificationOptions {
    public final String zza;
    public final String zzb;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
    public static final class Builder {
        public String zza = "";
        public String zzb = "";

        @RecentlyNonNull
        public ServerSideVerificationOptions build() {
            return new ServerSideVerificationOptions(this, (zzb) null);
        }

        @RecentlyNonNull
        public Builder setCustomData(@RecentlyNonNull String str) {
            this.zzb = str;
            return this;
        }

        @RecentlyNonNull
        public Builder setUserId(@RecentlyNonNull String str) {
            this.zza = str;
            return this;
        }
    }

    public /* synthetic */ ServerSideVerificationOptions(Builder builder, zzb zzb2) {
        this.zza = builder.zza;
        this.zzb = builder.zzb;
    }

    @RecentlyNonNull
    public String getCustomData() {
        return this.zzb;
    }

    @RecentlyNonNull
    public String getUserId() {
        return this.zza;
    }
}
