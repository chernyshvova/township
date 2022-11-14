package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzjy {
    public final /* synthetic */ zzjx zza;
    public zzkb zzb;

    public zzjy(zzjx zzjx) {
        this.zza = zzjx;
    }

    @WorkerThread
    public final void zza() {
        this.zza.zzc();
        if (this.zzb != null) {
            this.zza.zzc.removeCallbacks(this.zzb);
        }
        if (this.zza.zzs().zza(zzas.zzbu)) {
            this.zza.zzr().zzr.zza(false);
        }
    }

    @WorkerThread
    public final void zza(long j) {
        this.zzb = new zzkb(this, this.zza.zzl().currentTimeMillis(), j);
        this.zza.zzc.postDelayed(this.zzb, 2000);
    }
}
