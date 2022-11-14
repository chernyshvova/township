package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzcwq implements Runnable {
    public final zzcwr zza;
    public final Runnable zzb;

    public zzcwq(zzcwr zzcwr, Runnable runnable) {
        this.zza = zzcwr;
        this.zzb = runnable;
    }

    public final void run() {
        this.zza.zzj(this.zzb);
    }
}
