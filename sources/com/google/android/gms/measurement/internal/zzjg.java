package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzjg implements Runnable {
    public final /* synthetic */ AtomicReference zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ String zzd;
    public final /* synthetic */ zzn zze;
    public final /* synthetic */ zzir zzf;

    public zzjg(zzir zzir, AtomicReference atomicReference, String str, String str2, String str3, zzn zzn) {
        this.zzf = zzir;
        this.zza = atomicReference;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = zzn;
    }

    public final void run() {
        synchronized (this.zza) {
            try {
                zzei zzd2 = this.zzf.zzb;
                if (zzd2 == null) {
                    this.zzf.zzq().zze().zza("(legacy) Failed to get conditional properties; not connected to service", zzeq.zza(this.zzb), this.zzc, this.zzd);
                    this.zza.set(Collections.emptyList());
                    this.zza.notify();
                    return;
                }
                if (TextUtils.isEmpty(this.zzb)) {
                    this.zza.set(zzd2.zza(this.zzc, this.zzd, this.zze));
                } else {
                    this.zza.set(zzd2.zza(this.zzb, this.zzc, this.zzd));
                }
                this.zzf.zzaj();
                this.zza.notify();
            } catch (RemoteException e) {
                try {
                    this.zzf.zzq().zze().zza("(legacy) Failed to get conditional properties; remote exception", zzeq.zza(this.zzb), this.zzc, e);
                    this.zza.set(Collections.emptyList());
                    this.zza.notify();
                } catch (Throwable th) {
                    this.zza.notify();
                    throw th;
                }
            }
        }
    }
}
