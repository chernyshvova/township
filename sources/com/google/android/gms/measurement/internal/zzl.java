package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.0 */
public final class zzl implements Runnable {
    public final /* synthetic */ AppMeasurementDynamiteService.zza zza;
    public final /* synthetic */ AppMeasurementDynamiteService zzb;

    public zzl(AppMeasurementDynamiteService appMeasurementDynamiteService, AppMeasurementDynamiteService.zza zza2) {
        this.zzb = appMeasurementDynamiteService;
        this.zza = zza2;
    }

    public final void run() {
        this.zzb.zza.zzg().zza((zzgw) this.zza);
    }
}
