package com.applovin.impl.mediation.p012c;

import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.p027c.C1084a;
import com.applovin.impl.sdk.p027c.C1087d;
import com.applovin.impl.sdk.utils.C1264h;
import com.applovin.impl.sdk.utils.JsonUtils;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.c.b */
public class C0866b extends C1264h {

    /* renamed from: a */
    public static final String[] f777a = {"ads", "settings", "auto_init_adapters", "test_mode_idfas", "test_mode_auto_init_adapters"};

    /* renamed from: b */
    public static final String[] f778b = {"ads", "settings", "signal_providers"};

    /* renamed from: a */
    public static String m929a(C1188m mVar) {
        return C1264h.m2515a((String) mVar.mo10946a(C1084a.f1520c), "1.0/mediate", mVar);
    }

    /* renamed from: a */
    public static void m930a(JSONObject jSONObject, C1188m mVar) {
        if (JsonUtils.valueExists(jSONObject, "signal_providers")) {
            JSONObject shallowCopy = JsonUtils.shallowCopy(jSONObject);
            JsonUtils.removeObjectsForKeys(shallowCopy, f777a);
            mVar.mo10953a(C1087d.f1842y, shallowCopy.toString());
        }
    }

    /* renamed from: b */
    public static String m931b(C1188m mVar) {
        return C1264h.m2515a((String) mVar.mo10946a(C1084a.f1521d), "1.0/mediate", mVar);
    }

    /* renamed from: b */
    public static void m932b(JSONObject jSONObject, C1188m mVar) {
        if (jSONObject.length() != 0) {
            if (JsonUtils.valueExists(jSONObject, "auto_init_adapters") || JsonUtils.valueExists(jSONObject, "test_mode_auto_init_adapters")) {
                JSONObject shallowCopy = JsonUtils.shallowCopy(jSONObject);
                JsonUtils.removeObjectsForKeys(shallowCopy, f778b);
                mVar.mo10953a(C1087d.f1843z, shallowCopy.toString());
                return;
            }
            mVar.mo10982b(C1087d.f1843z);
        }
    }

    /* renamed from: c */
    public static String m933c(C1188m mVar) {
        return C1264h.m2515a((String) mVar.mo10946a(C1084a.f1520c), "1.0/mediate_debug", mVar);
    }

    /* renamed from: d */
    public static String m934d(C1188m mVar) {
        return C1264h.m2515a((String) mVar.mo10946a(C1084a.f1521d), "1.0/mediate_debug", mVar);
    }
}
