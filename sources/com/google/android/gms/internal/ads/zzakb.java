package com.google.android.gms.internal.ads;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzakb {
    public int zza;
    public long[] zzb;

    public zzakb() {
        this(32);
    }

    public zzakb(int i) {
        this.zzb = new long[32];
    }

    public final void zza(long j) {
        int i = this.zza;
        long[] jArr = this.zzb;
        if (i == jArr.length) {
            this.zzb = Arrays.copyOf(jArr, i + i);
        }
        long[] jArr2 = this.zzb;
        int i2 = this.zza;
        this.zza = i2 + 1;
        jArr2[i2] = j;
    }

    public final long zzb(int i) {
        if (i >= 0 && i < this.zza) {
            return this.zzb[i];
        }
        throw new IndexOutOfBoundsException(GeneratedOutlineSupport.outline11(46, "Invalid index ", i, ", size is ", this.zza));
    }

    public final int zzc() {
        return this.zza;
    }
}
