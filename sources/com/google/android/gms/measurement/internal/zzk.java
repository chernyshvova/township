package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzw;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.0 */
public final class zzk implements Runnable {
    public final /* synthetic */ zzw zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ AppMeasurementDynamiteService zzd;

    public zzk(AppMeasurementDynamiteService appMeasurementDynamiteService, zzw zzw, String str, String str2) {
        this.zzd = appMeasurementDynamiteService;
        this.zza = zzw;
        this.zzb = str;
        this.zzc = str2;
    }

    public final void run() {
        this.zzd.zza.zzv().zza(this.zza, this.zzb, this.zzc);
    }
}
