package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zziy implements Runnable {
    public final /* synthetic */ zzij zza;
    public final /* synthetic */ zzir zzb;

    public zziy(zzir zzir, zzij zzij) {
        this.zzb = zzir;
        this.zza = zzij;
    }

    public final void run() {
        zzei zzd = this.zzb.zzb;
        if (zzd == null) {
            this.zzb.zzq().zze().zza("Failed to send current screen to service");
            return;
        }
        try {
            if (this.zza == null) {
                zzd.zza(0, (String) null, (String) null, this.zzb.zzm().getPackageName());
            } else {
                zzd.zza(this.zza.zzc, this.zza.zza, this.zza.zzb, this.zzb.zzm().getPackageName());
            }
            this.zzb.zzaj();
        } catch (RemoteException e) {
            this.zzb.zzq().zze().zza("Failed to send current screen to the service", e);
        }
    }
}
