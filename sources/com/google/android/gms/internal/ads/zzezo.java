package com.google.android.gms.internal.ads;

import java.util.Deque;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzezo<T> {
    @GuardedBy("this")
    public final Deque<zzfqn<T>> zza = new LinkedBlockingDeque();
    public final Callable<T> zzb;
    public final zzfqo zzc;

    public zzezo(Callable<T> callable, zzfqo zzfqo) {
        this.zzb = callable;
        this.zzc = zzfqo;
    }

    public final synchronized void zza(int i) {
        int size = i - this.zza.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.zza.add(this.zzc.zzb(this.zzb));
        }
    }

    public final synchronized zzfqn<T> zzb() {
        zza(1);
        return this.zza.poll();
    }

    public final synchronized void zzc(zzfqn<T> zzfqn) {
        this.zza.addFirst(zzfqn);
    }
}
