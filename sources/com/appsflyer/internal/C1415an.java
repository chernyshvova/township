package com.appsflyer.internal;

import androidx.annotation.VisibleForTesting;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;

/* renamed from: com.appsflyer.internal.an */
public final class C1415an {
    @VisibleForTesting
    public static String AFInAppEventParameterName;
    @VisibleForTesting
    public static String values;

    public static void AFKeystoreWrapper(String str) {
        if (values == null) {
            valueOf(AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY));
        }
        String str2 = values;
        if (str2 != null) {
            AFLogger.AFInAppEventParameterName(str.replace(str2, AFInAppEventParameterName));
        }
    }

    public static void valueOf(String str) {
        values = str;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (i == 0 || i == str.length() - 1) {
                sb.append(str.charAt(i));
            } else {
                sb.append("*");
            }
        }
        AFInAppEventParameterName = sb.toString();
    }
}
