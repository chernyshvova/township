package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzqt implements Executor {
    public final Handler zza;

    public zzqt(Handler handler) {
        this.zza = handler;
    }

    public static Executor zza(Handler handler) {
        return new zzqt(handler);
    }

    public final void execute(Runnable runnable) {
        this.zza.post(runnable);
    }
}
