package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzal implements Runnable {
    public final /* synthetic */ zzgt zza;
    public final /* synthetic */ zzai zzb;

    public zzal(zzai zzai, zzgt zzgt) {
        this.zzb = zzai;
        this.zza = zzgt;
    }

    public final void run() {
        this.zza.zzt();
        if (zzw.zza()) {
            this.zza.zzp().zza((Runnable) this);
            return;
        }
        boolean zzb2 = this.zzb.zzb();
        long unused = this.zzb.zzd = 0;
        if (zzb2) {
            this.zzb.zza();
        }
    }
}
