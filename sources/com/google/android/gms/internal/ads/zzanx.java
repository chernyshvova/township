package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import java.util.Arrays;

@TargetApi(21)
/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzanx {
    public static final zzanx zza = new zzanx(new int[]{2}, 2);
    public final int[] zzb;
    public final int zzc = 2;

    public zzanx(int[] iArr, int i) {
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        this.zzb = copyOf;
        Arrays.sort(copyOf);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof zzanx) && Arrays.equals(this.zzb, ((zzanx) obj).zzb);
    }

    public final int hashCode() {
        return (Arrays.hashCode(this.zzb) * 31) + 2;
    }

    public final String toString() {
        String arrays = Arrays.toString(this.zzb);
        return GeneratedOutlineSupport.outline19(new StringBuilder(String.valueOf(arrays).length() + 67), "AudioCapabilities[maxChannelCount=2, supportedEncodings=", arrays, "]");
    }
}
