package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzil implements Runnable {
    public final /* synthetic */ Bundle zza;
    public final /* synthetic */ zzij zzb;
    public final /* synthetic */ zzij zzc;
    public final /* synthetic */ long zzd;
    public final /* synthetic */ zzii zze;

    public zzil(zzii zzii, Bundle bundle, zzij zzij, zzij zzij2, long j) {
        this.zze = zzii;
        this.zza = bundle;
        this.zzb = zzij;
        this.zzc = zzij2;
        this.zzd = j;
    }

    public final void run() {
        this.zze.zza(this.zza, this.zzb, this.zzc, this.zzd);
    }
}
