package com.google.android.gms.cloudmessaging;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.internal.cloudmessaging.zza;
import com.google.android.gms.internal.cloudmessaging.zzf;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
public final class zze {
    @GuardedBy("MessengerIpcClient.class")
    @Nullable
    public static zze zza;
    public final Context zzb;
    public final ScheduledExecutorService zzc;
    @GuardedBy("this")
    public zzf zzd = new zzf(this);
    @GuardedBy("this")
    public int zze = 1;

    @VisibleForTesting
    public zze(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.zzc = scheduledExecutorService;
        this.zzb = context.getApplicationContext();
    }

    public static synchronized zze zza(Context context) {
        zze zze2;
        synchronized (zze.class) {
            if (zza == null) {
                zza = new zze(context, zza.zza().zza(1, new NamedThreadFactory("MessengerIpcClient"), zzf.zzb));
            }
            zze2 = zza;
        }
        return zze2;
    }

    public final Task<Bundle> zzb(int i, Bundle bundle) {
        return zza(new zzs(zza(), 1, bundle));
    }

    public final Task<Void> zza(int i, Bundle bundle) {
        return zza(new zzn(zza(), 2, bundle));
    }

    private final synchronized <T> Task<T> zza(zzq<T> zzq) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(zzq);
            StringBuilder sb = new StringBuilder(valueOf.length() + 9);
            sb.append("Queueing ");
            sb.append(valueOf);
            Log.d("MessengerIpcClient", sb.toString());
        }
        if (!this.zzd.zza((zzq<?>) zzq)) {
            zzf zzf = new zzf(this);
            this.zzd = zzf;
            zzf.zza((zzq<?>) zzq);
        }
        return zzq.zzb.getTask();
    }

    private final synchronized int zza() {
        int i;
        i = this.zze;
        this.zze = i + 1;
        return i;
    }
}
