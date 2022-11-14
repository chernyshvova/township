package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class zzfd implements Runnable {
    public final /* synthetic */ boolean zza;
    public final /* synthetic */ zzfa zzb;

    public zzfd(zzfa zzfa, boolean z) {
        this.zzb = zzfa;
        this.zza = z;
    }

    public final void run() {
        this.zzb.zzb.zza(this.zza);
    }
}
