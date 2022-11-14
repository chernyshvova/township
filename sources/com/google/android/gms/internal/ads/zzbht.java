package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdInspectorError;
import com.google.android.gms.ads.OnAdInspectorClosedListener;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzbht extends zzbgt {
    public zzbht() {
    }

    public final void zze(@Nullable zzbdd zzbdd) {
        AdInspectorError adInspectorError;
        OnAdInspectorClosedListener zzu = zzbhv.zza().zzg;
        if (zzu != null) {
            if (zzbdd == null) {
                adInspectorError = null;
            } else {
                adInspectorError = new AdInspectorError(zzbdd.zza, zzbdd.zzb, zzbdd.zzc);
            }
            zzu.onAdInspectorClosed(adInspectorError);
        }
    }

    public /* synthetic */ zzbht(zzbhs zzbhs) {
    }
}
