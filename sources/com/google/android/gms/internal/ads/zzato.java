package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzato {
    public int zza;
    public final zzatg[] zzb;

    public zzato(zzatg[] zzatgArr, byte... bArr) {
        this.zzb = zzatgArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzato.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.zzb, ((zzato) obj).zzb);
    }

    public final int hashCode() {
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.zzb) + 527;
        this.zza = hashCode;
        return hashCode;
    }

    public final zzatg zza(int i) {
        return this.zzb[i];
    }

    public final zzatg[] zzb() {
        return (zzatg[]) this.zzb.clone();
    }
}
