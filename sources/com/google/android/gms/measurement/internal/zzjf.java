package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzjf implements Runnable {
    public final /* synthetic */ zzn zza;
    public final /* synthetic */ zzir zzb;

    public zzjf(zzir zzir, zzn zzn) {
        this.zzb = zzir;
        this.zza = zzn;
    }

    public final void run() {
        zzei zzd = this.zzb.zzb;
        if (zzd == null) {
            this.zzb.zzq().zze().zza("Failed to send consent settings to service");
            return;
        }
        try {
            zzd.zze(this.zza);
            this.zzb.zzaj();
        } catch (RemoteException e) {
            this.zzb.zzq().zze().zza("Failed to send consent settings to the service", e);
        }
    }
}
