package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzedz implements zzfju {
    public final zzeea zza;
    public final zzcmr zzb;
    public final zzeye zzc;
    public final zzcuu zzd;

    public zzedz(zzeea zzeea, zzcmr zzcmr, zzeye zzeye, zzcuu zzcuu) {
        this.zza = zzeea;
        this.zzb = zzcmr;
        this.zzc = zzeye;
        this.zzd = zzcuu;
    }

    public final Object apply(Object obj) {
        zzcmr zzcmr = this.zzb;
        zzeye zzeye = this.zzc;
        zzcuu zzcuu = this.zzd;
        if (zzeye.zzI) {
            zzcmr.zzau();
        }
        zzcmr.zzL();
        zzcmr.onPause();
        return zzcuu.zzh();
    }
}
