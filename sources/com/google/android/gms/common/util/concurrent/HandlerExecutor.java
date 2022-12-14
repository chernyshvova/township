package com.google.android.gms.common.util.concurrent;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.common.zzh;
import java.util.concurrent.Executor;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class HandlerExecutor implements Executor {
    public final Handler zza;

    @KeepForSdk
    public HandlerExecutor(@RecentlyNonNull Looper looper) {
        this.zza = new zzh(looper);
    }

    public final void execute(@RecentlyNonNull Runnable runnable) {
        this.zza.post(runnable);
    }
}
