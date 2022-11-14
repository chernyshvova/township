package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzty {
    public final int zza;
    public final byte[] zzb;
    public final int zzc;
    public final int zzd;

    public zzty(int i, byte[] bArr, int i2, int i3) {
        this.zza = i;
        this.zzb = bArr;
        this.zzc = i2;
        this.zzd = i3;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzty.class == obj.getClass()) {
            zzty zzty = (zzty) obj;
            return this.zza == zzty.zza && this.zzc == zzty.zzc && this.zzd == zzty.zzd && Arrays.equals(this.zzb, zzty.zzb);
        }
    }

    public final int hashCode() {
        return ((((Arrays.hashCode(this.zzb) + (this.zza * 31)) * 31) + this.zzc) * 31) + this.zzd;
    }
}
