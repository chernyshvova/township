package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.ads.internal.util.zzf;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzchc implements Executor {
    public final Handler zza = new zzf(Looper.getMainLooper());

    public final void execute(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            try {
                runnable.run();
            } catch (Throwable th) {
                zzs.zzc();
                zzr.zzO(zzs.zzg().zzm(), th);
                throw th;
            }
        } else {
            this.zza.post(runnable);
        }
    }
}
