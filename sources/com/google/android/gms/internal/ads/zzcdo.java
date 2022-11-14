package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzcdo implements Runnable {
    public final zzcdt zza;
    public final Bitmap zzb;

    public zzcdo(zzcdt zzcdt, Bitmap bitmap) {
        this.zza = zzcdt;
        this.zzb = bitmap;
    }

    public final void run() {
        this.zza.zzh(this.zzb);
    }
}
