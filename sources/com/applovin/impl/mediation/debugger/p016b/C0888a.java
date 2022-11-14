package com.applovin.impl.mediation.debugger.p016b;

import com.applovin.impl.mediation.p012c.C0866b;
import com.applovin.impl.mediation.p012c.C0867c;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.network.C1213b;
import com.applovin.impl.sdk.network.C1217c;
import com.applovin.impl.sdk.p027c.C1084a;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.p029e.C1109a;
import com.applovin.impl.sdk.p029e.C1157u;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.facebook.internal.FetchedAppGateKeepersManager;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.debugger.b.a */
public class C0888a extends C1109a {

    /* renamed from: a */
    public final C1213b.C1216c<JSONObject> f886a;

    public C0888a(C1213b.C1216c<JSONObject> cVar, C1188m mVar) {
        super("TaskFetchMediationDebuggerInfo", mVar, true);
        this.f886a = cVar;
    }

    /* renamed from: a */
    private JSONObject m1049a(C1188m mVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("installed_mediation_adapters", C0867c.m937a(mVar));
        } catch (JSONException e) {
            mo10769a("Failed to create mediation debugger request post body", e);
        }
        return jSONObject;
    }

    /* renamed from: b */
    private JSONObject m1050b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("installed_mediation_adapters", C0867c.m937a(this.f1961b));
        } catch (JSONException e) {
            mo10769a("Failed to construct JSON body", e);
        }
        return jSONObject;
    }

    /* renamed from: a */
    public Map<String, String> mo10101a() {
        HashMap hashMap = new HashMap();
        hashMap.put(FetchedAppGateKeepersManager.APPLICATION_SDK_VERSION, AppLovinSdk.VERSION);
        if (!((Boolean) this.f1961b.mo10946a(C1085b.f1797et)).booleanValue()) {
            hashMap.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f1961b.mo11010z());
        }
        Map<String, Object> h = this.f1961b.mo10941V().mo11213h();
        hashMap.put("package_name", String.valueOf(h.get("package_name")));
        hashMap.put("app_version", String.valueOf(h.get("app_version")));
        Map<String, Object> b = this.f1961b.mo10941V().mo11207b();
        hashMap.put("platform", String.valueOf(b.get("platform")));
        hashMap.put("os", String.valueOf(b.get("os")));
        return hashMap;
    }

    public void run() {
        C08891 r1 = new C1157u<JSONObject>(C1217c.m2223a(this.f1961b).mo11133b("POST").mo11127a(C0866b.m933c(this.f1961b)).mo11137c(C0866b.m934d(this.f1961b)).mo11128a(mo10101a()).mo11129a(m1049a(this.f1961b)).mo11126a(new JSONObject()).mo11132b(((Long) this.f1961b.mo10946a(C1084a.f1524g)).intValue()).mo11129a(m1050b()).mo11131a(), this.f1961b, mo10776g()) {
            /* renamed from: a */
            public void mo10008a(int i, String str, JSONObject jSONObject) {
                C0888a.this.f886a.mo10008a(i, str, jSONObject);
            }

            /* renamed from: a */
            public void mo10010a(JSONObject jSONObject, int i) {
                C0888a.this.f886a.mo10010a(jSONObject, i);
            }
        };
        r1.mo10853a(C1084a.f1520c);
        r1.mo10855b(C1084a.f1521d);
        this.f1961b.mo10938S().mo10828a((C1109a) r1);
    }
}
