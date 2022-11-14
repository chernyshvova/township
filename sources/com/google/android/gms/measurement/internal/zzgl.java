package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class zzgl implements Runnable {
    public final /* synthetic */ zzaq zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzfz zzc;

    public zzgl(zzfz zzfz, zzaq zzaq, String str) {
        this.zzc = zzfz;
        this.zza = zzaq;
        this.zzb = str;
    }

    public final void run() {
        this.zzc.zza.zzr();
        this.zzc.zza.zza(this.zza, this.zzb);
    }
}
