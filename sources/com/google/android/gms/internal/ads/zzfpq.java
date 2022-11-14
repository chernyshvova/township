package com.google.android.gms.internal.ads;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public abstract class zzfpq<T> extends zzfqm<T> {
    public final Executor zza;
    public final /* synthetic */ zzfpr zzb;

    public zzfpq(zzfpr zzfpr, Executor executor) {
        this.zzb = zzfpr;
        if (executor != null) {
            this.zza = executor;
            return;
        }
        throw null;
    }

    public abstract void zzb(T t);

    public final boolean zzd() {
        return this.zzb.isDone();
    }

    public final void zze() {
        try {
            this.zza.execute(this);
        } catch (RejectedExecutionException e) {
            this.zzb.zzi(e);
        }
    }

    public final void zzf(T t) {
        zzfpq unused = this.zzb.zza = null;
        zzb(t);
    }

    public final void zzg(Throwable th) {
        zzfpq unused = this.zzb.zza = null;
        if (th instanceof ExecutionException) {
            this.zzb.zzi(((ExecutionException) th).getCause());
        } else if (th instanceof CancellationException) {
            this.zzb.cancel(false);
        } else {
            this.zzb.zzi(th);
        }
    }
}
