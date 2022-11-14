package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzagx {
    public int zza;
    public final zzagf[] zzb;

    public zzagx(zzagf[] zzagfArr, byte... bArr) {
        this.zzb = zzagfArr;
        int length = zzagfArr.length;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzagx.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.zzb, ((zzagx) obj).zzb);
    }

    public final int hashCode() {
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.zzb) + 527;
        this.zza = hashCode;
        return hashCode;
    }
}
