package com.google.android.gms.internal.ads;

import androidx.annotation.GuardedBy;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzale {
    @GuardedBy("this")
    public long zza = 0;
    @GuardedBy("this")
    public long zzb;
    @GuardedBy("this")
    public long zzc = -9223372036854775807L;

    public zzale(long j) {
    }

    public final synchronized long zza() {
        return this.zza;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized long zzb() {
        /*
            r7 = this;
            monitor-enter(r7)
            long r0 = r7.zzc     // Catch:{ all -> 0x001f }
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0010
            long r2 = r7.zzb     // Catch:{ all -> 0x001f }
            long r2 = r2 + r0
            goto L_0x001b
        L_0x0010:
            long r0 = r7.zza     // Catch:{ all -> 0x001f }
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x001d
        L_0x001b:
            monitor-exit(r7)
            return r2
        L_0x001d:
            monitor-exit(r7)
            return r0
        L_0x001f:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzale.zzb():long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001b, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized long zzc() {
        /*
            r7 = this;
            monitor-enter(r7)
            long r0 = r7.zza     // Catch:{ all -> 0x0020 }
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x0014
            r4 = 0
            goto L_0x001a
        L_0x0014:
            long r0 = r7.zzc     // Catch:{ all -> 0x0020 }
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x001c
        L_0x001a:
            monitor-exit(r7)
            return r4
        L_0x001c:
            long r0 = r7.zzb     // Catch:{ all -> 0x0020 }
            monitor-exit(r7)
            return r0
        L_0x0020:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzale.zzc():long");
    }

    public final synchronized void zzd(long j) {
        this.zza = j;
        this.zzc = -9223372036854775807L;
    }

    public final synchronized long zze(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long j2 = this.zzc;
        if (j2 != -9223372036854775807L) {
            long j3 = (j2 * 90000) / 1000000;
            long j4 = (AnimatedStateListDrawableCompat.AnimatedStateListState.REVERSED_BIT + j3) / AnimatedStateListDrawableCompat.AnimatedStateListState.REVERSIBLE_FLAG_BIT;
            long j5 = ((-1 + j4) * AnimatedStateListDrawableCompat.AnimatedStateListState.REVERSIBLE_FLAG_BIT) + j;
            long j6 = (j4 * AnimatedStateListDrawableCompat.AnimatedStateListState.REVERSIBLE_FLAG_BIT) + j;
            j = Math.abs(j5 - j3) < Math.abs(j6 - j3) ? j5 : j6;
        }
        return zzf((j * 1000000) / 90000);
    }

    public final synchronized long zzf(long j) {
        if (this.zzc != -9223372036854775807L) {
            this.zzc = j;
        } else {
            long j2 = this.zza;
            if (j2 != RecyclerView.FOREVER_NS) {
                this.zzb = j2 - j;
            }
            this.zzc = j;
            notifyAll();
        }
        return j + this.zzb;
    }
}
