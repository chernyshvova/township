package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.3.0 */
public final /* synthetic */ class zzbhq implements Runnable {
    public final zzbhv zza;
    public final OnInitializationCompleteListener zzb;

    public zzbhq(zzbhv zzbhv, OnInitializationCompleteListener onInitializationCompleteListener) {
        this.zza = zzbhv;
        this.zzb = onInitializationCompleteListener;
    }

    public final void run() {
        this.zza.zzp(this.zzb);
    }
}
