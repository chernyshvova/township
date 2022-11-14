package com.google.android.gms.common.util;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.playrix.gplay.billing.Base64;

@ShowFirstParty
@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class Hex {
    public static final char[] zza = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final char[] zzb = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    @RecentlyNonNull
    @KeepForSdk
    public static String bytesToStringLowercase(@RecentlyNonNull byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[(length + length)];
        int i = 0;
        for (byte b : bArr) {
            byte b2 = b & Base64.EQUALS_SIGN_ENC;
            int i2 = i + 1;
            char[] cArr2 = zzb;
            cArr[i] = cArr2[b2 >>> 4];
            i = i2 + 1;
            cArr[i2] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    @RecentlyNonNull
    @KeepForSdk
    public static String bytesToStringUppercase(@RecentlyNonNull byte[] bArr) {
        return bytesToStringUppercase(bArr, false);
    }

    @RecentlyNonNull
    @KeepForSdk
    public static byte[] stringToBytes(@RecentlyNonNull String str) throws IllegalArgumentException {
        int length = str.length();
        if (length % 2 == 0) {
            byte[] bArr = new byte[(length / 2)];
            int i = 0;
            while (i < length) {
                int i2 = i + 2;
                bArr[i / 2] = (byte) Integer.parseInt(str.substring(i, i2), 16);
                i = i2;
            }
            return bArr;
        }
        throw new IllegalArgumentException("Hex string has odd number of characters");
    }

    @RecentlyNonNull
    @KeepForSdk
    public static String bytesToStringUppercase(@RecentlyNonNull byte[] bArr, boolean z) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(length + length);
        int i = 0;
        while (i < length && (!z || i != length - 1 || (bArr[i] & Base64.EQUALS_SIGN_ENC) != 0)) {
            sb.append(zza[(bArr[i] & 240) >>> 4]);
            sb.append(zza[bArr[i] & 15]);
            i++;
        }
        return sb.toString();
    }
}
