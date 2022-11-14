package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzpu implements Runnable {
    public final zzpy zza;
    public final zzro zzb;

    public zzpu(zzpy zzpy, zzro zzro) {
        this.zza = zzpy;
        this.zzb = zzro;
    }

    public final void run() {
        this.zza.zzn(this.zzb);
    }
}
