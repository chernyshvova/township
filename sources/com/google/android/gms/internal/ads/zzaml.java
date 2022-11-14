package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzaml implements Runnable {
    public final zzamm zza;
    public final Exception zzb;

    public zzaml(zzamm zzamm, Exception exc) {
        this.zza = zzamm;
        this.zzb = exc;
    }

    public final void run() {
        this.zza.zzk(this.zzb);
    }
}
