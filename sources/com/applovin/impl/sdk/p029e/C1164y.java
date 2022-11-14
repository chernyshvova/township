package com.applovin.impl.sdk.p029e;

import com.applovin.impl.sdk.C1188m;
import com.applovin.impl.sdk.network.C1213b;
import com.applovin.impl.sdk.network.C1217c;
import com.applovin.impl.sdk.p027c.C1085b;
import com.applovin.impl.sdk.utils.C1264h;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.e.y */
public abstract class C1164y extends C1109a {
    public C1164y(String str, C1188m mVar) {
        super(str, mVar);
    }

    /* renamed from: a */
    public abstract String mo10020a();

    /* renamed from: a */
    public void mo10021a(int i) {
        C1264h.m2517a(i, this.f1961b);
    }

    /* renamed from: a */
    public abstract void mo10022a(JSONObject jSONObject);

    /* renamed from: a */
    public void mo10863a(JSONObject jSONObject, final C1213b.C1216c<JSONObject> cVar) {
        C11651 r0 = new C1157u<JSONObject>(C1217c.m2223a(this.f1961b).mo11127a(C1264h.m2514a(mo10020a(), this.f1961b)).mo11137c(C1264h.m2524b(mo10020a(), this.f1961b)).mo11128a(C1264h.m2527e(this.f1961b)).mo11133b("POST").mo11129a(jSONObject).mo11139d(((Boolean) this.f1961b.mo10946a(C1085b.f1756eE)).booleanValue()).mo11126a(new JSONObject()).mo11125a(mo10777h()).mo11131a(), this.f1961b) {
            /* renamed from: a */
            public void mo10008a(int i, String str, JSONObject jSONObject) {
                cVar.mo10008a(i, str, jSONObject);
            }

            /* renamed from: a */
            public void mo10010a(JSONObject jSONObject, int i) {
                cVar.mo10010a(jSONObject, i);
            }
        };
        r0.mo10853a(C1085b.f1570aZ);
        r0.mo10855b(C1085b.f1622ba);
        this.f1961b.mo10938S().mo10828a((C1109a) r0);
    }

    /* renamed from: h */
    public abstract int mo10777h();

    /* renamed from: i */
    public JSONObject mo10864i() {
        JSONObject jSONObject = new JSONObject();
        String m = this.f1961b.mo10996m();
        if (((Boolean) this.f1961b.mo10946a(C1085b.f1746du)).booleanValue() && StringUtils.isValidString(m)) {
            JsonUtils.putString(jSONObject, "cuid", m);
        }
        if (((Boolean) this.f1961b.mo10946a(C1085b.f1748dw)).booleanValue()) {
            JsonUtils.putString(jSONObject, "compass_random_token", this.f1961b.mo10997n());
        }
        if (((Boolean) this.f1961b.mo10946a(C1085b.f1750dy)).booleanValue()) {
            JsonUtils.putString(jSONObject, "applovin_random_token", this.f1961b.mo10998o());
        }
        mo10022a(jSONObject);
        return jSONObject;
    }
}
