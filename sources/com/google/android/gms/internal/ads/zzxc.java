package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzxc implements zzxi {
    public final zztn zza;
    public final zztm zzb;
    public long zzc = -1;
    public long zzd = -1;

    public zzxc(zztn zztn, zztm zztm) {
        this.zza = zztn;
        this.zzb = zztm;
    }

    public final long zza(zztb zztb) {
        long j = this.zzd;
        if (j < 0) {
            return -1;
        }
        this.zzd = -1;
        return -(j + 2);
    }

    public final void zzb(long j) {
        long[] jArr = this.zzb.zza;
        this.zzd = jArr[zzalh.zzD(jArr, j, true, true)];
    }

    public final zztv zzc() {
        zzajg.zzd(this.zzc != -1);
        return new zztl(this.zza, this.zzc);
    }

    public final void zzd(long j) {
        this.zzc = j;
    }
}
