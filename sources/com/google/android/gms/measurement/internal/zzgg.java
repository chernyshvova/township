package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class zzgg implements Runnable {
    public final /* synthetic */ zzn zza;
    public final /* synthetic */ zzfz zzb;

    public zzgg(zzfz zzfz, zzn zzn) {
        this.zzb = zzfz;
        this.zza = zzn;
    }

    public final void run() {
        this.zzb.zza.zzr();
        this.zzb.zza.zza(this.zza);
    }
}
