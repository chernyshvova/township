package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final /* synthetic */ class zzhd implements Runnable {
    public final zzhb zza;

    public zzhd(zzhb zzhb) {
        this.zza = zzhb;
    }

    public final void run() {
        zzhb zzhb = this.zza;
        zzhb.zzc();
        if (zzhb.zzr().zzs.zza()) {
            zzhb.zzq().zzv().zza("Deferred Deep Link already retrieved. Not fetching again.");
            return;
        }
        long zza2 = zzhb.zzr().zzt.zza();
        zzhb.zzr().zzt.zza(1 + zza2);
        if (zza2 >= 5) {
            zzhb.zzq().zzh().zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
            zzhb.zzr().zzs.zza(true);
            return;
        }
        zzhb.zzy.zzag();
    }
}
