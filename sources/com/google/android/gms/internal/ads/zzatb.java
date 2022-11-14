package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzatb {
    public final int zza;
    public final zzank[] zzb;
    public int zzc;

    public zzatb(zzank... zzankArr) {
        int length = zzankArr.length;
        zzaul.zzd(length > 0);
        this.zzb = zzankArr;
        this.zza = length;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzatb.class == obj.getClass()) {
            zzatb zzatb = (zzatb) obj;
            return this.zza == zzatb.zza && Arrays.equals(this.zzb, zzatb.zzb);
        }
    }

    public final int hashCode() {
        int i = this.zzc;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.zzb) + 527;
        this.zzc = hashCode;
        return hashCode;
    }

    public final zzank zza(int i) {
        return this.zzb[i];
    }

    public final int zzb(zzank zzank) {
        int i = 0;
        while (true) {
            zzank[] zzankArr = this.zzb;
            if (i >= zzankArr.length) {
                return -1;
            }
            if (zzank == zzankArr[i]) {
                return i;
            }
            i++;
        }
    }
}
