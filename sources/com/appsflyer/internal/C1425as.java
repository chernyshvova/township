package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.deeplink.DeepLink;
import com.appsflyer.deeplink.DeepLinkResult;
import java.util.Map;
import org.json.JSONException;

/* renamed from: com.appsflyer.internal.as */
public final class C1425as {
    public static void AFInAppEventParameterName(Map<String, String> map) {
        if (C1387af.AFKeystoreWrapper != null) {
            try {
                StringBuilder sb = new StringBuilder("Calling onAppOpenAttribution with:\n");
                sb.append(map.toString());
                AFLogger.AFInAppEventType(sb.toString());
                C1387af.AFKeystoreWrapper.onAppOpenAttribution(map);
            } catch (Throwable th) {
                AFLogger.values(th.getLocalizedMessage(), th);
            }
        }
    }

    public static void AFInAppEventType(String str) {
        if (C1474f.AFInAppEventParameterName().AFInAppEventType != null) {
            AFLogger.AFInAppEventType("[DDL] Error occurred: ".concat(String.valueOf(str)));
            AFInAppEventType(new DeepLinkResult((DeepLink) null, DeepLinkResult.Error.NETWORK));
            return;
        }
        valueOf(str);
    }

    public static void valueOf(String str) {
        if (C1387af.AFKeystoreWrapper != null) {
            try {
                AFLogger.AFInAppEventType("Calling onAppOpenAttributionFailure with: ".concat(String.valueOf(str)));
                C1387af.AFKeystoreWrapper.onAttributionFailure(str);
            } catch (Throwable th) {
                AFLogger.values(th.getLocalizedMessage(), th);
            }
        }
    }

    public static void AFInAppEventType(Map<String, String> map) {
        DeepLinkResult deepLinkResult;
        if (C1474f.AFInAppEventParameterName().AFInAppEventType != null) {
            try {
                DeepLink values = DeepLink.values(map);
                values.AFInAppEventParameterName.put("is_deferred", false);
                deepLinkResult = new DeepLinkResult(values, (DeepLinkResult.Error) null);
            } catch (JSONException e) {
                AFLogger.AFInAppEventParameterName("[DDL] Error occurred", (Throwable) e);
                deepLinkResult = new DeepLinkResult((DeepLink) null, DeepLinkResult.Error.UNEXPECTED);
            } catch (Throwable th) {
                AFInAppEventType(new DeepLinkResult((DeepLink) null, (DeepLinkResult.Error) null));
                throw th;
            }
            AFInAppEventType(deepLinkResult);
            return;
        }
        AFInAppEventParameterName(map);
    }

    public static void AFInAppEventType(DeepLinkResult deepLinkResult) {
        if (C1474f.AFInAppEventParameterName().AFInAppEventType != null) {
            StringBuilder sb = new StringBuilder("[DDL] Calling onDeepLinking with:\n");
            sb.append(deepLinkResult.toString());
            AFLogger.AFInAppEventType(sb.toString());
            try {
                C1474f.AFInAppEventParameterName().AFInAppEventType.onDeepLinking(deepLinkResult);
            } catch (Throwable th) {
                AFLogger.values(th.getLocalizedMessage(), th);
            }
        } else {
            AFLogger.AFInAppEventType("[DDL] skipping, no callback registered");
        }
    }
}
