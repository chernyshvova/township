package com.google.android.gms.auth;

import android.text.TextUtils;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.facebook.internal.Utility;
import com.google.android.gms.common.internal.Preconditions;

public final class CookieUtil {
    public static String getCookieUrl(String str, Boolean bool) {
        Preconditions.checkNotEmpty(str);
        String str2 = zza(bool) ? Utility.URL_SCHEME : "http";
        return GeneratedOutlineSupport.outline12(GeneratedOutlineSupport.outline3(str, str2.length() + 3), str2, "://", str);
    }

    public static String getCookieValue(String str, String str2, String str3, String str4, Boolean bool, Boolean bool2, Long l) {
        StringBuilder sb = new StringBuilder(str);
        sb.append('=');
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str2);
        }
        if (zza(bool)) {
            sb.append(";HttpOnly");
        }
        if (zza(bool2)) {
            sb.append(";Secure");
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append(";Domain=");
            sb.append(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            sb.append(";Path=");
            sb.append(str4);
        }
        if (l != null && l.longValue() > 0) {
            sb.append(";Max-Age=");
            sb.append(l);
        }
        return sb.toString();
    }

    public static boolean zza(Boolean bool) {
        return bool != null && bool.booleanValue();
    }
}
