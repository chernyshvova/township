package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaaa implements zztv {
    public final zzzx zza;
    public final int zzb;
    public final long zzc;
    public final long zzd;
    public final long zze;

    public zzaaa(zzzx zzzx, int i, long j, long j2) {
        this.zza = zzzx;
        this.zzb = i;
        this.zzc = j;
        long j3 = (j2 - j) / ((long) zzzx.zzd);
        this.zzd = j3;
        this.zze = zzd(j3);
    }

    private final long zzd(long j) {
        return zzalh.zzF(j * ((long) this.zzb), 1000000, (long) this.zza.zzc);
    }

    public final boolean zza() {
        return true;
    }

    public final zztt zzb(long j) {
        long zzy = zzalh.zzy((((long) this.zza.zzc) * j) / (((long) this.zzb) * 1000000), 0, this.zzd - 1);
        long j2 = this.zzc;
        int i = this.zza.zzd;
        long zzd2 = zzd(zzy);
        zztw zztw = new zztw(zzd2, (((long) i) * zzy) + j2);
        if (zzd2 >= j || zzy == this.zzd - 1) {
            return new zztt(zztw, zztw);
        }
        long j3 = zzy + 1;
        return new zztt(zztw, new zztw(zzd(j3), (j3 * ((long) this.zza.zzd)) + this.zzc));
    }

    public final long zzc() {
        return this.zze;
    }
}
