package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzje implements Runnable {
    public final /* synthetic */ boolean zza;
    public final /* synthetic */ boolean zzb;
    public final /* synthetic */ zzaq zzc;
    public final /* synthetic */ zzn zzd;
    public final /* synthetic */ String zze;
    public final /* synthetic */ zzir zzf;

    public zzje(zzir zzir, boolean z, boolean z2, zzaq zzaq, zzn zzn, String str) {
        this.zzf = zzir;
        this.zza = z;
        this.zzb = z2;
        this.zzc = zzaq;
        this.zzd = zzn;
        this.zze = str;
    }

    public final void run() {
        zzei zzd2 = this.zzf.zzb;
        if (zzd2 == null) {
            this.zzf.zzq().zze().zza("Discarding data. Failed to send event to service");
            return;
        }
        if (this.zza) {
            this.zzf.zza(zzd2, (AbstractSafeParcelable) this.zzb ? null : this.zzc, this.zzd);
        } else {
            try {
                if (TextUtils.isEmpty(this.zze)) {
                    zzd2.zza(this.zzc, this.zzd);
                } else {
                    zzd2.zza(this.zzc, this.zze, this.zzf.zzq().zzx());
                }
            } catch (RemoteException e) {
                this.zzf.zzq().zze().zza("Failed to send event to the service", e);
            }
        }
        this.zzf.zzaj();
    }
}
