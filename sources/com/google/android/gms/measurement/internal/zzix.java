package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzml;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzix implements Runnable {
    public final /* synthetic */ AtomicReference zza;
    public final /* synthetic */ zzn zzb;
    public final /* synthetic */ zzir zzc;

    public zzix(zzir zzir, AtomicReference atomicReference, zzn zzn) {
        this.zzc = zzir;
        this.zza = atomicReference;
        this.zzb = zzn;
    }

    public final void run() {
        synchronized (this.zza) {
            try {
                if (!zzml.zzb() || !this.zzc.zzs().zza(zzas.zzcg) || this.zzc.zzr().zzx().zze()) {
                    zzei zzd = this.zzc.zzb;
                    if (zzd == null) {
                        this.zzc.zzq().zze().zza("Failed to get app instance id");
                        this.zza.notify();
                        return;
                    }
                    this.zza.set(zzd.zzc(this.zzb));
                    String str = (String) this.zza.get();
                    if (str != null) {
                        this.zzc.zze().zza(str);
                        this.zzc.zzr().zzj.zza(str);
                    }
                    this.zzc.zzaj();
                    this.zza.notify();
                } else {
                    this.zzc.zzq().zzj().zza("Analytics storage consent denied; will not get app instance id");
                    this.zzc.zze().zza((String) null);
                    this.zzc.zzr().zzj.zza((String) null);
                    this.zza.set((Object) null);
                    this.zza.notify();
                }
            } catch (RemoteException e) {
                try {
                    this.zzc.zzq().zze().zza("Failed to get app instance id", e);
                    this.zza.notify();
                } catch (Throwable th) {
                    this.zza.notify();
                    throw th;
                }
            }
        }
    }
}
