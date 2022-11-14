package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzagf {
    public final zzafr zza;
    public final int zzb;
    public final int[] zzc;
    public final zzkc[] zzd;
    public int zze;

    public zzagf(zzafr zzafr, int[] iArr, int i) {
        int length = iArr.length;
        zzajg.zzd(length > 0);
        if (zzafr != null) {
            this.zza = zzafr;
            this.zzb = length;
            this.zzd = new zzkc[length];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                this.zzd[i2] = zzafr.zza(iArr[i2]);
            }
            Arrays.sort(this.zzd, zzage.zza);
            this.zzc = new int[this.zzb];
            for (int i3 = 0; i3 < this.zzb; i3++) {
                this.zzc[i3] = zzafr.zzb(this.zzd[i3]);
            }
            return;
        }
        throw null;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzagf zzagf = (zzagf) obj;
            return this.zza == zzagf.zza && Arrays.equals(this.zzc, zzagf.zzc);
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

    public final zzafr zzb() {
        return this.zza;
    }

    public final int zzc() {
        return this.zzc.length;
    }

    public final zzkc zzd(int i) {
        return this.zzd[i];
    }

    public final int zze(int i) {
        return this.zzc[0];
    }
}
