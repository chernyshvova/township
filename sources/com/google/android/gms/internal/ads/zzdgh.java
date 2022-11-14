package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdgh {
    public final Set<zzdhz<zzdcv>> zza = new HashSet();
    public final Set<zzdhz<zzddy>> zzb = new HashSet();
    public final Set<zzdhz<zzbcz>> zzc = new HashSet();
    public final Set<zzdhz<zzdbd>> zzd = new HashSet();
    public final Set<zzdhz<zzdbx>> zze = new HashSet();
    public final Set<zzdhz<zzddc>> zzf = new HashSet();
    public final Set<zzdhz<zzdcr>> zzg = new HashSet();
    public final Set<zzdhz<zzdbg>> zzh = new HashSet();
    public final Set<zzdhz<zzfgi>> zzi = new HashSet();
    public final Set<zzdhz<zzamt>> zzj = new HashSet();
    public final Set<zzdhz<zzdbt>> zzk = new HashSet();
    public final Set<zzdhz<zzddo>> zzl = new HashSet();
    public final Set<zzdhz<zzo>> zzm = new HashSet();
    public zzevs zzn;

    public final zzdgh zza(zzdbd zzdbd, Executor executor) {
        this.zzd.add(new zzdhz(zzdbd, executor));
        return this;
    }

    public final zzdgh zzb(zzdcr zzdcr, Executor executor) {
        this.zzg.add(new zzdhz(zzdcr, executor));
        return this;
    }

    public final zzdgh zzc(zzdbg zzdbg, Executor executor) {
        this.zzh.add(new zzdhz(zzdbg, executor));
        return this;
    }

    public final zzdgh zzd(zzdbt zzdbt, Executor executor) {
        this.zzk.add(new zzdhz(zzdbt, executor));
        return this;
    }

    public final zzdgh zze(zzamt zzamt, Executor executor) {
        this.zzj.add(new zzdhz(zzamt, executor));
        return this;
    }

    public final zzdgh zzf(zzbcz zzbcz, Executor executor) {
        this.zzc.add(new zzdhz(zzbcz, executor));
        return this;
    }

    public final zzdgh zzg(zzdbx zzdbx, Executor executor) {
        this.zze.add(new zzdhz(zzdbx, executor));
        return this;
    }

    public final zzdgh zzh(zzddc zzddc, Executor executor) {
        this.zzf.add(new zzdhz(zzddc, executor));
        return this;
    }

    public final zzdgh zzi(zzo zzo, Executor executor) {
        this.zzm.add(new zzdhz(zzo, executor));
        return this;
    }

    public final zzdgh zzj(zzddo zzddo, Executor executor) {
        this.zzl.add(new zzdhz(zzddo, executor));
        return this;
    }

    public final zzdgh zzk(zzevs zzevs) {
        this.zzn = zzevs;
        return this;
    }

    public final zzdgh zzl(zzddy zzddy, Executor executor) {
        this.zzb.add(new zzdhz(zzddy, executor));
        return this;
    }

    public final zzdgi zzm() {
        return new zzdgi(this, (zzdgg) null);
    }
}
