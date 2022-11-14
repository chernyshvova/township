package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzhx implements Runnable {
    public final /* synthetic */ zzac zza;
    public final /* synthetic */ long zzb;
    public final /* synthetic */ int zzc;
    public final /* synthetic */ long zzd;
    public final /* synthetic */ boolean zze;
    public final /* synthetic */ zzhb zzf;

    public zzhx(zzhb zzhb, zzac zzac, long j, int i, long j2, boolean z) {
        this.zzf = zzhb;
        this.zza = zzac;
        this.zzb = j;
        this.zzc = i;
        this.zzd = j2;
        this.zze = z;
    }

    public final void run() {
        this.zzf.zza(this.zza);
        this.zzf.zza(this.zzb, false);
        this.zzf.zza(this.zza, this.zzc, this.zzd, true, this.zze);
    }
}
