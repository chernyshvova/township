package com.google.android.gms.internal.ads;

import com.playrix.gplay.billing.Base64;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzfsd implements Comparable<zzfsd> {
    public final byte[] zza;

    public /* synthetic */ zzfsd(byte[] bArr, zzfsb zzfsb) {
        this.zza = Arrays.copyOf(bArr, bArr.length);
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        zzfsd zzfsd = (zzfsd) obj;
        int length = this.zza.length;
        int length2 = zzfsd.zza.length;
        if (length != length2) {
            return length - length2;
        }
        int i = 0;
        while (true) {
            byte[] bArr = this.zza;
            if (i >= bArr.length) {
                return 0;
            }
            byte b = bArr[i];
            byte b2 = zzfsd.zza[i];
            if (b != b2) {
                return b - b2;
            }
            i++;
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzfsd)) {
            return false;
        }
        return Arrays.equals(this.zza, ((zzfsd) obj).zza);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(r2 + r2);
        for (byte b : this.zza) {
            byte b2 = b & Base64.EQUALS_SIGN_ENC;
            sb.append("0123456789abcdef".charAt(b2 >> 4));
            sb.append("0123456789abcdef".charAt(b2 & 15));
        }
        return sb.toString();
    }
}
