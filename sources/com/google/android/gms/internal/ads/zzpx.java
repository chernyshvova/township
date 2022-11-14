package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzpx implements Runnable {
    public final zzpy zza;
    public final Exception zzb;

    public zzpx(zzpy zzpy, Exception exc) {
        this.zza = zzpy;
        this.zzb = exc;
    }

    public final void run() {
        this.zza.zzk(this.zzb);
    }
}
