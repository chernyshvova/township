package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzdja {
    public final zzdkb zza;
    @Nullable
    public final zzcmr zzb;

    public zzdja(zzdkb zzdkb, @Nullable zzcmr zzcmr) {
        this.zza = zzdkb;
        this.zzb = zzcmr;
    }

    public static final zzdhz<zzdhr> zzh(zzdkg zzdkg) {
        return new zzdhz<>(zzdkg, zzche.zzf);
    }

    public final zzdkb zza() {
        return this.zza;
    }

    @Nullable
    public final zzcmr zzb() {
        return this.zzb;
    }

    @Nullable
    public final View zzc() {
        zzcmr zzcmr = this.zzb;
        if (zzcmr != null) {
            return zzcmr.zzG();
        }
        return null;
    }

    @Nullable
    public final View zzd() {
        zzcmr zzcmr = this.zzb;
        if (zzcmr == null) {
            return null;
        }
        return zzcmr.zzG();
    }

    public Set<zzdhz<zzdbd>> zze(zzdad zzdad) {
        return Collections.singleton(new zzdhz(zzdad, zzche.zzf));
    }

    public Set<zzdhz<zzdhr>> zzf(zzdad zzdad) {
        return Collections.singleton(new zzdhz(zzdad, zzche.zzf));
    }

    public final zzdhz<zzdfl> zzg(Executor executor) {
        return new zzdhz<>(new zzdiz(this.zzb), executor);
    }
}
