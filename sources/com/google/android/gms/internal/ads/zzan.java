package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzan {
    public static final boolean zza = zzao.zzb;
    public final List<zzam> zzb = new ArrayList();
    public boolean zzc = false;

    public final void finalize() throws Throwable {
        if (!this.zzc) {
            zzb("Request on the loose");
            zzao.zzc("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }
    }

    public final synchronized void zza(String str, long j) {
        if (!this.zzc) {
            this.zzb.add(new zzam(str, j, SystemClock.elapsedRealtime()));
        } else {
            throw new IllegalStateException("Marker added to finished log");
        }
    }

    public final synchronized void zzb(String str) {
        long j;
        this.zzc = true;
        if (this.zzb.size() == 0) {
            j = 0;
        } else {
            long j2 = this.zzb.get(0).zzc;
            List<zzam> list = this.zzb;
            j = list.get(list.size() - 1).zzc - j2;
        }
        if (j > 0) {
            long j3 = this.zzb.get(0).zzc;
            zzao.zzb("(%-4d ms) %s", Long.valueOf(j), str);
            for (zzam next : this.zzb) {
                long j4 = next.zzc;
                zzao.zzb("(+%-4d) [%2d] %s", Long.valueOf(j4 - j3), Long.valueOf(next.zzb), next.zza);
                j3 = j4;
            }
        }
    }
}
