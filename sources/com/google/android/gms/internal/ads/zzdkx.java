package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdkx implements zzbps<Object> {
    public final WeakReference<zzdla> zza;

    public /* synthetic */ zzdkx(zzdla zzdla, zzdkw zzdkw) {
        this.zza = new WeakReference<>(zzdla);
    }

    public final void zza(Object obj, Map<String, String> map) {
        zzdla zzdla = (zzdla) this.zza.get();
        if (zzdla != null && "_ac".equals(map.get("eventName"))) {
            zzdla.zzh.onAdClicked();
        }
    }
}
