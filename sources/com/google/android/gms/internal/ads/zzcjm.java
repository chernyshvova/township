package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzcjm implements Runnable {
    public final zzcjq zza;
    public final int zzb;
    public final int zzc;

    public zzcjm(zzcjq zzcjq, int i, int i2) {
        this.zza = zzcjq;
        this.zzb = i;
        this.zzc = i2;
    }

    public final void run() {
        this.zza.zzK(this.zzb, this.zzc);
    }
}
