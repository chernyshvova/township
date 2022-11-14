package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.MainThread;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zzjq;
import com.google.android.gms.measurement.internal.zzju;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class AppMeasurementService extends Service implements zzju {
    public zzjq<AppMeasurementService> zza;

    private final zzjq<AppMeasurementService> zza() {
        if (this.zza == null) {
            this.zza = new zzjq<>(this);
        }
        return this.zza;
    }

    @MainThread
    public final IBinder onBind(Intent intent) {
        return zza().zza(intent);
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

    @MainThread
    public final int onStartCommand(Intent intent, int i, int i2) {
        return zza().zza(intent, i, i2);
    }

    @MainThread
    public final boolean onUnbind(Intent intent) {
        return zza().zzb(intent);
    }

    public final boolean zza(int i) {
        return stopSelfResult(i);
    }

    public final void zza(JobParameters jobParameters, boolean z) {
        throw new UnsupportedOperationException();
    }

    public final void zza(Intent intent) {
        WakefulBroadcastReceiver.completeWakefulIntent(intent);
    }
}
