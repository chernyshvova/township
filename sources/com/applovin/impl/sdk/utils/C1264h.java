package com.applovin.impl.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.p027c.C1086c;
import com.applovin.impl.sdk.p027c.C1087d;
import com.applovin.impl.sdk.p027c.C1088e;
import com.applovin.sdk.AppLovinSdk;
import com.swrve.sdk.ISwrveCommon;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.utils.h */
public class C1264h {

    /* renamed from: a */
    public static final int[] f2444a = {7, 4, 2, 1, 11};

    /* renamed from: b */
    public static final int[] f2445b = {5, 6, 10, 3, 9, 8, 14};

    /* renamed from: c */
    public static final int[] f2446c = {15, 12, 13};

    /* renamed from: d */
    public static final int[] f2447d = {20};

    /* renamed from: a */
    public static String m2513a(InputStream inputStream, C1188m mVar) throws IOException {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[((Integer) mVar.mo10946a(C1085b.f1673cZ)).intValue()];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                return byteArrayOutputStream.toString("UTF-8");
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    /* renamed from: a */
    public static String m2514a(String str, C1188m mVar) {
        return m2515a((String) mVar.mo10946a(C1085b.f1570aZ), str, mVar);
    }

    /* renamed from: a */
    public static String m2515a(String str, String str2, C1188m mVar) {
        if (str == null || str.length() < 4) {
            throw new IllegalArgumentException("Invalid domain specified");
        } else if (str2 == null) {
            throw new IllegalArgumentException("No endpoint specified");
        } else if (mVar != null) {
            return GeneratedOutlineSupport.outline16(str, str2);
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    /* renamed from: a */
    public static JSONObject m2516a(JSONObject jSONObject) throws JSONException {
        return (JSONObject) jSONObject.getJSONArray("results").get(0);
    }

    /* renamed from: a */
    public static void m2517a(int i, C1188m mVar) {
        if (i == 401) {
            StringBuilder outline24 = GeneratedOutlineSupport.outline24("SDK key \"");
            outline24.append(mVar.mo11010z());
            outline24.append("\" is rejected by AppLovin. Please make sure the SDK key is correct.");
            C1314v.m2663i(AppLovinSdk.TAG, outline24.toString());
        } else if (i == 418) {
            mVar.mo10931K().mo10680a((C1085b<?>) C1085b.f1571ac, (Object) Boolean.TRUE);
            mVar.mo10931K().mo10679a();
        } else {
            if (i < 400 || i >= 500) {
                if (i != -1 || !((Boolean) mVar.mo10946a(C1085b.f1573ae)).booleanValue()) {
                    return;
                }
            } else if (!((Boolean) mVar.mo10946a(C1085b.f1573ae)).booleanValue()) {
                return;
            }
            mVar.mo10994k();
        }
    }

    /* renamed from: a */
    public static void m2518a(JSONObject jSONObject, boolean z, C1188m mVar) {
        mVar.mo10969ag().mo10900a(jSONObject, z);
    }

    /* renamed from: a */
    public static boolean m2519a() {
        return m2522a((String) null);
    }

    /* renamed from: a */
    public static boolean m2520a(int i, int[] iArr) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m2521a(Context context) {
        if (context.getSystemService("connectivity") == null) {
            return true;
        }
        NetworkInfo b = m2523b(context);
        if (b != null) {
            return b.isConnected();
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m2522a(String str) {
        if (C1263g.m2509e()) {
            return (!C1263g.m2510f() || TextUtils.isEmpty(str)) ? NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted() : NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
        }
        return true;
    }

    /* renamed from: b */
    public static NetworkInfo m2523b(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            return connectivityManager.getActiveNetworkInfo();
        }
        return null;
    }

    /* renamed from: b */
    public static String m2524b(String str, C1188m mVar) {
        return m2515a((String) mVar.mo10946a(C1085b.f1622ba), str, mVar);
    }

    /* renamed from: c */
    public static void m2525c(JSONObject jSONObject, C1188m mVar) {
        String string = JsonUtils.getString(jSONObject, "persisted_data", (String) null);
        if (StringUtils.isValidString(string)) {
            mVar.mo10953a(C1087d.f1814A, string);
            mVar.mo10922B().mo11374c("ConnectionUtils", "Updated persisted data");
        }
    }

    /* renamed from: d */
    public static void m2526d(JSONObject jSONObject, C1188m mVar) {
        if (jSONObject == null) {
            throw new IllegalArgumentException("No response specified");
        } else if (mVar != null) {
            try {
                if (jSONObject.has("settings")) {
                    C1086c K = mVar.mo10931K();
                    if (!jSONObject.isNull("settings")) {
                        K.mo10681a(jSONObject.getJSONObject("settings"));
                        K.mo10679a();
                    }
                }
            } catch (JSONException e) {
                mVar.mo10922B().mo11373b("ConnectionUtils", "Unable to parse settings out of API response", e);
            }
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    /* renamed from: e */
    public static Map<String, String> m2527e(C1188m mVar) {
        String str;
        HashMap hashMap = new HashMap();
        String str2 = (String) mVar.mo10946a(C1085b.f1574af);
        if (StringUtils.isValidString(str2)) {
            str = "device_token";
        } else {
            if (!((Boolean) mVar.mo10946a(C1085b.f1797et)).booleanValue()) {
                str2 = mVar.mo11010z();
                str = "api_key";
            }
            hashMap.putAll(Utils.stringifyObjectMap(mVar.mo10941V().mo11214i()));
            return hashMap;
        }
        hashMap.put(str, str2);
        hashMap.putAll(Utils.stringifyObjectMap(mVar.mo10941V().mo11214i()));
        return hashMap;
    }

    /* renamed from: e */
    public static void m2528e(JSONObject jSONObject, C1188m mVar) {
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "filesystem_values", (JSONObject) null);
        if (jSONObject2 != null) {
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(mVar.mo10932L()).edit();
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object object = JsonUtils.getObject(jSONObject2, next, (Object) null);
                if (object != null) {
                    C1088e.m1672a(next, object, (SharedPreferences) null, edit);
                }
            }
            edit.apply();
        }
    }

    /* renamed from: f */
    public static String m2529f(C1188m mVar) {
        NetworkInfo b = m2523b(mVar.mo10932L());
        if (b == null) {
            return "unknown";
        }
        int type = b.getType();
        int subtype = b.getSubtype();
        return type == 1 ? "wifi" : type == 0 ? m2520a(subtype, f2444a) ? "2g" : m2520a(subtype, f2445b) ? "3g" : m2520a(subtype, f2446c) ? "4g" : m2520a(subtype, f2447d) ? "5g" : ISwrveCommon.DEVICE_TYPE_MOBILE : "unknown";
    }

    /* renamed from: f */
    public static void m2530f(JSONObject jSONObject, C1188m mVar) {
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "variables", (JSONObject) null);
        if (jSONObject2 != null) {
            mVar.mo11009y().updateVariables(jSONObject2);
        }
    }

    /* renamed from: g */
    public static String m2531g(C1188m mVar) {
        return m2515a((String) mVar.mo10946a(C1085b.f1568aX), ((Boolean) mVar.mo10946a(C1085b.f1733dh)).booleanValue() ? "5.0/ad" : "4.0/ad", mVar);
    }

    /* renamed from: h */
    public static String m2532h(C1188m mVar) {
        return m2515a((String) mVar.mo10946a(C1085b.f1569aY), ((Boolean) mVar.mo10946a(C1085b.f1733dh)).booleanValue() ? "5.0/ad" : "4.0/ad", mVar);
    }

    /* renamed from: i */
    public static String m2533i(C1188m mVar) {
        return m2515a((String) mVar.mo10946a(C1085b.f1568aX), "4.0/ad", mVar);
    }

    /* renamed from: j */
    public static String m2534j(C1188m mVar) {
        return m2515a((String) mVar.mo10946a(C1085b.f1569aY), "4.0/ad", mVar);
    }

    /* renamed from: k */
    public static String m2535k(C1188m mVar) {
        return m2515a((String) mVar.mo10946a(C1085b.f1625bd), "1.0/variable_config", mVar);
    }

    /* renamed from: l */
    public static String m2536l(C1188m mVar) {
        return m2515a((String) mVar.mo10946a(C1085b.f1626be), "1.0/variable_config", mVar);
    }
}
