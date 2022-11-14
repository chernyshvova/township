package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzeld {
    public final zzdml zza;
    public final zzekq zzb;
    public final zzdbg zzc;

    public zzeld(zzdml zzdml, zzfdh zzfdh) {
        this.zza = zzdml;
        zzekq zzekq = new zzekq(zzfdh);
        this.zzb = zzekq;
        this.zzc = new zzelc(zzekq, this.zza.zze());
    }

    public final void zza(zzbfe zzbfe) {
        this.zzb.zzn(zzbfe);
    }

    public final zzdkk zzb() {
        return new zzdkk(this.zza, this.zzb.zzl());
    }

    public final zzekq zzc() {
        return this.zzb;
    }

    public final zzdcr zzd() {
        return this.zzb;
    }

    public final zzdbg zze() {
        return this.zzc;
    }
}
