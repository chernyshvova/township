package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzhu implements Runnable {
    public final /* synthetic */ Boolean zza;
    public final /* synthetic */ zzhb zzb;

    public zzhu(zzhb zzhb, Boolean bool) {
        this.zzb = zzhb;
        this.zza = bool;
    }

    public final void run() {
        this.zzb.zza(this.zza, true);
    }
}
