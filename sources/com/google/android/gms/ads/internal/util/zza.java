package com.google.android.gms.ads.internal.util;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zza implements Runnable {
    public final /* synthetic */ zzb zza;

    public zza(zzb zzb) {
        this.zza = zzb;
    }

    public final void run() {
        Thread unused = this.zza.zzb = Thread.currentThread();
        this.zza.zza();
    }
}
