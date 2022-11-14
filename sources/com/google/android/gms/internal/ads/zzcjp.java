package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzcjp implements Runnable {
    public final zzcjq zza;
    public final boolean zzb;
    public final long zzc;

    public zzcjp(zzcjq zzcjq, boolean z, long j) {
        this.zza = zzcjq;
        this.zzb = z;
        this.zzc = j;
    }

    public final void run() {
        this.zza.zzH(this.zzb, this.zzc);
    }
}
