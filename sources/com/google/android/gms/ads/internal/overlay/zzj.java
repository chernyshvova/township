package com.google.android.gms.ads.internal.overlay;

import android.graphics.drawable.Drawable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzj implements Runnable {
    public final zzk zza;
    public final Drawable zzb;

    public zzj(zzk zzk, Drawable drawable) {
        this.zza = zzk;
        this.zzb = drawable;
    }

    public final void run() {
        zzk zzk = this.zza;
        zzk.zza.zzb.getWindow().setBackgroundDrawable(this.zzb);
    }
}
