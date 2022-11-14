package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzg;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzcsi implements zzcsg {
    public final zzg zza;

    public zzcsi(zzg zzg) {
        this.zza = zzg;
    }

    public final void zza(Map<String, String> map) {
        this.zza.zzc(Boolean.parseBoolean(map.get("content_url_opted_out")));
    }
}
