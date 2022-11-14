package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzw;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzjj implements Runnable {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzn zzc;
    public final /* synthetic */ zzw zzd;
    public final /* synthetic */ zzir zze;

    public zzjj(zzir zzir, String str, String str2, zzn zzn, zzw zzw) {
        this.zze = zzir;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzn;
        this.zzd = zzw;
    }

    public final void run() {
        ArrayList<Bundle> arrayList = new ArrayList<>();
        try {
            zzei zzd2 = this.zze.zzb;
            if (zzd2 == null) {
                this.zze.zzq().zze().zza("Failed to get conditional properties; not connected to service", this.zza, this.zzb);
                return;
            }
            arrayList = zzkv.zzb(zzd2.zza(this.zza, this.zzb, this.zzc));
            this.zze.zzaj();
            this.zze.zzo().zza(this.zzd, arrayList);
        } catch (RemoteException e) {
            this.zze.zzq().zze().zza("Failed to get conditional properties; remote exception", this.zza, this.zzb, e);
        } finally {
            this.zze.zzo().zza(this.zzd, arrayList);
        }
    }
}
