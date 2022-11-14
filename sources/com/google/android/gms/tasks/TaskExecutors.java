package com.google.android.gms.tasks;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.tasks.zzb;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
public final class TaskExecutors {
    public static final Executor MAIN_THREAD = new zza();
    public static final Executor zza = new zzt();

    /* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
    public static final class zza implements Executor {
        public final Handler zza = new zzb(Looper.getMainLooper());

        public final void execute(@NonNull Runnable runnable) {
            this.zza.post(runnable);
        }
    }
}
