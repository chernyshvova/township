package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzatc {
    public static final zzatc zza = new zzatc(new zzatb[0]);
    public final int zzb;
    public final zzatb[] zzc;
    public int zzd;

    public zzatc(zzatb... zzatbArr) {
        this.zzc = zzatbArr;
        this.zzb = zzatbArr.length;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzatc.class == obj.getClass()) {
            zzatc zzatc = (zzatc) obj;
            return this.zzb == zzatc.zzb && Arrays.equals(this.zzc, zzatc.zzc);
        }
    }

    public final int hashCode() {
        int i = this.zzd;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.zzc);
        this.zzd = hashCode;
        return hashCode;
    }

    public final zzatb zza(int i) {
        return this.zzc[i];
    }

    public final int zzb(zzatb zzatb) {
        for (int i = 0; i < this.zzb; i++) {
            if (this.zzc[i] == zzatb) {
                return i;
            }
        }
        return -1;
    }
}
