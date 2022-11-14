package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdqt<T> implements zzbps<Object> {
    public final /* synthetic */ zzdqu zza;
    public final WeakReference<T> zzb;
    public final String zzc;
    public final zzbps<T> zzd;

    public /* synthetic */ zzdqt(zzdqu zzdqu, WeakReference weakReference, String str, zzbps zzbps, zzdqk zzdqk) {
        this.zza = zzdqu;
        this.zzb = weakReference;
        this.zzc = str;
        this.zzd = zzbps;
    }

    public final void zza(Object obj, Map<String, String> map) {
        Object obj2 = this.zzb.get();
        if (obj2 == null) {
            this.zza.zze(this.zzc, this);
        } else {
            this.zzd.zza(obj2, map);
        }
    }
}
