package com.google.android.gms.internal.ads;

import android.view.Surface;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzavr implements Runnable {
    public final /* synthetic */ Surface zza;
    public final /* synthetic */ zzavt zzb;

    public zzavr(zzavt zzavt, Surface surface) {
        this.zzb = zzavt;
        this.zza = surface;
    }

    public final void run() {
        this.zzb.zzb.zzo(this.zza);
    }
}
