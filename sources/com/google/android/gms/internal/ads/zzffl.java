package com.google.android.gms.internal.ads;

import android.webkit.WebView;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzffl implements Runnable {
    public final /* synthetic */ zzffm zza;
    public final WebView zzb = this.zza.zza;

    public zzffl(zzffm zzffm) {
        this.zza = zzffm;
    }

    public final void run() {
        this.zzb.destroy();
    }
}
