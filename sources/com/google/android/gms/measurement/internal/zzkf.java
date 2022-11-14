package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzms;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzkf {
    public final /* synthetic */ zzjx zza;

    public zzkf(zzjx zzjx) {
        this.zza = zzjx;
    }

    @WorkerThread
    @VisibleForTesting
    private final void zzb(long j, boolean z) {
        this.zza.zzc();
        if (this.zza.zzy.zzaa()) {
            this.zza.zzr().zzp.zza(j);
            this.zza.zzq().zzw().zza("Session started, time", Long.valueOf(this.zza.zzl().elapsedRealtime()));
            Long valueOf = Long.valueOf(j / 1000);
            this.zza.zze().zza("auto", "_sid", (Object) valueOf, j);
            this.zza.zzr().zzm.zza(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", valueOf.longValue());
            if (this.zza.zzs().zza(zzas.zzbj) && z) {
                bundle.putLong("_aib", 1);
            }
            this.zza.zze().zza("auto", "_s", j, bundle);
            if (zzms.zzb() && this.zza.zzs().zza(zzas.zzbo)) {
                String zza2 = this.zza.zzr().zzu.zza();
                if (!TextUtils.isEmpty(zza2)) {
                    this.zza.zze().zza("auto", "_ssr", j, GeneratedOutlineSupport.outline5("_ffr", zza2));
                }
            }
        }
    }

    @WorkerThread
    public final void zza() {
        this.zza.zzc();
        if (this.zza.zzr().zza(this.zza.zzl().currentTimeMillis())) {
            this.zza.zzr().zzm.zza(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                this.zza.zzq().zzw().zza("Detected application was in foreground");
                zzb(this.zza.zzl().currentTimeMillis(), false);
            }
        }
    }

    @WorkerThread
    public final void zza(long j, boolean z) {
        this.zza.zzc();
        this.zza.zzaa();
        if (this.zza.zzr().zza(j)) {
            this.zza.zzr().zzm.zza(true);
        }
        this.zza.zzr().zzp.zza(j);
        if (this.zza.zzr().zzm.zza()) {
            zzb(j, z);
        }
    }
}
