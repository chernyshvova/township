package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzhk implements Runnable {
    public final /* synthetic */ long zza;
    public final /* synthetic */ zzhb zzb;

    public zzhk(zzhb zzhb, long j) {
        this.zzb = zzhb;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zza(this.zza, true);
        this.zzb.zzg().zza((AtomicReference<String>) new AtomicReference());
    }
}
