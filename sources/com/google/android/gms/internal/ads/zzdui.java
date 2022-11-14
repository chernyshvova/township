package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdui implements zzddy, zzdcr, zzdbg {
    public final zzduq zza;
    public final zzduz zzb;

    public zzdui(zzduq zzduq, zzduz zzduz) {
        this.zza = zzduq;
        this.zzb = zzduz;
    }

    public final void zzbT(zzbdd zzbdd) {
        this.zza.zzc().put("action", "ftl");
        this.zza.zzc().put("ftl", String.valueOf(zzbdd.zza));
        this.zza.zzc().put("ed", zzbdd.zzc);
        this.zzb.zzb(this.zza.zzc());
    }

    public final void zzbU() {
        this.zza.zzc().put("action", "loaded");
        this.zzb.zzb(this.zza.zzc());
    }

    public final void zzj(zzcbk zzcbk) {
        this.zza.zzb(zzcbk.zza);
    }

    public final void zzq(zzeyq zzeyq) {
        this.zza.zza(zzeyq);
    }
}
