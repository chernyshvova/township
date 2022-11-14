package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@20.3.0 */
public final class zzaiq {
    public static final Pattern zza = Pattern.compile("bytes (\\d+)-(\\d+)/(?:\\d+|\\*)");
    public static final Pattern zzb = Pattern.compile("bytes (?:(?:\\d+-\\d+)|\\*)/(\\d+)");

    public static long zza(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        Matcher matcher = zzb.matcher(str);
        if (!matcher.matches()) {
            return -1;
        }
        String group = matcher.group(1);
        if (group != null) {
            return Long.parseLong(group);
        }
        throw null;
    }

    public static long zzb(@Nullable String str, @Nullable String str2) {
        long j = -1;
        if (!TextUtils.isEmpty(str)) {
            try {
                j = Long.parseLong(str);
            } catch (NumberFormatException unused) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 28);
                sb.append("Unexpected Content-Length [");
                sb.append(str);
                sb.append("]");
                Log.e("HttpUtil", sb.toString());
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return j;
        }
        Matcher matcher = zza.matcher(str2);
        if (!matcher.matches()) {
            return j;
        }
        try {
            String group = matcher.group(2);
            if (group != null) {
                long parseLong = Long.parseLong(group);
                String group2 = matcher.group(1);
                if (group2 != null) {
                    long parseLong2 = (parseLong - Long.parseLong(group2)) + 1;
                    if (j < 0) {
                        return parseLong2;
                    }
                    if (j == parseLong2) {
                        return j;
                    }
                    StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 26 + String.valueOf(str2).length());
                    sb2.append("Inconsistent headers [");
                    sb2.append(str);
                    sb2.append("] [");
                    sb2.append(str2);
                    sb2.append("]");
                    Log.w("HttpUtil", sb2.toString());
                    return Math.max(j, parseLong2);
                }
                throw null;
            }
            throw null;
        } catch (NumberFormatException unused2) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(str2).length() + 27);
            sb3.append("Unexpected Content-Range [");
            sb3.append(str2);
            sb3.append("]");
            Log.e("HttpUtil", sb3.toString());
            return j;
        }
    }
}
