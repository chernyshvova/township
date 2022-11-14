package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.common.util.Clock;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzdgi {
    public final Set<zzdhz<zzbcz>> zza;
    public final Set<zzdhz<zzdbd>> zzb;
    public final Set<zzdhz<zzdbx>> zzc;
    public final Set<zzdhz<zzddc>> zzd;
    public final Set<zzdhz<zzdcr>> zze;
    public final Set<zzdhz<zzdcv>> zzf;
    public final Set<zzdhz<zzdbg>> zzg;
    public final Set<zzdhz<zzdbt>> zzh;
    public final Set<zzdhz<zzfgi>> zzi;
    public final Set<zzdhz<zzamt>> zzj;
    public final Set<zzdhz<zzddo>> zzk;
    public final Set<zzdhz<zzo>> zzl;
    public final Set<zzdhz<zzddy>> zzm;
    @Nullable
    public final zzevs zzn;
    public zzdbf zzo;
    public zzeha zzp;

    public /* synthetic */ zzdgi(zzdgh zzdgh, zzdgg zzdgg) {
        this.zza = zzdgh.zzc;
        this.zzc = zzdgh.zze;
        this.zzd = zzdgh.zzf;
        this.zzb = zzdgh.zzd;
        this.zze = zzdgh.zzg;
        this.zzf = zzdgh.zza;
        this.zzg = zzdgh.zzh;
        this.zzh = zzdgh.zzk;
        this.zzi = zzdgh.zzi;
        this.zzj = zzdgh.zzj;
        this.zzk = zzdgh.zzl;
        this.zzn = zzdgh.zzn;
        this.zzl = zzdgh.zzm;
        this.zzm = zzdgh.zzb;
    }

    public final Set<zzdhz<zzdbd>> zza() {
        return this.zzb;
    }

    public final Set<zzdhz<zzdcr>> zzb() {
        return this.zze;
    }

    public final Set<zzdhz<zzdbg>> zzc() {
        return this.zzg;
    }

    public final Set<zzdhz<zzdbt>> zzd() {
        return this.zzh;
    }

    public final Set<zzdhz<zzfgi>> zze() {
        return this.zzi;
    }

    public final Set<zzdhz<zzamt>> zzf() {
        return this.zzj;
    }

    public final Set<zzdhz<zzbcz>> zzg() {
        return this.zza;
    }

    public final Set<zzdhz<zzdbx>> zzh() {
        return this.zzc;
    }

    public final Set<zzdhz<zzddc>> zzi() {
        return this.zzd;
    }

    public final Set<zzdhz<zzddo>> zzj() {
        return this.zzk;
    }

    public final Set<zzdhz<zzddy>> zzk() {
        return this.zzm;
    }

    public final Set<zzdhz<zzdcv>> zzl() {
        return this.zzf;
    }

    public final Set<zzdhz<zzo>> zzm() {
        return this.zzl;
    }

    @Nullable
    public final zzevs zzn() {
        return this.zzn;
    }

    public final zzdbf zzo(Set<zzdhz<zzdbg>> set) {
        if (this.zzo == null) {
            this.zzo = new zzdbf(set);
        }
        return this.zzo;
    }

    public final zzeha zzp(Clock clock, zzehb zzehb, zzeds zzeds) {
        if (this.zzp == null) {
            this.zzp = new zzeha(clock, zzehb, zzeds);
        }
        return this.zzp;
    }
}
