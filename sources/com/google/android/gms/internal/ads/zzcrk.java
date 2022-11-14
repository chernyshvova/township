package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzcrk implements Runnable {
    public final zzcrl zza;
    public final Runnable zzb;

    public zzcrk(zzcrl zzcrl, Runnable runnable) {
        this.zza = zzcrl;
        this.zzb = runnable;
    }

    public final void run() {
        this.zza.zzc(this.zzb);
    }
}
