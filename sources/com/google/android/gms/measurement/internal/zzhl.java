package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzhl implements Runnable {
    public final /* synthetic */ AtomicReference zza;
    public final /* synthetic */ boolean zzb;
    public final /* synthetic */ zzhb zzc;

    public zzhl(zzhb zzhb, AtomicReference atomicReference, boolean z) {
        this.zzc = zzhb;
        this.zza = atomicReference;
        this.zzb = z;
    }

    public final void run() {
        this.zzc.zzg().zza((AtomicReference<List<zzku>>) this.zza, this.zzb);
    }
}
