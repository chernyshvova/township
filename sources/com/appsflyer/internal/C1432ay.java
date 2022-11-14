package com.appsflyer.internal;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.appsflyer.AFLogger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.appsflyer.internal.ay */
public final class C1432ay {
    public static Map<String, Object> AFInAppEventParameterName(String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!next.equals("is_cache")) {
                    hashMap.put(next, jSONObject.isNull(next) ? null : jSONObject.get(next));
                }
            }
            return hashMap;
        } catch (JSONException e) {
            AFLogger.values(e.getMessage(), e);
            return null;
        }
    }

    public static void AFKeystoreWrapper(C1387af afVar, C1480h hVar, String str, Context context, SharedPreferences sharedPreferences, Integer num, Throwable th) {
        C1387af afVar2 = afVar;
        Context context2 = context;
        SharedPreferences sharedPreferences2 = sharedPreferences;
        if (hVar.AFInAppEventType()) {
            if (C1387af.AFKeystoreWrapper == null) {
                AFLogger.AFInAppEventType("[GCD-E01] AppsFlyerConversionListener is null - skip gcd");
                return;
            }
            StringBuilder sb = new StringBuilder("[GCD-A01] Loading conversion data. Counter: ");
            sb.append(hVar.onDeepLinkingNative);
            AFLogger.AFInAppEventType(sb.toString());
            long j = sharedPreferences2.getLong("appsflyerConversionDataCacheExpiration", 0);
            if (j != 0 && System.currentTimeMillis() - j > 5184000000L) {
                AFLogger.AFInAppEventType("[GCD-E02] Cached conversion data expired");
                C1387af.AFInAppEventType(context2, "sixtyDayConversionData");
                C1387af.AFInAppEventParameterName(context2, "attributionId", (String) null);
                afVar.valueOf(context2, "appsflyerConversionDataCacheExpiration", 0);
            }
            if (sharedPreferences2.getString("attributionId", (String) null) != null) {
                if (C1387af.AFInAppEventParameterName(sharedPreferences2, "appsFlyerCount", false) > 1) {
                    try {
                        Map<String, Object> values = values(context);
                        if (values != null) {
                            try {
                                if (!values.containsKey("is_first_launch")) {
                                    values.put("is_first_launch", Boolean.FALSE);
                                }
                                C1436ba.AFInAppEventParameterName(values);
                            } catch (Throwable th2) {
                                AFLogger.values(th2.getLocalizedMessage(), th2);
                            }
                        }
                    } catch (C1437bb e) {
                        AFLogger.values(e.getMessage(), e);
                    }
                }
            } else if (th != null) {
                StringBuilder sb2 = new StringBuilder("Launch exception: ");
                sb2.append(th.getMessage());
                C1436ba.values(sb2.toString());
            } else if (num.intValue() != 200) {
                C1436ba.values("Launch status code: ".concat(String.valueOf(num)));
            } else {
                C1436ba baVar = new C1436ba(afVar, (Application) context.getApplicationContext(), str);
                C1387af.AFInAppEventParameterName(baVar.AFInAppEventParameterName, baVar, 10, TimeUnit.MILLISECONDS);
            }
        }
    }

    public static Map<String, Object> values(Context context) throws C1437bb {
        String string = C1387af.AFInAppEventType(context).getString("attributionId", (String) null);
        if (string != null && string.length() > 0) {
            return AFInAppEventParameterName(string);
        }
        throw new C1437bb();
    }
}
