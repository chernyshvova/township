package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzhc implements Runnable {
    public final /* synthetic */ AtomicReference zza;
    public final /* synthetic */ zzhb zzb;

    public zzhc(zzhb zzhb, AtomicReference atomicReference) {
        this.zzb = zzhb;
        this.zza = atomicReference;
    }

    public final void run() {
        synchronized (this.zza) {
            try {
                this.zza.set(Boolean.valueOf(this.zzb.zzs().zzj(this.zzb.zzf().zzaa())));
                this.zza.notify();
            } catch (Throwable th) {
                this.zza.notify();
                throw th;
            }
        }
    }
}
