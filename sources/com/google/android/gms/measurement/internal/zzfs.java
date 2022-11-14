package com.google.android.gms.measurement.internal;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzm;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzfs<V> extends FutureTask<V> implements Comparable<zzfs<V>> {
    public final boolean zza;
    public final long zzb;
    public final String zzc;
    public final /* synthetic */ zzfr zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfs(zzfr zzfr, Callable<V> callable, boolean z, String str) {
        super(zzm.zza().zza(callable));
        this.zzd = zzfr;
        Preconditions.checkNotNull(str);
        long andIncrement = zzfr.zzj.getAndIncrement();
        this.zzb = andIncrement;
        this.zzc = str;
        this.zza = z;
        if (andIncrement == RecyclerView.FOREVER_NS) {
            zzfr.zzq().zze().zza("Tasks index overflow");
        }
    }

    public final /* synthetic */ int compareTo(@NonNull Object obj) {
        zzfs zzfs = (zzfs) obj;
        boolean z = this.zza;
        if (z != zzfs.zza) {
            return z ? -1 : 1;
        }
        long j = this.zzb;
        long j2 = zzfs.zzb;
        if (j < j2) {
            return -1;
        }
        if (j > j2) {
            return 1;
        }
        this.zzd.zzq().zzf().zza("Two tasks share the same index. index", Long.valueOf(this.zzb));
        return 0;
    }

    public final void setException(Throwable th) {
        this.zzd.zzq().zze().zza(this.zzc, th);
        if (th instanceof zzfq) {
            Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
        }
        super.setException(th);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfs(zzfr zzfr, Runnable runnable, boolean z, String str) {
        super(zzm.zza().zza(runnable), (Object) null);
        this.zzd = zzfr;
        Preconditions.checkNotNull(str);
        long andIncrement = zzfr.zzj.getAndIncrement();
        this.zzb = andIncrement;
        this.zzc = str;
        this.zza = z;
        if (andIncrement == RecyclerView.FOREVER_NS) {
            zzfr.zzq().zze().zza("Tasks index overflow");
        }
    }
}
