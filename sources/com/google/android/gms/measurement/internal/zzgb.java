package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class zzgb implements Runnable {
    public final /* synthetic */ zzn zza;
    public final /* synthetic */ zzfz zzb;

    public zzgb(zzfz zzfz, zzn zzn) {
        this.zzb = zzfz;
        this.zza = zzn;
    }

    public final void run() {
        this.zzb.zza.zzr();
        zzkl zza2 = this.zzb.zza;
        zzn zzn = this.zza;
        zza2.zzp().zzc();
        zza2.zzn();
        Preconditions.checkNotEmpty(zzn.zza);
        zza2.zzc(zzn);
    }
}
