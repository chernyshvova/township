package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfpr<V> extends zzfpe<Object, V> {
    @CheckForNull
    public zzfpq<?> zza;

    public zzfpr(zzfmg<? extends zzfqn<?>> zzfmg, boolean z, Executor executor, Callable<V> callable) {
        super(zzfmg, z, false);
        this.zza = new zzfpp(this, callable, executor);
        zza();
    }

    public final void zzB(int i) {
        super.zzB(i);
        if (i == 1) {
            this.zza = null;
        }
    }

    public final void zzf() {
        zzfpq<?> zzfpq = this.zza;
        if (zzfpq != null) {
            zzfpq.zzh();
        }
    }

    public final void zzw(int i, @CheckForNull Object obj) {
    }

    public final void zzx() {
        zzfpq<?> zzfpq = this.zza;
        if (zzfpq != null) {
            zzfpq.zze();
        }
    }
}
