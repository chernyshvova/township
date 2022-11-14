package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzw;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzit implements Runnable {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ boolean zzc;
    public final /* synthetic */ zzn zzd;
    public final /* synthetic */ zzw zze;
    public final /* synthetic */ zzir zzf;

    public zzit(zzir zzir, String str, String str2, boolean z, zzn zzn, zzw zzw) {
        this.zzf = zzir;
        this.zza = str;
        this.zzb = str2;
        this.zzc = z;
        this.zzd = zzn;
        this.zze = zzw;
    }

    public final void run() {
        Bundle bundle = new Bundle();
        try {
            zzei zzd2 = this.zzf.zzb;
            if (zzd2 == null) {
                this.zzf.zzq().zze().zza("Failed to get user properties; not connected to service", this.zza, this.zzb);
                return;
            }
            bundle = zzkv.zza(zzd2.zza(this.zza, this.zzb, this.zzc, this.zzd));
            this.zzf.zzaj();
            this.zzf.zzo().zza(this.zze, bundle);
        } catch (RemoteException e) {
            this.zzf.zzq().zze().zza("Failed to get user properties; remote exception", this.zza, e);
        } finally {
            this.zzf.zzo().zza(this.zze, bundle);
        }
    }
}
