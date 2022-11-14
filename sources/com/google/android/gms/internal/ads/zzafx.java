package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzafx {
    public static final zzif<zzafx> zzg = zzafw.zza;
    public final int zza = -1;
    public final Uri[] zzb = new Uri[0];
    public final int[] zzc = new int[0];
    public final long[] zzd = new long[0];
    public final long zze = 0;
    public final boolean zzf = false;

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzafx.class == obj.getClass()) {
            zzafx zzafx = (zzafx) obj;
            return this.zza == zzafx.zza && Arrays.equals(this.zzb, zzafx.zzb) && Arrays.equals(this.zzc, zzafx.zzc) && Arrays.equals(this.zzd, zzafx.zzd) && this.zze == zzafx.zze && this.zzf == zzafx.zzf;
        }
    }

    public final int hashCode() {
        int i = this.zza;
        int hashCode = Arrays.hashCode(this.zzb);
        int hashCode2 = Arrays.hashCode(this.zzc);
        int hashCode3 = Arrays.hashCode(this.zzd);
        long j = this.zze;
        return (((((((((i * 31) + hashCode) * 31) + hashCode2) * 31) + hashCode3) * 31) + ((int) ((j >>> 32) ^ j))) * 31) + (this.zzf ? 1 : 0);
    }
}
