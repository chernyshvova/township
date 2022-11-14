package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zztr implements zztv {
    public final long[] zza;
    public final long[] zzb;
    public final long zzc;
    public final boolean zzd;

    public zztr(long[] jArr, long[] jArr2, long j) {
        int length = jArr.length;
        int length2 = jArr2.length;
        zzajg.zza(length == length2);
        boolean z = length2 > 0;
        this.zzd = z;
        if (!z || jArr2[0] <= 0) {
            this.zza = jArr;
            this.zzb = jArr2;
        } else {
            int i = length2 + 1;
            long[] jArr3 = new long[i];
            this.zza = jArr3;
            this.zzb = new long[i];
            System.arraycopy(jArr, 0, jArr3, 1, length2);
            System.arraycopy(jArr2, 0, this.zzb, 1, length2);
        }
        this.zzc = j;
    }

    public final boolean zza() {
        return this.zzd;
    }

    public final zztt zzb(long j) {
        if (!this.zzd) {
            zztw zztw = zztw.zza;
            return new zztt(zztw, zztw);
        }
        int zzD = zzalh.zzD(this.zzb, j, true, true);
        zztw zztw2 = new zztw(this.zzb[zzD], this.zza[zzD]);
        if (zztw2.zzb != j) {
            long[] jArr = this.zzb;
            if (zzD != jArr.length - 1) {
                int i = zzD + 1;
                return new zztt(zztw2, new zztw(jArr[i], this.zza[i]));
            }
        }
        return new zztt(zztw2, zztw2);
    }

    public final long zzc() {
        return this.zzc;
    }
}
