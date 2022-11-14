package com.google.android.gms.internal.ads;

import androidx.recyclerview.widget.RecyclerView;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzadg implements zzafl {
    public final zzafl[] zza;

    public zzadg(zzafl[] zzaflArr) {
        this.zza = zzaflArr;
    }

    public final void zzf(long j) {
        for (zzafl zzf : this.zza) {
            zzf.zzf(j);
        }
    }

    public final long zzh() {
        long j = Long.MAX_VALUE;
        for (zzafl zzh : this.zza) {
            long zzh2 = zzh.zzh();
            if (zzh2 != Long.MIN_VALUE) {
                j = Math.min(j, zzh2);
            }
        }
        if (j == RecyclerView.FOREVER_NS) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    public final long zzl() {
        long j = Long.MAX_VALUE;
        for (zzafl zzl : this.zza) {
            long zzl2 = zzl.zzl();
            if (zzl2 != Long.MIN_VALUE) {
                j = Math.min(j, zzl2);
            }
        }
        if (j == RecyclerView.FOREVER_NS) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    public final boolean zzn(long j) {
        long j2 = j;
        boolean z = false;
        while (true) {
            long zzl = zzl();
            if (zzl != Long.MIN_VALUE) {
                boolean z2 = false;
                for (zzafl zzafl : this.zza) {
                    long zzl2 = zzafl.zzl();
                    boolean z3 = zzl2 != Long.MIN_VALUE && zzl2 <= j2;
                    if (zzl2 == zzl || z3) {
                        z2 |= zzafl.zzn(j2);
                    }
                }
                z |= z2;
                if (!z2) {
                    break;
                }
            } else {
                break;
            }
        }
        return z;
    }

    public final boolean zzo() {
        for (zzafl zzo : this.zza) {
            if (zzo.zzo()) {
                return true;
            }
        }
        return false;
    }
}
