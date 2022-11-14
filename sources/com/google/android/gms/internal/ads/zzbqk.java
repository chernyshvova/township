package com.google.android.gms.internal.ads;

import androidx.annotation.RequiresApi;
import com.google.android.gms.ads.p033h5.OnH5AdsEventListener;

@RequiresApi(api = 21)
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbqk extends zzbqm {
    public final OnH5AdsEventListener zza;

    public zzbqk(OnH5AdsEventListener onH5AdsEventListener) {
        this.zza = onH5AdsEventListener;
    }

    public final void zzb(String str) {
        this.zza.onH5AdsEvent(str);
    }
}
