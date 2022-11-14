package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzw;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.0 */
public final class zzj implements Runnable {
    public final /* synthetic */ zzw zza;
    public final /* synthetic */ zzaq zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ AppMeasurementDynamiteService zzd;

    public zzj(AppMeasurementDynamiteService appMeasurementDynamiteService, zzw zzw, zzaq zzaq, String str) {
        this.zzd = appMeasurementDynamiteService;
        this.zza = zzw;
        this.zzb = zzaq;
        this.zzc = str;
    }

    public final void run() {
        this.zzd.zza.zzv().zza(this.zza, this.zzb, this.zzc);
    }
}
