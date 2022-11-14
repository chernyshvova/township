package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zziv implements Runnable {
    public final /* synthetic */ AtomicReference zza;
    public final /* synthetic */ zzn zzb;
    public final /* synthetic */ boolean zzc;
    public final /* synthetic */ zzir zzd;

    public zziv(zzir zzir, AtomicReference atomicReference, zzn zzn, boolean z) {
        this.zzd = zzir;
        this.zza = atomicReference;
        this.zzb = zzn;
        this.zzc = z;
    }

    public final void run() {
        synchronized (this.zza) {
            try {
                zzei zzd2 = this.zzd.zzb;
                if (zzd2 == null) {
                    this.zzd.zzq().zze().zza("Failed to get all user properties; not connected to service");
                    this.zza.notify();
                    return;
                }
                this.zza.set(zzd2.zza(this.zzb, this.zzc));
                this.zzd.zzaj();
                this.zza.notify();
            } catch (RemoteException e) {
                try {
                    this.zzd.zzq().zze().zza("Failed to get all user properties; remote exception", e);
                    this.zza.notify();
                } catch (Throwable th) {
                    this.zza.notify();
                    throw th;
                }
            }
        }
    }
}
