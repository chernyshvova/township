package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzs implements Runnable {
    public final zzac zza;
    public final zzai zzb;
    public final Runnable zzc;

    public zzs(zzac zzac, zzai zzai, Runnable runnable) {
        this.zza = zzac;
        this.zzb = zzai;
        this.zzc = runnable;
    }

    public final void run() {
        this.zza.zzl();
        if (this.zzb.zzc()) {
            this.zza.zzs(this.zzb.zza);
        } else {
            this.zza.zzt(this.zzb.zzc);
        }
        if (this.zzb.zzd) {
            this.zza.zzc("intermediate-response");
        } else {
            this.zza.zzd("done");
        }
        Runnable runnable = this.zzc;
        if (runnable != null) {
            runnable.run();
        }
    }
}
