package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzhv implements Runnable {
    public final /* synthetic */ AtomicReference zza;
    public final /* synthetic */ zzhb zzb;

    public zzhv(zzhb zzhb, AtomicReference atomicReference) {
        this.zzb = zzhb;
        this.zza = atomicReference;
    }

    public final void run() {
        synchronized (this.zza) {
            try {
                this.zza.set(Double.valueOf(this.zzb.zzs().zzc(this.zzb.zzf().zzaa(), zzas.zzan)));
                this.zza.notify();
            } catch (Throwable th) {
                this.zza.notify();
                throw th;
            }
        }
    }
}
