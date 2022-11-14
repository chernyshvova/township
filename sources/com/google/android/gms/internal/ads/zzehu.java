package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final /* synthetic */ class zzehu implements zzfju {
    public final zzehy zza;
    public final zzcmr zzb;
    public final zzeye zzc;
    public final zzdrk zzd;

    public zzehu(zzehy zzehy, zzcmr zzcmr, zzeye zzeye, zzdrk zzdrk) {
        this.zza = zzehy;
        this.zzb = zzcmr;
        this.zzc = zzeye;
        this.zzd = zzdrk;
    }

    public final Object apply(Object obj) {
        zzcmr zzcmr = this.zzb;
        zzeye zzeye = this.zzc;
        zzdrk zzdrk = this.zzd;
        if (zzeye.zzI) {
            zzcmr.zzau();
        }
        zzcmr.zzL();
        zzcmr.onPause();
        return zzdrk.zzh();
    }
}
