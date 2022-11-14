package com.google.android.gms.ads.p033h5;

import android.content.Context;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RequiresApi;
import com.google.android.gms.internal.ads.zzbqu;

@RequiresApi(api = 21)
/* renamed from: com.google.android.gms.ads.h5.H5AdsRequestHandler */
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class H5AdsRequestHandler {
    public final zzbqu zza;

    public H5AdsRequestHandler(@RecentlyNonNull Context context, @RecentlyNonNull OnH5AdsEventListener onH5AdsEventListener) {
        this.zza = new zzbqu(context, onH5AdsEventListener);
    }

    public void clearAdObjects() {
        this.zza.zzb();
    }

    public boolean handleH5AdsRequest(@RecentlyNonNull String str) {
        return this.zza.zza(str);
    }

    public boolean shouldInterceptRequest(@RecentlyNonNull String str) {
        return zzbqu.zzc(str);
    }
}
