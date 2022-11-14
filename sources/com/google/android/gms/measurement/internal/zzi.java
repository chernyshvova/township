package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzw;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.0 */
public final class zzi implements Runnable {
    public final /* synthetic */ zzw zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ boolean zzd;
    public final /* synthetic */ AppMeasurementDynamiteService zze;

    public zzi(AppMeasurementDynamiteService appMeasurementDynamiteService, zzw zzw, String str, String str2, boolean z) {
        this.zze = appMeasurementDynamiteService;
        this.zza = zzw;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = z;
    }

    public final void run() {
        this.zze.zza.zzv().zza(this.zza, this.zzb, this.zzc, this.zzd);
    }
}
