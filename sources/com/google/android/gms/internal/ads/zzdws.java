package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzdws implements Runnable {
    public final zzdww zza;
    public final zzchj zzb;

    public zzdws(zzdww zzdww, zzchj zzchj) {
        this.zza = zzdww;
        this.zzb = zzchj;
    }

    public final void run() {
        zzchj zzchj = this.zzb;
        String zzd = zzs.zzg().zzl().zzn().zzd();
        if (!TextUtils.isEmpty(zzd)) {
            zzchj.zzc(zzd);
        } else {
            zzchj.zzd(new Exception());
        }
    }
}
