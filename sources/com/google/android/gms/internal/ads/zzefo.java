package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzefo implements zzfju {
    public final zzefq zza;
    public final zzcmr zzb;
    public final zzeye zzc;
    public final zzdix zzd;

    public zzefo(zzefq zzefq, zzcmr zzcmr, zzeye zzeye, zzdix zzdix) {
        this.zza = zzefq;
        this.zzb = zzcmr;
        this.zzc = zzeye;
        this.zzd = zzdix;
    }

    public final Object apply(Object obj) {
        zzcmr zzcmr = this.zzb;
        zzeye zzeye = this.zzc;
        zzdix zzdix = this.zzd;
        if (zzeye.zzI) {
            zzcmr.zzau();
        }
        zzcmr.zzL();
        zzcmr.onPause();
        return zzdix.zzh();
    }
}
