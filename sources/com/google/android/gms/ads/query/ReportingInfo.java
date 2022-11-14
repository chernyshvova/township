package com.google.android.gms.ads.query;

import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzcal;
import com.google.android.gms.internal.ads.zzcam;
import java.util.List;
import java.util.Map;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class ReportingInfo {
    public final zzcam zza;

    @KeepForSdk
    /* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
    public static final class Builder {
        public final zzcal zza;

        @KeepForSdk
        public Builder(@RecentlyNonNull View view) {
            zzcal zzcal = new zzcal();
            this.zza = zzcal;
            zzcal.zza(view);
        }

        @RecentlyNonNull
        @KeepForSdk
        public ReportingInfo build() {
            return new ReportingInfo(this, (zza) null);
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setAssetViews(@RecentlyNonNull Map<String, View> map) {
            this.zza.zzb(map);
            return this;
        }
    }

    public /* synthetic */ ReportingInfo(Builder builder, zza zza2) {
        this.zza = new zzcam(builder.zza);
    }

    @KeepForSdk
    public void reportTouchEvent(@RecentlyNonNull MotionEvent motionEvent) {
        this.zza.zzc(motionEvent);
    }

    @KeepForSdk
    public void updateClickUrl(@RecentlyNonNull Uri uri, @RecentlyNonNull UpdateClickUrlCallback updateClickUrlCallback) {
        this.zza.zzb(uri, updateClickUrlCallback);
    }

    @KeepForSdk
    public void updateImpressionUrls(@RecentlyNonNull List<Uri> list, @RecentlyNonNull UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        this.zza.zza(list, updateImpressionUrlsCallback);
    }
}
