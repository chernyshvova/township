package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public class zzcvq {
    public final zzcxg zza;
    public final View zzb;
    public final zzeyf zzc;
    public final zzcmr zzd;

    public zzcvq(View view, @Nullable zzcmr zzcmr, zzcxg zzcxg, zzeyf zzeyf) {
        this.zzb = view;
        this.zzd = zzcmr;
        this.zza = zzcxg;
        this.zzc = zzeyf;
    }

    public static final zzdhz<zzdcr> zzf(Context context, zzcgy zzcgy, zzeye zzeye, zzeyw zzeyw) {
        return new zzdhz<>(new zzcvo(context, zzcgy, zzeye, zzeyw), zzche.zzf);
    }

    public static final Set<zzdhz<zzdcr>> zzg(zzcxa zzcxa) {
        return Collections.singleton(new zzdhz(zzcxa, zzche.zzf));
    }

    public static final zzdhz<zzdcr> zzh(zzcwy zzcwy) {
        return new zzdhz<>(zzcwy, zzche.zze);
    }

    @Nullable
    public final zzcmr zza() {
        return this.zzd;
    }

    public final View zzb() {
        return this.zzb;
    }

    public final zzcxg zzc() {
        return this.zza;
    }

    public final zzeyf zzd() {
        return this.zzc;
    }

    public zzdcp zze(Set<zzdhz<zzdcr>> set) {
        return new zzdcp(set);
    }
}
