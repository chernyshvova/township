package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzpv implements Runnable {
    public final zzpy zza;
    public final boolean zzb;

    public zzpv(zzpy zzpy, boolean z) {
        this.zza = zzpy;
        this.zzb = z;
    }

    public final void run() {
        this.zza.zzm(this.zzb);
    }
}
