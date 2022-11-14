package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzpr implements Runnable {
    public final zzpy zza;
    public final long zzb;

    public zzpr(zzpy zzpy, long j) {
        this.zza = zzpy;
        this.zzb = j;
    }

    public final void run() {
        this.zza.zzq(this.zzb);
    }
}
