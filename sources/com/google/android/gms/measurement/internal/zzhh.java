package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzhh implements Runnable {
    public final /* synthetic */ long zza;
    public final /* synthetic */ zzhb zzb;

    public zzhh(zzhb zzhb, long j) {
        this.zzb = zzhb;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zzr().zzk.zza(this.zza);
        this.zzb.zzq().zzv().zza("Minimum session duration set", Long.valueOf(this.zza));
    }
}
