package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzjh implements Runnable {
    public final /* synthetic */ boolean zza = true;
    public final /* synthetic */ boolean zzb;
    public final /* synthetic */ zzz zzc;
    public final /* synthetic */ zzn zzd;
    public final /* synthetic */ zzz zze;
    public final /* synthetic */ zzir zzf;

    public zzjh(zzir zzir, boolean z, boolean z2, zzz zzz, zzn zzn, zzz zzz2) {
        this.zzf = zzir;
        this.zzb = z2;
        this.zzc = zzz;
        this.zzd = zzn;
        this.zze = zzz2;
    }

    public final void run() {
        zzei zzd2 = this.zzf.zzb;
        if (zzd2 == null) {
            this.zzf.zzq().zze().zza("Discarding data. Failed to send conditional user property to service");
            return;
        }
        if (this.zza) {
            this.zzf.zza(zzd2, (AbstractSafeParcelable) this.zzb ? null : this.zzc, this.zzd);
        } else {
            try {
                if (TextUtils.isEmpty(this.zze.zza)) {
                    zzd2.zza(this.zzc, this.zzd);
                } else {
                    zzd2.zza(this.zzc);
                }
            } catch (RemoteException e) {
                this.zzf.zzq().zze().zza("Failed to send conditional user property to the service", e);
            }
        }
        this.zzf.zzaj();
    }
}
