package com.google.android.gms.ads.internal;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzg implements Runnable {
    public final zzi zza;
    public final boolean zzb;

    public zzg(zzi zzi, boolean z) {
        this.zza = zzi;
        this.zzb = z;
    }

    public final void run() {
        this.zza.zzb(this.zzb);
    }
}
