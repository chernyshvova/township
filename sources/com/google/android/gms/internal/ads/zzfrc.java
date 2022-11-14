package com.google.android.gms.internal.ads;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfrc<V> extends zzfpu<V> implements RunnableFuture<V> {
    @CheckForNull
    public volatile zzfqm<?> zza;

    public zzfrc(zzfpk<V> zzfpk) {
        this.zza = new zzfra(this, zzfpk);
    }

    public static <V> zzfrc<V> zza(Runnable runnable, V v) {
        return new zzfrc<>(Executors.callable(runnable, v));
    }

    public final void run() {
        zzfqm<?> zzfqm = this.zza;
        if (zzfqm != null) {
            zzfqm.run();
        }
        this.zza = null;
    }

    @CheckForNull
    public final String zzc() {
        zzfqm<?> zzfqm = this.zza;
        if (zzfqm == null) {
            return super.zzc();
        }
        String valueOf = String.valueOf(zzfqm);
        return GeneratedOutlineSupport.outline19(new StringBuilder(valueOf.length() + 7), "task=[", valueOf, "]");
    }

    public final void zzd() {
        zzfqm<?> zzfqm;
        if (zzg() && (zzfqm = this.zza) != null) {
            zzfqm.zzh();
        }
        this.zza = null;
    }

    public zzfrc(Callable<V> callable) {
        this.zza = new zzfrb(this, callable);
    }
}
