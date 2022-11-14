package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzjb implements Runnable {
    public final /* synthetic */ Bundle zza;
    public final /* synthetic */ zzn zzb;
    public final /* synthetic */ zzir zzc;

    public zzjb(zzir zzir, Bundle bundle, zzn zzn) {
        this.zzc = zzir;
        this.zza = bundle;
        this.zzb = zzn;
    }

    public final void run() {
        zzei zzd = this.zzc.zzb;
        if (zzd == null) {
            this.zzc.zzq().zze().zza("Failed to send default event parameters to service");
            return;
        }
        try {
            zzd.zza(this.zza, this.zzb);
        } catch (RemoteException e) {
            this.zzc.zzq().zze().zza("Failed to send default event parameters to service", e);
        }
    }
}
