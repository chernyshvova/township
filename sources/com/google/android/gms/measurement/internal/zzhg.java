package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzhg implements Runnable {
    public final /* synthetic */ long zza;
    public final /* synthetic */ zzhb zzb;

    public zzhg(zzhb zzhb, long j) {
        this.zzb = zzhb;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zzr().zzl.zza(this.zza);
        this.zzb.zzq().zzv().zza("Session timeout duration set", Long.valueOf(this.zza));
    }
}
