package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzawv implements ValueCallback<String> {
    public final /* synthetic */ zzaww zza;

    public zzawv(zzaww zzaww) {
        this.zza = zzaww;
    }

    /* renamed from: zza */
    public final void onReceiveValue(String str) {
        zzaww zzaww = this.zza;
        zzaww.zze.zzd(zzaww.zzb, zzaww.zzc, str, zzaww.zzd);
    }
}
