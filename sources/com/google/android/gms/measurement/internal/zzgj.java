package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzml;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class zzgj implements Runnable {
    public final /* synthetic */ zzn zza;
    public final /* synthetic */ zzfz zzb;

    public zzgj(zzfz zzfz, zzn zzn) {
        this.zzb = zzfz;
        this.zza = zzn;
    }

    public final void run() {
        this.zzb.zza.zzr();
        zzkl zza2 = this.zzb.zza;
        zzn zzn = this.zza;
        if (zzml.zzb() && zza2.zzb().zza(zzas.zzci)) {
            zza2.zzp().zzc();
            zza2.zzn();
            Preconditions.checkNotEmpty(zzn.zza);
            zzac zza3 = zzac.zza(zzn.zzw);
            zzac zza4 = zza2.zza(zzn.zza);
            zza2.zzq().zzw().zza("Setting consent, package, consent", zzn.zza, zza3);
            zza2.zza(zzn.zza, zza3);
            if (zza3.zza(zza4)) {
                zza2.zza(zzn);
            }
        }
    }
}
