package com.google.android.gms.internal.ads;

import com.facebook.appevents.AppEventsConstants;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzbpu implements zzbps<zzcmr> {
    public final zzbpv zza;

    public zzbpu(zzbpv zzbpv, byte[] bArr) {
        this.zza = zzbpv;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcmr zzcmr = (zzcmr) obj;
        boolean equals = AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("transparentBackground"));
        boolean equals2 = AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("blur"));
        float f = 0.0f;
        try {
            if (map.get("blurRadius") != null) {
                f = Float.parseFloat((String) map.get("blurRadius"));
            }
        } catch (NumberFormatException e) {
            zzcgs.zzg("Fail to parse float", e);
        }
        this.zza.zza(equals);
        this.zza.zzb(equals2, f);
        zzcmr.zzaD(equals);
    }
}
