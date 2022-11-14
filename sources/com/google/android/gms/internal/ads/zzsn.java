package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzsn implements zztv {
    public final zzsq zza;
    public final long zzb;
    public final long zzc;
    public final long zzd;
    public final long zze;
    public final long zzf;

    public zzsn(zzsq zzsq, long j, long j2, long j3, long j4, long j5, long j6) {
        this.zza = zzsq;
        this.zzb = j;
        this.zzc = j3;
        this.zzd = j4;
        this.zze = j5;
        this.zzf = j6;
    }

    public final boolean zza() {
        return true;
    }

    public final zztt zzb(long j) {
        zztw zztw = new zztw(j, zzsp.zza(this.zza.zza(j), 0, this.zzc, this.zzd, this.zze, this.zzf));
        return new zztt(zztw, zztw);
    }

    public final long zzc() {
        return this.zzb;
    }

    public final long zzd(long j) {
        return this.zza.zza(j);
    }
}
