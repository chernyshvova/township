package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzpj {
    public static final zzpj zza = new zzpj(new int[]{2}, 8);
    public static final zzpj zzb = new zzpj(new int[]{2, 5, 6}, 8);
    public final int[] zzc;
    public final int zzd = 8;

    public zzpj(@Nullable int[] iArr, int i) {
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        this.zzc = copyOf;
        Arrays.sort(copyOf);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof zzpj) && Arrays.equals(this.zzc, ((zzpj) obj).zzc);
    }

    public final int hashCode() {
        return (Arrays.hashCode(this.zzc) * 31) + 8;
    }

    public final String toString() {
        String arrays = Arrays.toString(this.zzc);
        return GeneratedOutlineSupport.outline19(new StringBuilder(String.valueOf(arrays).length() + 67), "AudioCapabilities[maxChannelCount=8, supportedEncodings=", arrays, "]");
    }
}
