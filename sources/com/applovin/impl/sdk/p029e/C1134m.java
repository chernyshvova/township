package com.applovin.impl.sdk.p029e;

import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.C1314v;
import com.applovin.impl.sdk.network.C1217c;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.utils.C1264h;
import com.applovin.impl.sdk.utils.Utils;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.e.m */
public class C1134m extends C1109a {

    /* renamed from: a */
    public final C1136a f2002a;

    /* renamed from: com.applovin.impl.sdk.e.m$a */
    public interface C1136a {
        /* renamed from: a */
        void mo10432a();
    }

    public C1134m(C1188m mVar, C1136a aVar) {
        super("TaskFetchVariables", mVar);
        this.f2002a = aVar;
    }

    /* renamed from: a */
    private Map<String, String> m1902a() {
        return Utils.stringifyObjectMap(this.f1961b.mo10941V().mo11205a((Map<String, String>) null, false, false));
    }

    public void run() {
        C11351 r1 = new C1157u<JSONObject>(C1217c.m2223a(this.f1961b).mo11127a(C1264h.m2535k(this.f1961b)).mo11137c(C1264h.m2536l(this.f1961b)).mo11128a(m1902a()).mo11133b("GET").mo11126a(new JSONObject()).mo11132b(((Integer) this.f1961b.mo10946a(C1085b.f1731df)).intValue()).mo11131a(), this.f1961b) {
            /* renamed from: a */
            public void mo10008a(int i, String str, JSONObject jSONObject) {
                mo10773d("Unable to fetch variables: server returned " + i);
                C1314v.m2663i("AppLovinVariableService", "Failed to load variables.");
                C1134m.this.f2002a.mo10432a();
            }

            /* renamed from: a */
            public void mo10010a(JSONObject jSONObject, int i) {
                C1264h.m2526d(jSONObject, this.f1961b);
                C1264h.m2525c(jSONObject, this.f1961b);
                C1264h.m2530f(jSONObject, this.f1961b);
                C1264h.m2528e(jSONObject, this.f1961b);
                C1134m.this.f2002a.mo10432a();
            }
        };
        r1.mo10853a(C1085b.f1625bd);
        r1.mo10855b(C1085b.f1626be);
        this.f1961b.mo10938S().mo10828a((C1109a) r1);
    }
}
