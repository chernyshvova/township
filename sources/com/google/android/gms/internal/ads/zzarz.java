package com.google.android.gms.internal.ads;

import androidx.recyclerview.widget.RecyclerView;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzarz implements zzasz {
    public final zzasz[] zza;

    public zzarz(zzasz[] zzaszArr) {
        this.zza = zzaszArr;
    }

    public final long zza() {
        long j = Long.MAX_VALUE;
        for (zzasz zza2 : this.zza) {
            long zza3 = zza2.zza();
            if (zza3 != Long.MIN_VALUE) {
                j = Math.min(j, zza3);
            }
        }
        if (j == RecyclerView.FOREVER_NS) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    public final boolean zzb(long j) {
        boolean z;
        boolean z2 = false;
        do {
            long zza2 = zza();
            if (zza2 == Long.MIN_VALUE) {
                break;
            }
            z = false;
            for (zzasz zzasz : this.zza) {
                if (zzasz.zza() == zza2) {
                    z |= zzasz.zzb(j);
                }
            }
            z2 |= z;
        } while (z);
        return z2;
    }
}
