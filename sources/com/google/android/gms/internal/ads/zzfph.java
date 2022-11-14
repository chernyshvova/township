package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfph extends zzfpg {
    public final AtomicReferenceFieldUpdater<zzfpj<?>, Set<Throwable>> zza;
    public final AtomicIntegerFieldUpdater<zzfpj<?>> zzb;

    public zzfph(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
        super((zzfpf) null);
        this.zza = atomicReferenceFieldUpdater;
        this.zzb = atomicIntegerFieldUpdater;
    }

    public final void zza(zzfpj<?> zzfpj, @CheckForNull Set<Throwable> set, Set<Throwable> set2) {
        this.zza.compareAndSet(zzfpj, (Object) null, set2);
    }

    public final int zzb(zzfpj<?> zzfpj) {
        return this.zzb.decrementAndGet(zzfpj);
    }
}
