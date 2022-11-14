package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcxi;
import com.google.android.gms.internal.ads.zzdam;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzevi<R extends zzdam<AdT>, AdT extends zzcxi> implements zzevv<R, zzevh<R, AdT>> {
    public final zzfah zza;
    public final Executor zzb;
    public final zzfqa<Void> zzc = new zzevg(this);

    public zzevi(zzfah zzfah, Executor executor) {
        this.zza = zzfah;
        this.zzb = executor;
    }

    public final zzfqn<zzevh<R, AdT>> zza(zzevw zzevw, zzevu<R> zzevu, R r) {
        return zzfqe.zzf(zzfqe.zzi(zzfpv.zzw(new zzevr(this.zza, r, this.zzb).zza()), new zzeve(this, r), this.zzb), Exception.class, new zzevf(this), this.zzb);
    }

    public final /* synthetic */ zzfqn zzb(zzdam zzdam, zzevq zzevq) throws Exception {
        zzfar zzfar = zzevq.zzb;
        zzcbk zzcbk = zzevq.zza;
        zzfaq<?, ?> zza2 = zzfar != null ? this.zza.zza(zzfar) : null;
        if (zzfar == null) {
            return zzfqe.zza(null);
        }
        if (!(zza2 == null || zzcbk == null)) {
            zzfqe.zzp(zzdam.zzc().zzf(zzcbk), this.zzc, this.zzb);
        }
        return zzfqe.zza(new zzevh(zzfar, zzcbk, zza2));
    }

    public final /* bridge */ /* synthetic */ zzfqn zzc(zzevw zzevw, zzevu zzevu, Object obj) {
        return zza(zzevw, zzevu, (zzdam) null);
    }

    public final /* bridge */ /* synthetic */ Object zzd() {
        return null;
    }
}
