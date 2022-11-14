package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzavp implements Runnable {
    public final /* synthetic */ int zza;
    public final /* synthetic */ long zzb;
    public final /* synthetic */ zzavt zzc;

    public zzavp(zzavt zzavt, int i, long j) {
        this.zzc = zzavt;
        this.zza = i;
        this.zzb = j;
    }

    public final void run() {
        this.zzc.zzb.zzm(this.zza, this.zzb);
    }
}
