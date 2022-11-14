package com.google.android.gms.ads.admanager;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.query.AdInfo;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbhn;
import java.util.List;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class AdManagerAdRequest extends AdRequest {

    @VisibleForTesting
    /* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
    public static final class Builder extends AdRequest.Builder {
        @RecentlyNonNull
        public Builder addCategoryExclusion(@RecentlyNonNull String str) {
            this.zza.zzp(str);
            return this;
        }

        @RecentlyNonNull
        public Builder addCustomTargeting(@RecentlyNonNull String str, @RecentlyNonNull String str2) {
            this.zza.zzo(str, str2);
            return this;
        }

        @RecentlyNonNull
        public Builder setPublisherProvidedId(@RecentlyNonNull String str) {
            this.zza.zzl(str);
            return this;
        }

        @RecentlyNonNull
        public Builder addCustomTargeting(@RecentlyNonNull String str, @RecentlyNonNull List<String> list) {
            if (list != null) {
                this.zza.zzo(str, TextUtils.join(",", list));
            }
            return this;
        }

        @RecentlyNonNull
        public AdManagerAdRequest build() {
            return new AdManagerAdRequest(this, (zza) null);
        }

        @RecentlyNonNull
        @KeepForSdk
        @Deprecated
        public Builder setAdInfo(@RecentlyNonNull AdInfo adInfo) {
            this.zza.zzr(adInfo);
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setAdString(@RecentlyNonNull String str) {
            this.zza.zzs(str);
            return this;
        }
    }

    public /* synthetic */ AdManagerAdRequest(Builder builder, zza zza) {
        super(builder);
    }

    @RecentlyNonNull
    public Bundle getCustomTargeting() {
        return this.zza.zzq();
    }

    @RecentlyNonNull
    public String getPublisherProvidedId() {
        return this.zza.zzj();
    }

    public final zzbhn zza() {
        return this.zza;
    }
}
