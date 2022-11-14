package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzw;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.0 */
public final class zzh implements Runnable {
    public final /* synthetic */ zzw zza;
    public final /* synthetic */ AppMeasurementDynamiteService zzb;

    public zzh(AppMeasurementDynamiteService appMeasurementDynamiteService, zzw zzw) {
        this.zzb = appMeasurementDynamiteService;
        this.zza = zzw;
    }

    public final void run() {
        this.zzb.zza.zzv().zza(this.zza);
    }
}
