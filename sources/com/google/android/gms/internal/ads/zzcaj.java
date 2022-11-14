package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.query.UpdateImpressionUrlsCallback;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzcaj extends zzcaf {
    public final /* synthetic */ UpdateImpressionUrlsCallback zza;

    public zzcaj(zzcam zzcam, UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        this.zza = updateImpressionUrlsCallback;
    }

    public final void zze(List<Uri> list) {
        this.zza.onSuccess(list);
    }

    public final void zzf(String str) {
        this.zza.onFailure(str);
    }
}
