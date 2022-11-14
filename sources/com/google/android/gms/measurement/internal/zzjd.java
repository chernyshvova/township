package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzw;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzjd implements Runnable {
    public final /* synthetic */ zzaq zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzw zzc;
    public final /* synthetic */ zzir zzd;

    public zzjd(zzir zzir, zzaq zzaq, String str, zzw zzw) {
        this.zzd = zzir;
        this.zza = zzaq;
        this.zzb = str;
        this.zzc = zzw;
    }

    public final void run() {
        byte[] bArr = null;
        try {
            zzei zzd2 = this.zzd.zzb;
            if (zzd2 == null) {
                this.zzd.zzq().zze().zza("Discarding data. Failed to send event to service to bundle");
                return;
            }
            bArr = zzd2.zza(this.zza, this.zzb);
            this.zzd.zzaj();
            this.zzd.zzo().zza(this.zzc, bArr);
        } catch (RemoteException e) {
            this.zzd.zzq().zze().zza("Failed to send event to the service to bundle", e);
        } finally {
            this.zzd.zzo().zza(this.zzc, bArr);
        }
    }
}
