package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcxi;
import com.google.android.gms.internal.ads.zzdam;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzevb<U extends zzdam<A>, A extends zzcxi> implements zzfbc<U, A> {
    public final zzevu<U> zza;
    public final zzevw zzb;
    public final zzbdk zzc;
    public final String zzd;
    public final Executor zze;
    public final zzbdv zzf;
    public final zzfar zzg;

    public zzevb(zzevu<U> zzevu, zzevw zzevw, zzbdk zzbdk, String str, Executor executor, zzbdv zzbdv, zzfar zzfar) {
        this.zza = zzevu;
        this.zzb = zzevw;
        this.zzc = zzbdk;
        this.zzd = str;
        this.zze = executor;
        this.zzf = zzbdv;
        this.zzg = zzfar;
    }

    public final Executor zza() {
        return this.zze;
    }

    public final zzfar zzb() {
        return this.zzg;
    }
}
