package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.MainThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzae;
import com.google.android.gms.measurement.internal.zzju;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class zzjq<T extends Context & zzju> {
    public final T zza;

    public zzjq(T t) {
        Preconditions.checkNotNull(t);
        this.zza = t;
    }

    @MainThread
    public final void zza() {
        zzfu.zza(this.zza, (zzae) null, (Long) null).zzq().zzw().zza("Local AppMeasurementService is starting up");
    }

    @MainThread
    public final void zzb() {
        zzfu.zza(this.zza, (zzae) null, (Long) null).zzq().zzw().zza("Local AppMeasurementService is shutting down");
    }

    @MainThread
    public final void zzc(Intent intent) {
        if (intent == null) {
            zzc().zze().zza("onRebind called with null intent");
            return;
        }
        zzc().zzw().zza("onRebind called. action", intent.getAction());
    }

    private final zzeq zzc() {
        return zzfu.zza(this.zza, (zzae) null, (Long) null).zzq();
    }

    @MainThread
    public final int zza(Intent intent, int i, int i2) {
        zzeq zzq = zzfu.zza(this.zza, (zzae) null, (Long) null).zzq();
        if (intent == null) {
            zzq.zzh().zza("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        zzq.zzw().zza("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            zza((Runnable) new zzjt(this, i2, zzq, intent));
        }
        return 2;
    }

    @MainThread
    public final boolean zzb(Intent intent) {
        if (intent == null) {
            zzc().zze().zza("onUnbind called with null intent");
            return true;
        }
        zzc().zzw().zza("onUnbind called for intent. action", intent.getAction());
        return true;
    }

    private final void zza(Runnable runnable) {
        zzkl zza2 = zzkl.zza((Context) this.zza);
        zza2.zzp().zza((Runnable) new zzjv(this, zza2, runnable));
    }

    @MainThread
    public final IBinder zza(Intent intent) {
        if (intent == null) {
            zzc().zze().zza("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzfz(zzkl.zza((Context) this.zza));
        }
        zzc().zzh().zza("onBind received unknown action", action);
        return null;
    }

    @TargetApi(24)
    @MainThread
    public final boolean zza(JobParameters jobParameters) {
        zzeq zzq = zzfu.zza(this.zza, (zzae) null, (Long) null).zzq();
        String string = jobParameters.getExtras().getString("action");
        zzq.zzw().zza("Local AppMeasurementJobService called. action", string);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        zza((Runnable) new zzjs(this, zzq, jobParameters));
        return true;
    }

    public final /* synthetic */ void zza(zzeq zzeq, JobParameters jobParameters) {
        zzeq.zzw().zza("AppMeasurementJobService processed last upload request.");
        ((zzju) this.zza).zza(jobParameters, false);
    }

    public final /* synthetic */ void zza(int i, zzeq zzeq, Intent intent) {
        if (((zzju) this.zza).zza(i)) {
            zzeq.zzw().zza("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i));
            zzc().zzw().zza("Completed wakeful intent.");
            ((zzju) this.zza).zza(intent);
        }
    }
}
