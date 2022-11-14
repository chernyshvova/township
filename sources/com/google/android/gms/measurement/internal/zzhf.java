package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzhf implements Runnable {
    public final /* synthetic */ boolean zza;
    public final /* synthetic */ zzhb zzb;

    public zzhf(zzhb zzhb, boolean z) {
        this.zzb = zzhb;
        this.zza = z;
    }

    public final void run() {
        boolean zzaa = this.zzb.zzy.zzaa();
        boolean zzz = this.zzb.zzy.zzz();
        this.zzb.zzy.zza(this.zza);
        if (zzz == this.zza) {
            this.zzb.zzy.zzq().zzw().zza("Default data collection state already set to", Boolean.valueOf(this.zza));
        }
        if (this.zzb.zzy.zzaa() == zzaa || this.zzb.zzy.zzaa() != this.zzb.zzy.zzz()) {
            this.zzb.zzy.zzq().zzj().zza("Default data collection is different than actual status", Boolean.valueOf(this.zza), Boolean.valueOf(zzaa));
        }
        this.zzb.zzal();
    }
}
