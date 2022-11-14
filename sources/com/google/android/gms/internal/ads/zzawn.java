package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AppEventListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final class zzawn extends zzbfx {
    public final AppEventListener zza;

    public zzawn(AppEventListener appEventListener) {
        this.zza = appEventListener;
    }

    public final void zzb(String str, String str2) {
        this.zza.onAppEvent(str, str2);
    }

    public final AppEventListener zzc() {
        return this.zza;
    }
}
