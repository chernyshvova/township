package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzip implements Runnable {
    public final /* synthetic */ zzij zza;
    public final /* synthetic */ long zzb;
    public final /* synthetic */ zzii zzc;

    public zzip(zzii zzii, zzij zzij, long j) {
        this.zzc = zzii;
        this.zza = zzij;
        this.zzb = j;
    }

    public final void run() {
        this.zzc.zza(this.zza, false, this.zzb);
        zzii zzii = this.zzc;
        zzii.zza = null;
        zzii.zzg().zza((zzij) null);
    }
}
