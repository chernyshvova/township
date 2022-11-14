package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdzt implements zzddy {
    public final Context zza;
    public final zzcfb zzb;

    public zzdzt(Context context, zzcfb zzcfb) {
        this.zza = context;
        this.zzb = zzcfb;
    }

    public final void zzj(zzcbk zzcbk) {
    }

    public final void zzq(zzeyq zzeyq) {
        if (!TextUtils.isEmpty(zzeyq.zzb.zzb.zzd)) {
            this.zzb.zzd(this.zza, zzeyq.zza.zza.zzd);
            this.zzb.zzp(this.zza, zzeyq.zzb.zzb.zzd);
        }
    }
}
