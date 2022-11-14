package com.applovin.impl.sdk.network;

import com.android.tools.p006r8.GeneratedOutlineSupport;
import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.p029e.C1109a;
import com.applovin.impl.sdk.p029e.C1157u;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.network.a */
public class C1211a extends C1109a {

    /* renamed from: a */
    public final String f2275a;

    /* renamed from: c */
    public final C1217c<JSONObject> f2276c;

    public C1211a(String str, C1217c<JSONObject> cVar, C1188m mVar) {
        super(GeneratedOutlineSupport.outline16("CommunicatorRequestTask:", str), mVar);
        this.f2275a = str;
        this.f2276c = cVar;
    }

    public void run() {
        this.f1961b.mo10938S().mo10828a((C1109a) new C1157u<JSONObject>(this.f2276c, this.f1961b, mo10776g()) {
            /* renamed from: a */
            public void mo10008a(int i, String str, JSONObject jSONObject) {
                this.f1961b.mo10969ag().mo10898a(C1211a.this.f2275a, C1211a.this.f2276c.mo11103a(), i, jSONObject, str, false);
            }

            /* renamed from: a */
            public void mo10010a(JSONObject jSONObject, int i) {
                this.f1961b.mo10969ag().mo10898a(C1211a.this.f2275a, C1211a.this.f2276c.mo11103a(), i, jSONObject, (String) null, true);
            }
        });
    }
}
