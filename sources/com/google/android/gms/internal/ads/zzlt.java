package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzlt {
    public static final zzif<zzlt> zzh = zzls.zza;
    @Nullable
    public final Object zza;
    public final int zzb;
    @Nullable
    public final Object zzc;
    public final int zzd;
    public final long zze;
    public final long zzf;
    public final int zzg;

    public zzlt(@Nullable Object obj, int i, @Nullable Object obj2, int i2, long j, long j2, int i3, int i4) {
        this.zza = obj;
        this.zzb = i;
        this.zzc = obj2;
        this.zzd = i2;
        this.zze = j;
        this.zzf = j2;
        this.zzg = i3;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzlt.class == obj.getClass()) {
            zzlt zzlt = (zzlt) obj;
            return this.zzb == zzlt.zzb && this.zzd == zzlt.zzd && this.zze == zzlt.zze && this.zzf == zzlt.zzf && this.zzg == zzlt.zzg && zzfka.zza(this.zza, zzlt.zza) && zzfka.zza(this.zzc, zzlt.zzc);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, Integer.valueOf(this.zzb), this.zzc, Integer.valueOf(this.zzd), Integer.valueOf(this.zzb), Long.valueOf(this.zze), Long.valueOf(this.zzf), Integer.valueOf(this.zzg), -1});
    }
}
