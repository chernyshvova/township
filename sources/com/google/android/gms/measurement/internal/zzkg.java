package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class zzkg extends zzai {
    public final /* synthetic */ zzkl zza;
    public final /* synthetic */ zzkh zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzkg(zzkh zzkh, zzgt zzgt, zzkl zzkl) {
        super(zzgt);
        this.zzb = zzkh;
        this.zza = zzkl;
    }

    public final void zza() {
        this.zzb.zze();
        this.zzb.zzq().zzw().zza("Starting upload from DelayedRunnable");
        this.zza.zzo();
    }
}
