package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzs;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeqs<T> {
    public final Set<zzeqp<? extends zzeqo<T>>> zza;
    public final Executor zzb;

    public zzeqs(Executor executor, Set<zzeqp<? extends zzeqo<T>>> set) {
        this.zzb = executor;
        this.zza = set;
    }

    public final zzfqn<T> zza(T t) {
        ArrayList arrayList = new ArrayList(this.zza.size());
        for (zzeqp next : this.zza) {
            zzfqn zza2 = next.zza();
            if (zzblc.zza.zze().booleanValue()) {
                zza2.zze(new zzeqq(next, zzs.zzj().elapsedRealtime()), zzche.zzf);
            }
            arrayList.add(zza2);
        }
        return zzfqe.zzo(arrayList).zza(new zzeqr(arrayList, t), this.zzb);
    }
}
