package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfqc<V> implements Runnable {
    public final Future<V> zza;
    public final zzfqa<? super V> zzb;

    public zzfqc(Future<V> future, zzfqa<? super V> zzfqa) {
        this.zza = future;
        this.zzb = zzfqa;
    }

    public final void run() {
        Throwable zza2;
        Future<V> future = this.zza;
        if (!(future instanceof zzfrf) || (zza2 = zzfrg.zza((zzfrf) future)) == null) {
            try {
                this.zzb.zzb(zzfqe.zzq(this.zza));
            } catch (ExecutionException e) {
                this.zzb.zza(e.getCause());
            } catch (Error | RuntimeException e2) {
                this.zzb.zza(e2);
            }
        } else {
            this.zzb.zza(zza2);
        }
    }

    public final String toString() {
        zzfjy zza2 = zzfjz.zza(this);
        zza2.zza(this.zzb);
        return zza2.toString();
    }
}
