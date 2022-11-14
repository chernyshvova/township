package com.google.android.gms.common.util;

import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.playrix.gplay.billing.Base64;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class HexDumpUtils {
    @KeepForSdk
    @RecentlyNullable
    public static String dump(@RecentlyNonNull byte[] bArr, int i, int i2, boolean z) {
        int length;
        if (bArr == null || (length = bArr.length) == 0 || i < 0 || i2 <= 0 || i + i2 > length) {
            return null;
        }
        StringBuilder sb = new StringBuilder(((i2 + 15) / 16) * (z ? 75 : 57));
        int i3 = i2;
        int i4 = 0;
        int i5 = 0;
        while (i3 > 0) {
            if (i4 == 0) {
                if (i2 < 65536) {
                    sb.append(String.format("%04X:", new Object[]{Integer.valueOf(i)}));
                } else {
                    sb.append(String.format("%08X:", new Object[]{Integer.valueOf(i)}));
                }
                i5 = i;
            } else if (i4 == 8) {
                sb.append(" -");
            }
            sb.append(String.format(" %02X", new Object[]{Integer.valueOf(bArr[i] & Base64.EQUALS_SIGN_ENC)}));
            i3--;
            i4++;
            if (z && (i4 == 16 || i3 == 0)) {
                int i6 = 16 - i4;
                if (i6 > 0) {
                    for (int i7 = 0; i7 < i6; i7++) {
                        sb.append("   ");
                    }
                }
                if (i6 >= 8) {
                    sb.append("  ");
                }
                sb.append("  ");
                for (int i8 = 0; i8 < i4; i8++) {
                    char c = (char) bArr[i5 + i8];
                    if (c < ' ' || c > '~') {
                        c = '.';
                    }
                    sb.append(c);
                }
            }
            if (i4 == 16 || i3 == 0) {
                sb.append(10);
                i4 = 0;
            }
            i++;
        }
        return sb.toString();
    }
}