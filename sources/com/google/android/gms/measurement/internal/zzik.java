package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzik implements Runnable {
    public final /* synthetic */ zzij zza;
    public final /* synthetic */ zzij zzb;
    public final /* synthetic */ long zzc;
    public final /* synthetic */ boolean zzd;
    public final /* synthetic */ zzii zze;

    public zzik(zzii zzii, zzij zzij, zzij zzij2, long j, boolean z) {
        this.zze = zzii;
        this.zza = zzij;
        this.zzb = zzij2;
        this.zzc = j;
        this.zzd = z;
    }

    public final void run() {
        this.zze.zza(this.zza, this.zzb, this.zzc, this.zzd, (Bundle) null);
    }
}
