package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zziz implements Runnable {
    public final /* synthetic */ zzn zza;
    public final /* synthetic */ zzir zzb;

    public zziz(zzir zzir, zzn zzn) {
        this.zzb = zzir;
        this.zza = zzn;
    }

    public final void run() {
        zzei zzd = this.zzb.zzb;
        if (zzd == null) {
            this.zzb.zzq().zze().zza("Discarding data. Failed to send app launch");
            return;
        }
        try {
            zzd.zza(this.zza);
            this.zzb.zzi().zzac();
            this.zzb.zza(zzd, (AbstractSafeParcelable) null, this.zza);
            this.zzb.zzaj();
        } catch (RemoteException e) {
            this.zzb.zzq().zze().zza("Failed to send app launch to the service", e);
        }
    }
}
