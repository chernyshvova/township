package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfqp implements Executor {
    public final /* synthetic */ Executor zza;
    public final /* synthetic */ zzfox zzb;

    public zzfqp(Executor executor, zzfox zzfox) {
        this.zza = executor;
        this.zzb = zzfox;
    }

    public final void execute(Runnable runnable) {
        try {
            this.zza.execute(runnable);
        } catch (RejectedExecutionException e) {
            this.zzb.zzi(e);
        }
    }
}
