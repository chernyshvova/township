package com.appsflyer.internal;

import androidx.annotation.Nullable;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import org.json.JSONObject;

/* renamed from: com.appsflyer.internal.ap */
public final class C1417ap {
    @Nullable
    public static JSONObject values(String str) {
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            try {
                boolean z = AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DPM, false);
                if (!jSONObject2.optBoolean("monitor", false) || z) {
                    C1414am.AFKeystoreWrapper().values();
                    C1414am.AFKeystoreWrapper().AFInAppEventParameterName();
                } else {
                    C1414am.AFKeystoreWrapper().valueOf();
                }
                if (!jSONObject2.has("ol_id")) {
                    return jSONObject2;
                }
                String optString = jSONObject2.optString("ol_scheme", (String) null);
                String optString2 = jSONObject2.optString("ol_domain", (String) null);
                String optString3 = jSONObject2.optString("ol_ver", (String) null);
                if (optString != null) {
                    AppsFlyerProperties.getInstance().set(AppsFlyerProperties.ONELINK_SCHEME, optString);
                }
                if (optString2 != null) {
                    AppsFlyerProperties.getInstance().set(AppsFlyerProperties.ONELINK_DOMAIN, optString2);
                }
                if (optString3 == null) {
                    return jSONObject2;
                }
                AppsFlyerProperties.getInstance().set("onelinkVersion", optString3);
                return jSONObject2;
            } catch (Throwable th) {
                th = th;
                jSONObject = jSONObject2;
                AFLogger.values(th.getMessage(), th);
                C1414am.AFKeystoreWrapper().values();
                C1414am.AFKeystoreWrapper().AFInAppEventParameterName();
                return jSONObject;
            }
        } catch (Throwable th2) {
            th = th2;
            AFLogger.values(th.getMessage(), th);
            C1414am.AFKeystoreWrapper().values();
            C1414am.AFKeystoreWrapper().AFInAppEventParameterName();
            return jSONObject;
        }
    }
}
