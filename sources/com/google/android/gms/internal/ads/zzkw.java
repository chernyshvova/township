package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzkw {
    public final zzadv zza;
    public final long zzb;
    public final long zzc;
    public final long zzd;
    public final long zze;
    public final boolean zzf;
    public final boolean zzg;
    public final boolean zzh;
    public final boolean zzi;

    public zzkw(zzadv zzadv, long j, long j2, long j3, long j4, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = z;
        boolean z6 = z2;
        boolean z7 = z3;
        boolean z8 = z4;
        boolean z9 = false;
        zzajg.zza(!z8 || z6);
        zzajg.zza(!z7 || z6);
        if (!z5 || (!z6 && !z7 && !z8)) {
            z9 = true;
        }
        zzajg.zza(z9);
        this.zza = zzadv;
        this.zzb = j;
        this.zzc = j2;
        this.zzd = j3;
        this.zze = j4;
        this.zzf = z5;
        this.zzg = z6;
        this.zzh = z7;
        this.zzi = z8;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzkw.class == obj.getClass()) {
            zzkw zzkw = (zzkw) obj;
            return this.zzb == zzkw.zzb && this.zzc == zzkw.zzc && this.zzd == zzkw.zzd && this.zze == zzkw.zze && this.zzf == zzkw.zzf && this.zzg == zzkw.zzg && this.zzh == zzkw.zzh && this.zzi == zzkw.zzi && zzalh.zzc(this.zza, zzkw.zza);
        }
    }

    public final int hashCode() {
        return ((((((((((((((((this.zza.hashCode() + 527) * 31) + ((int) this.zzb)) * 31) + ((int) this.zzc)) * 31) + ((int) this.zzd)) * 31) + ((int) this.zze)) * 31) + (this.zzf ? 1 : 0)) * 31) + (this.zzg ? 1 : 0)) * 31) + (this.zzh ? 1 : 0)) * 31) + (this.zzi ? 1 : 0);
    }

    public final zzkw zza(long j) {
        if (j == this.zzb) {
            return this;
        }
        return new zzkw(this.zza, j, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi);
    }

    public final zzkw zzb(long j) {
        if (j == this.zzc) {
            return this;
        }
        return new zzkw(this.zza, this.zzb, j, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi);
    }
}
