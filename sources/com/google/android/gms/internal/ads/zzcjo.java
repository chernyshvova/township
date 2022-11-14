package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzcjo implements Runnable {
    public final zzcjq zza;
    public final int zzb;

    public zzcjo(zzcjq zzcjq, int i) {
        this.zza = zzcjq;
        this.zzb = i;
    }

    public final void run() {
        this.zza.zzI(this.zzb);
    }
}
