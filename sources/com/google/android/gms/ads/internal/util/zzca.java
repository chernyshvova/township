package com.google.android.gms.ads.internal.util;

import com.google.android.gms.ads.internal.zzs;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzca {
    public long zza;
    @GuardedBy("lock")
    public long zzb = Long.MIN_VALUE;
    public final Object zzc = new Object();

    public zzca(long j) {
        this.zza = j;
    }

    public final boolean zza() {
        synchronized (this.zzc) {
            long elapsedRealtime = zzs.zzj().elapsedRealtime();
            if (this.zzb + this.zza > elapsedRealtime) {
                return false;
            }
            this.zzb = elapsedRealtime;
            return true;
        }
    }

    public final void zzb(long j) {
        synchronized (this.zzc) {
            this.zza = j;
        }
    }
}
