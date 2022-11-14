package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzatg {
    public final zzatb zza;
    public final int zzb;
    public final int[] zzc;
    public final zzank[] zzd;
    public int zze;

    public zzatg(zzatb zzatb, int... iArr) {
        int length = iArr.length;
        zzaul.zzd(length > 0);
        if (zzatb != null) {
            this.zza = zzatb;
            this.zzb = length;
            this.zzd = new zzank[length];
            for (int i = 0; i < iArr.length; i++) {
                this.zzd[i] = zzatb.zza(iArr[i]);
            }
            Arrays.sort(this.zzd, new zzatf((zzate) null));
            this.zzc = new int[this.zzb];
            for (int i2 = 0; i2 < this.zzb; i2++) {
                this.zzc[i2] = zzatb.zzb(this.zzd[i2]);
            }
            return;
        }
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzatg zzatg = (zzatg) obj;
            return this.zza == zzatg.zza && Arrays.equals(this.zzc, zzatg.zzc);
        }
    }

    public final int hashCode() {
        int i = this.zze;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.zzc) + (System.identityHashCode(this.zza) * 31);
        this.zze = hashCode;
        return hashCode;
    }

    public final zzatb zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zzc.length;
    }

    public final zzank zzc(int i) {
        return this.zzd[i];
    }

    public final int zzd(int i) {
        return this.zzc[0];
    }
}
