package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class zzgi implements Runnable {
    public final /* synthetic */ zzaq zza;
    public final /* synthetic */ zzn zzb;
    public final /* synthetic */ zzfz zzc;

    public zzgi(zzfz zzfz, zzaq zzaq, zzn zzn) {
        this.zzc = zzfz;
        this.zza = zzaq;
        this.zzb = zzn;
    }

    public final void run() {
        zzaq zzb2 = this.zzc.zzb(this.zza, this.zzb);
        this.zzc.zza.zzr();
        this.zzc.zza.zza(zzb2, this.zzb);
    }
}
