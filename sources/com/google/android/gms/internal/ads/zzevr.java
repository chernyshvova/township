package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdam;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzevr<R extends zzdam<? extends zzcxi>> {
    public final zzfah zza;
    public final R zzb;
    public final Executor zzc;
    public zzevq zzd;

    public zzevr(zzfah zzfah, R r, Executor executor) {
        this.zza = zzfah;
        this.zzb = r;
        this.zzc = executor;
    }

    /* access modifiers changed from: private */
    @Deprecated
    public final zzfar zze() {
        zzeyw zza2 = this.zzb.zza();
        return this.zza.zzd(zza2.zzd, zza2.zzf, zza2.zzj);
    }

    public final zzfqn<zzevq> zza() {
        zzfqn<V> zzfqn;
        zzevq zzevq = this.zzd;
        if (zzevq != null) {
            return zzfqe.zza(zzevq);
        }
        if (!zzblf.zza.zze().booleanValue()) {
            zzevq zzevq2 = new zzevq((zzcbk) null, zze(), (zzevo) null);
            this.zzd = zzevq2;
            zzfqn = zzfqe.zza(zzevq2);
        } else {
            zzfqn = zzfqe.zzf(zzfqe.zzj(zzfpv.zzw(this.zzb.zzc().zze(this.zza.zze())), new zzevp(this), this.zzc), zzeaa.class, new zzevo(this), this.zzc);
        }
        return zzfqe.zzj(zzfqn, zzevn.zza, this.zzc);
    }
}
