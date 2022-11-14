package com.google.android.gms.common.util;

import androidx.annotation.RecentlyNonNull;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class NumberUtils {
    @KeepForSdk
    public static long parseHexLong(@RecentlyNonNull String str) {
        if (str.length() > 16) {
            throw new NumberFormatException(GeneratedOutlineSupport.outline19(new StringBuilder(str.length() + 37), "Invalid input: ", str, " exceeds 16 characters"));
        } else if (str.length() != 16) {
            return Long.parseLong(str, 16);
        } else {
            return (Long.parseLong(str.substring(0, 8), 16) << 32) | Long.parseLong(str.substring(8), 16);
        }
    }
}
