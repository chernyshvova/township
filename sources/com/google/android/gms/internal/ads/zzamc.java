package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzamc implements Runnable {
    public final zzamm zza;
    public final zzro zzb;

    public zzamc(zzamm zzamm, zzro zzro) {
        this.zza = zzamm;
        this.zzb = zzro;
    }

    public final void run() {
        this.zza.zzt(this.zzb);
    }
}
