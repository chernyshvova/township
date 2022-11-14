package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzpw implements Runnable {
    public final zzpy zza;
    public final Exception zzb;

    public zzpw(zzpy zzpy, Exception exc) {
        this.zza = zzpy;
        this.zzb = exc;
    }

    public final void run() {
        this.zza.zzl(this.zzb);
    }
}
