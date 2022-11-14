package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final /* synthetic */ class zzjs implements Runnable {
    public final zzjq zza;
    public final zzeq zzb;
    public final JobParameters zzc;

    public zzjs(zzjq zzjq, zzeq zzeq, JobParameters jobParameters) {
        this.zza = zzjq;
        this.zzb = zzeq;
        this.zzc = jobParameters;
    }

    public final void run() {
        this.zza.zza(this.zzb, this.zzc);
    }
}
