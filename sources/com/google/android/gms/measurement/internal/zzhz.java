package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzhz implements Runnable {
    public final /* synthetic */ zzac zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ long zzc;
    public final /* synthetic */ boolean zzd;
    public final /* synthetic */ zzhb zze;

    public zzhz(zzhb zzhb, zzac zzac, int i, long j, boolean z) {
        this.zze = zzhb;
        this.zza = zzac;
        this.zzb = i;
        this.zzc = j;
        this.zzd = z;
    }

    public final void run() {
        this.zze.zza(this.zza);
        this.zze.zza(this.zza, this.zzb, this.zzc, false, this.zzd);
    }
}
