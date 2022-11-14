package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class zzgd implements Runnable {
    public final /* synthetic */ zzz zza;
    public final /* synthetic */ zzfz zzb;

    public zzgd(zzfz zzfz, zzz zzz) {
        this.zzb = zzfz;
        this.zza = zzz;
    }

    public final void run() {
        this.zzb.zza.zzr();
        if (this.zza.zzc.zza() == null) {
            this.zzb.zza.zzb(this.zza);
        } else {
            this.zzb.zza.zza(this.zza);
        }
    }
}
