package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdpq {
    public final Executor zza;
    public final zzcuc zzb;
    public final zzdib zzc;

    public zzdpq(Executor executor, zzcuc zzcuc, zzdib zzdib) {
        this.zza = executor;
        this.zzc = zzdib;
        this.zzb = zzcuc;
    }

    public final void zza(zzcmr zzcmr) {
        if (zzcmr != null) {
            this.zzc.zza(zzcmr.zzH());
            this.zzc.zzh(new zzdpm(zzcmr), this.zza);
            this.zzc.zzh(new zzdpn(zzcmr), this.zza);
            this.zzc.zzh(this.zzb, this.zza);
            this.zzb.zza(zzcmr);
            zzcmr.zzab("/trackActiveViewUnit", new zzdpo(this));
            zzcmr.zzab("/untrackActiveViewUnit", new zzdpp(this));
        }
    }

    public final /* synthetic */ void zzb(zzcmr zzcmr, Map map) {
        this.zzb.zzb();
    }

    public final /* synthetic */ void zzc(zzcmr zzcmr, Map map) {
        this.zzb.zzd();
    }
}
