package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdky implements zzbps<Object> {
    public final WeakReference<zzdla> zza;

    public /* synthetic */ zzdky(zzdla zzdla, zzdkw zzdkw) {
        this.zza = new WeakReference<>(zzdla);
    }

    public final void zza(Object obj, Map<String, String> map) {
        zzdla zzdla = (zzdla) this.zza.get();
        if (zzdla != null) {
            zzdla.zzh.onAdClicked();
        }
    }
}
