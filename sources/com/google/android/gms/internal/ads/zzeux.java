package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzcxi;
import com.google.android.gms.internal.ads.zzdam;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeux<R extends zzdam<AdT>, AdT extends zzcxi> implements zzevv<R, zzfaq<R, AdT>> {
    public R zza;
    public final Executor zzb = zzfqu.zza();

    public final R zza() {
        return this.zza;
    }

    public final zzfqn<zzfaq<R, AdT>> zzb(zzevw zzevw, zzevu<R> zzevu, @Nullable R r) {
        zzdal<R> zza2 = zzevu.zza(zzevw.zzb);
        zza2.zzh(new zzewb(true));
        R r2 = (zzdam) zza2.zzf();
        this.zza = r2;
        zzcyl zzc = r2.zzc();
        zzfaq zzfaq = new zzfaq();
        return zzfqe.zzj(zzfqe.zzi(zzfpv.zzw(zzc.zzb()), new zzeuv(this, zzfaq, zzc), this.zzb), new zzeuw(zzfaq), this.zzb);
    }

    public final /* bridge */ /* synthetic */ zzfqn zzc(zzevw zzevw, zzevu zzevu, @Nullable Object obj) {
        return zzb(zzevw, zzevu, (zzdam) null);
    }

    public final /* bridge */ /* synthetic */ Object zzd() {
        return this.zza;
    }
}
