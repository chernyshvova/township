package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzebl implements zzddy, zzdcr, zzdbg {
    public final zzfdg zza;
    public final zzfdh zzb;
    public final zzcgh zzc;

    public zzebl(zzfdg zzfdg, zzfdh zzfdh, zzcgh zzcgh) {
        this.zza = zzfdg;
        this.zzb = zzfdh;
        this.zzc = zzcgh;
    }

    public final void zzbT(zzbdd zzbdd) {
        zzfdg zzfdg = this.zza;
        zzfdg.zzc("action", "ftl");
        zzfdg.zzc("ftl", String.valueOf(zzbdd.zza));
        zzfdg.zzc("ed", zzbdd.zzc);
        this.zzb.zza(this.zza);
    }

    public final void zzbU() {
        zzfdh zzfdh = this.zzb;
        zzfdg zzfdg = this.zza;
        zzfdg.zzc("action", "loaded");
        zzfdh.zza(zzfdg);
    }

    public final void zzj(zzcbk zzcbk) {
        this.zza.zzf(zzcbk.zza);
    }

    public final void zzq(zzeyq zzeyq) {
        this.zza.zzg(zzeyq, this.zzc);
    }
}
