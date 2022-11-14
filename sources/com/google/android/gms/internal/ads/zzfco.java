package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfco<O> {
    public final /* synthetic */ zzfcp zza;
    public final Object zzb;
    @Nullable
    public final String zzc;
    public final zzfqn<?> zzd;
    public final List<zzfqn<?>> zze;
    public final zzfqn<O> zzf;

    public zzfco(zzfcp zzfcp, zzfcp zzfcp2, String str, zzfqn zzfqn, List<zzfqn> list, zzfqn<O> zzfqn2) {
        this.zza = zzfcp;
        this.zzb = zzfcp2;
        this.zzc = str;
        this.zzd = zzfqn;
        this.zze = list;
        this.zzf = zzfqn2;
    }

    public /* synthetic */ zzfco(zzfcp zzfcp, Object obj, String str, zzfqn zzfqn, List list, zzfqn zzfqn2, zzfce zzfce) {
        this(zzfcp, obj, (String) null, zzfqn, list, zzfqn2);
    }

    public final zzfco<O> zza(String str) {
        return new zzfco(this.zza, this.zzb, str, this.zzd, this.zze, this.zzf);
    }

    public final <O2> zzfco<O2> zzb(zzfcb<O, O2> zzfcb) {
        return zzc(new zzfcj(zzfcb));
    }

    public final <O2> zzfco<O2> zzc(zzfpl<O, O2> zzfpl) {
        return zzd(zzfpl, this.zza.zzb);
    }

    public final <O2> zzfco<O2> zzd(zzfpl<O, O2> zzfpl, Executor executor) {
        return new zzfco(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzfqe.zzi(this.zzf, zzfpl, executor));
    }

    public final <O2> zzfco<O2> zze(zzfqn<O2> zzfqn) {
        return zzd(new zzfck(zzfqn), zzche.zzf);
    }

    public final <T extends Throwable> zzfco<O> zzf(Class<T> cls, zzfcb<T, O> zzfcb) {
        return zzg(cls, new zzfcl(zzfcb));
    }

    public final <T extends Throwable> zzfco<O> zzg(Class<T> cls, zzfpl<T, O> zzfpl) {
        zzfcp zzfcp = this.zza;
        return new zzfco(zzfcp, this.zzb, this.zzc, this.zzd, this.zze, zzfqe.zzg(this.zzf, cls, zzfpl, zzfcp.zzb));
    }

    public final zzfco<O> zzh(long j, TimeUnit timeUnit) {
        zzfcp zzfcp = this.zza;
        return new zzfco(zzfcp, this.zzb, this.zzc, this.zzd, this.zze, zzfqe.zzh(this.zzf, j, timeUnit, zzfcp.zzc));
    }

    public final zzfcd zzi() {
        Object obj = this.zzb;
        String str = this.zzc;
        if (str == null) {
            str = this.zza.zzc(obj);
        }
        zzfcd zzfcd = new zzfcd(obj, str, this.zzf);
        this.zza.zzd.zza(zzfcd);
        this.zzd.zze(new zzfcm(this, zzfcd), zzche.zzf);
        zzfqe.zzp(zzfcd, new zzfcn(this, zzfcd), zzche.zzf);
        return zzfcd;
    }

    public final zzfco<O> zzj(Object obj) {
        return this.zza.zza(obj, zzi());
    }
}
