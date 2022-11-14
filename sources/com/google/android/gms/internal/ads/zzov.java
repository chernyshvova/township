package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzov {
    public final long zza;
    public final zzmv zzb;
    public final int zzc;
    @Nullable
    public final zzadv zzd;
    public final long zze;
    public final zzmv zzf;
    public final int zzg;
    @Nullable
    public final zzadv zzh;
    public final long zzi;
    public final long zzj;

    public zzov(long j, zzmv zzmv, int i, @Nullable zzadv zzadv, long j2, zzmv zzmv2, int i2, @Nullable zzadv zzadv2, long j3, long j4) {
        this.zza = j;
        this.zzb = zzmv;
        this.zzc = i;
        this.zzd = zzadv;
        this.zze = j2;
        this.zzf = zzmv2;
        this.zzg = i2;
        this.zzh = zzadv2;
        this.zzi = j3;
        this.zzj = j4;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzov.class == obj.getClass()) {
            zzov zzov = (zzov) obj;
            return this.zza == zzov.zza && this.zzc == zzov.zzc && this.zze == zzov.zze && this.zzg == zzov.zzg && this.zzi == zzov.zzi && this.zzj == zzov.zzj && zzfka.zza(this.zzb, zzov.zzb) && zzfka.zza(this.zzd, zzov.zzd) && zzfka.zza(this.zzf, zzov.zzf) && zzfka.zza(this.zzh, zzov.zzh);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.zza), this.zzb, Integer.valueOf(this.zzc), this.zzd, Long.valueOf(this.zze), this.zzf, Integer.valueOf(this.zzg), this.zzh, Long.valueOf(this.zzi), Long.valueOf(this.zzj)});
    }
}
