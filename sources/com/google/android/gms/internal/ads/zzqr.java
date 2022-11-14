package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import java.lang.Exception;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzqr<T extends Exception> {
    @Nullable
    public T zza;
    public long zzb;

    public zzqr(long j) {
    }

    public final void zza(T t) throws Exception {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.zza == null) {
            this.zza = t;
            this.zzb = 100 + elapsedRealtime;
        }
        if (elapsedRealtime >= this.zzb) {
            T t2 = this.zza;
            if (t2 != t) {
                zzgcg.zza(t2, t);
            }
            T t3 = this.zza;
            this.zza = null;
            throw t3;
        }
    }

    public final void zzb() {
        this.zza = null;
    }
}
