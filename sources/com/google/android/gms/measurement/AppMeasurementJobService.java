package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import androidx.annotation.MainThread;
import com.google.android.gms.measurement.internal.zzjq;
import com.google.android.gms.measurement.internal.zzju;

@TargetApi(24)
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class AppMeasurementJobService extends JobService implements zzju {
    public zzjq<AppMeasurementJobService> zza;

    private final zzjq<AppMeasurementJobService> zza() {
        if (this.zza == null) {
            this.zza = new zzjq<>(this);
        }
        return this.zza;
    }

    @MainThread
    public final void onCreate() {
        super.onCreate();
        zza().zza();
    }

    @MainThread
    public final void onDestroy() {
        zza().zzb();
        super.onDestroy();
    }

    @MainThread
    public final void onRebind(Intent intent) {
        zza().zzc(intent);
    }

    public final boolean onStartJob(JobParameters jobParameters) {
        return zza().zza(jobParameters);
    }

    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    @MainThread
    public final boolean onUnbind(Intent intent) {
        return zza().zzb(intent);
    }

    public final void zza(Intent intent) {
    }

    public final boolean zza(int i) {
        throw new UnsupportedOperationException();
    }

    @TargetApi(24)
    public final void zza(JobParameters jobParameters, boolean z) {
        jobFinished(jobParameters, false);
    }
}
